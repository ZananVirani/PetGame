import greenfoot.*;

/**
 * The InteractionButton class represents a clickable button on the PlayWithPetScreen that triggers a specific interaction with the pet, such as playing
 * or feeding.
 * 
 * When clicked, the button briefly enlarges to provide visual feedback and triggers the corresponding interaction action.
 * 
 * This button enhances user experience by providing interactive feedback and executes a method in the PlayWithPetScreen when pressed.
 * 
 * Example usage:
 * InteractionButton playButton = new InteractionButton("Play", screen);
 * addObject(playButton, 300, 200);
 * 
 * @author Group 78
 */
public class InteractionButton extends Actor
{
    private String action;
    private PlayWithPetScreen screen;
    private boolean isAnimating = false;
    private int animationTimer = 0;

    private static final int WIDTH = 120;
    private static final int HEIGHT = 30;

    /**
     * Constructor.
     * @param actionType The action this button triggers
     * @param screen The world the button belongs to
     */
    public InteractionButton(String actionType, PlayWithPetScreen screen)
    {
        this.action = actionType;
        this.screen = screen;
        drawButton(false);
    }


    /**
     * Act method - Handles click detection and animation behavior.
     * 
     * When the button is clicked, it triggers the associated action in the PlayWithPetScreen and starts an animation that enlarges the button briefly.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this) && !isAnimating)
        {
            isAnimating = true;
            animationTimer = 5; // frames of animation
            screen.interact(action);
        }

        if (isAnimating)
        {
            animationTimer--;
            if (animationTimer > 0)
            {
                drawButton(true); // scale up slightly
            }
            else
            {
                drawButton(false); // back to normal
                isAnimating = false;
            }
        }
    }

    /**
     * Draws the button with optional enlargement. The button is drawn with a light blue background, dark gray shadow, and black text.
     * 
     * @param enlarged Whether the button should appear in an enlarged (clicked) state.
     */
    private void drawButton(boolean enlarged)
    {
        int scale = enlarged ? 2 : 0;
        int width = WIDTH + scale;
        int height = HEIGHT + scale;

        GreenfootImage img = new GreenfootImage(width, height);

        // Shadow effect
        img.setColor(new Color(50, 50, 50)); // dark gray
        img.fillRect(3, 3, width - 3, height - 3);

        // Button background
        img.setColor(new Color(80, 160, 255)); // light blue
        img.fillRect(0, 0, width - 3, height - 3);

        // Text
        img.setColor(Color.BLACK);
        img.setFont(new Font("Arial", 14));
        int textX = 10;
        int textY = height / 2 + 5;
        img.drawString(action, textX, textY);

        setImage(img);
    }
}
