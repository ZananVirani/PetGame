import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class QuestionDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuestionDisplay extends Actor
{
    private String questionText;
    private String correctAnswer;
    private boolean reveal;
    
    public QuestionDisplay(){
        reveal = false;
        generate();       
        updateImage();
    }
    
    public String getCorrect(){
        return correctAnswer;
    }
    
    public void generate(){
        String[] eq = MathBackend.newQuestion();
        questionText = eq[0];
        correctAnswer = eq[1];
        
        updateImage();
    }
    
    public void setReveal(boolean val){
        reveal = val;
        updateImage();
    }
    
    private void updateImage(){
        
        GreenfootImage img = new GreenfootImage(250, 60);
        img.setColor(Color.BLACK);
        img.setFont(new Font("Arial", true, false, 40)); // Bold, size 40
        
        GreenfootImage text;
        if (!reveal) 
        text = new GreenfootImage(questionText + "?", 40, Color.BLACK, 
        new Color(0, 0, 0, 0));
        else text = new GreenfootImage(questionText + correctAnswer, 40, Color.BLACK, 
        new Color(0, 0, 0, 0));
        
        int x = (img.getWidth() - text.getWidth()) / 2;
        int y = (img.getHeight() - text.getHeight()) / 2;
        img.drawImage(text, x, y);

        setImage(img);
    }
    
    /**
     * Act - do whatever the QuestionDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
