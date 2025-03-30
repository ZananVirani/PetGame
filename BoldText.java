import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EquationText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoldText extends Actor
{
    public BoldText(String inputText, int fontSize){
        
        GreenfootImage img = new GreenfootImage(250, 60);
        img.setColor(Color.BLACK);
        img.setFont(new Font("Arial", true, false, fontSize)); // Bold, size 40

        GreenfootImage text = new GreenfootImage(inputText, fontSize, Color.BLACK, new Color(0, 0, 0, 0));
        int x = (img.getWidth() - text.getWidth()) / 2;
        int y = (img.getHeight() - text.getHeight()) / 2;
        img.drawImage(text, x, y);

        setImage(img);
    }
    /**
     * Act - do whatever the EquationText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
