import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * SubmitButton is a clickable button that triggers an action on the linked TextInput. When clicked, it calls the onSubmit() method of the associated
 * TextInput. The button is visually styled with the label "Submit".
 * 
 * This button is typically used to submit user input.
 * 
 * @author Group 78
 */
public class SubmitButton extends Actor {
    private TextInput input;

    /**
     * Constructs a SubmitButton linked to the given TextInput.
     * 
     * @param input The TextInput associated with this button.
     */
    public SubmitButton(TextInput input) {
        this.input = input;

        int width = 100;
        int height = 35;
        String label = "Submit";

        GreenfootImage buttonImg = new GreenfootImage(width, height);
        buttonImg.setColor(new Color(200, 200, 200)); // Light gray background
        buttonImg.fillRect(0, 0, width, height);

        GreenfootImage textImg = new GreenfootImage(label, 18, Color.BLACK, new Color(0, 0, 0, 0));
        int textX = (width - textImg.getWidth()) / 2;
        int textY = (height - textImg.getHeight()) / 2;

        buttonImg.drawImage(textImg, textX, textY);
        setImage(buttonImg);
    }

    /**
     * Act - checks if the SubmitButton is clicked.
     * If clicked, it calls the onSubmit() method of the linked TextInput.
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            input.onSubmit(); // Trigger dummy method
        }
    }
}

