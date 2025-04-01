import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextInput here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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

    public String getText() {
        return input.toString();
    }

    private void updateImage() {
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(Color.WHITE);
        img.fill(); // white background

        img.setFont(new Font("Arial", false, false, 24));
        img.setColor(Color.BLACK);
        img.drawString(input.toString(), 10, height / 2 + 8);

        setImage(img);
    }

    public void setSubmit(boolean val){
        submitted = val;    
    }

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

    public void clear(){
        input.delete(0, input.length());
    }

}
