import greenfoot.*;

/**
 * The GameOverButton class represents a button that appears when the game is over.
 * 
 * When clicked, this button clears the screen stack and returns the player to the Main Menu. It is visually displayed as a dark gray button with the
 * label "Back To Main Menu".
 * 
 * This class enhances navigation after the game ends and provides a clear way for the user to return to the main screen.
 * 
 * Example usage:
 * addObject(new GameOverButton(), 350, 400);
 * 
 * @author Group 78
 */
public class GameOverButton extends Actor
{
    /**
     * Constructs a GameOverButton with predefined width, height, and label.
     * 
     * The button image is styled with a dark gray background and white bold text.
     */
    public GameOverButton()
    {
        int width = 160;
        int height = 100;
        String label = "Back To\nMain Menu";

        GreenfootImage buttonImg = new GreenfootImage(width, height);
        buttonImg.setColor(Color.DARK_GRAY); // Button background color
        buttonImg.fillRect(0, 0, width, height);

        Font font = new Font("Arial", true, false, 24);
        GreenfootImage textImg = new GreenfootImage(label, 24, Color.WHITE, new Color(0, 0, 0, 0));
        int textX = (width - textImg.getWidth()) / 2;
        int textY = (height - textImg.getHeight()) / 2;

        buttonImg.drawImage(textImg, textX, textY);
        setImage(buttonImg);
    }

    /**
     * Act method - listens for mouse clicks on the GameOverButton.
     * 
     * When clicked, it clears the screen stack and navigates the user back to the Main Menu. This method is automatically called by the Greenfoot
     * environment during each act cycle.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            ScreenManager.clearStack();
            ScreenManager.push(new MainMenu());
        }
    }
}
