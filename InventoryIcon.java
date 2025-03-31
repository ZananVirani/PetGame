import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inventory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InventoryIcon extends Actor
{
    public InventoryIcon(){
        GreenfootImage img = getImage();
        
        img.scale(80,80);
        setImage(img);
    }
    /**
     * Act - do whatever the Inventory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            /*String[][] testInventory = {
                {"hamburger", "10", "5"},
                {"pizza", "8", "4"},
                {"fries", "12", "6"},
                {"drink", "5", "10"},
                {"taco", "9", "7"},
                {"bluegift", "0", "0"},
                {"greengift", "0", "0"},
                {"goldgift", "0", "0"},
                {"purplegift", "0", "0"},
                {"redgift", "0", "0"}
            };*/
            Inventory testInventory = new Inventory();
            Greenfoot.setWorld(new InventoryScreen()); 
        }
    }
}
