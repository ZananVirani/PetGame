import greenfoot.*;

/**
 * Pet represents the virtual pet and handles its mood/state images.
 */
public class Pet extends Actor
{
    private String currentState = "";
    private static final int PET_WIDTH = 200;
    private static final int PET_HEIGHT = 200;

    public Pet()
    {
        setToNormal(); // Default state
    }

    /**
     * Sets the pet to normal (default) appearance.
     */
    public void setToNormal()
    {
        if (!currentState.equals("normal"))
        {
            setScaledImage("cat.png");
            currentState = "normal";
        }
    }

    /**
     * Sets the pet to hungry appearance.
     */
    public void setToHungry()
    {
        if (!currentState.equals("hungry"))
        {
            setScaledImage("catHungry.png");
            currentState = "hungry";
        }
    }

    /**
     * Sets the pet to sleepy appearance.
     */
    public void setToSleepy()
    {
        if (!currentState.equals("sleepy"))
        {
            setScaledImage("catSleepy.png");
            currentState = "sleepy";
        }
    }

    /**
     * Sets the pet to angry appearance.
     */
    public void setToAngry()
    {
        if (!currentState.equals("angry"))
        {
            setScaledImage("catAngry.png");
            currentState = "angry";
        }
    }

    /**
     * Sets the pet to dead appearance.
     */
    public void setToDead()
    {
        if (!currentState.equals("dead"))
        {
            setScaledImage("catDead.png");
            currentState = "dead";
        }
    }

    /**
     * Sets the pet to sleeping appearance.
     */
    public void setToSleeping()
    {
        if (!currentState.equals("sleeping"))
        {
            setScaledImage("catSleeping.png");
            currentState = "sleeping";
        }
    }

    /**
     * Sets the pet to exercise appearance (initial frame).
     */
    public void setToExercise()
    {
        if (!currentState.equals("exercise"))
        {
            setScaledImage("catActive1.png");
            currentState = "exercise";
        }
    }

    /**
     * Directly sets and scales the image for the pet.
     */
    private void setScaledImage(String filename)
    {
        GreenfootImage img = new GreenfootImage(filename);
        img.scale(PET_WIDTH, PET_HEIGHT);
        setImage(img);
    }

    /**
     * Used when manually animating during exercise.
     */
    public void setExerciseFrame(String filename)
    {
        GreenfootImage img = new GreenfootImage(filename);
        img.scale(PET_WIDTH, PET_HEIGHT);
        setImage(img);
    }

    /**
     * Manually sets the pet's current state (used during animation).
     */
    public void setCurrentState(String state)
    {
        currentState = state;
    }

    /**
     * Returns the current state string.
     */
    public String getState()
    {
        return currentState;
    }
}