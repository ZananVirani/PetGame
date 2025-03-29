import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ResultIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResultIcon extends Actor
{
    private boolean show;
    private boolean correct;
    
    public ResultIcon(){
        updateImage();
    }
    
    private void updateImage(){
        if (show){
            String imageFile = correct ? 
            "correct_result.png" : "incorrect_result.png";
            GreenfootImage img = new GreenfootImage(imageFile);
            img.scale(50, 50);
            setImage(img);
        } else{
            setImage((GreenfootImage) null);
        }
    }
    
    public void setCorrect(boolean correct){
        this.correct = correct;
        show = true;
        
        updateImage();
    }
    
    public void clear(){
        show = false;
        updateImage();
    }
    
    /**
     * Act - do whatever the ResultIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
