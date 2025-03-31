import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Random;

public class Inventory {
    private List<Food> foodItems;
    private List<Gift> giftItems;

    private List<Food> randomFoods;

    private List<Gift> randomGifts;

    public Inventory() {
        this.foodItems = new ArrayList<>();
        this.giftItems = new ArrayList<>();

        randomFoods = new ArrayList<>();
        randomFoods.add(new Food("Hamburger", 10));
        randomFoods.add(new Food("Pizza", 8));
        randomFoods.add(new Food("Fries", 12));
        randomFoods.add(new Food("Drink", 5));
        randomFoods.add(new Food("Taco", 9));

        randomGifts = new ArrayList<>();
        randomGifts.add(new Gift("Blue Gift", 10));
        randomGifts.add(new Gift("Green Gift", 10));
        randomGifts.add(new Gift("Gold Gift", 10));
        randomGifts.add(new Gift("Purple Gift", 10));
        randomGifts.add(new Gift("Red Gift", 10));
    }

    public void addFood() {
        Random random = new Random();
        int randomIndex = random.nextInt(randomFoods.size());
        foodItems.add(randomFoods.get(randomIndex));
    }

    public void addGift() {
        Random random = new Random();
        int randomIndex = random.nextInt(randomGifts.size());
        giftItems.add(randomGifts.get(randomIndex));
    }

    public boolean hasFood(Food food) {
        return this.foodItems.contains(food);
    }

    public boolean hasGift(Gift gift) {
        return this.giftItems.contains(gift);
    }

    public List<Food> getFoodItems() {
        return foodItems;
    }

    public List<Gift> getGiftItems() {
        return giftItems;
    }

    public void useFood(Food food) {
        if (this.hasFood(food)) {
            PetClass.increaseVital(PetClass.getFullness(), food.getValue());
            PetClass.increaseScore(10);
            foodItems.remove(food);
        } else {
            System.out.println("Food item not found in inventory.");
        }
    }

    public void useGift(Gift gift) {
        if (this.hasGift(gift)) {
            PetClass.increaseVital(PetClass.getHappiness(), gift.getValue());
            PetClass.increaseScore(10);
            giftItems.remove(gift);
        } else {
            System.out.println("Gift item not found in inventory.");
        }
    }
}
