import greenfoot.*;

/**
 * The ResultIcon class visually displays whether the player's answer was correct or incorrect. It shows a result image based on correctness and allows
 * clearing the display.
 * 
 * @author Group 78
 */
public class ResultIcon extends Actor {
    private boolean show;
    private boolean correct;

    /**
     * Constructs a new ResultIcon and initializes its image.
     */
    public ResultIcon(){
        updateImage();
    }

    /**
     * Updates the icon image based on whether the result should be shown and if the answer was correct.
     */
    private void updateImage(){
        if (show){
            String imageFile = correct ? "correct_result.png" : "incorrect_result.png";
            GreenfootImage img = new GreenfootImage(imageFile);
            img.scale(50, 50);
            setImage(img);
        } else {
            setImage((GreenfootImage) null);
        }
    }

    /**
     * Sets whether the answer was correct and shows the result icon.
     * 
     * @param correct true if the answer was correct, false otherwise
     */
    public void setCorrect(boolean correct){
        this.correct = correct;
        show = true;
        updateImage();
    }

    /**
     * Clears the result icon so nothing is displayed.
     */
    public void clear(){
        show = false;
        updateImage();
    }

    /**
     * Act - do whatever the ResultIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        // No action required
    }
}