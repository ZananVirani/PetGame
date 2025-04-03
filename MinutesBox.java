import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.time.LocalTime;

/**
 * The MinutesBox class represents a clickable UI element that displays and allows adjustment
 * of minute values in a 24-hour clock format. It can increment or decrement minutes when clicked.
 * 
 * This component is used in time setting screens to let users easily set the desired time.
 * 
 * @author Group 78
 */
public class MinutesBox extends Actor
{
    private int minutes;

    /**
     * Constructs a MinutesBox object with the current minute value.
     * 
     * @param lt LocalTime object used to initialize the minute value. If null, initializes minutes to 0.
     */
    public MinutesBox(LocalTime lt) {
        if (lt != null)
        minutes = lt.getMinute();
        else
        minutes = 0;
        
        updateImage();
    }

    /**
     * Act method is called when the 'Act' or 'Run' button is pressed in the environment. Checks if the MinutesBox is clicked and increments or
     * decrements the minutes based on click position.
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            int mouseY = Greenfoot.getMouseInfo().getY();
            int y = getY();

            if (mouseY < y - 10) {
                minutes = (minutes + 1) % 60;
                updateImage();
            } else if (mouseY > y + 10) {
                minutes = (minutes + 59) % 60; // circular down
                updateImage();
            }
        }
    }

    /**
     * Updates the visual appearance of the MinutesBox with the current minute value. Displays an up arrow, the current minute, and a down arrow.
     */
    private void updateImage() {
        GreenfootImage img = new GreenfootImage(100, 100);
        img.setColor(Color.WHITE);
        img.fill();
        img.setColor(Color.BLACK);
        img.drawRect(0, 0, 70, 99);

        img.setFont(new Font("Arial", false, false, 18));
        img.drawString("▲", 28, 20); // up arrow
        img.drawString(String.format("%02d min", minutes), 10, 55);
        img.drawString("▼", 28, 90); // down arrow

        setImage(img);
    }

    /**
     * Returns the current minute value displayed in the MinutesBox.
     * 
     * @return the current minutes value
     */
    public int getMinutes() {
        return minutes;
    }
}
