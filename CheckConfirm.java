import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CheckConfirm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CheckConfirm extends Actor
{
    private HoursBox hours1, hours2; 
    private MinutesBox minutes1, minutes2;
    private ParentalToggle toggle;
    public CheckConfirm(HoursBox h1, MinutesBox m1, HoursBox h2, MinutesBox m2, ParentalToggle pt){  
        hours1 = h1;
        hours2 = h2;
        minutes1 = m1;
        minutes2 = m2;
        toggle = pt;
          
        GreenfootImage check = getImage();
        check.scale(30, 30); // scale original checkmark
    
        GreenfootImage img = new GreenfootImage(40, 40);
        img.setColor(Color.GRAY);
        img.drawOval(0, 0, 39, 39); // draw circular border
    
        img.drawImage(check, 5, 5); // center the checkmark inside the circle
    
        setImage(img);
    }
    /**
     * Act - do whatever the CheckConfirm wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            // SHIRRRARMAIENIUWFNIEWNFIEWNFIUNEWIFNEWUINFIUENI
            // PUT YOUR STUFF OVER HEARE
            
            int firstHr = hours1.getHour();
            int secondHr = hours2.getHour();
            int firstMin = minutes1.getMinutes();
            int secondMin = minutes2.getMinutes();
            boolean enabled = toggle.isEnabled();
        }
    }
}
