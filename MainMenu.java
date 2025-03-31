
/**
 * The MainMenu class represents the main menu screen of the Virtual Pet Simulator game. It displays the game title, an oval visual element, three main buttons 
 * (New Game, Load Game, Tutorial), and a settings icon. This class also handles the transition to the Pet Selection Screen when the "NEW GAME" button is clicked.
 * 
 * @author Jay Prajapati
 * @version March 29th 2025
 */

import greenfoot.*;

public class MainMenu extends World {
    /**
     * This is the constructor for objects of class MainMenu.
     * This function initializes and displays the main menu UI components.
     */
    public MainMenu() {
        super(700, 500, 1);

        Player.setup();

        // Adding the Title Actor
        addObject(new Title("VIRTUAL PET SIMULATOR"), 350, 60);

        GreenfootImage oval = new GreenfootImage(300, 80);
        oval.setColor(Color.BLACK);
        oval.drawOval(0, 0, 299, 79);
        getBackground().drawImage(oval, 200, 150);

        GreenfootImage dogImg = new GreenfootImage("dog.png");
        dogImg.scale(120, 120);
        getBackground().drawImage(dogImg, 300, 100);

        addObject(new MenuButton("NEW GAME"), 350, 280);
        addObject(new MenuButton("LOAD GAME"), 350, 330);
        addObject(new MenuButton("TUTORIAL"), 350, 380);
        addObject(new MenuButton("PARENTAL CONTROLS"), 350, 430);

        addObject(new Cross(), 50, 50);

        // GreenfootImage gearImg = new GreenfootImage("gear.png");
        // gearImg.scale(100, 100);
        // getBackground().drawImage(gearImg, 570, 370);
    }

    /**
     * This funciton handles mouse click events on the main menu buttons. This
     * function navigates to PetSelectionScreen when "NEW GAME" is clicked.
     */
    public void act() {
        if (Greenfoot.mouseClicked(null)) {
            Actor clicked = Greenfoot.getMouseInfo().getActor();
            if (clicked instanceof MenuButton) {
                MenuButton btn = (MenuButton) clicked;
                if (btn.getLabel().equals("NEW GAME")) {
                    System.out.println(Player.isWithinTimeRestrictions());
                    if (Player.isWithinTimeRestrictions())
                    ScreenManager.push(new PetSelectionScreen());
                    else
                    showText("Not Allowed To Play Right Now!", 350, 250);
                } else if (btn.getLabel().equals("LOAD GAME")) {
                    if (Player.isWithinTimeRestrictions()){
                                   String[] alivePets = { "Fluffy", "Buddy", "Max", "Fluffy", "Buddy", "Max", "Fluffy", "Buddy", "Max",
                            "Fluffy", "Buddy", "Max" }; // Example array. Make sure you change this with the actual pets
                                                        // that are alive.
                    ScreenManager.push(new LoadPetScreen(alivePets));
                }
                    else
                    showText("Not Allowed To Play Right Now!", 350, 250);
                } else if (btn.getLabel().equals("TUTORIAL")) {
                    ScreenManager.push(new TutorialScreen());
                } else {
                    ScreenManager.push(new PasswordScreen());
                }
            }
        }
    }

    /**
     * The Title class creates a title that goes on top of the Main Menu Page. The
     * regular text does not look good in Greenfoot, so an extra class had to be
     * created
     * to make the Main Menu page seem appealing.
     */
    class Title extends Actor {
        public Title(String titleText) {
            GreenfootImage titleImage = new GreenfootImage(titleText, 40, Color.BLACK, new Color(200, 200, 200, 150));
            setImage(titleImage);
        }
    }

    /**
     * The MenuButton class represents a clickable button on the main menu screen.
     * This class will display a label and store the label text.
     */
    class MenuButton extends Actor {
        private String label;

        /**
         * Constructs a MenuButton with the specified label.
         * 
         * @param label The text label of the button.
         */
        public MenuButton(String label) {
            this.label = label;
            GreenfootImage img = new GreenfootImage(label, 30, Color.BLACK, Color.GRAY);
            setImage(img);
        }

        /**
         * Returns the label of the button.
         * 
         * @return The button label.
         */
        public String getLabel() {
            return label;
        }
    }
}