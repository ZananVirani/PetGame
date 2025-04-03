import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The end screen of the game when the user leaves the game.
 * 
 * This is the screen that appears when ther user wants to close the game, and
 * is a work-around from the fact
 * that the Greenfoot IDE does not offer a convenient, safe way for the game to
 * properly exit.
 * 
 * @author Group 78
 */
public class BlackScreen extends World {

    /**
     * Constructor for objects of class GameOver.
     * 
     * Draws a gray screen with a message in the center, thanking the player for
     * playing.
     */
    public BlackScreen() {
        // Create a new world with 700x500 cells with a cell size of 1x1 pixels.
        super(700, 500, 1);

        // Set the background color to gray
        getBackground().setColor(Color.GRAY);
        getBackground().fill();

        // Set the text color to white and draw the text
        showText("Thanks for playing :)", getWidth() / 2, getHeight() / 2);
    }

    /**
     * When the act method is called, stop the game.
     */
    public void act() {
        Greenfoot.stop();
    }
}
