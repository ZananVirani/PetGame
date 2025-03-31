import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SaveButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SaveButton extends Actor
{   
    public SaveButton() {
        GreenfootImage img = new GreenfootImage("SAVE GAME", 24, Color.BLACK, new Color(200, 200, 200, 150));
        setImage(img);
    }
    
    
    public void act(){
        if (Greenfoot.mouseClicked(this)){
            // Save the state somehow through pet thingie
            
            showText("Saved!", 325, 80);        
        }  
    }
}
