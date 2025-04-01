import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cross here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cross extends Actor
{
    public Cross(){
        GreenfootImage image = getImage();
        
        image.scale(50,50);
        setImage(image);
    }
    
    /**
     * Act - do whatever the Cross wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            if (getWorld() instanceof MainMenu) ScreenManager.push(new BlackScreen());
            else ScreenManager.pop();
        }
    }
}
