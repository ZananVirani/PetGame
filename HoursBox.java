import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.time.LocalTime;

/**
 * The HoursBox class allows the user to select and adjust the hour value.
 * 
 * It displays the current hour and provides up and down arrows for incrementing or decrementing the hour. The hour value loops between 0 and 23,
 * ensuring a 24-hour format. Clicking above or below the box adjusts the hour accordingly.
 * 
 * This class is used as part of the parental control time restriction settings.
 * 
 * Example usage:
 * HoursBox box = new HoursBox(LocalTime.now());
 * addObject(box, 100, 100);
 * 
 * @author Group 78
 */
public class HoursBox extends Actor
{
    private int hour = 0;

    /**
     * Constructs an HoursBox object and initializes its hour value.
     * 
     * @param lt LocalTime object to initialize the hour value; if null, defaults to 0.
     */
    public HoursBox(LocalTime lt) {
        if (lt != null)
        hour = lt.getHour();
        else
        hour = 0;
        
        updateImage();
    }

    /**
     * Act method - updates the hour value based on mouse click position.
     * 
     * If the user clicks above the box, the hour increments by 1 (mod 24). If the user clicks below the box, the hour decrements by 1 (mod 24).
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            int mouseY = Greenfoot.getMouseInfo().getY();
            int y = getY();

            if (mouseY < y - 10) {
                hour = (hour + 1) % 24;
                updateImage();
            } else if (mouseY > y + 10) {
                hour = (hour + 23) % 24; // circular down
                updateImage();
            }
        }
    }


    /**
     * Updates the visual representation of the HoursBox.
     * 
     * Draws the current hour along with up and down arrows.
     */
    private void updateImage() {
        GreenfootImage img = new GreenfootImage(100, 100);
        img.setColor(Color.WHITE);
        img.fill();
        img.setColor(Color.BLACK);
        img.drawRect(0, 0, 70, 99);

        img.setFont(new Font("Arial", false, false, 18));
        img.drawString("▲", 28, 20); // up arrow
        img.drawString(String.format("%02d hrs", hour), 15, 55);
        img.drawString("▼", 28, 90); // down arrow

        setImage(img);
    }

    /**
     * Retrieves the current hour value stored in this HoursBox.
     * 
     * @return the hour value (0-23)
     */
    public int getHour() {
        return hour;
    }
}
