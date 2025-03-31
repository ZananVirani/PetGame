import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.time.LocalTime;

/**
 * Write a description of class MinutesBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinutesBox extends Actor
{
    private int minutes;

    public MinutesBox(LocalTime lt) {
        if (lt != null)
        minutes = lt.getMinute();
        else
        minutes = 0;
        
        updateImage();
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            int mouseY = Greenfoot.getMouseInfo().getY();
            int y = getY();

            if (mouseY < y - 10) {
                minutes = (minutes + 1) % 60;
                updateImage();
            } else if (mouseY > y + 10) {
                minutes = (minutes + 59) % 60; // circular down
                updateImage();
            }
        }
    }

    private void updateImage() {
        GreenfootImage img = new GreenfootImage(100, 100);
        img.setColor(Color.WHITE);
        img.fill();
        img.setColor(Color.BLACK);
        img.drawRect(0, 0, 70, 99);

        img.setFont(new Font("Arial", false, false, 18));
        img.drawString("▲", 28, 20); // up arrow
        img.drawString(String.format("%02d min", minutes), 10, 55);
        img.drawString("▼", 28, 90); // down arrow

        setImage(img);
    }

    public int getMinutes() {
        return minutes;
    }
}
