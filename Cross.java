import greenfoot.*;

/**
 * The Cross class represents a cross (X) button in the user interface.  It is used to close or exit the current screen.
 * 
 * When clicked, if the current screen is the MainMenu, it opens a BlackScreen. Otherwise, it pops the current screen and returns to the previous one.
 * 
 * This class enhances navigation by providing a standard exit button.
 * 
 * Example usage:
 * addObject(new Cross(), 50, 50);
 * 
 * @author Group 78
 */
public class Cross extends Actor
{
    /**
     * Constructs a Cross object and scales its image to 50x50 pixels.
     */
    public Cross()
    {
        GreenfootImage image = getImage();
        image.scale(50, 50);
        setImage(image);
    }

    /**
     * Act method - listens for mouse clicks on the Cross button.
     * 
     * If the current world is the MainMenu, it pushes a BlackScreen to the screen stack. Otherwise, it pops the current screen, effectively closing it
     * and returning to the previous screen.
     * 
     * This method is called automatically by the Greenfoot environment in each act cycle.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            if (getWorld() instanceof MainMenu) 
            {
                ScreenManager.push(new BlackScreen());
            }
            else 
            {
                ScreenManager.pop();
            }
        }
    }
}
