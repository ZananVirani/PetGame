import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Inventory class manages the collection of food and gift items for a pet.
 * This class handles adding, removing, and using items, as well as maintaining
 * lists of available random items that can be added to the inventory.
 * 
 * @author Group78
 */
public class Inventory {
    private List<Food> foodItems;
    private List<Gift> giftItems;

    private List<Food> randomFoods;

    private List<Gift> randomGifts;

    /**
     * Constructs a new Inventory with empty food and gift lists.
     * Initializes the available random food and gift items.
     */
    public Inventory() {
        this.foodItems = new ArrayList<>();
        this.giftItems = new ArrayList<>();

        randomFoods = new ArrayList<>();
        randomFoods.add(new Food("Hamburger", 20));
        randomFoods.add(new Food("Pizza", 15));
        randomFoods.add(new Food("Fries", 9));
        randomFoods.add(new Food("Drink", 5));
        randomFoods.add(new Food("Taco", 14));

        randomGifts = new ArrayList<>();
        randomGifts.add(new Gift("Blue Gift", 15));
        randomGifts.add(new Gift("Green Gift", 8));
        randomGifts.add(new Gift("Gold Gift", 25));
        randomGifts.add(new Gift("Purple Gift", 10));
        randomGifts.add(new Gift("Red Gift", 5));
    }

    /**
     * Extracts names from a list of Food objects.
     *
     * @param foodList List of Food objects to extract names from
     * @return List of food names
     */
    public static List<String> extractFoodNames(List<Food> foodList) {
        return foodList.stream()
                .map(Food::getName)
                .collect(Collectors.toList());
    }

    /**
     * Extracts names from a list of Gift objects.
     *
     * @param giftList List of Gift objects to extract names from
     * @return List of gift names
     */
    public static List<String> extractGiftNames(List<Gift> giftList) {
        return giftList.stream()
                .map(Gift::getName)
                .collect(Collectors.toList());
    }

    /**
     * Adds a random food item to the inventory.
     *
     * @return The Food item that was added
     */
    public Food addFood() {
        Random random = new Random();
        int randomIndex = random.nextInt(randomFoods.size());
        Food item = randomFoods.get(randomIndex);
        foodItems.add(item);
        return item;
    }

    /**
     * Adds a random gift item to the inventory.
     *
     * @return The Gift item that was added
     */
    public Gift addGift() {
        Random random = new Random();
        int randomIndex = random.nextInt(randomGifts.size());
        Gift item = randomGifts.get(randomIndex);
        giftItems.add(item);
        return item;
    }

    /**
     * Adds a food item to the inventory by its name.
     *
     * @param name The name of the food item to add
     */
    public void addFoodFromName(String name) {
        for (Food item : randomFoods) {
            if (item.getName().equals(name)) {
                foodItems.add(item);
                break;
            }
        }
    }

    /**
     * Adds a gift item to the inventory by its name.
     *
     * @param name The name of the gift item to add
     */
    public void addGiftFromName(String name) {
        for (Gift item : randomGifts) {
            if (item.getName().equals(name)) {
                giftItems.add(item);
                break;
            }
        }
    }

    /**
     * Checks if a specific food item exists in the inventory.
     *
     * @param food The Food item to check for
     * @return true if the food item is in the inventory, false otherwise
     */
    public boolean hasFood(Food food) {
        return this.foodItems.contains(food);
    }

    /**
     * Checks if a specific gift item exists in the inventory.
     *
     * @param gift The Gift item to check for
     * @return true if the gift item is in the inventory, false otherwise
     */
    public boolean hasGift(Gift gift) {
        return this.giftItems.contains(gift);
    }

    /**
     * Gets the list of food items in the inventory.
     *
     * @return List of Food items
     */
    public List<Food> getFoodItems() {
        return foodItems;
    }

    /**
     * Gets the list of gift items in the inventory.
     *
     * @return List of Gift items
     */
    public List<Gift> getGiftItems() {
        return giftItems;
    }

    /**
     * Uses a food item from the inventory, increasing the pet's fullness.
     * Removes the food item from inventory after use.
     *
     * @param food The Food item to use
     */
    public void useFood(Food food) {
        if (this.hasFood(food)) {
            foodItems.remove(food);
            PetClass.increaseFullness(food.getValue());
        } else {
            System.out.println("Food item not found in inventory.");
        }
    }

    /**
     * Uses a gift item from the inventory, increasing the pet's happiness.
     * Removes the gift item from inventory after use.
     *
     * @param gift The Gift item to use
     */
    public void useGift(Gift gift) {
        if (this.hasGift(gift)) {
            giftItems.remove(gift);
            PetClass.increaseHappiness(gift.getValue());
        } else {
            System.out.println("Gift item not found in inventory.");
        }
    }

    /**
     * Clears all items from the inventory.
     */
    public void clear() {
        this.foodItems = new ArrayList<>();
        this.giftItems = new ArrayList<>();
    }
}
