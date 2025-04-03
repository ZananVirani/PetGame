import greenfoot.*;
/**
 * The InventoryIcon class represents an icon used to access the player's inventory.
 * 
 * This icon is displayed on the screen and when clicked, will open the Inventory screen, allowing the player to view their collected items. 
 * The icon image is scaled to a standard size to ensure consistency in the user interface.
 * 
 * Example usage:
 * InventoryIcon icon = new InventoryIcon();
 * addObject(icon, 100, 100);
 * 
 * @author Group 78
 */
public class InventoryIcon extends Actor
{
    /**
     * Constructs an InventoryIcon and scales its image to the appropriate size.
     */
    public InventoryIcon()
    {
        GreenfootImage img = getImage();
        img.scale(80, 80);
        setImage(img);
    }

    /**
     * Act method - Defines the behavior of the InventoryIcon.
     * 
     * This method is called on every frame and is responsible for detecting user interactions.
     * (You can implement functionality here such as opening the InventoryScreen when clicked.)
     */
    public void act()
    {
        // Currently empty - can be used to handle click event to open inventory
    }
}
