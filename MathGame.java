import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MathGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MathGame extends World
{
    private int globalTimer;
    /**
     * Constructor for objects of class MathGame.
     * 
     */
    public MathGame()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        Score currentScore = new Score(0);
        QuestionDisplay qDisplay = new QuestionDisplay();
        ResultIcon resIcon = new ResultIcon();
        
        TextInput input = new TextInput(150, 45, currentScore, qDisplay, resIcon);
        
        // Leave button
        addObject(new Cross(), 50, 50);
        // EquationBox
        addObject(new BorderBox(450,150),350,180);
        // Equation Text
        addObject(qDisplay, 350, 180);
        // Your Answer:
        addObject(new BoldText("Your Answer: ", 30), 120,340);
        // Answer Text Box
        addObject(new BorderBox(300, 60), 390,340);
        // Submit Button
        addObject(new SubmitButton(input), 480, 340);
        // Your Score:
        addObject(new BoldText("Your Score: ", 30), 110,430);
        // Current Score:
        addObject(new ScoreDisplay(currentScore), 220,430);
        // User Input
        addObject(input, 330,340);
        // Result Icon
        addObject(resIcon, 590, 340);
        // Next Question Button
        addObject(new NextQButton(input), 570, 440);
        
        globalTimer = 0;

    }
    
    public void act(){
        globalTimer++;
        if (globalTimer % 60 == 0){
            Player.incrementTime();
            globalTimer = 0;
        }
    }
}
