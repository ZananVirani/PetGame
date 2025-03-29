/**
 * The InventoryScreen class represents the inventory page in the Virtual Pet Simulator game.
 * It displays various in-game items, an add icon, a description panel, and an exit icon.
 * Players can click on items to view their descriptions and return to the main menu using the exit icon.
 * 
 * @author Jay Prajapati
 * @version March 29th 2025
 */

import greenfoot.*;
import java.util.*;

public class InventoryScreen extends World 
{
    private DescriptionPanel panel;

    /**
     * This is the constructor for objects of class InventoryScreen.
     * This function initializes and displays the inventory UI components.
     */
    public InventoryScreen() {
        super(700, 500, 1);

        AddIcon addIcon = new AddIcon();
        addObject(addIcon, 100, 100);

        InventoryItem item1 = new InventoryItem("Item One");
        addObject(item1, 200, 100);

        panel = new DescriptionPanel();
        addObject(panel, 550, 250);

        ExitIcon exit = new ExitIcon();
        addObject(exit, 650, 450);
    }

    /**
     * This funciton handles mouse click events in the inventory screen.
     * Updates description panel or navigates back to main menu.
     */
    public void act() {
        if (Greenfoot.mouseClicked(null)) {
            Actor clicked = Greenfoot.getMouseInfo().getActor();
            if (clicked instanceof InventoryItem) {
                panel.updateDescription(((InventoryItem) clicked).getItemName());
            } else if (clicked instanceof ExitIcon) {
                Greenfoot.setWorld(new MainMenu());
            }
        }
    }

    /**
     * The InventoryItem class represents an in-game item.
     */
    class InventoryItem extends Actor {
        private String itemName;

        /**
         * Constructs an InventoryItem with the specified name.
         * @param name The item name.
         */
        public InventoryItem(String name) {
            this.itemName = name;
            GreenfootImage img = new GreenfootImage(50, 50);
            img.setColor(Color.BLACK);
            img.drawRect(0, 0, 49, 49);
            setImage(img);
        }

        /**
         * Returns the name of the item.
         * @return The item name.
         */
        public String getItemName() {
            return itemName;
        }
    }

    /**
     * The AddIcon class represents the icon used to add new items.
     */
    class AddIcon extends Actor {
        public AddIcon() {
            GreenfootImage img = new GreenfootImage("addicon.png");
            img.scale(40, 40);
            setImage(img);
        }
    }

    /**
     * The ExitIcon class represents the icon used to exit the inventory screen.
     */
    class ExitIcon extends Actor {
        public ExitIcon() {
            GreenfootImage img = new GreenfootImage("exit.png");
            img.scale(40, 40);
            setImage(img);
        }
    }

    /**
     * The DescriptionPanel class represents a panel displaying item details.
     */
    class DescriptionPanel extends Actor {
        private GreenfootImage panel;
        private GreenfootImage cartIcon, heartIcon;

        /**
         * Constructs the DescriptionPanel and initializes icons.
         */
        public DescriptionPanel() {
            panel = new GreenfootImage(250, 400);
            cartIcon = new GreenfootImage("shoppingcart.png");
            heartIcon = new GreenfootImage("heart.png");
            cartIcon.scale(30, 30);
            heartIcon.scale(30, 30);
            updateDescription("");
        }

        /**
         * Updates the panel to display the description of a selected item.
         * @param itemName The name of the selected item.
         */
        public void updateDescription(String itemName) {
            panel.setColor(Color.WHITE);
            panel.fill();
            panel.setColor(Color.BLACK);
            panel.drawRect(0, 0, 249, 349);
            panel.drawString(itemName.isEmpty() ? "Item One Description" : itemName, 10, 20);
            panel.drawString("INFO", 10, 50);
            panel.drawString("+STATS", 10, 70);
            panel.drawString("-STATS", 10, 90);
            panel.drawString("PERKS", 10, 110);
            panel.drawImage(cartIcon, 10, 300);
            panel.drawImage(heartIcon, 50, 300);
            setImage(panel);
        }
    }
}
