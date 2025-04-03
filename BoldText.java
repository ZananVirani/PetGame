import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The BoldText class displays bolded text on the screen with a specific font size and color. This class is used to render important 
 * or highlighted text in the Greenfoot environment. It draws the given input text centered inside a predefined image box.
 * 
 * Example usage:
 * new BoldText("Game Over", 40);
 * 
 * @author Group 78
 */
public class BoldText extends Actor
{
    /**
     * Constructs a BoldText object with the specified input text and font size.
     * The text is rendered in bold Arial font, centered within a rectangle.
     * 
     * @param inputText The text to be displayed.
     * @param fontSize The size of the font used to render the text.
     */
    public BoldText(String inputText, int fontSize) 
    {
        // Create a new GreenfootImage as the background
        GreenfootImage img = new GreenfootImage(250, 60);
        img.setColor(Color.BLACK);

        // Set font to Arial, bold, with specified size
        img.setFont(new Font("Arial", true, false, fontSize));

        // Create a new GreenfootImage for the input text
        GreenfootImage text = new GreenfootImage(inputText, fontSize, Color.BLACK, new Color(0, 0, 0, 0));

        // Calculate X and Y positions to center the text
        int x = (img.getWidth() - text.getWidth()) / 2;
        int y = (img.getHeight() - text.getHeight()) / 2;

        // Draw the text onto the background image
        img.drawImage(text, x, y);

        // Set the image of the Actor
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
