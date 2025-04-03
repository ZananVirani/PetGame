import greenfoot.*;

/**
 * The PetNameBox class represents a visual text box that displays the name of the pet. It creates an image with the pet's name and sets it as the
 * Actor's image. This class is used to visually display the pet's name on the screen.
 * 
 * @author Group 78
 */
class PetNameBox extends Actor
{
    /**
     * Creates a new PetNameBox with the given pet name.
     * 
     * @param petName The name of the pet to display.
     */
    public PetNameBox(String petName)
    {
        GreenfootImage img = new GreenfootImage(petName, 24, Color.BLACK, new Color(200, 200, 200, 150));
        setImage(img);
    }
}
