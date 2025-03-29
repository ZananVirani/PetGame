import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EquationBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BorderBox extends Actor
{
    public BorderBox(int width, int height){
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(Color.BLACK);
        img.drawRect(0, 0, width - 1, height - 1); // outline only, no fill
        setImage(img);
    }
    
    /**
     * Act - do whatever the EquationBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
