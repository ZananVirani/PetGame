import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreDisplay extends Actor
{
    private Score score;

    public ScoreDisplay(Score score) {
        this.score = score;
        updateImage();
    }
    
    /**
     * Act - do whatever the ScoreDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        updateImage();
    }
    
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
