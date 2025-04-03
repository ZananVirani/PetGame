import greenfoot.*;

/**
 * PlayWithPetScreen is the main interactive area with the pet.
 * Handles stat tracking, interaction, passive depletion, and Game Over logic.
 * 
 * @author Group78
 */
public class PlayWithPetScreen extends World {
    // UI stat bars
    private StatBar healthBar, happinessBar, fullnessBar, sleepBar;

    // Global timer used for passive effects
    private int globalTimer;

    // Pet and toy objects
    private Pet pet;
    private Toy currentToy;

    // Pet state flags
    private boolean isSleeping = false;
    private boolean isGameOver;
    private boolean isExercising = false;

    // Exercise animation variables
    private int exerciseTimer = 0;
    private boolean showingExerciseFrame1 = true;
    private int exerciseFrameCounter = 0;
    private static final int PET_WIDTH = 100;
    private static final int PET_HEIGHT = 100;
    private GreenfootImage exerciseFrame1;
    private GreenfootImage exerciseFrame2;

    // Vet interaction variables
    private boolean showVet = false;
    private int vetTimer = 0;
    private boolean vetOnCooldown = false;
    private int vetCoolDownTimer = 0;
    private final int VET_COOLDOWN_DURATION = 600;

    // Toy cooldown variables
    private boolean toyOnCoolDown = false;
    private int toyCoolDownTimer = 0;
    private final int TOY_COOLDOWN_DURATION = 600;

    // Flag to alternate between gift and food
    private boolean gift;

    // UI components
    private InventoryIcon invIcon;
    private Calculator calculator;
    private SimpleText mathText, invText;

    /**
     * Constructor sets up the pet, stat bars, UI components, and interaction buttons.
     */
    public PlayWithPetScreen() {
        super(700, 500, 1);

        // Set custom background
        setBackground("background.png");

        pet = new Pet();
        addObject(pet, getWidth() / 2, getHeight() / 2 - 20);

        // Initialize stat bars with current pet stats
        healthBar = new StatBar("health", PetClass.getHealth());
        happinessBar = new StatBar("happiness", PetClass.getHappiness());
        fullnessBar = new StatBar("fullness", PetClass.getFullness());
        sleepBar = new StatBar("sleepiness", PetClass.getSleep());

        // Place stat bars vertically with spacing
        int x = 120, y = 90, spacing = 25;
        addObject(healthBar, x, y);
        addObject(happinessBar, x, y + spacing);
        addObject(fullnessBar, x, y + spacing * 2);
        addObject(sleepBar, x, y + spacing * 3);

        // Add main interaction buttons
        addObject(new InteractionButton("Throw Ball", this), 80, 460);
        addObject(new InteractionButton("Pet the Pet", this), 210, 460);
        addObject(new InteractionButton("Give Gift", this), 340, 460);
        addObject(new InteractionButton("Feed", this), 470, 460);
        addObject(new SleepButton(this), 600, 460);
        addObject(new InteractionButton("Exercise", this), 80, 420);
        addObject(new InteractionButton("Take to Vet", this), 210, 420);

        // UI labels and icons
        invText = new SimpleText("Inventory");
        addObject(invText, 630, 85);

        mathText = new SimpleText("Math Game!");
        addObject(new SimpleText("Math Game!"), 620, 230);

        invIcon = new InventoryIcon();
        addObject(invIcon, 610, 115);
        addObject(new Cross(), 50, 50);

        calculator = new Calculator();
        addObject(calculator, 610, 250);

        addObject(new SaveButton(this), 355, 55);

        // Display pet's name
        showText(PetClass.getName(), 350, 330);

        globalTimer = 0;
        isGameOver = false;
        gift = false;
    }

    /**
     * act() runs continuously and manages stat changes, animations, and logic checks.
     */
    public void act() {
        if (Greenfoot.mouseClicked(null))
            SoundManager.playClick(); // play click sound on any mouse click

        if (!isGameOver)
            SoundManager.playBgm(); // play background music

        // Handle clicks during Game Over
        if (isGameOver) {
            exerciseTimer = -1;
            showVet = false;
            if (Greenfoot.mouseClicked(null)) {
                Actor clicked = Greenfoot.getMouseInfo().getActor();
                if (clicked instanceof GameOverButton) {
                    ScreenManager.clearStack();
                    ScreenManager.push(new MainMenu());
                }
            }
        }

        // Exercise animation logic
        if (isExercising) {
            exerciseTimer--;
            exerciseFrameCounter++;

            // Switch between exercise frames every 15 ticks
            if (exerciseFrameCounter % 15 == 0) {
                pet.setImage(showingExerciseFrame1 ? exerciseFrame2 : exerciseFrame1);
                showingExerciseFrame1 = !showingExerciseFrame1;
            }

            // End exercise session
            if (exerciseTimer <= 0) {
                isExercising = false;
                exerciseFrameCounter = 0;
                showText("", getWidth() / 2, 80);
                updatePetMood(); // go back to mood-based sprite
            } else {
                showText(PetClass.getName() + "'s busy!", getWidth() / 2, 80);
                return; // skip rest of act() while exercising
            }
        }

        // Vet cooldown logic
        if (vetOnCooldown) {
            vetCoolDownTimer--;
            if (vetTimer <= 0) {
                showVet = false;
                removeObjects(getObjects(Nurse.class));
            }
        }

        // Toy cooldown logic
        if (toyOnCoolDown) {
            toyCoolDownTimer--;
            if (toyCoolDownTimer <= 0) {
                toyOnCoolDown = false;
            }
        }

        // Vet animation timer
        if (showVet) {
            vetTimer--;
            if (vetTimer <= 0) {
                showVet = false;
                removeObjects(getObjects(Nurse.class));
            }
        }

        // Passive stat drain logic every 1200 ticks
        globalTimer++;
        if (globalTimer % 60 == 0) {
            Player.incrementTime(); // general clock
        }

        if (globalTimer >= 1200 && !isGameOver) {
            GameState.saveAll(); // auto save

            // Alternate between food and gift
            Inventory inv = PetClass.getInventory();
            if (gift) {
                Gift gift = inv.addGift();
                addObject(new ItemImage(gift.getName().toLowerCase(), this), 450, 300);
                showText("Gift Received!", 450, 370);
            } else {
                Food food = inv.addFood();
                addObject(new ItemImage(food.getName().toLowerCase(), this), 450, 300);
                showText("Food Received!", 450, 370);
            }
            gift = !gift;

            // Passive stat changes
            if (isSleeping) {
                PetClass.increaseSleep(15);
                sleepBar.increase(15);
                fullnessBar.decrease(PetClass.decreaseFullness(5));
                happinessBar.decrease(PetClass.decreaseHappiness(5));
            } else {
                happinessBar.decrease(PetClass.decreaseHappiness(5));
                fullnessBar.decrease(PetClass.decreaseFullness(7));
                sleepBar.decrease(PetClass.decreaseSleep(6));
                if (fullnessBar.getValue() == 0 || sleepBar.getValue() == 0) {
                    PetClass.decreaseHealth(20);
                    healthBar.decrease(20);
                }
            }

            if (fullnessBar.getValue() == 0) {
                happinessBar.decrease(PetClass.decreaseHappiness(5));
            }

            globalTimer = 0;
        }

        updateWarnings(); // check if we should warn the user

        if (!isSleeping && !isGameOver && !isExercising) {
            updatePetMood(); // adjust pet sprite based on current mood
        }

        if (healthBar.getValue() <= 0 && !isGameOver) {
            triggerGameOver();
        }

        if (Greenfoot.mouseClicked(invIcon) && !isGameOver) {
            ScreenManager.push(new InventoryScreen(fullnessBar, happinessBar));
        }
    }


     /**
     * Handles user interaction from the buttons (Throw Ball, Feed, etc.)
     * @param interaction The label of the interaction to perform.
     */
    public void interact(String interaction) {
        if (isGameOver)
            return;

        // Remove any current toy
        if (currentToy != null) {
            removeObject(currentToy);
            currentToy = null;
        }

        // Block all interactions if pet is exercising
        if (isExercising) {
            showText(PetClass.getName() + "'s busy!", getWidth() / 2, 80);
            return;
        }

        // Block all interactions if pet is sleeping
        if (isSleeping) {
            showText(PetClass.getName() + " is sleeping... wake it up first!", getWidth() / 2, 60);
            return;
        }

        // Clear any message
        showText("", getWidth() / 2, 80);

        // Perform the selected interaction
        switch (interaction) {
            case "Throw Ball":
                if (toyOnCoolDown) {
                    showText("Take a break!", getWidth() / 2, 60);
                    return;
                }
                // Boost happiness
                PetClass.increaseHappiness(10);
                happinessBar.increase(10);

                // Decrease other stats
                sleepBar.decrease(PetClass.decreaseSleep(5));
                fullnessBar.decrease(PetClass.decreaseFullness(3));

                // Show toy
                if (currentToy != null)
                    removeObject(currentToy);
                currentToy = new Toy();
                addObject(currentToy, 150, 250);

                // Start cooldown
                toyOnCoolDown = true;
                toyCoolDownTimer = TOY_COOLDOWN_DURATION;
                break;

            case "Pet the Pet":
                // Pet must be happy to allow petting
                if (happinessBar.getValue() < 50) {
                    showText(PetClass.getName() + " is unhappy, play with it!", getWidth() / 2, 60);
                    return;
                }
                PetClass.increaseHappiness(7);
                happinessBar.increase(7);
                addObject(new Hand(), pet.getX() - 30, pet.getY() - 40);
                break;

            case "Give Gift":
                // Open inventory screen
                ScreenManager.push(new InventoryScreen(fullnessBar, happinessBar));
                break;

            case "Feed":
                // Open inventory screen (food)
                ScreenManager.push(new InventoryScreen(fullnessBar, happinessBar));
                break;

            case "Exercise":
                // Preload animation frames
                pet.setImage(exerciseFrame1);
                pet.setCurrentState("exercise");

                isExercising = true;
                exerciseTimer = 300; // 5 seconds
                exerciseFrameCounter = 0;
                showingExerciseFrame1 = true;

                // Load and scale exercise frames
                exerciseFrame1 = new GreenfootImage(PetClass.getType().toLowerCase() + "Active1.png");
                exerciseFrame1.scale(200, 200);

                exerciseFrame2 = new GreenfootImage(PetClass.getType().toLowerCase() + "Active2.png");
                exerciseFrame2.scale(200, 200);

                pet.setImage(exerciseFrame1);

                showText(PetClass.getName() + "'s busy!", getWidth() / 2, 80);

                // Affect stats
                sleepBar.decrease(PetClass.decreaseSleep(10));
                fullnessBar.decrease(PetClass.decreaseFullness(10));
                PetClass.increaseHealth(15);
                healthBar.increase(10);
                break;

            case "Take to Vet":
                if (vetOnCooldown) {
                    showText("Vet is on cooldown!", getWidth() / 2, 60);
                    return;
                }

                // Show nurse
                showVet = true;
                vetTimer = 180; // 3 seconds
                addObject(new Nurse(), getWidth() / 2, getHeight() / 2);

                // Increase health
                PetClass.increaseHealth(10);
                healthBar.increase(10);

                // Start vet cooldown
                vetOnCooldown = true;
                vetCoolDownTimer = VET_COOLDOWN_DURATION;
                break;
        }
    }

    /**
     * Ends the game and shows GAME OVER screen.
     */
    private void triggerGameOver() {
        isGameOver = true;
        showText("GAME OVER", getWidth() / 2, getHeight() / 2);
        Player.petDied(PetClass.getName());
        addObject(new GameOverButton(), 570, getHeight() / 2);

        // Clear all active UI/gameplay items
        removeObjects(getObjects(Toy.class));
        removeObjects(getObjects(Hand.class));
        removeObjects(getObjects(InteractionButton.class));
        removeObjects(getObjects(SleepButton.class));
        removeObjects(getObjects(SaveButton.class));
        removeObjects(getObjects(InventoryIcon.class));
        removeObjects(getObjects(Calculator.class));
        removeObjects(getObjects(SimpleText.class));
        SoundManager.stopBgm(); // stop music
    }

    /**
     * Enables or disables sleep mode.
     * @param sleep true to sleep, false to wake up
     */
    public void setSleepingMode(boolean sleep) {
        isSleeping = sleep;

        if (isSleeping) {
            pet.setToSleeping(); // sleeping sprite
        } else {
            updatePetMood(); // resume normal mood
            showText("", getWidth() / 2, 80);
        }
    }

    /**
     * Updates pet sprite based on stat values (angry, sleepy, hungry, normal).
     */
    public void updatePetMood() {
        if (isGameOver || healthBar.getValue() <= 0) {
            pet.setToDead();
            return;
        }

        if (happinessBar.getValue() < 50) {
            if (!pet.getState().equals("angry"))
                pet.setToAngry();
        } else if (sleepBar.getValue() < 50) {
            if (!pet.getState().equals("sleepy"))
                pet.setToSleepy();
        } else if (fullnessBar.getValue() < 50) {
            if (!pet.getState().equals("hungry"))
                pet.setToHungry();
        } else {
            if (!pet.getState().equals("normal"))
                pet.setToNormal();
        }
    }

    /**
     * Displays warnings if stat levels drop too low.
     */
    private void updateWarnings() {
        showText("", getWidth() / 2, 30);

        if (healthBar.getValue() < 50 && healthBar.getValue() > 0) {
            showText("Warning: " + PetClass.getName() + "'s health is low", getWidth() / 2, 30);
        } else if (sleepBar.getValue() < 50 && sleepBar.getValue() > 0) {
            showText("Warning: " + PetClass.getName() + " is low on sleep", getWidth() / 2, 30);
        } else if (fullnessBar.getValue() < 50 && fullnessBar.getValue() > 0) {
            showText("Warning: " + PetClass.getName() + " is getting hungry", getWidth() / 2, 30);
        }
    }

    /**
     * Returns whether the pet has died and game is over.
     * @return true if dead
     */
    public boolean isGameOver() {
        return isGameOver;
    }

    /**
     * Custom UI text element for messages/labels.
     */
    class SimpleText extends Actor {
        public SimpleText(String message) {
            GreenfootImage img = new GreenfootImage(150, 100);
            img.setColor(Color.BLACK);
            img.setFont(new Font("Arial", false, false, 20));
            img.drawString(message, 10, 25);
            setImage(img);
        }
    }

    /**
     * Nurse character that appears during vet interactions.
     */
    class Nurse extends Actor {
        public Nurse() {
            setImage("nurse.png");
            getImage().scale(200, 200);
        }
    }

    /**
     * Gives access to the pet object.
     * @return pet instance
     */
    public Pet getPet() {
        return this.pet;
    }
}
