/**
 * The LetsGoButton class represents a clickable button that allows the user to start the Math game. When the button is clicked, it navigates the user to
 * the MathTutorial screen.
 * 
 * This button is visually styled with a green background and white "Let's Go!" text.
 * 
 * @author Group 78
 */
public class LetsGoButton extends Actor
{
    /**
     * Constructs a LetsGoButton object. Initializes the button's appearance, including its size, background color, and displayed text.
     */
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
     * Act method is called when the 'Act' or 'Run' button is pressed in the environment. Checks if the button is clicked and navigates to the
     * MathTutorial screen.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            ScreenManager.push(new MathGame());
        }
    }
}
