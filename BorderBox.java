import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The BorderBox class is used to create a simple rectangular border box in the Greenfoot environment. The box has a specified width and height
 * and is outlined in black with no fill.
 * 
 * This class is useful for visually grouping or framing UI components such as text, buttons, or other interactive elements.
 * 
 * Example usage:
 * addObject(new BorderBox(200, 100), 300, 250);
 * 
 * @author Group 78
 */
public class BorderBox extends Actor
{
    /**
     * Constructs a BorderBox with the specified width and height. The box will have a black outline with no fill.
     * 
     * @param width The width of the border box.
     * @param height The height of the border box.
     */
    public BorderBox(int width, int height) 
    {
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(Color.BLACK);
        img.drawRect(0, 0, width - 1, height - 1); // outline only, no fill
        setImage(img);
    }
    
    /**
     * Act - do whatever the EquationBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
