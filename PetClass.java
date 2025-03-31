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
    private static String currentState;

    public static void Setup(String name, String type) {
        petName = name;
        health = 100;
        fullness = 100;
        happiness = 100;
        sleep = 100;
        score = 0;
        currentState = null;
        petType = type;
        if (petType == "Cat") {
            multiplier = 1;
            vitalMultiplier = "fullness";
        } else if (petType == "Dog") {
            multiplier = 2;
            vitalMultiplier = "happiness";
        } else if (petType == "Bear") {
            multiplier = 3;
            vitalMultiplier = "sleep";
        }
    }

    public static void increaseVital(int vital, int value) {
        vital += value;
    }

    public static void decreaseVital(int vital, int value, String vitalName) {
        if (vitalName.equals(vitalMultiplier)) {
            vital -= value * multiplier;
        } else {
            vital -= value;
        }
    }

    public static int getVital(int vital) {
        return vital;
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

    public static void setCurrentState(String state) {
        currentState = state;
    }

    public static String getCurrentState() {
        return currentState;
    }

    public static Map<String, Object> getPetData() {
        Map<String, Object> petData = new HashMap<>();
        petData.put("petName", petName);
        petData.put("health", String.valueOf(health));
        petData.put("fullness", String.valueOf(fullness));
        petData.put("happiness", String.valueOf(happiness));
        petData.put("sleep", String.valueOf(sleep));
        petData.put("score", String.valueOf(score));
        petData.put("currentState", currentState);
        petData.put("petType", petType);
        petData.put("multiplier", String.valueOf(multiplier));
        petData.put("vitalMultiplier", vitalMultiplier);
        return petData;
    }

    public static void setPetData(Map<String, Object> petData) {
        petName = petData.get("petName") != null ? petData.get("petName").toString() : null;

        health = parseIntSafe(petData.get("health"));
        fullness = parseIntSafe(petData.get("fullness"));
        happiness = parseIntSafe(petData.get("happiness"));
        sleep = parseIntSafe(petData.get("sleep"));
        score = parseIntSafe(petData.get("score"));

        currentState = petData.get("currentState") != null ? petData.get("currentState").toString() : null;
        petType = petData.get("petType") != null ? petData.get("petType").toString() : null;
        multiplier = parseIntSafe(petData.get("multiplier"));
        vitalMultiplier = petData.get("vitalMultiplier") != null ? petData.get("vitalMultiplier").toString() : null;

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
