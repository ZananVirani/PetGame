import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LetsGoButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LetsGoButton extends Actor
{
    public LetsGoButton() {
        int width = 160;
        int height = 50;
        String label = "Let's Go!";

        GreenfootImage buttonImg = new GreenfootImage(width, height);
        buttonImg.setColor(new Color(34, 177, 76)); // Green background
        buttonImg.fillRect(0, 0, width, height);

        Font font = new Font("Arial", true, false, 24);
        GreenfootImage textImg = new GreenfootImage(label, 24, Color.WHITE, new Color(0, 0, 0, 0));
        int textX = (width - textImg.getWidth()) / 2;
        int textY = (height - textImg.getHeight()) / 2;

        buttonImg.drawImage(textImg, textX, textY);
        setImage(buttonImg);
    }
    
    /**
     * Act - do whatever the LetsGoButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            ScreenManager.push(new MathGame());
        }
    }
}
