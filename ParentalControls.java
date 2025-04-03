import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Screen where parental settings can be set.
 * 
 * ParentalControls is a world that allows parents to set playtime restrictions,
 * view playtime statistics, and click a button to go to another screen where
 * they
 * can revive pets for their child.
 * 
 * Playtime restrictions are only enabled if the ParentalToggle is enabled, and
 * then
 * the check button is clicked.
 * 
 * @author Group 78
 * @see Player
 */
public class ParentalControls extends World {

    /**
     * Constructor for objects of class ParentalControls.
     */
    public ParentalControls() {
        // Create a new world with 700x500 cells with a cell size of 1x1 pixels.
        super(700, 500, 1);

        // Start time allowed
        HoursBox h1 = new HoursBox(Player.getStartTime());
        MinutesBox m1 = new MinutesBox(Player.getStartTime());

        // End time allowed
        HoursBox h2 = new HoursBox(Player.getEndTime());
        MinutesBox m2 = new MinutesBox(Player.getEndTime());

        // Leave button
        addObject(new Cross(), 50, 50);
        // Title
        addObject(new TitleText("Parental Controls"), 590, 200);
        // Subtitle
        addObject(new SubtitleText("Playtime Restrictions"), 620, 260);

        // Parental Toggle to enable or disable restrictions
        ParentalToggle pt = new ParentalToggle();
        addObject(pt, 370, 170);

        // Subtitle
        addObject(new SubtitleText("Allowable Play\nTime:"), 370, 370);
        // Hyphen
        addObject(new TitleText(" -"), 690, 390);

        // Load objects
        addObject(h1, 220, 250);
        addObject(m1, 310, 250);
        addObject(h2, 440, 250);
        addObject(m2, 530, 250);

        // Statistics
        addObject(new SubtitleText("Playtime Statistics"), 633, 470);
        addObject(new ParagraphText(String.format("Average Session: %.2fmins", Player.getAverageSession())), 490, 530);
        addObject(new ParagraphText(String.format("Total Time: %d hrs and %d mins", Player.getTotalTime().toHours(),
                Player.getTotalTime().toMinutes())), 740, 530);

        // Perform logic when button is clicked.
        addObject(new CheckConfirm(h1, m1, h2, m2, pt, this), 620, 250);

        // Go to revival screen
        addObject(new ReviveButton(), 370, 440);
    }

    /**
     * Handles the click event for the world, just to trigger the sound.
     */
    public void act() {
        if (Greenfoot.mouseClicked(null))
            SoundManager.playClick();
    }
}
