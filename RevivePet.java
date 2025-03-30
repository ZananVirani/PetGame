import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RevivePet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RevivePet extends World
{

    /**
     * Constructor for objects of class RevivePet.
     * 
     */
    public RevivePet()
    {    
        super(700, 500, 1); 
        
        // Leave button
        addObject(new Cross(), 50, 50);
        // Title
        addObject(new TitleText("Revive Pets"), 620, 200);
    }
}
