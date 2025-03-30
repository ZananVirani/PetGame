import greenfoot.*;

/**
 * A toggle button that puts the pet to sleep or wakes it up.
 */
public class SleepButton extends Actor
{
    private PlayWithPetScreen screen;
    private boolean sleeping = false;

    public SleepButton(PlayWithPetScreen screen)
    {
        this.screen = screen;
        updateImage();
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            sleeping = !sleeping;
            screen.setSleepingMode(sleeping);
            updateImage();
        }
    }

    private void updateImage()
    {
        int width = 120;
        int height = 30;
        String label = sleeping ? "Wake Up" : "Sleep";
        GreenfootImage img = new GreenfootImage(120, 30);
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
        img.drawString("Sleep", textX, textY);
        setImage(img);
    }
}
