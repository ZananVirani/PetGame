import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ScoreDisplay class is responsible for displaying the player's current score on the screen. It continuously updates the score display.
 * 
 * The score is displayed in large, bold text.
 * 
 * @author Group 78
 */
public class ScoreDisplay extends Actor
{
    private Score score;

    /**
     * Constructs a ScoreDisplay and associates it with the given score object.
     * 
     * @param score The Score object to display.
     */
    public ScoreDisplay(Score score) {
        this.score = score;
        updateImage();
    }

    /**
     * Act - continuously updates the score display when the 'Act' or 'Run' button is pressed.
     */
    public void act()
    {
        updateImage();
    }

    /**
     * Updates the displayed image to show the current score.
     */
    private void updateImage(){
        GreenfootImage img = new GreenfootImage(250, 60);
        img.setColor(Color.BLACK);
        img.setFont(new Font("Arial", true, false, 40)); // Bold, size 40

        GreenfootImage text = new GreenfootImage(score.toString(), 30, Color.BLACK, new Color(0, 0, 0, 0));
        int x = (img.getWidth() - text.getWidth()) / 2;
        int y = (img.getHeight() - text.getHeight()) / 2;
        img.drawImage(text, x, y);

        setImage(img);
    }
}

