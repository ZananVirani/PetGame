import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * PetClass represents the core pet management system for a virtual pet game.
 * This class handles all pet-related attributes and behaviors including health,
 * happiness, sleep, and inventory management.
 * 
 * @author Group78
 */
public class PetClass {
    private static String petName;
    private static int health;
    private static int fullness;
    private static int happiness;
    private static int sleep;
    private static int score;
    private static String petType;
    private static int multiplier;
    private static String vitalMultiplier;
    private static Inventory inventory;
    // private static String currentState;

    /**
     * Initializes a new pet with the specified name and type.
     * Sets up initial values for all pet attributes and determines
     * the vital multiplier based on pet type.
     *
     * @param name The name of the pet
     * @param type The type of pet (Cat, Dog, or other)
     */
    public static void Setup(String name, String type) {
        petName = name;
        health = 100;
        fullness = 100;
        happiness = 100;
        sleep = 100;
        score = 0;
        inventory = new Inventory();
        // currentState = null;
        petType = type;
        if (petType.equals("Cat")) {
            multiplier = 2;
            vitalMultiplier = "fullness";
        } else if (petType.equals("Dog")) {
            multiplier = 2;
            vitalMultiplier = "happiness";
        } else {
            multiplier = 2;
            vitalMultiplier = "sleep";
        }
    }

    /**
     * Getter for the pet's inventory.
     *
     * @return The Inventory object containing the pet's items
     */
    public static Inventory getInventory() {
        return inventory;
    }

    /**
     * Increases the pet's health by the specified value.
     *
     * @param value The amount to increase health by
     */
    public static void increaseHealth(int value) {
        health += value;
    }

    /**
     * Decreases the pet's health by the specified value.
     *
     * @param value The amount to decrease health by
     */
    public static void decreaseHealth(int value) {
        health -= value;
    }

    /**
     * Increases the pet's fullness by the specified value.
     *
     * @param value The amount to increase fullness by
     */
    public static void increaseFullness(int value) {
        fullness += value;
    }

    /**
     * Decreases the pet's fullness by the specified value.
     * If fullness is the vital multiplier for this pet type,
     * the decrease amount is multiplied by the pet's multiplier.
     *
     * @param value The base amount to decrease fullness by
     * @return The actual amount decreased (may be modified by multiplier)
     */
    public static int decreaseFullness(int value) {
        if (vitalMultiplier.equals("fullness")) {
            fullness -= value * multiplier;
            return value * multiplier;
        } else {
            fullness -= value;
            return value;
        }
    }

    /**
     * Increases the pet's happiness by the specified value.
     *
     * @param value The amount to increase happiness by
     */
    public static void increaseHappiness(int value) {
        happiness += value;
    }

    /**
     * Decreases the pet's happiness by the specified value.
     * If happiness is the vital multiplier for this pet type,
     * the decrease amount is multiplied by the pet's multiplier.
     *
     * @param value The base amount to decrease happiness by
     * @return The actual amount decreased (may be modified by multiplier)
     */
    public static int decreaseHappiness(int value) {
        if (vitalMultiplier.equals("happiness")) {
            happiness -= value * multiplier;
            return value * multiplier;
        } else {
            happiness -= value;
            return value;
        }
    }

    /**
     * Increases the pet's sleep by the specified value.
     *
     * @param value The amount to increase sleep by
     */
    public static void increaseSleep(int value) {
        sleep += value;
    }

    /**
     * Decreases the pet's sleep by the specified value.
     * If sleep is the vital multiplier for this pet type,
     * the decrease amount is multiplied by the pet's multiplier.
     *
     * @param value The base amount to decrease sleep by
     * @return The actual amount decreased (may be modified by multiplier)
     */
    public static int decreaseSleep(int value) {
        if (vitalMultiplier.equals("sleep")) {
            sleep -= value * multiplier;
            return value * multiplier;
        } else {
            sleep -= value;
            return value;
        }
    }

    /**
     * Gets the type of the pet.
     *
     * @return The pet's type (Cat, Dog, or other)
     */
    public static String getType() {
        return petType;
    }

    /**
     * Increases the pet's score by the specified value.
     *
     * @param value The amount to increase score by
     */
    public static void increaseScore(int value) {
        score += value;
    }

    /**
     * Decreases the pet's score by the specified value.
     *
     * @param value The amount to decrease score by
     */
    public static void decreaseScore(int value) {
        score -= value;
    }

    /**
     * Gets the pet's current score.
     *
     * @return The pet's current score
     */
    public static int getScore() {
        return score;
    }

    /**
     * Gets the pet's name.
     *
     * @return The pet's name
     */
    public static String getName() {
        return petName;
    }

    /**
     * Gets the pet's current fullness level.
     *
     * @return The pet's current fullness value
     */
    public static int getFullness() {
        return fullness;
    }

    /**
     * Gets the pet's current health level.
     *
     * @return The pet's current health value
     */
    public static int getHealth() {
        return health;
    }

    /**
     * Gets the pet's current happiness level.
     *
     * @return The pet's current happiness value
     */
    public static int getHappiness() {
        return happiness;
    }

    /**
     * Gets the pet's current sleep level.
     *
     * @return The pet's current sleep value
     */
    public static int getSleep() {
        return sleep;
    }

    /**
     * Retrieves all pet data in a Map format for saving purposes.
     * This includes all pet attributes and inventory items.
     *
     * @return A Map containing all pet data
     */
    public static Map<String, Object> getPetData() {
        Map<String, Object> petData = new HashMap<>();
        petData.put("petName", petName);
        petData.put("health", String.valueOf(health));
        petData.put("fullness", String.valueOf(fullness));
        petData.put("happiness", String.valueOf(happiness));
        petData.put("sleep", String.valueOf(sleep));
        petData.put("score", String.valueOf(score));
        // petData.put("currentState", currentState);
        petData.put("petType", petType);
        petData.put("multiplier", String.valueOf(multiplier));
        petData.put("vitalMultiplier", vitalMultiplier);
        petData.put("foodItems", Inventory.extractFoodNames(inventory.getFoodItems()));
        petData.put("giftItems", Inventory.extractGiftNames(inventory.getGiftItems()));
        return petData;
    }

    /**
     * Sets all pet data from a Map for loading purposes.
     * This method is used to restore pet state from saved data.
     *
     * @param petData A Map containing all pet data to restore
     */
    public static void setPetData(Map<String, Object> petData) {
        petName = petData.get("petName") != null ? petData.get("petName").toString() : null;

        health = parseIntSafe(petData.get("health"));
        fullness = parseIntSafe(petData.get("fullness"));
        happiness = parseIntSafe(petData.get("happiness"));
        sleep = parseIntSafe(petData.get("sleep"));
        score = parseIntSafe(petData.get("score"));

        // currentState = petData.get("currentState") != null ?
        // petData.get("currentState").toString() : null;
        petType = petData.get("petType") != null ? petData.get("petType").toString() : null;
        multiplier = parseIntSafe(petData.get("multiplier"));
        vitalMultiplier = petData.get("vitalMultiplier") != null ? petData.get("vitalMultiplier").toString() : null;

        // Inventory stuff
        if (inventory == null)
            inventory = new Inventory();

        String[] foods = ((List<?>) petData.get("foodItems"))
                .stream()
                .map(obj -> obj == null ? null : obj.toString())
                .toArray(String[]::new);

        for (String i : foods) {
            inventory.addFoodFromName(i);
        }

        String[] gifts = ((List<?>) petData.get("giftItems"))
                .stream()
                .map(obj -> obj == null ? null : obj.toString())
                .toArray(String[]::new);

        for (String i : gifts) {
            inventory.addGiftFromName(i);
        }

    }

    /**
     * Safely parses an Object to an integer.
     * Handles various input types and provides error handling.
     *
     * @param value The Object to parse as an integer
     * @return The parsed integer value, or 0 if parsing fails
     */
    private static int parseIntSafe(Object value) {
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        if (value != null) {
            try {
                return Integer.parseInt(value.toString());
            } catch (NumberFormatException e) {
                System.err.println("Invalid number: " + value);
            }
        }
        return 0; // default fallback
    }

}
