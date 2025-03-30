import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Subtitle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SubtitleText extends Actor
{
    public SubtitleText(String message) {
        
        GreenfootImage img = new GreenfootImage(700, 300);
        img.setColor(Color.BLACK);
        img.setFont(new Font("Arial", false, false, 20));
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
