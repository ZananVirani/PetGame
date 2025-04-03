import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The QuestionDisplay class is responsible for displaying a math question and its answer on the screen. It generates new questions, manages whether the
 * answer is revealed, and updates the displayed text accordingly. This class is used in the math tutorial screen to show questions to the user.
 * 
 * @author Group 78
 */
public class QuestionDisplay extends Actor
{
    private String questionText;
    private String correctAnswer;
    private boolean reveal;
    
    /**
     * Constructs a QuestionDisplay object and generates a new question. The answer is initially hidden.
     */
    public QuestionDisplay(){
        reveal = false;
        generate();       
        updateImage();
    }
    
    /**
     * Returns the correct answer to the displayed question.
     * 
     * @return The correct answer as a String.
     */
    public String getCorrect(){
        return correctAnswer;
    }
    
    /**
     * Generates a new math question and its corresponding answer. The question and answer are fetched from MathBackend.
     */
    public void generate(){
        String[] eq = MathBackend.newQuestion();
        questionText = eq[0];
        correctAnswer = eq[1];
        
        updateImage();
    }
    
    /**
     * Sets whether the answer to the question should be revealed.
     * 
     * @param val True to reveal the answer, false to hide it.
     */
    public void setReveal(boolean val){
        reveal = val;
        updateImage();
    }
    
    /**
     * Updates the displayed image of the question. Shows the question only, or both question and answer based on the 'reveal' flag.
     */
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
