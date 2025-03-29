import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SubmitButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SubmitButton extends Actor
{
    private TextInput input;
    
    public SubmitButton(TextInput input) {
        this.input = input;
        
        int width = 100;
        int height = 35;
        String label = "Submit";

        GreenfootImage buttonImg = new GreenfootImage(width, height);
        buttonImg.setColor(new Color(200, 200, 200)); // Light gray
        buttonImg.fillRect(0, 0, width, height);

        GreenfootImage textImg = new GreenfootImage(label, 18, Color.BLACK, new Color(0, 0, 0, 0));
        int textX = (width - textImg.getWidth()) / 2;
        int textY = (height - textImg.getHeight()) / 2;

        buttonImg.drawImage(textImg, textX, textY);
        setImage(buttonImg);
    }
    /**
     * Act - do whatever the SubmitButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            input.onSubmit(); // trigger dummy method
        }
    }
}
