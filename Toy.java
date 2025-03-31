import greenfoot.*;

/**
 * Toy bounces around while pet is playing. Stops if the game is over.
 */
public class Toy extends Actor
{
    private int dx = 4;
    private int dy = 3;
    private int lifetime = 300;
    
    public Toy()
    {
    }

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
    

    private void moveAround()
    {
        setLocation(getX() + dx, getY() + dy);

        if (getX() <= 10 || getX() >= getWorld().getWidth() - 10) dx = -dx;
        if (getY() <= 10 || getY() >= getWorld().getHeight() - 10) dy = -dy;
    }
}
