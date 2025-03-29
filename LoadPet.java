import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoadPet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoadPet extends World
{

    /**
     * Constructor for objects of class LoadPet.
     * 
     */
    public LoadPet()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        
        // Leave button
        addObject(new Cross(), 50, 50);
        // Title
        addObject(new TitleText("Revive Pets"), 620, 200);
    }
}
