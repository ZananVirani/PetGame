import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ConfirmButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
/**
 * The ConfirmButton class represents a button to confirm pet selection.
 */
class ConfirmButton extends Actor {
    private NameInput input;
    
    public ConfirmButton(NameInput input) {
        this.input = input;
        GreenfootImage img = new GreenfootImage("CONFIRM", 24, Color.BLACK, new Color(200, 200, 200, 150));
        setImage(img);
    }
    
    public ConfirmButton() {
        GreenfootImage img = new GreenfootImage("CONFIRM", 24, Color.BLACK, new Color(200, 200, 200, 150));
        setImage(img);
    }
    
    
    public void act(){
        if (Greenfoot.mouseClicked(this) && input.getText().length() >= 1){
            if (input.getPrompt().equals("Name: "))
            input.createPet();
            else input.validatePassword();
        }
        
    }
}