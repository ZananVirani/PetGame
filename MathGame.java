import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MathGame is the main game world where the player can answer math questions to
 * win prizes.
 * 
 * This world prompts the player with a math question and allows them to input
 * their answer. If they
 * get 10 questions correct, they will receive a gift. The game also keeps track
 * of the player's score
 * and awards food and gifts based on their performance. This was done to
 * encourage players to
 * continue playing, exercise their mind, and to reward them for their efforts.
 * 
 * @author Group 78
 * @see MathBackend
 * @see Score
 * @see TextInput
 */
public class MathGame extends World {
    // Timer to keep track of how long the player has been playing for.
    private int globalTimer;
    // Mutable score object to keep track of the player's score.
    private Score currentScore;

    /**
     * Constructor for objects of class MathGame, initializes the world with a score
     * and
     * sets up the game interface.
     */
    public MathGame() {
        // Create a new world with 700x500 cells with a cell size of 1x1 pixels.
        super(700, 500, 1);

        // Load the score from the PetClass, which is saves the player's previous score.
        currentScore = new Score(PetClass.getScore());

        // Load icons
        QuestionDisplay qDisplay = new QuestionDisplay();
        ResultIcon resIcon = new ResultIcon();

        // Input field for the player to enter their answer.
        // The TextInput class handles the input and submission of the answer.
        TextInput input = new TextInput(150, 45, currentScore, qDisplay, resIcon, this);

        // Leave button
        addObject(new Cross(), 50, 50);
        // EquationBox
        addObject(new BorderBox(450, 150), 350, 180);
        // Equation Text
        addObject(qDisplay, 350, 180);
        // Your Answer:
        addObject(new BoldText("Your Answer: ", 30), 120, 340);
        // Answer Text Box
        addObject(new BorderBox(300, 60), 390, 340);
        // Submit Button
        addObject(new SubmitButton(input), 480, 340);
        // Your Score:
        addObject(new BoldText("Your Score: ", 30), 110, 430);
        // Current Score:
        addObject(new ScoreDisplay(currentScore), 220, 430);
        // User Input
        addObject(input, 330, 340);
        // Result Icon
        addObject(resIcon, 590, 340);
        // Next Question Button
        addObject(new NextQButton(input), 570, 440);

        // Initialize the timer to 0.
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
