import greenfoot.*;

/**
 * Hand animation appears when petting. Stops if the game is over.
 */
public class Hand extends Actor
{
    private int timer = 60;

    public Hand()
    {
        setImage("hand.png");
        getImage().scale(200, 200);
    }

    public void act()
    {
        if (getWorld() instanceof PlayWithPetScreen) {
            PlayWithPetScreen screen = (PlayWithPetScreen)getWorld();
            if (screen.isGameOver()) return;
        }

        setLocation(getX(), getY() + Greenfoot.getRandomNumber(3) - 1);
        timer--;
        if (timer <= 0) getWorld().removeObject(this);
    }
}
