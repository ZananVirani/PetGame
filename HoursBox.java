import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HoursBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HoursBox extends Actor
{
    private int hour = 0;

    public HoursBox() {
        updateImage();
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            int mouseY = Greenfoot.getMouseInfo().getY();
            int y = getY();

            if (mouseY < y - 10) {
                hour = (hour + 1) % 24;
                updateImage();
            } else if (mouseY > y + 10) {
                hour = (hour + 23) % 24; // circular down
                updateImage();
            }
        }
    }

    private void updateImage() {
        GreenfootImage img = new GreenfootImage(100, 100);
        img.setColor(Color.WHITE);
        img.fill();
        img.setColor(Color.BLACK);
        img.drawRect(0, 0, 75, 99);

        img.setFont(new Font("Arial", false, false, 18));
        img.drawString("▲", 35, 20); // up arrow
        img.drawString(String.format("%02d hrs", hour), 15, 55);
        img.drawString("▼", 35, 90); // down arrow

        setImage(img);
    }

    public int getHour() {
        return hour;
    }
}
