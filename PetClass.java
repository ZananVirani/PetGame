import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

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
    //private static String currentState;

    public static void Setup(String name, String type) {
        petName = name;
        health = 100;
        fullness = 100;
        happiness = 100;
        sleep = 100;
        score = 0;
        inventory = new Inventory();
        //currentState = null;
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

    public static Inventory getInventory(){
        return inventory;
    }

    public static void increaseHealth(int value) {
        health += value;
    }

    public static void decreaseHealth(int value) {
        health -= value;
    }

    public static void increaseFullness(int value) {
        fullness += value;
    }

    public static void decreaseFullness(int value) {
        if (vitalMultiplier.equals("fullness")) {
            fullness -= value * multiplier;
        } else {
            fullness -= value;
        }
    }

    public static void increaseHappiness(int value) {
        happiness += value;
    }

    public static void decreaseHappiness(int value) {
        if (vitalMultiplier.equals("happiness")) {
            happiness -= value * multiplier;
        } else {
            happiness -= value;
        }
    }

    public static void increaseSleep(int value) {
        sleep += value;
    }

    public static void decreaseSleep(int value) {
        if (vitalMultiplier.equals("sleep")) {
            sleep -= value * multiplier;
        } else {
            sleep -= value;
        }
    }

    public static String getType(){
        return petType;
    }

    public static void increaseScore(int value) {
        score += value;
    }

    public static void decreaseScore(int value) {
        score -= value;
    }

    public static int getScore() {
        return score;
    }

    public static String getName() {
        return petName;
    }

    public static int getFullness() {
        return fullness;
    }

    public static int getHealth() {
        return health;
    }

    public static int getHappiness() {
        return happiness;
    }

    public static int getSleep() {
        return sleep;
    }

    /*
    public static void setCurrentState(String state) {
    currentState = state;
    }

    public static String getCurrentState() {
    return currentState;
    }
     */

    public static Map<String, Object> getPetData() {
        Map<String, Object> petData = new HashMap<>();
        petData.put("petName", petName);
        petData.put("health", String.valueOf(health));
        petData.put("fullness", String.valueOf(fullness));
        petData.put("happiness", String.valueOf(happiness));
        petData.put("sleep", String.valueOf(sleep));
        petData.put("score", String.valueOf(score));
        //petData.put("currentState", currentState);
        petData.put("petType", petType);
        petData.put("multiplier", String.valueOf(multiplier));
        petData.put("vitalMultiplier", vitalMultiplier);
        petData.put("foodItems", Inventory.extractFoodNames(inventory.getFoodItems()));
        petData.put("giftItems", Inventory.extractGiftNames(inventory.getGiftItems()));
        return petData;
    }

    public static void setPetData(Map<String, Object> petData) {
        petName = petData.get("petName") != null ? petData.get("petName").toString() : null;

        health = parseIntSafe(petData.get("health"));
        fullness = parseIntSafe(petData.get("fullness"));
        happiness = parseIntSafe(petData.get("happiness"));
        sleep = parseIntSafe(petData.get("sleep"));
        score = parseIntSafe(petData.get("score"));

        //currentState = petData.get("currentState") != null ? petData.get("currentState").toString() : null;
        petType = petData.get("petType") != null ? petData.get("petType").toString() : null;
        multiplier = parseIntSafe(petData.get("multiplier"));
        vitalMultiplier = petData.get("vitalMultiplier") != null ? petData.get("vitalMultiplier").toString() : null;
        
        // Inventory stuff
        inventory.clear();
        
        String[] foods = ((List<?>) petData.get("foodItems"))
            .stream()
            .map(obj -> obj == null ? null : obj.toString())
            .toArray(String[]::new);
            
        for (String i: foods){
            inventory.addFoodFromName(i);
        }

        String[] gifts = ((List<?>) petData.get("giftItems"))
            .stream()
            .map(obj -> obj == null ? null : obj.toString())
            .toArray(String[]::new);
            
        for (String i: gifts){
            inventory.addGiftFromName(i);
        }

    }

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
