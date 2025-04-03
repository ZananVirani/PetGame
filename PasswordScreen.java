import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This world lets parents enter their password that will allow them to access
 * the parental controls screen.
 * 
 * The password is hardcoded to "ilovecs2212". If the password is entered
 * correctly, the user is taken to the parental controls screen. If the password
 * is incorrect, the user is taken to the incorrect password screen, which is a
 * child of this screen.
 * 
 * @author Group 78
 * @see IncorrectScreen
 * @see ParentalControls
 * @see ConfirmButton
 */
public class PasswordScreen extends World {

    /**
     * Constructor for objects of class PasswordScreen.
     */
    public PasswordScreen() {
        // Create a new world with 700x500 cells with a cell size of 1x1 pixels.
        super(700, 500, 1);

        // Title
        addObject(new pageTitle("Please Enter Your Password"), 350, 60);
        // Input for the password
        NameInput nameInput = new NameInput("Password: ");
        addObject(nameInput, 300, 280);
        // Leave button
        addObject(new Cross(), 50, 50);
        // Handles the logic for password confirmation
        ConfirmButton confirmButton = new ConfirmButton(nameInput);
        addObject(confirmButton, 600, 450);
    }

    /**
     * Handles the click event for the world, just to trigger the sound.
     */
    public void act() {
        if (Greenfoot.mouseClicked(null))
            SoundManager.playClick();
    }
}
