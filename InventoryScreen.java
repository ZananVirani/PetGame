import greenfoot.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

/**
 * The InventoryScreen class displays the player's inventory items dynamically based on the provided inventory array from the backend. It also shows item descriptions
 * and allows the player to navigate back to the main menu.
 * 
 * This screen contains interactive item icons, an exit button, and a description panel to display details of selected items.
 * 
 * @author Group 78
 */
public class InventoryScreen extends World 
{
    private DescriptionPanel panel;
    //private String[][] inventory;
    private Inventory inventory;
    private UseButton useButton;
    private int globalTimer;
    private StatBar fullness, happiness;

    /**
     * Constructs an InventoryScreen with the given inventory items.
     * 
     * @param inventory 2D array containing item names and their stats Format: {{"itemName", "health", "energy"}, ...}
     */
    public InventoryScreen(StatBar full, StatBar happy) 
    {
        super(700, 500, 1);
        fullness = full;
        happiness = happy;
        this.inventory = PetClass.getInventory();
        loadIcons();
        loadInventory(this.inventory);
        panel = new DescriptionPanel();
        addObject(panel, 570, 200);
        globalTimer = 0;
    }

    /**
     * Loads the static icons (Exit button).
     */
    private void loadIcons() 
    {
        addObject(new Cross(), 50, 50);
    }

    /**
     * Loads the inventory items based on the inventory array provided from the backend. Displays the items in rows with a maximum of 3 items per row.
     */
    private void loadInventory(Inventory backend) 
    {
        int startX = 150;
        int startY = 90;
        int x = startX;
        int y = startY;
        
        addObject(new SubtitleText("Food"), 600, 170);
        List<Food> foodItems = backend.getFoodItems();
        int count = 0;
        for (Food foodItem : foodItems) {
            String name = foodItem.getName();
            int value = foodItem.getValue();
            int energy = value + 10;
    
            InventoryItem icon = new InventoryItem(name, value, energy);
            addObject(icon, x, y);
    
            count++;
            if (count % 6 == 0) {
                x = startX;
                y += 50;
            } else {
                x += 50;
            }
        }
        
        x = startX;
        y = startY + 225; // Add vertical space between sections
    
        addObject(new SubtitleText("Gifts"), 600, 400); // Centered above gift row
    
        List<Gift> giftItems = backend.getGiftItems();
        count = 0;
        for (Gift giftItem : giftItems) {
            String name = giftItem.getName();
            int value = giftItem.getValue();
            int energy = value + 10;
    
            InventoryItem icon = new InventoryItem(name, value, energy);
            addObject(icon, x, y);
    
            count++;
            if (count % 6 == 0) {
                x = startX;
                y += 50;
            } else {
                x += 50;
            }
        }
    }

    /**
     * Checks for mouse clicks on inventory items or the exit icon. Updates the description panel or navigates back to the main menu accordingly.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(null)) SoundManager.playClick();
        globalTimer++;
        if (globalTimer % 60 == 0){
            Player.incrementTime();
            globalTimer = 0;
        }
        if (Greenfoot.mouseClicked(null)) 
        {
            Actor clicked = Greenfoot.getMouseInfo().getActor();
            if (clicked instanceof InventoryItem) 
            {
                InventoryItem item = (InventoryItem) clicked;
                panel.updateDescription((InventoryItem) clicked);
                
                if(useButton != null){
                    removeObject(useButton);
                }
                
                useButton = new UseButton(inventory, item, fullness, happiness);
                addObject(useButton, 550, 300); 
            } 
        }
    }
}
    /**
     * InventoryItem class represents an individual inventory item icon. Displays the item's image and stores its stats.
     */
    class InventoryItem extends Actor 
    {
        private String itemName;
        private int health;
        private int energy;

        /**
         * Constructs an InventoryItem with the given name, health, and energy values. Loads the item's image based on its name.
         * 
         * @param name Name of the item (must match the image file name)
         * @param health Health stat of the item
         * @param energy Energy stat of the item
         */
        public InventoryItem(String name, int health, int energy) 
        {
            this.itemName = name;
            this.health = health;
            this.energy = energy;
            GreenfootImage img;
            try 
            {
                img = new GreenfootImage(name.toLowerCase().replaceAll("\\s+", "") + ".png");
            } 
            catch (Exception e) 
            {
                img = new GreenfootImage(50, 50); // placeholder image
                img.setColor(Color.RED);
                img.fill();
            }
            img.scale(40, 40);
            setImage(img);
        }

        /**
         * Returns the name of the item.
         * 
         * @return Item name
         */
        public String getItemName() 
        {
            return itemName;
        }

        /**
         * Returns the health stat of the item.
         * 
         * @return Health stat
         */
        public int getHealth() 
        {
            return health;
        }

        /**
         * Returns the energy stat of the item.
         * 
         * @return Energy stat
         */
        public int getEnergy() 
        {
            return energy;
        }
    }


    /**
     * DescriptionPanel class displays the information of the selected inventory item including its health and energy stats.
     */
    class DescriptionPanel extends Actor 
    {
        private GreenfootImage panel;
        private GreenfootImage cartIcon, heartIcon;

        /**
         * Constructs a DescriptionPanel and initializes its display.
         */
        public DescriptionPanel() 
        {
            panel = new GreenfootImage(220, 320);
            updateDescription(null);
        }

        /**
         * Updates the panel to display the information of the selected item.
         * 
         * @param item The selected inventory item (null to clear the panel)
         */
        public void updateDescription(InventoryItem item) 
        {
            panel.setColor(Color.WHITE);
            panel.fill();
            panel.setColor(Color.BLACK);
            panel.drawRect(0, 0, 200, 300);
            if (item != null) 
            {
                panel.drawString(item.getItemName(), 10, 20);
                panel.drawString("INFO", 10, 50);
                panel.drawString("+ Health: " + item.getHealth(), 10, 70);
                panel.drawString("+ Energy: " + item.getEnergy(), 10, 90);
            } 
            else 
            {
                panel.drawString("Item Description", 10, 20);
                panel.drawString("INFO", 10, 50);
            }
            setImage(panel);
        }
    }

    class UseButton extends Actor {
        private InventoryItem linkedItem;
        private Inventory inventory;
        private StatBar fullness, happiness;
    
        public UseButton(Inventory inventory, InventoryItem item, StatBar fullness, StatBar happiness) {
            this.linkedItem = item;
            this.inventory = inventory;
            this.fullness = fullness;
            this.happiness = happiness;
            GreenfootImage img = new GreenfootImage("Use", 20, Color.WHITE, Color.GREEN);
            img.scale(120, 50);
            setImage(img);
        }
    
        public void act() {
            if (Greenfoot.mouseClicked(this)) {
                useItem(inventory, linkedItem);
            }
        }
    
        private void useItem(Inventory inventory, InventoryItem item) {
            String name = item.getItemName();
            int value = item.getHealth();
            if(name.endsWith("Gift")){
                Gift gift = new Gift(name, value);
                inventory.useGift(gift);
                happiness.increase(value);
            } else{
                Food food = new Food(name, value);
                inventory.useFood(food);
                fullness.increase(value);
            }            
            ScreenManager.pop();
        }
    }