import greenfoot.*;

/**
 * The {@code Pet} class represents the virtual pet character in the game.
 * It manages the visual appearance and mood/state of the pet by changing its image
 * based on its current emotional or physical state (e.g., normal, hungry, sleepy, angry, dead, etc.).
 * <p>
 * The class supports scaling the pet image to a fixed size and provides methods
 * to update the pet's mood based on user interactions or game logic.
 * 
 * This class is a key component of the virtual pet simulation, contributing to the pet's interactivity.
 * 
 * @author (Your name)
 * @version (a version number or a date)
 */
public class Pet extends Actor {
    private String currentState = "";
    private String type;
    private static final int PET_WIDTH = 200;
    private static final int PET_HEIGHT = 200;

    /**
     * Constructs a {@code Pet} object with a default appearance.
     * Initializes the pet type based on the {@code PetClass} and sets the pet to its normal state.
     */
    public Pet() {
        type = PetClass.getType().toLowerCase();
        setToNormal(); // Default state
    }

    /**
     * Sets the pet's appearance to the normal state. Updates the image only if the current state is not already "normal".
     */
    public void setToNormal() {
        if (!currentState.equals("normal")) {
            setScaledImage(type + "Normal.png");
            currentState = "normal";
        }
    }

    /**
     * Sets the pet's appearance to the hungry state. Updates the image only if the current state is not already "hungry".
     */
    public void setToHungry() {
        if (!currentState.equals("hungry")) {
            setScaledImage(type + "Hungry.png");
            currentState = "hungry";
        }
    }

    /**
     * Sets the pet's appearance to the sleepy state. Updates the image only if the current state is not already "sleepy".
     */
    public void setToSleepy() {
        if (!currentState.equals("sleepy")) {
            setScaledImage(type + "Sleepy.png");
            currentState = "sleepy";
        }
    }

    /**
     * Sets the pet's appearance to the angry state. Updates the image only if the current state is not already "angry".
     */
    public void setToAngry() {
        if (!currentState.equals("angry")) {
            setScaledImage(type + "Angry.png");
            currentState = "angry";
        }
    }

    /**
     * Sets the pet's appearance to the dead state. Updates the image only if the current state is not already "dead".
     */
    public void setToDead() {
        if (!currentState.equals("dead")) {
            setScaledImage(type + "Dead.png");
            currentState = "dead";
        }
    }

    /**
     * Sets the pet's appearance to the sleeping state. Updates the image only if the current state is not already "sleeping".
     */
    public void setToSleeping() {
        if (!currentState.equals("sleeping")) {
            setScaledImage(type + "Sleeping.png");
            currentState = "sleeping";
        }
    }

    /**
     * Sets the pet's appearance to the exercise state. Displays the initial exercise frame.
     * Updates the image only if the current state is not already "exercise".
     */
    public void setToExercise() {
        if (!currentState.equals("exercise")) {
            setScaledImage(type + "Active1.png");
            currentState = "exercise";
        }
    }

    /**
     * Sets and scales the pet's image based on the provided filename. This method is used internally to load and resize the image.
     * 
     * @param filename The name of the image file to be displayed.
     */
    private void setScaledImage(String filename) {
        GreenfootImage img = new GreenfootImage(filename);
        img.scale(PET_WIDTH, PET_HEIGHT);
        setImage(img);
    }

    /**
     * Sets and scales the pet's image for an exercise animation frame. This method is intended to be used for manually animating the pet while
     * exercising.
     * 
     * @param filename The name of the image file to be displayed as part of the animation.
     */
    public void setExerciseFrame(String filename) {
        GreenfootImage img = new GreenfootImage(filename);
        img.scale(PET_WIDTH, PET_HEIGHT);
        setImage(img);
    }

    /**
     * Manually sets the pet's current state. This method is useful when managing custom animations or external state updates.
     * 
     * @param state The new state of the pet.
     */
    public void setCurrentState(String state) {
        currentState = state;
    }

    /**
     * Retrieves the pet's current state.
     * 
     * @return A {@code String} representing the current state of the pet.
     */
    public String getState() {
        return currentState;
    }
}