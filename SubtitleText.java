import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * SubtitleText displays a subtitle message on the screen. It creates a text image with the provided message and shows it in the world.
 * 
 * This class can be used to display informational or narrative subtitles.
 * 
 * @author Group 78
 */
public class SubtitleText extends Actor
{
    /**
     * Constructs a SubtitleText with the specified message.
     * 
     * @param message The subtitle message to display.
     */
    public SubtitleText(String message) {
        GreenfootImage img = new GreenfootImage(700, 300);
        img.setColor(Color.BLACK);
        img.setFont(new Font("Arial", false, false, 20));
        img.drawString(message, 10, 25);
        setImage(img);
    }

    /**
     * Act - does nothing by default.
     * This method is called whenever the 'Act' or 'Run' button is pressed in Greenfoot.
     */
    public void act()
    {
        // No action needed for SubtitleText
    }
}