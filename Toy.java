import greenfoot.*;

/**
 * Toy bounces around while the pet is playing. The Toy moves in a bouncing pattern and disappears after a certain lifetime. It stops moving if the game
 * is over. Used to create an interactive effect on the play screen.
 * 
 * @author Group 78
 */
public class Toy extends Actor
{
    private int dx = 4;
    private int dy = 3;
    private int lifetime = 300;
    
    public Toy()
    {
    }

    /**
     * Act method - called repeatedly to update the toy's behavior.
     * Handles bouncing movement, lifetime expiry, and stops if the game is over.
     */
    public void act()
    {
        lifetime--;
        if (lifetime <= 0){
            getWorld().removeObject(this);
            return;
        }
        
        // Stop moving if game is over
        if (getWorld() instanceof PlayWithPetScreen) {
            PlayWithPetScreen screen = (PlayWithPetScreen)getWorld();
            if (screen.isGameOver()) return;
        }

        moveAround();
    }
    
    /**
     * Moves the toy around in a bouncing pattern. Reverses direction when reaching the edges of the world.
     */
    private void moveAround()
    {
        setLocation(getX() + dx, getY() + dy);

        if (getX() <= 10 || getX() >= getWorld().getWidth() - 10) dx = -dx;
        if (getY() <= 10 || getY() >= getWorld().getHeight() - 10) dy = -dy;
    }
}
