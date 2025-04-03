import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Calculator class represents an interactive calculator icon in the Greenfoot environment.When the user clicks on this icon, it opens the
 * MathTutorial screen, which likely contains a tutorial or educational content related to mathematics.
 * 
 * This class is part of the game's user interface, allowing players to access math learning features.
 * The calculator image is resized for proper display.
 * 
 * Example usage:
 * addObject(new Calculator(), 300, 250);
 * 
 * @author Group 78
 */
public class Calculator extends Actor
{
    /**
     * Constructs a Calculator object and scales its image to a standard size (60x60).
     * The scaled image improves visibility and maintains consistency with other UI elements.
     */
    public Calculator() 
    {
        GreenfootImage img = getImage();
        img.scale(60, 60);
        setImage(img);
    }

    /**
     * Act method - checks for mouse clicks on the Calculator icon. When clicked, it navigates the player to the MathTutorial screen.
     * This method is called automatically by the Greenfoot environment during each act cycle.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) 
        {
            ScreenManager.push(new MathTutorial());
        }
    }
}