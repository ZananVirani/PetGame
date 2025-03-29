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
        String label = sleeping ? "Wake Up" : "Sleep";
        GreenfootImage img = new GreenfootImage(120, 30);
        img.setColor(Color.DARK_GRAY);
        img.fillRect(0, 0, 120, 30);
        img.setColor(Color.WHITE);
        img.setFont(new Font("Arial", 14));
        img.drawString(label, 20, 20);
        setImage(img);
    }
}
