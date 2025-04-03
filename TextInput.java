import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * TextInput handles user keyboard input during the quiz gameplay. It collects text input from the player, displays it on the screen, and checks if the
 * input matches the correct answer. It also manages feedback, score updates, and gift/food rewards.
 * 
 * This class is used in conjunction with QuestionDisplay, ResultIcon, and Score classes.
 * 
 * Features:
 * - Accepts alphanumeric input up to 6 characters
 * - Handles enter key for submission and backspace for deletion
 * - Updates score and displays result feedback
 * - Grants food/gift rewards for every 10 correct answers
 * - Saves game state on each submission
 * 
 * @author Jay Prajapati
 */
public class TextInput extends Actor {
    private StringBuilder input;
    private int width;
    private int height;
    private Score score;
    private QuestionDisplay qDisplay;
    private ResultIcon icon;
    private boolean submitted;
    private boolean gift;
    private World world;
    private int globalTimer;

    /**
     * Constructs a TextInput field with the specified dimensions and references to other game components.
     * 
     * @param width  The width of the input box.
     * @param height The height of the input box.
     * @param score  The Score object to update upon correct answers.
     * @param qDisplay The QuestionDisplay object associated with this input.
     * @param icon   The ResultIcon object to show feedback.
     * @param world  The World in which this TextInput exists.
     */
    public TextInput(int width, int height, 
    Score score, QuestionDisplay qDisplay, ResultIcon icon, World world) {
        this.world = world;
        this.width = width;
        this.height = height;
        input = new StringBuilder();
        this.score = score;
        this.qDisplay = qDisplay;
        this.icon = icon;
        gift = false;
        globalTimer = 0;
        updateImage();
    }

    /**
     * Called repeatedly in the Greenfoot environment. Handles key input, submission, and displays feedback messages.
     */
    public void act() {
        if (globalTimer > 0) globalTimer--;
        if (globalTimer <= 0) {
            world.showText("", 380, 480);
        }
        String key = Greenfoot.getKey();
        if (key != null) {
            if (key.equals("enter") && input.length() > 0) {
                onSubmit(); 
            } else if (key.equals("backspace") && input.length() > 0) {
                input.deleteCharAt(input.length() - 1);
            } else if (key.length() == 1 && input.length() < 6) {
                input.append(key);
            }
            updateImage();
        }
    }

    /**
     * Returns the current text input as a String.
     * 
     * @return The text entered by the user.
     */
    public String getText() {
        return input.toString();
    }

    /**
     * Updates the displayed image of the input box based on current input text.
     */
    private void updateImage() {
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(Color.WHITE);
        img.fill(); // white background

        img.setFont(new Font("Arial", false, false, 24));
        img.setColor(Color.BLACK);
        img.drawString(input.toString(), 10, height / 2 + 8);

        setImage(img);
    }

    /**
     * Sets the submitted state of this input.
     * 
     * @param val true if submitted, false otherwise.
     */
    public void setSubmit(boolean val){
        submitted = val;    
    }


    /**
     * Handles the input submission:
     * - Checks if the input matches the correct answer.
     * - Updates score and shows feedback.
     * - Grants rewards every 10 correct answers.
     * - Saves game state.
     * - Clears and resets input if already submitted.
     */
    public void onSubmit(){
        if (!submitted){
            setSubmit(true);
            String correctAnswer = qDisplay.getCorrect(); 

            while (input.length() > 1 && input.charAt(0) == ('0')){
                input.deleteCharAt(0);
            }

            if (input.toString().equals(correctAnswer)){
                score.increase(1);
                PetClass.increaseScore(1);
                icon.setCorrect(true);
                if (score.getScore() % 10 == 0){
                    globalTimer = 180;
                    if (gift) {
                        Gift gift = PetClass.getInventory().addGift();
                        world.addObject(new ItemImage(gift.getName().toLowerCase(), world),380, 410);
                        world.showText("Gift Received!", 380, 480);  
                    } else{
                        Food food = PetClass.getInventory().addFood();
                        world.addObject(new ItemImage(food.getName().toLowerCase(), world), 380, 410);
                        world.showText("Food Received!", 380, 480); 
                    }
                }
            }
            else icon.setCorrect(false);

            qDisplay.setReveal(true);
            GameState.saveAll();
        } else {
            setSubmit(false);
            clear();
            icon.clear();
            qDisplay.generate();
            qDisplay.setReveal(false);

            updateImage();
        }
    }

    /**
     * Clears the current text input.
     */
    public void clear(){
        input.delete(0, input.length());
    }

}
