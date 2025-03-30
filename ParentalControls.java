import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ParentalControls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ParentalControls extends World
{

    /**
     * Constructor for objects of class ParentalControls.
     * 
     */
    public ParentalControls()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        
        HoursBox h1 = new HoursBox();
        MinutesBox m1 = new MinutesBox();
        
        HoursBox h2 = new HoursBox();
        MinutesBox m2 = new MinutesBox();
        
         // Leave button
        addObject(new Cross(), 50, 50);
        // Title
        addObject(new TitleText("Parental Controls"), 590, 200);
        addObject(new SubtitleText("Playtime Restrictions"), 620, 260);
        addObject(new ParentalToggle(), 370, 170);
        
        addObject(new SubtitleText("Allowable Play\nTime:"), 390, 370);
        addObject(new TitleText("      -"), 690, 390);
        addObject(h1, 250, 250);
        addObject(m1, 340, 250);
        addObject(h2, 480, 250);
        addObject(m2, 570, 250);
        
        addObject(new SubtitleText("Playtime Statistics"), 633, 470);
        addObject(new ParagraphText("Average Session: 180mins"), 490, 530);
        addObject(new ParagraphText("Total Time: 200hrs and 50 mins"), 740, 530);
        
        
        addObject(new ReviveButton(), 370, 440);
    }
}
