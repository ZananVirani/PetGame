import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Calculator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Calculator extends Actor
{
    public Calculator(){
        GreenfootImage img = getImage();
        img.scale(60, 60);
        setImage(img);
    }
    
    /**
     * Act - do whatever the Calculator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            ScreenManager.push(new MathTutorial());
        }
    }
}
