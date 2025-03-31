import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Image here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemImage extends Actor
{
    private int lifetimer;
    private World world;

    public ItemImage(String file, World world)
    {
        this.world = world;
        setImage(toFlatLowercase(file) + ".png");
        GreenfootImage img = getImage();
        img.scale(60,60);
        setImage(img);

        lifetimer = 300;
    }

    /**
     * Act - do whatever the Image wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {   
        lifetimer--;
        if (lifetimer <= 0) {
            world.removeObject(this);
            world.showText("", 450, 370);
        }
    }

    public String toFlatLowercase(String input) {
        return input.toLowerCase().replaceAll("\\s+", "");
    }
}
