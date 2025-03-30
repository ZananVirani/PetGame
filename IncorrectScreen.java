import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IncorrectScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IncorrectScreen extends PasswordScreen
{

    /**
     * Constructor for objects of class IncorrectScreen.
     * 
     */
    public IncorrectScreen()
    {    
        super();
        
        addObject(new SubtitleText("Incorrect Password"), 550, 600);
    }
}
