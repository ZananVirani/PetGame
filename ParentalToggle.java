import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ParentalToggle class represents a toggle button in the game that allows the player or user to enable or disable a parental restriction feature.
 * 
 * The toggle displays two options visually: "Enable" and "Disable". When clicked, the toggle state switches between enabled and disabled, updating the
 * button appearance accordingly.
 * 
 * This feature is useful for controlling access to certain game functions or limiting gameplay for younger users.
 * 
 * @author (Your name)
 * @version (a version number or a date)
 */
public class ParentalToggle extends Actor
{
    private boolean enabled;
    private static final int WIDTH = 200;
    private static final int HEIGHT = 60;

    /**
     * Constructs a ParentalToggle button and initializes its visual appearance. The initial state is set to disabled.
     */
    public ParentalToggle()
    {
        updateImage();
    }

    /**
     * Act method - called whenever the 'Act' or 'Run' button is pressed.
     * If the toggle button is clicked, the state is flipped (enabled/disabled) and the visual appearance is updated.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            enabled = !enabled;
            updateImage();
        }
    }

    /**
     * Updates the visual appearance of the toggle button based on its current state. Displays two options "Enable" and "Disable", with the active option
     * highlighted.
     */
    private void updateImage()
    {
        GreenfootImage img = new GreenfootImage(WIDTH, HEIGHT);
        img.setColor(Color.WHITE);
        img.fill();
        img.setColor(Color.BLACK);

        int circleY = HEIGHT / 2 - 10;

        // Enable option
        img.setColor(enabled ? Color.MAGENTA : Color.BLACK);
        img.fillOval(20, circleY, 20, 20);
        img.drawString("Enable", 50, circleY + 16);

        // Disable option
        img.setColor(!enabled ? Color.MAGENTA : Color.BLACK);
        img.fillOval(120, circleY, 20, 20);
        img.drawString("Disable", 150, circleY + 16);

        setImage(img);
    }

    /**
     * Returns the current state of the toggle.
     * 
     * @return true if the parental toggle is enabled, false otherwise.
     */
    public boolean isEnabled()
    {
        return enabled;
    }
}

