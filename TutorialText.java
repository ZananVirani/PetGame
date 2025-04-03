import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * TutorialText displays the instructions and game rules for the player.
 * 
 * It provides guidance on how to play the math game, how to submit answers, and how to earn rewards and increase the pet's happiness.
 * 
 * The text is displayed in a large message box when the game starts.
 * 
 * @author Group 78
 */
public class TutorialText extends Actor
{
    /**
     * Constructs a TutorialText object and displays the game instructions.
     */
    public TutorialText() {
        String message =
            "Your pet loves brain games! Solve math problems to earn rewards\nand make your pet smarter!\n\n" +
            "✔ A math question will appear at the top of the screen.\n" +
            "✔ Pick the correct answer in the textbox.\n" +
            "✔ Click arrow icon to check your response.\n" +
            "✔ Each correct answer earns points and increases your pet’s happiness!\n" +
            "✔ Get ten correct answers earns a reward!\n\n" +
            "Don't worry—if you get stuck, take your time. Learning is fun!";

        GreenfootImage img = new GreenfootImage(700, 300);
        img.setColor(Color.BLACK);
        img.setFont(new Font("Arial", false, false, 18));
        img.drawString(message, 10, 25);
        setImage(img);
    }
    /**
     * Act - do whatever the TutorialText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
