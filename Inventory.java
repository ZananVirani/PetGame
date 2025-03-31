import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Random;
import java.util.stream.Collectors;

public class Inventory {
    private List<Food> foodItems;
    private List<Gift> giftItems;

    private List<Food> randomFoods;

    private List<Gift> randomGifts;

    public Inventory() {
        this.foodItems = new ArrayList<>();
        this.giftItems = new ArrayList<>();

        randomFoods = new ArrayList<>();
        randomFoods.add(new Food("Hamburger", 20));
        randomFoods.add(new Food("Pizza", 15));
        randomFoods.add(new Food("Fries", 9));
        randomFoods.add(new Food("Drink", 5));
        randomFoods.add(new Food("Taco",14));

        randomGifts = new ArrayList<>();
        randomGifts.add(new Gift("Blue Gift", 15));
        randomGifts.add(new Gift("Green Gift", 8));
        randomGifts.add(new Gift("Gold Gift", 25));
        randomGifts.add(new Gift("Purple Gift", 10));
        randomGifts.add(new Gift("Red Gift", 5));
    }

    public static List<String> extractFoodNames(List<Food> foodList) {
        return foodList.stream()
        .map(Food::getName)
        .collect(Collectors.toList());
    }

    public static List<String> extractGiftNames(List<Gift> giftList) {
        return giftList.stream()
        .map(Gift::getName)
        .collect(Collectors.toList());
    }

    public Food addFood() {
        Random random = new Random();
        int randomIndex = random.nextInt(randomFoods.size());
        Food item = randomFoods.get(randomIndex);
        foodItems.add(item);
        return item;
    }

    public Gift addGift() {
        Random random = new Random();
        int randomIndex = random.nextInt(randomGifts.size());
        Gift item = randomGifts.get(randomIndex);
        giftItems.add(item);
        return item;
    }

    public void addFoodFromName(String name){
        for (Food item : randomFoods){
            if (item.getName().equals(name)){
                foodItems.add(item);
                break;
            }
        }
    }

    public void addGiftFromName(String name){
        for (Gift item : randomGifts){
            if (item.getName().equals(name)){
                giftItems.add(item);
                break;
            }
        }
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
            foodItems.remove(food);
        } else {
            System.out.println("Food item not found in inventory.");
        }
    }

    public void useGift(Gift gift) {
        if (this.hasGift(gift)) {
            giftItems.remove(gift);
        } else {
            System.out.println("Gift item not found in inventory.");
        }
    }

    public void clear(){
        this.foodItems = new ArrayList<>();
        this.giftItems = new ArrayList<>(); 
    }
}
