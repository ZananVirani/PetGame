import greenfoot.*;

/**
 * The ConfirmButton class represents a button that allows the user to confirm their pet selection or validate their password, depending on the current
 * input prompt.
 * 
 * If the input prompt is "Name: ", clicking the button will create a pet. Otherwise, it will validate the password provided by the user.
 * 
 * This button is displayed on the pet selection and password confirmation screens.
 * 
 * Example usage:
 * addObject(new ConfirmButton(nameInput), x, y);
 * 
 * @author Group 78
 */
class ConfirmButton extends Actor 
{
    private NameInput input;

    /**
     * Constructs a ConfirmButton associated with the provided NameInput instance. This constructor is used when the button needs to interact with a
     * specific NameInput field.
     * 
     * @param input The NameInput instance associated with this button.
     */
    public ConfirmButton(NameInput input) 
    {
        this.input = input;
        GreenfootImage img = new GreenfootImage("CONFIRM", 24, Color.BLACK, new Color(200, 200, 200, 150));
        setImage(img);
    }

    /**
     * Constructs a ConfirmButton without any associated NameInput.
     * Typically used when the button does not need to perform any action related to NameInput.
     */
    public ConfirmButton() 
    {
        GreenfootImage img = new GreenfootImage("CONFIRM", 24, Color.BLACK, new Color(200, 200, 200, 150));
        setImage(img);
    }

    /**
     * Act method - listens for mouse clicks on the ConfirmButton.
     * If the input prompt is "Name: ", it will trigger the creation of a new pet. Otherwise, it will attempt to validate the user's password.
     * 
     * This method is automatically called by the Greenfoot environment in each act cycle.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            if (input.getPrompt().equals("Name: "))
            {
                input.createPet();
            }
            else 
            {
                input.validatePassword();
            }
        }
    }
}
