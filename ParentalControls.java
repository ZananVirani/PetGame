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
        
        HoursBox h1 = new HoursBox(Player.getStartTime());
        MinutesBox m1 = new MinutesBox(Player.getStartTime());
        
        HoursBox h2 = new HoursBox(Player.getEndTime());
        MinutesBox m2 = new MinutesBox(Player.getEndTime());
        
         // Leave button
        addObject(new Cross(), 50, 50);
        // Title
        addObject(new TitleText("Parental Controls"), 590, 200);
        addObject(new SubtitleText("Playtime Restrictions"), 620, 260);
        
        ParentalToggle pt = new ParentalToggle();
        addObject(pt, 370, 170);
        
        addObject(new SubtitleText("Allowable Play\nTime:"), 370, 370);
        addObject(new TitleText(" -"), 690, 390);
        addObject(h1, 220, 250);
        addObject(m1, 310, 250);
        addObject(h2, 440, 250);
        addObject(m2, 530, 250);
        
        addObject(new SubtitleText("Playtime Statistics"), 633, 470);
        addObject(new ParagraphText(String.format("Average Session: %.2fmins", Player.getAverageSession())), 490, 530);
        addObject(new ParagraphText(String.format("Total Time: %d hrs and %d mins", Player.getTotalTime().toHours(), Player.getTotalTime().toMinutes())), 740, 530);
        
        addObject(new CheckConfirm(h1, m1, h2, m2, pt, this), 620, 250);
        
        
        addObject(new ReviveButton(), 370, 440);
    }
}
