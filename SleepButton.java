import greenfoot.*;

/**
 * SleepButton is a toggle button that controls the pet's sleep mode. Clicking the button will either put the pet to sleep or wake it up, depending on
 * its current state. It also checks if the pet's sleep level is full and resets the pet's state if necessary.
 * 
 * The button's label dynamically changes between "Sleep" and "Wake Up".
 * 
 * @author Group 78
 */
public class SleepButton extends Actor {
    private PlayWithPetScreen screen;
    private boolean sleeping = false;

    /**
     * Constructs a SleepButton associated with the PlayWithPetScreen.
     * 
     * @param screen The PlayWithPetScreen that contains the pet.
     */
    public SleepButton(PlayWithPetScreen screen) {
        this.screen = screen;
        updateImage();
    }

    /**
     * Act - checks if the sleep button is clicked or if the pet's sleep level is full.
     * Updates the pet's sleep mode accordingly and refreshes the button appearance.
     */
    public void act() {
        if (PetClass.getSleep() >= 100) {
            sleeping = false;
            screen.getPet().setToNormal();
            screen.getPet().setCurrentState("normal");
        }

        if (Greenfoot.mouseClicked(this)) {
            if (!sleeping || PetClass.getSleep() < 100) {
                sleeping = true;
                screen.setSleepingMode(sleeping);
                updateImage();
            }
        }
    }

    /**
     * Updates the appearance of the button based on the sleeping state. Displays "Sleep" or "Wake Up" accordingly.
     */
    private void updateImage() {
        int width = 120;
        int height = 30;
        String label = sleeping ? "Wake Up" : "Sleep";

        GreenfootImage img = new GreenfootImage(width, height);

        // Shadow effect
        img.setColor(new Color(50, 50, 50)); // dark gray
        img.fillRect(3, 3, width - 3, height - 3);

        // Button background
        img.setColor(new Color(80, 160, 255)); // light blue
        img.fillRect(0, 0, width - 3, height - 3);

        // Text
        img.setColor(Color.BLACK);
        img.setFont(new Font("Arial", 14));
        int textX = 10;
        int textY = height / 2 + 5;
        img.drawString(label, textX, textY);

        setImage(img);
    }
}

