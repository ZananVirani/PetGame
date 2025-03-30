import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ParagraphText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ParagraphText extends Actor
{
    public ParagraphText(String message){
        GreenfootImage img = new GreenfootImage(700,300);
        img.setColor(Color.BLACK);
        img.setFont(new Font("Arial", false, false, 15));
        img.drawString(message, 10, 25);
        setImage(img);
    }
    /**
     * Act - do whatever the ParagraphText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
