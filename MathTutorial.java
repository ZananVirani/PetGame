import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A simple world that serves as a tutorial for the math game.
 * 
 * This world provides instructions on how to play the game, including
 * how to answer questions and earn rewards. It acts as the bridge between
 * the main menu and the actual math game.
 * 
 * @author Group 78
 */
public class MathTutorial extends World {
    // Track the global timer for the game to contribute to player's time.
    private int globalTimer;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MathTutorial() {
        // Create a new world with 700x500 cells with a cell size of 1x1 pixels.
        super(700, 500, 1);

        // Load icons
        // Button to start the game
        LetsGoButton btn = new LetsGoButton();
        // Leave button
        addObject(new Cross(), 50, 50);
        // Paragraph Text
        addObject(new TutorialText(), 400, 280);
        // Title Text
        addObject(new TitleText("Math Game Tutorial"), 550, 200);
        addObject(btn, 570, 440);

        // Initialize the global timer to 0.
        globalTimer = 0;

    }

    /**
     * Keep track of time. All of the main logic is handled by the actors.
     * Handles the click event for the world, just to trigger the sound.
     */
    public void act() {
        if (Greenfoot.mouseClicked(null))
            SoundManager.playClick();
        globalTimer++;
        if (globalTimer % 60 == 0) {
            // Increment timer for the player every second.
            Player.incrementTime();
            // Reset the global timer to avoid overflow.
            globalTimer = 0;
        }
    }
}
