import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * TitleText displays a large title text message on the screen. This class is used to show the title of a tutorial or any other section in the game
 * environment.
 * 
 * It creates a bold, large-sized black title on a transparent background.
 * 
 * Example Usage:
 * new TitleText("Welcome to the Game!");
 * 
 * @author Group 78
 */
public class TitleText extends Actor
{
    /**
     * Creates a new TitleText object with the specified message. The message is displayed in large black font.
     * 
     * @param message The title text to display.
     */
    public TitleText(String message) {
        GreenfootImage img = new GreenfootImage(700, 300);
        img.setColor(Color.BLACK);
        img.setFont(new Font("Arial", false, false, 30));
        img.drawString(message, 10, 25);
        setImage(img);
    }

    /**
     * Act method - currently does nothing.
     * Can be used to add behavior to the title text if needed.
     */
    public void act()
    {
        // Add your action code here.
    }
}
