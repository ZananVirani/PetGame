import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Parentaltoggle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ParentalToggle extends Actor
{
    private boolean enabled;
    private static final int WIDTH = 200;
    private static final int HEIGHT = 60;

    public ParentalToggle() {
        updateImage();
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            enabled = !enabled;
            updateImage();
        }
    }

    private void updateImage() {
        GreenfootImage img = new GreenfootImage(WIDTH, HEIGHT);
        img.setColor(Color.WHITE);
        img.fill();
        img.setColor(Color.BLACK);

        int circleY = HEIGHT / 2 - 10;

        // ENABLE OPTION
        img.setColor(enabled ? Color.MAGENTA : Color.BLACK);
        img.fillOval(20, circleY, 20, 20);
        img.drawString("Enable", 50, circleY + 16);

        // DISABLE OPTION
        img.setColor(!enabled ? Color.MAGENTA : Color.BLACK);
        img.fillOval(120, circleY, 20, 20);
        img.drawString("Disable", 150, circleY + 16);

        setImage(img);
    }

    public boolean isEnabled() {
        return enabled;
    }
}
