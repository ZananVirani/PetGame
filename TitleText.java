import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialTitle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleText extends Actor
{
    public TitleText(String message) {
        
        GreenfootImage img = new GreenfootImage(700, 300);
        img.setColor(Color.BLACK);
        img.setFont(new Font("Arial", false, false, 30));
        img.drawString(message, 10, 25);
        setImage(img);
    }
    
    /**
     * Act - do whatever the TutorialTitle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
