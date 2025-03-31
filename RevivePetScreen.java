import greenfoot.*;

/**
 * RevivePetScreen displays all dead pets passed from the backend.
 * Each pet name is shown in a simple box, evenly spaced and wrapped
 * across multiple rows if necessary.
 * Provides a way for players to select and revive a dead pet.
 * Includes a cross button to return to the Main Menu.
 * 
 * @author Jay
 * @version 1.0
 */
public class RevivePetScreen extends World {
    private static final int PADDING_X = 100;
    private static final int PADDING_Y = 70;
    private static final int START_X = 140;
    private static final int START_Y = 120;
    private static final int MAX_X = 600;

    /**
     * Creates a new RevivePetScreen with the given array of dead pet names.
     * 
     * @param pets An array of strings containing names of dead pets.
     */
    public RevivePetScreen() {
        super(700, 500, 1);
        addObject(new TitleText("Revive Pets"), 620, 200);
        layoutPets(Player.getDeceasedPets());
        addObject(new Cross(), 50, 50);
    }

    /**
     * Lays out pet name boxes evenly on the screen.
     * Automatically moves to the next row when reaching screen edge.
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
    }
}