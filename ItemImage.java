import greenfoot.*;

/**
 * The ItemImage class represents an item image that temporarily appears on the screen.
 * 
 * This class is used to display an item (such as food or gifts) when the user interacts with the game (e.g., selects or uses an item). The image is
 * shown for a limited time and then disappears automatically.
 * 
 * The item's image file is dynamically loaded based on the file name passed to the constructor. Spaces in the file name are removed and the name is
 * converted to lowercase to match the expected file name format.
 * 
 * Example usage:
 * ItemImage image = new ItemImage("Pizza", world);
 * 
 * @author Group 78
 */
public class ItemImage extends Actor
{
    private int lifetimer;
    private World world;

    /**
     * Constructs an ItemImage object with the specified file name and world. Loads the corresponding image file, scales it, and initializes the lifetime.
     * 
     * @param file  The name of the item image file (without extension).
     * @param world The current Greenfoot world where the image will be displayed.
     */
    public ItemImage(String file, World world)
    {
        this.world = world;
        setImage(toFlatLowercase(file) + ".png");
        GreenfootImage img = getImage();
        img.scale(60, 60);
        setImage(img);

        lifetimer = 200; // Lifetime duration in frames
    }

    /**
     * Act method - Controls the lifetime of the ItemImage.
     * 
     * Decreases the lifetime counter on every frame. Once the lifetime expires, the image is removed from the world.
     */
    public void act()
    {
        lifetimer--;
        if (lifetimer <= 0) 
        {
            world.removeObject(this);
            world.showText("", 450, 370);
        }
    }

    /**
     * Converts the input string to lowercase and removes all whitespace.
     * 
     * This ensures that the image file name format is consistent and file loading succeeds.
     * 
     * @param input The original string input.
     * @return The formatted string with lowercase letters and no spaces.
     */
    public String toFlatLowercase(String input) 
    {
        return input.toLowerCase().replaceAll("\\s+", "");
    }
}
