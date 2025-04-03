import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.time.LocalTime;

/**
 * The CheckConfirm class represents a checkmark confirmation button in the Greenfoot environment.
 * This button is used to save and apply the player's selected time restrictions from the 
 * HoursBox and MinutesBox components. It also interacts with the parental toggle option.
 * 
 * When clicked, the button either sets or removes the player's time restrictions based on the toggle state.
 * A visual circular checkmark icon is displayed as the button.
 * 
 * This class is part of the parental control system in the game.
 * 
 * Example usage:
 * addObject(new CheckConfirm(h1, m1, h2, m2, toggle, world), x, y);
 * 
 * @author 
 * @version 1.0
 */
public class CheckConfirm extends Actor
{
    private HoursBox hours1, hours2;
    private MinutesBox minutes1, minutes2;
    private ParentalToggle toggle;
    private World world;

    /**
     * Constructs a CheckConfirm button with the specified hour boxes, minute boxes,
     * parental toggle, and associated world. Initializes the checkmark icon.
     * 
     * @param h1 First HoursBox instance
     * @param m1 First MinutesBox instance
     * @param h2 Second HoursBox instance
     * @param m2 Second MinutesBox instance
     * @param pt ParentalToggle instance
     * @param world The Greenfoot world where the button is added
     */
    public CheckConfirm(HoursBox h1, MinutesBox m1, HoursBox h2, MinutesBox m2, ParentalToggle pt, World world)
    {
        hours1 = h1;
        hours2 = h2;
        minutes1 = m1;
        minutes2 = m2;
        toggle = pt;
        this.world = world;

        GreenfootImage check = getImage();
        check.scale(30, 30); // Scale checkmark image

        GreenfootImage img = new GreenfootImage(40, 40);
        img.setColor(Color.GRAY);
        img.drawOval(0, 0, 39, 39); // Draw circular border

        img.drawImage(check, 5, 5); // Center the checkmark
        
        setImage(img);
    }

    /**
     * Act method - listens for mouse clicks on the CheckConfirm button.
     * When clicked, it reads the selected start and end times from the HoursBox and MinutesBox,
     * checks if parental restrictions are enabled, and saves the appropriate time restrictions.
     * Displays a confirmation message once saved.
     * 
     * This method is automatically called by the Greenfoot environment in each act cycle.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            int firstHr = hours1.getHour();
            int secondHr = hours2.getHour();
            int firstMin = minutes1.getMinutes();
            int secondMin = minutes2.getMinutes();

            LocalTime startTime = LocalTime.of(firstHr, firstMin);
            LocalTime endTime = LocalTime.of(secondHr, secondMin);
            boolean enabled = toggle.isEnabled();

            if (enabled)
            {
                Player.setTimeRestrictions(startTime, endTime);
            }
            else
            {
                Player.setTimeRestrictions(null, null);
            }

            GameState.savePlayer();
            world.showText("Saved!", 620, 300);
        }
    }
}
