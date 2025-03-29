import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MathTutorial extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MathTutorial()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        
        Cross cross = new Cross();
        LetsGoButton btn = new LetsGoButton();
        
        addObject(cross, 50, 50);
        addObject(new TutorialText(),400,280);
        addObject(new TitleText("Math Game Tutorial"), 550, 200);
        addObject(btn, 570, 440);

    }
}
