import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextQButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextQButton extends Actor
{
    private TextInput input;
    
    public NextQButton(TextInput input){
        this.input = input;
        int width = 160;
        int height = 50;
        String label = "Next Question";

        GreenfootImage buttonImg = new GreenfootImage(width, height);
        buttonImg.setColor(new Color(34, 177, 76)); // Green background
        buttonImg.fillRect(0, 0, width, height);

        Font font = new Font("Arial", true, false, 20);
        GreenfootImage textImg = new GreenfootImage(label, 20, Color.WHITE, new Color(0, 0, 0, 0));
        int textX = (width - textImg.getWidth()) / 2;
        int textY = (height - textImg.getHeight()) / 2;

        buttonImg.drawImage(textImg, textX, textY);
        setImage(buttonImg);
        
    }
    
    /**
     * Act - do whatever the NextQButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            input.onSubmit();
        }
    }
}
