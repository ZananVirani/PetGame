
/**
 * The PetSelectionScreen class represents the pet selection screen of the Virtual Pet Simulator game.
 * It allows the player to select one of three pets, enter a name for the pet, and confirm their selection.
 * Clicking confirm will transition to the Inventory screen. Clicking exit will return to Main Menu.
 * 
 * @author Jay Prajapati
 * @version March 29th 2025
 */

import greenfoot.*;
import java.util.*;

public class PetSelectionScreen extends World {
    private RadioButton pet1, pet2, pet3;
    private ConfirmButton confirmButton;
    private ExitIcon exitIcon;
    private String selectedPet = "";
    private DescriptionLabel descriptionLabel;

    /**
     * Constructor for objects of class PetSelectionScreen.
     * Initializes and displays pet selection UI components.
     */
    public PetSelectionScreen() {
        super(700, 500, 1);

        addObject(new pageTitle("Give Your Pet A Name!"), 350, 60);

        pet1 = new RadioButton("  Bear", "bear.png");
        pet2 = new RadioButton("  Cat", "petCat.png");
        pet3 = new RadioButton("  Dog", "dog.png");

        descriptionLabel = new DescriptionLabel();
        addObject(descriptionLabel, 350, 330); // Centered under pet images

        addObject(pet1, 175, 200);
        addObject(pet2, 350, 200);
        addObject(pet3, 525, 200);

        NameInput nameInput = new NameInput(this);
        addObject(nameInput, 400, 280);

        confirmButton = new ConfirmButton(nameInput);
        addObject(confirmButton, 600, 450);

        addObject(new Cross(), 50, 50);
    }

    /**
     * Handles mouse click events for pet selection, confirmation, and exiting.
     *
     **/
    public void act() {
        if (Greenfoot.mouseClicked(pet1))
            selectPet("Bear");
        else if (Greenfoot.mouseClicked(pet2))
            selectPet("Cat");
        else if (Greenfoot.mouseClicked(pet3))
            selectPet("Dog");
    }

    /**
     * Updates selected pet.
     * 
     * @param pet The selected pet.
     */
    private void selectPet(String pet) {
        selectedPet = pet;
        TempType.setValue(pet);
        pet1.setSelected(pet.equals("Bear"));
        pet2.setSelected(pet.equals("Cat"));
        pet3.setSelected(pet.equals("Dog"));

        // Update description text
        String desc = "";
        switch (pet) {
            case "Bear":
                desc = "Bear: Calm and strong. Loves naps!\n Energy drains faster";
                break;
            case "Cat":
                desc = "Cat: Curious and playful. Make sure to play with it! \n Hapiness drains faster";
                break;
            case "Dog":
                desc = "Dog: Loyal and active. Make sure to feed him lots!\n Hunger drains faster";
                break;
        }

        descriptionLabel.setText(desc);
    }

}

class TempType{
    private static String value = "";

    public static void setValue(String val){
        value = val;
    }

    public static String getValue(){
        return value;
    }
}

/**
 * The Title class creates a title that goes on top of the Main Menu Page. The
 * regular text does not look good in Greenfoot, so an extra class had to be
 * created
 * to make the Main Menu page seem appealing.
 */
class pageTitle extends Actor {
    public pageTitle(String titleText) {
        GreenfootImage titleImage = new GreenfootImage(titleText, 40, Color.BLACK, Color.WHITE);
        setImage(titleImage);
    }
}

/**
 * The RadioButton class represents a selectable radio button for choosing a
 * pet.
 */
class RadioButton extends Actor {
    private boolean selected = false;
    private String label;
    private String imageName;

    /**
     * Constructs a RadioButton with the specified label and image.
     * 
     * @param label     The label of the radio button.
     * @param imageName The image filename for the pet icon.
     */
    public RadioButton(String label, String imageName) {
        this.label = label;
        this.imageName = imageName;
        updateImage();
    }

    /**
     * Sets the selected state of the radio button.
     * 
     * @param s True if selected, false otherwise.
     */
    public void setSelected(boolean s) {
        selected = s;
        updateImage();
    }

    /**
     * Updates the radio button image based on selection state.
     */
    private void updateImage() {
        GreenfootImage img = new GreenfootImage(80, 100);
        GreenfootImage petImg = new GreenfootImage(imageName);
        petImg.scale(60, 60);
        img.drawImage(petImg, 10, 0);
        img.setColor(Color.BLACK);
        img.drawOval(30, 70, 15, 15);
        if (selected)
            img.fillOval(34, 74, 7, 7);
        img.drawString(label, 20, 95);
        setImage(img);
    }
}

/**
 * The NameInput class represents an input field where the player can type a pet
 * name.
 */
class NameInput extends Actor {
    private String text = "";
    private String prompt = "";
    private World world;
    
    public NameInput(World world) {
        this.prompt = "Name: ";
        this.world = world;
        updateImage();
    }

    public NameInput(String prompt) {
        this.prompt = prompt;
        updateImage();
    }

    /**
     * Updates the name text as the player types.
     */
    public void act() {
        String key = Greenfoot.getKey();
        if (key != null) {
            if (key.equals("backspace") && text.length() > 0) {
                text = text.substring(0, text.length() - 1);
            } 
            else if (key.equals("space")){
            } else if (key.equals("enter")){
                if (getPrompt().equals("Name: ")){
                    createPet();
                } else validatePassword();
            } else if (key.length() == 1 && (Character.isDigit(key.charAt(0)) || Character.isLetter(key.charAt(0))) && text.length() < 20) {
                text += key;
            } 
            updateImage();
        }
    }

    public void validatePassword(){
        String password = "ilovecs2212";

        if (text.equals(password)) ScreenManager.replace(new ParentalControls());
        else ScreenManager.replace(new IncorrectScreen());
    }

    /**
     * Updates the visual display of the input field.
     */
    private void updateImage() {
        GreenfootImage img = new GreenfootImage(prompt + text, 24, Color.BLACK, new Color(200, 200, 200, 150));
        setImage(img);
    }

    /**
     * Returns the entered name text.
     * 
     * @return The name input text.
     */
    public String getText() {
        return text;
    }

    public String getPrompt() {
        return prompt;
    }

    public void createPet(){

        if (TempType.getValue().equals("") || text.length() < 1){
            world.showText("Missing Info!", 325, 300);
            return;
        }

        PetClass.Setup(text, TempType.getValue());
        if (!GameState.createNewPet()){
            world.showText("This name is taken. Choose a new one!", 325, 300);
        }
        GameState.savePlayer();
        ScreenManager.replace(new PlayWithPetScreen());
    }
}

/**
 * The ExitIcon class represents the icon used to exit the pet selection screen.
 */
class ExitIcon extends Actor {
    public ExitIcon() {
        GreenfootImage img = new GreenfootImage("exit.png");
        img.scale(40, 40);
        setImage(img);
    }
}

/**
 * Displays the description of the selected pet.
 */
class DescriptionLabel extends Actor {
    private String text = "";

    public DescriptionLabel() {
        updateImage();

    }

    public void setText(String newText) {
        text = newText;
        updateImage();
    }

    private void updateImage() {
        GreenfootImage img = new GreenfootImage(text, 20, Color.BLACK, new Color(255, 255, 255, 180));
        setImage(img);
    }
}
