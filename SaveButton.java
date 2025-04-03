import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The SaveButton class represents a button that allows the player to save the current game state. When clicked, it attempts to save the game and
 * displays a confirmation message. If saving fails, an error message is displayed.
 * 
 * The "Saved!" message will disappear after 2 seconds.
 *
 * @author Group 78
 */
public class SaveButton extends Actor
{
    private World world;
    private long savedMessageTime = 0;

    /**
     * Constructs a SaveButton and associates it with the specified world.
     * 
     * @param world The world where the save button is placed.
     */
    public SaveButton(World world) {
        this.world = world;
        savedMessageTime = 0;
        GreenfootImage img = new GreenfootImage("SAVE GAME", 24, Color.BLACK, new Color(200, 200, 200, 150));
        setImage(img);
    }

    /**
     * Act - checks if the button is clicked to save the game. Displays a confirmation or error message and clears the message after 2 seconds.
     */
    public void act(){
        if (Greenfoot.mouseClicked(this)){
            try{
                GameState.saveAll();
            } catch (Exception e){
                System.out.println(e);
                world.showText("SOMETHING WENT WRONG!", 325, 200);
            }
            world.showText("Saved!", 325, 80);
            savedMessageTime = System.currentTimeMillis();
        }

        if (savedMessageTime > 0 && System.currentTimeMillis() - savedMessageTime > 2000) {
            world.showText("", 325, 80); // Clear message
            savedMessageTime = 0;
        }
    }
}

