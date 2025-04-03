import greenfoot.*;
/**
 * The ParagraphText class is responsible for displaying a block of text (paragraph) in the Greenfoot environment. It creates a visual box containing the
 * given message.
 * 
 * This class is used to display instructions, descriptions, or other lengthy messages to the player within the game screen.
 * 
 * @author Group 78
 */
public class ParagraphText extends Actor
{
    /**
     * Constructs a ParagraphText object with the specified message. The message is rendered in a black font on a large image background.
     * 
     * @param message The text content to be displayed as a paragraph.
     */
    public ParagraphText(String message)
    {
        GreenfootImage img = new GreenfootImage(700, 300);
        img.setColor(Color.BLACK);
        img.setFont(new Font("Arial", false, false, 15));
        img.drawString(message, 10, 25);
        setImage(img);
    }

    /**
     * Act - currently no behavior.
     * This method is called whenever the 'Act' or 'Run' button is pressed in the environment.
     */
    public void act()
    {
        // No specific action required.
    }
}