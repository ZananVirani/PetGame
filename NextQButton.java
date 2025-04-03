/**
 * The NextQButton class represents a button that allows the player to proceed to the next question in the Math tutorial. It is linked to a TextInput
 * field which processes the player's input upon clicking.
 * 
 * When the button is clicked, it triggers the onSubmit() method of the associated TextInput.
 * 
 * @author Group 78
 */
public class NextQButton extends Actor
{
    private TextInput input;

    /**
     * Constructs a NextQButton with an associated TextInput field. Sets the button's label and visual appearance.
     * 
     * @param input The TextInput object associated with this button.
     */
    public NextQButton(TextInput input)
    {
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
     * Act - performs an action when the NextQButton is clicked.
     * Specifically, it triggers the onSubmit() method of the associated TextInput.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            input.onSubmit();
        }
    }
}
