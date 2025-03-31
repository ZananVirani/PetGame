import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SaveButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SaveButton extends Actor
{   
    private World world;
    private long savedMessageTime = 0;
    
    public SaveButton(World world) {
        this.world = world;
        savedMessageTime = 0;
        GreenfootImage img = new GreenfootImage("SAVE GAME", 24, Color.BLACK, new Color(200, 200, 200, 150));
        setImage(img);
    }
    
    
    public void act(){
        if (Greenfoot.mouseClicked(this)){
            try{
                GameState.saveAll();
            } catch (Exception e){
                System.out.println(e);
                world.showText("SOMETHING WENT WRONG!", 325, 200);
            }
            
            world.showText("Saved!", 325, 80);
            savedMessageTime = System.currentTimeMillis();
        } 
        
        if (savedMessageTime > 0 && System.currentTimeMillis() - savedMessageTime > 2000) {
            world.showText("", 325, 80); // Clear message
            savedMessageTime = 0;
        }
    }
}
