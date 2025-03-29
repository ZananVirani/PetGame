import greenfoot.*;

/**
 * A styled and animated action button using only fillRect.
 * No roundRect, but includes shadow effect and click animation.
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
     * Draws a rectangular button with text and optional scale effect.
     * @param enlarged Whether to draw the button in a "clicked" larger size.
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
