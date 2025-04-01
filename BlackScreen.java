import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackScreen extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public BlackScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1);
        
        getBackground().setColor(Color.GRAY);
        getBackground().fill();
        
        showText("Thanks for playing :)", getWidth() / 2, getHeight() / 2);
    }
    
    public void act(){
        Greenfoot.stop();
    }
}
