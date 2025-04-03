import greenfoot.*;

/**
 * ReviveButton navigates the player to the RevivePetScreen when clicked, showing all dead pets passed from the backend.
 * 
 * @author Group 78
 */
public class ReviveButton extends Actor {

    /**
     * Constructor for the class: creates a new ReviveButton.
     */
    public ReviveButton() {
        int width = 160;
        int height = 50;
        String label = "Revive Pets";

        GreenfootImage buttonImg = new GreenfootImage(width, height);
        buttonImg.setColor(Color.MAGENTA);
        buttonImg.fillRect(0, 0, width, height);

        Font font = new Font("Arial", true, false, 24);
        GreenfootImage textImg = new GreenfootImage(label, 24, Color.WHITE, new Color(0, 0, 0, 0));
        int textX = (width - textImg.getWidth()) / 2;
        int textY = (height - textImg.getHeight()) / 2;

        buttonImg.drawImage(textImg, textX, textY);
        setImage(buttonImg);
    }

    /**
     * When clicked, open RevivePetScreen with dead pet array.
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            ScreenManager.push(new RevivePetScreen());
        }
    }
}