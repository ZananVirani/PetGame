import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * TutorialScreen class is a screen that displays the tutorial screen.
 * 
 * This world provides a short summary of how to play the game.
 * It includes instructions on how to care for the pet, track its vitals,
 * and manage screen time. The tutorial is designed to be informative
 * and user-friendly, ensuring that players understand the game mechanics
 * before they start playing.
 * 
 * @author Group 78
 */
public class TutorialScreen extends World {

    /**
     * Constructor for objects of class TutorialScreen.
     */
    public TutorialScreen() {
        // Create a new world with 700x500 cells with a cell size of 1x1 pixels.
        super(700, 500, 1);
        // Text to be displayed
        String tutorialText = "• Choose your pet, give it a name, and let the fun begin!\n" +
                "• Use buttons to feed, play, and care for your pet daily.\n" +
                "• Track pet vitals: health, happiness, sleepiness, and fullness.\n" +
                "• Pet not feeling great? Take it to the vet or let it sleep!\n" +
                "• Use your inventory to give gifts and feed your pet treats.\n" +
                "• Collect cool items by earning points through good pet care!\n" +
                "• Commands like play, feed, and sleep are just a click away.\n" +
                "• Parents can manage screen time with password-protected settings.\n" +
                "• Your pet reacts — get it happy, sleepy, or even a little angry!\n" +
                "• Keep your pet alive and well... or it might just ghost you 😢\n" +
                "• Too attached to a pet and you lost? Get your parent to revive it!";

        // Leave button
        addObject(new Cross(), 50, 50);
        // Subtitle text
        addObject(new SubtitleText(tutorialText), 400, 280);
        // Title text
        addObject(new TitleText("Tutorial"), 650, 200);
    }

    /**
     * Handles the click event for the world, just to trigger the sound.
     */
    public void act() {
        if (Greenfoot.mouseClicked(null))
            SoundManager.playClick();
    }
}
