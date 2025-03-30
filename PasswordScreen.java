import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PasswordScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PasswordScreen extends World
{

    /**
     * Constructor for objects of class PasswordScreen.
     * 
     */
    public PasswordScreen()
    {    
        super(700, 500, 1);

        addObject(new pageTitle("Please Enter Your Password"), 350, 60);

        
        NameInput nameInput = new NameInput("Password: ");
        addObject(nameInput, 300, 280);

        addObject(new Cross(), 50, 50);
        
        ConfirmButton confirmButton = new ConfirmButton(nameInput);
        addObject(confirmButton, 600, 450);
    }
}
