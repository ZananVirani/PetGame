import greenfoot.*;

/**
 * PlayWithPetScreen is the main interactive area with the pet.
 * Handles stat tracking, interaction, passive depletion, and Game Over logic.
 */
public class PlayWithPetScreen extends World
{
    private StatBar healthBar, happinessBar, hungerBar, energyBar;
    private int globalTimer;
    private Pet pet;
    private Toy currentToy;
    private boolean isSleeping = false;
    private boolean isGameOver;

    public PlayWithPetScreen()
    {
        super(700, 500, 1);

        // Set custom background color
        GreenfootImage bg = new GreenfootImage(700, 500);
        bg.setColor(Color.WHITE);
        bg.fill();
        setBackground(bg);

        pet = new Pet();
        addObject(pet, getWidth() / 2, getHeight() / 2 - 50);

        healthBar = new StatBar("health", 100);
        happinessBar = new StatBar("happiness", 100);
        hungerBar = new StatBar("hunger", 100);
        energyBar = new StatBar("energy", 100);

        int x = 120, y = 350, spacing = 25;
        addObject(healthBar, x, y);
        addObject(happinessBar, x, y + spacing);
        addObject(hungerBar, x, y + spacing * 2);
        addObject(energyBar, x, y + spacing * 3);

        addObject(new InteractionButton("Throw Ball", this), 100, 460);
        addObject(new InteractionButton("Pet the Pet", this), 230, 460);
        addObject(new InteractionButton("Give Toy", this), 360, 460);
        addObject(new InteractionButton("Feed", this), 490, 460);
        addObject(new SleepButton(this), 620, 460);
        
        addObject(new InventoryIcon(), 620, 70);
        addObject(new Cross(), 50, 50);
        addObject(new SimpleText(), 620, 230);  
        addObject(new Calculator(), 610, 250);

        globalTimer = 0;
        isGameOver = false;
    }

    public void act()
    {
        if (isGameOver) return;

        globalTimer++;

        if (globalTimer >= 3600)
        {
            if (isSleeping)
            {
                energyBar.increase(10);
                hungerBar.decrease(5);
                happinessBar.decrease(5);
                // pet image stays sleeping
            }
            else
            {
                happinessBar.decrease(5);
                hungerBar.decrease(7);
                energyBar.decrease(6);

                if (hungerBar.getValue() == 0 || energyBar.getValue() == 0)
                {
                    healthBar.decrease(10);
                }
            }

            globalTimer = 0;
        }

        updateWarnings();

        if (healthBar.getValue() <= 0)
        {
            triggerGameOver();
        }

        if (!isSleeping && !isGameOver)
        {
            updatePetMood();
        }

    }

    public void interact(String interaction)
    {
        if (isGameOver) return;

        if (isSleeping)
        {
            showText("Pet is sleeping... wake it up first!", getWidth() / 2, 60);
            return;
        }

        // Clear any previous warning
        showText("", getWidth() / 2, 60);

        switch(interaction)
        {
            case "Throw Ball":
                happinessBar.increase(10);
                energyBar.decrease(5);
                hungerBar.decrease(3);
                if (currentToy != null) removeObject(currentToy);
                currentToy = new Toy();
                addObject(currentToy, 150, 250);
                break;

            case "Pet the Pet":
                if (happinessBar.getValue() < 50)
                {
                    showText("Cat is unhappy, play with it!", getWidth() / 2, 60);
                    return;
                }
                happinessBar.increase(7);
                addObject(new Hand(), pet.getX() - 30, pet.getY() - 40);
                break;

            case "Give Toy":
                happinessBar.increase(5);
                energyBar.decrease(2);
                if (currentToy != null) removeObject(currentToy); 
                currentToy = new Toy();
                addObject(currentToy, 200, 250);
                break;
            case "Feed":
                hungerBar.increase(15);
                happinessBar.increase(5);

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
            showText("", getWidth() / 2, 60); // Clear “sleeping” warning
        }
    }

    /**
     * Updates the pet's image based on current stat levels.
     * Prioritizes death first, then other moods if pet is alive and awake.
     */
    private void updatePetMood()
    {
        // ?Always show dead if health is 0 or less
        if (isGameOver || healthBar.getValue() <= 0)
        {
            pet.setToDead();
            return;
        }

        // ?Skip mood logic if pet is sleeping
        if (isSleeping) return;

        // ?Mood based on current stat levels
        if (happinessBar.getValue() < 50)
        {
            pet.setToAngry();
        }
        else if (energyBar.getValue() < 50)
        {
            pet.setToSleepy();
        }
        else if (hungerBar.getValue() < 50)
        {
            pet.setToHungry();
        }
        else
        {
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
            showText("Warning: Pet's health is low", getWidth() / 2, 30);
        }
        else if (energyBar.getValue() < 50 && energyBar.getValue() > 0)
        {
            showText("Warning: Pet is low on energy", getWidth() / 2, 30);
        }
        else if (hungerBar.getValue() < 50 && hungerBar.getValue() > 0)
        {
            showText("Warning: Pet is getting hungry", getWidth() / 2, 30);
        }
    }

    public boolean isGameOver()
    {
        return isGameOver;
    }
    
    class SimpleText extends Actor{
        public SimpleText(){
            GreenfootImage img = new GreenfootImage(150, 100);
            img.setColor(Color.BLACK);
            img.setFont(new Font("Arial", false, false, 20));
            img.drawString("Math Game!", 10, 25);
            
            setImage(img);
        }
    }

}
