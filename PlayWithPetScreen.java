import greenfoot.*;

/**
 * PlayWithPetScreen is the main interactive area with the pet.
 * Handles stat tracking, interaction, passive depletion, and Game Over logic.
 */
public class PlayWithPetScreen extends World
{
    private StatBar healthBar, happinessBar, fullnessBar, sleepBar;
    private int globalTimer;
    private Pet pet;
    private Toy currentToy;
    private boolean isSleeping = false;
    private boolean isGameOver;
    private boolean isExercising = false;
    private int exerciseTimer = 0;
    private boolean showVet = false;
    private int vetTimer = 0;
    private boolean showingExerciseFrame1 = true;
    private int exerciseFrameCounter = 0;
    private static final int PET_WIDTH = 100;
    private static final int PET_HEIGHT = 100;
    private GreenfootImage exerciseFrame1;
    private GreenfootImage exerciseFrame2;
    private boolean vetOnCooldown = false;
    private int vetCoolDownTimer = 0;
    private final int VET_COOLDOWN_DURATION = 600;

    public PlayWithPetScreen()
    {
        super(700, 500, 1);

        // Set custom background color
        GreenfootImage bg = new GreenfootImage(700, 500);
        bg.setColor(Color.WHITE);
        bg.fill();
        setBackground(bg);

        pet = new Pet();
        addObject(pet, getWidth() / 2, getHeight() / 2 - 20);

        healthBar = new StatBar("health", PetClass.getHealth());
        happinessBar = new StatBar("happiness", PetClass.getHappiness());
        fullnessBar = new StatBar("fullness", PetClass.getFullness());
        sleepBar = new StatBar("sleepiness", PetClass.getSleep());

        int x = 120, y = 150, spacing = 25;
        addObject(healthBar, x, y);
        addObject(happinessBar, x, y + spacing);
        addObject(fullnessBar, x, y + spacing * 2);
        addObject(sleepBar, x, y + spacing * 3);

        addObject(new InteractionButton("Throw Ball", this), 80, 460);
        addObject(new InteractionButton("Pet the Pet", this), 210, 460);
        addObject(new InteractionButton("Give Toy", this), 340, 460);
        addObject(new InteractionButton("Feed", this), 470, 460);
        addObject(new SleepButton(this), 600, 460);
        
        

        addObject(new InteractionButton("Exercise", this), 80, 420);
        addObject(new InteractionButton("Take to Vet", this), 210, 420);
        
        //////////////////////////////////
        
        addObject(new InventoryIcon(), 610, 115);
        addObject(new SimpleText("Inventory"), 630, 85);
        addObject(new Cross(), 50, 50);
        addObject(new SimpleText("Math Game!"), 620, 230);  
        addObject(new Calculator(), 610, 250);

        addObject(new SaveButton(this), 355, 55);
        showText(PetClass.getName(), 350, 330);

        globalTimer = 0;
        isGameOver = false;
    }

    public void act()
    {
        // Exercise logic
        if (isExercising)
        {
            exerciseTimer--;
            exerciseFrameCounter++;

            // Switch frames every 15 ticks
            if (exerciseFrameCounter % 15 == 0)
            {
                pet.setImage(showingExerciseFrame1 ? exerciseFrame2 : exerciseFrame1);
                showingExerciseFrame1 = !showingExerciseFrame1;
            }

            // End of exercise
            if (exerciseTimer <= 0)
            {
                isExercising = false;
                exerciseFrameCounter = 0;
                showText("", getWidth() / 2, 80);
                updatePetMood(); // restore appropriate mood sprite
            }
            else
            {
                showText(PetClass.getName() + "'s busy!", getWidth() / 2, 80);
                return; // block all other logic while exercising
            }
        }
        
        if (vetOnCooldown){
            vetCoolDownTimer--;
            
            if (vetTimer <= 0){
                showVet = false;
                removeObjects(getObjects(Nurse.class));
            }
        }

        // Vet timer logic (if you have vet feature)
        if (showVet)
        {
            vetTimer--;
            if (vetTimer <= 0)
            {
                showVet = false;
                removeObjects(getObjects(Nurse.class));
            }
        }

        // Passive stat drain every 15 seconds
        globalTimer++;
        if (globalTimer >= 1000)
        {
            if (isSleeping)
            {
                PetClass.increaseSleep(15);
                sleepBar.increase(15);
                
                PetClass.decreaseFullness(5);
                fullnessBar.decrease(5);
                
                PetClass.decreaseHappiness(5);
                happinessBar.decrease(5);
            }
            else
            {
                PetClass.decreaseHappiness(5);
                happinessBar.decrease(5);
                
                PetClass.decreaseFullness(5);
                fullnessBar.decrease(7);
                
                PetClass.decreaseSleep(6);
                sleepBar.decrease(6);

                if (fullnessBar.getValue() == 0 || sleepBar.getValue() == 0)
                {
                    PetClass.decreaseHealth(10);
                    healthBar.decrease(10);
                }
            }
            
            if (fullnessBar.getValue() == 0) {
                PetClass.decreaseHappiness(5);
                happinessBar.decrease(5);
            }

            globalTimer = 0;
        }

        updateWarnings();

        if (!isSleeping && !isGameOver && !isExercising)
        {
            updatePetMood(); // update appearance based on mood if not sleeping or exercising
        }

        if (healthBar.getValue() <= 0 && !isGameOver)
        {
            triggerGameOver();
        }
    }

    public void interact(String interaction)
    {
        if (isGameOver) return;
        
        if (currentToy != null){
            removeObject(currentToy);
            currentToy = null;
        }
        
        if (isExercising) {
            showText(PetClass.getName() + "'s busy!", getWidth() / 2, 80);
            return;
        }
        if (isSleeping)
        {
            showText(PetClass.getName() + " is sleeping... wake it up first!", getWidth() / 2, 60);
            return;
        }

        // Clear any previous warning
        showText("", getWidth() / 2, 80);

        switch(interaction)
        {
            case "Throw Ball":
                // xyz
                happinessBar.increase(10);
                // xyz
                sleepBar.decrease(5);
                // xyz
                fullnessBar.decrease(3);
                if (currentToy != null) removeObject(currentToy);
                currentToy = new Toy();
                addObject(currentToy, 150, 250);
                break;

            case "Pet the Pet":
                if (happinessBar.getValue() < 50)
                {
                    showText(PetClass.getName() + " is unhappy, play with it!", getWidth() / 2, 60);
                    return;
                }
                // xyz
                happinessBar.increase(7);
                addObject(new Hand(), pet.getX() - 30, pet.getY() - 40);
                break;

            case "Give Gift":
                // TODO
                PetClass.increaseHappiness(5);
                happinessBar.increase(5);
                break;
                
            case "Feed":
                PetClass.increaseFullness(15);
                fullnessBar.increase(15);

                break;
                
            case "Exercise":
                pet.setImage(exerciseFrame1);
                pet.setCurrentState("exercise"); // Set state so mood logic knows to override it later

                isExercising = true;
                exerciseTimer = 300; // 5 seconds
                exerciseFrameCounter = 0;
                showingExerciseFrame1 = true;

                // Preload and scale exercise animation frames
                exerciseFrame1 = new GreenfootImage(PetClass.getType().toLowerCase() + "Active1.png");
                exerciseFrame1.scale(200, 200);

                exerciseFrame2 = new GreenfootImage(PetClass.getType().toLowerCase() + "Active2.png");
                exerciseFrame2.scale(200, 200);

                pet.setImage(exerciseFrame1); // Start with frame 1

                showText(PetClass.getName() + "'s busy!", getWidth() / 2, 80);
                
                // xyz
                sleepBar.decrease(15);
                // xyz
                healthBar.increase(10);
                break;

            case "Take to Vet":
                             if (vetOnCooldown)
                {
                    showText("Vet is on cooldown!", getWidth() / 2, 60);
                    return;
                }
                showVet = true;
                vetTimer = 180; // Nurse stays for 3 seconds
                addObject(new Nurse(), getWidth() / 2, getHeight() / 2);
                              
                PetClass.increaseHealth(25);
                healthBar.increase(25); // Boost health
               
                
                vetOnCooldown = true;
                vetCoolDownTimer = VET_COOLDOWN_DURATION;
                
                break; 
        }
    }

    /**
     * Triggers end of game.
     */
    private void triggerGameOver()
    {
        isGameOver = true;
        showText("GAME OVER", getWidth() / 2, getHeight() / 2);
        addObject(new GameOverButton(), getWidth() / 2, getHeight() / 2 + 100);
        // Remove toy, hand, and interaction buttons
        removeObjects(getObjects(Toy.class));
        removeObjects(getObjects(Hand.class));
        removeObjects(getObjects(InteractionButton.class));
        removeObjects(getObjects(SleepButton.class));
    }

    public void setSleepingMode(boolean sleep)
    {
        isSleeping = sleep;

        if (isSleeping)
        {
            pet.setToSleeping(); // ✅ Use this, not setImage directly
        }
        else
        {
            updatePetMood(); // Re-evaluate mood immediately when waking up
            showText("", getWidth() / 2, 80); // Clear “sleeping” warning
        }
    }

    /**
     * Updates the pet's image based on current stat levels.
     * Prioritizes death first, then other moods if pet is alive and awake.
     */
    private void updatePetMood()
    {
        if (isGameOver || healthBar.getValue() <= 0)
        {
            pet.setToDead();
            return;
        }

        // Only change if mood is actually different
        if (happinessBar.getValue() < 50)
        {
            if (!pet.getState().equals("angry"))
                pet.setToAngry();
        }
        else if (sleepBar.getValue() < 50)
        {
            if (!pet.getState().equals("sleepy"))
                pet.setToSleepy();
        }
        else if (fullnessBar.getValue() < 50)
        {
            if (!pet.getState().equals("hungry"))
                pet.setToHungry();
        }
        else
        {
            if (!pet.getState().equals("normal"))
                pet.setToNormal();
        }
    }

    /**
     * Display appropriate warning text based on stat levels.
     */
    private void updateWarnings()
    {
        showText("", getWidth() / 2, 30);

        if (healthBar.getValue() < 50 && healthBar.getValue() > 0)
        {
            showText("Warning: " + PetClass.getName() + "'s health is low", getWidth() / 2, 30);
        }
        else if (sleepBar.getValue() < 50 && sleepBar.getValue() > 0)
        {
            showText("Warning: " + PetClass.getName() + " is low on sleep", getWidth() / 2, 30);
        }
        else if (fullnessBar.getValue() < 50 && fullnessBar.getValue() > 0)
        {
            showText("Warning: " + PetClass.getName() + " is getting hungry", getWidth() / 2, 30);
        }
    }

    public boolean isGameOver()
    {
        return isGameOver;
    }
    
    class SimpleText extends Actor{
        public SimpleText(String message){
            GreenfootImage img = new GreenfootImage(150, 100);
            img.setColor(Color.BLACK);
            img.setFont(new Font("Arial", false, false, 20));
            img.drawString(message, 10, 25);
            
            setImage(img);
        }
    }
    
    class Nurse extends Actor{
        public Nurse()
        {
            setImage("nurse.png");
            getImage().scale(200,200);
        }
    }

}
