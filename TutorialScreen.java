import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialScreen extends World
{

    /**
     * Constructor for objects of class TutorialScreen.
     * 
     */
    public TutorialScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        
        String tutorialText =
    "• Choose your pet, give it a name, and let the fun begin!\n" +
    "• Use buttons to feed, play, and care for your pet daily.\n" +
    "• Track pet vitals: health, happiness, sleepiness, and fullness.\n" +
    "• Pet not feeling great? Take it to the vet or let it sleep!\n" +
    "• Use your inventory to give gifts and feed your pet treats.\n" +
    "• Collect cool items by earning points through good pet care!\n" +
    "• Commands like play, feed, and sleep are just a click away.\n" +
    "• Parents can manage screen time with password-protected settings.\n" +
    "• Your pet reacts — get it happy, sleepy, or even a little angry!\n" +
    "• Keep your pet alive and well... or it might just ghost you 😢\n" +
    "• Too attached to a pet and you lost? Get your parent to revive it!";
    
        addObject(new Cross(), 50, 50);
        addObject(new SubtitleText(tutorialText),400,280);
        addObject(new TitleText("Tutorial"), 650, 200);
    }
}
