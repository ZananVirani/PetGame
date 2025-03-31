import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

class PetNameBox extends Actor 
{
    /**
     * Creates a new PetNameBox with the given pet name.
     * 
     * @param petName Name of the pet to display.
     */
    public PetNameBox(String petName) 
    {
        GreenfootImage img = new GreenfootImage(petName, 24, Color.BLACK, new Color(200, 200, 200, 150));
        setImage(img);
    }
}
