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
            ScreenManager.push(new InventoryScreen()); 
        }
    }
}
