import greenfoot.*;

/**
 * LoadPetScreen displays all alive pets passed from the backend. Each pet name
 * is shown in a simple box, evenly spaced and wrapped across multiple rows if
 * necessary.
 * Provides a way for players to select and load an existing pet. Includes a
 * cross button to return to the Main Menu.
 * 
 * @author Group 78
 */
public class LoadPetScreen extends World {
    private static final int PADDING_X = 200;
    private static final int PADDING_Y = 40;
    private static final int START_X = 120;
    private static final int START_Y = 120;
    private static final int MAX_X = 600;

    /**
     * Creates a new LoadPetScreen with the given array of pet names.
     * 
     * @param pets An array of strings containing names of alive pets.
     */
    public LoadPetScreen() {
        super(700, 500, 1);
        addObject(new TitleText("Load Pets"), 620, 200);
        layoutPets(Player.getAlivePets());
        addObject(new Cross(), 50, 50);
    }

    /**
     * Lays out pet name boxes evenly on the screen. Automatically moves to the next
     * row when reaching screen edge.
     * 
     * @param pets An array of strings containing pet names.
     */
    private void layoutPets(String[] pets) {
        int x = START_X;
        int y = START_Y;

        for (String pet : pets) {
            if (pet != null){
                PetNameBox box = new PetNameBox(pet, this);
                addObject(box, x, y);

                x += PADDING_X;
                if (x > MAX_X) {
                    x = START_X;
                    y += PADDING_Y;
                }
            }
        }
    }

    /**
     * Detects if the cross button is clicked to return to Main Menu.
     */
    public void act() {
    if (Greenfoot.mouseClicked(null)) SoundManager.playClick();
    }
}

class PetNameBox extends Actor 
{
    private String name;
    private World world;
    /**
     * Creates a new PetNameBox with the given pet name.
     * 
     * @param petName Name of the pet to display.
     */
    public PetNameBox(String petName, World world) 
    {
        this.name = petName;
        this.world = world;
        GreenfootImage img = new GreenfootImage(petName, 24, Color.BLACK, new Color(200, 200, 200, 150));
        setImage(img);
    }

    public void act(){
        if (Greenfoot.mouseClicked(this)){
            if (world instanceof LoadPetScreen){
                GameState.loadPet(name);
                SoundManager.stopAll();
                ScreenManager.replace(new PlayWithPetScreen());
            } else{
                Player.revivePet(name);
                ScreenManager.pop();
            }
        }
    }

}