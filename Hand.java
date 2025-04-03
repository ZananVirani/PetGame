import greenfoot.*;

/**
 * The Hand class represents a hand animation that appears when the player pets their virtual pet.
 * 
 * The animation lasts for a short duration and disappears automatically after a timer runs out. Additionally, if the game is over, the animation stops
 * immediately.
 * 
 * This class adds visual feedback to the petting interaction in the game.
 * 
 * Example usage:
 * addObject(new Hand(), 300, 300);
 * 
 * @author Group 78
 */
public class Hand extends Actor
{
    // Timer to control how long the hand animation stays on the screen
    private int timer = 60;

    /**
     * Constructs a Hand object.
     * 
     * Sets the image of the hand and scales it to the appropriate size.
     */
    public Hand()
    {
        setImage("hand.png");
        getImage().scale(200, 200);
    }

    /**
     * Act method - controls the animation behavior of the hand.
     * 
     * - If the current world is an instance of PlayWithPetScreen and the game is over, the animation stops.
     * - Otherwise, the hand gently moves up and down and disappears after the timer runs out.
     * 
     * This method is automatically called by the Greenfoot environment during each act cycle.
     */
    public void act()
    {
        if (getWorld() instanceof PlayWithPetScreen) 
        {
            PlayWithPetScreen screen = (PlayWithPetScreen) getWorld();
            if (screen.isGameOver()) return;
        }

        setLocation(getX(), getY() + Greenfoot.getRandomNumber(3) - 1);
        timer--;
        if (timer <= 0) getWorld().removeObject(this);
    }
}
