import greenfoot.*;

/**
 * Pet represents the virtual pet and allows changing its appearance.
 */
public class Pet extends Actor
{
    private String currentState = "";
    private int scale = 200;

    public Pet()
    {
        setToNormal();
    }

    public void setToNormal()
    {
        if (!currentState.equals("normal"))
        {
            setImage("Cat.png");
            getImage().scale(scale, scale); 
            currentState = "normal";
        }
    }

    public void setToHungry()
    {
        if (!currentState.equals("hungry"))
        {
            setImage("catHungry.png");
            getImage().scale(scale, scale);
            currentState = "hungry";
        }
    }

    public void setToSleepy()
    {
        if (!currentState.equals("sleepy"))
        {
            setImage("catSleepy.png");
            getImage().scale(scale, scale);
            currentState = "sleepy";
        }
    }

    public void setToDead()
    {
        if (!currentState.equals("dead"))
        {
            setImage("catDead.png");
            getImage().scale(scale, scale);
            currentState = "dead";
        }
    }

    public void setToAngry()
    {
        if (!currentState.equals("angry"))
        {
            setImage("catAngry.png");
            getImage().scale(scale, scale);
            currentState = "angry";
        }
    }

    public void setToSleeping()
    {
        if (!currentState.equals("sleeping"))
        {
            setImage("catSleeping.png");
            getImage().scale(scale, scale);
            currentState = "sleeping";
        }
    }

    public String getState()
    {
        return currentState;
    }
}

