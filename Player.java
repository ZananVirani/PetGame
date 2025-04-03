import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.io.File;

/**
 * Player class manages player-related data and operations in the virtual pet
 * game.
 * This includes tracking session information, time restrictions, and managing
 * lists of alive and deceased pets.
 * 
 * @author Group78
 */
public class Player {
    private static int numberOfSessions;
    private static Duration totalTimeSpent;
    private static boolean parentPass;
    private static String[] alivePets;
    private static String[] deceasedPets;
    private static LocalTime[] timeRestrictions; // Array to store start and end times

    /**
     * Initializes the player's data. If a save file exists, loads the data;
     * otherwise, sets up default values.
     */
    public static void setup() {
        File playerFile = new File("player_save.json");
        if (playerFile.exists()) {
            GameState.loadPlayer();
        } else {
            numberOfSessions = 0;
            totalTimeSpent = Duration.ZERO;
            parentPass = false;
            alivePets = new String[10];
            deceasedPets = new String[10];
            timeRestrictions = new LocalTime[2]; // Initialize array for start and end times
        }
    }

    /**
     * Gets the list of currently alive pets.
     *
     * @return Array of alive pet names
     */
    public static String[] getAlivePets() {
        return alivePets;
    }

    /**
     * Gets the list of deceased pets.
     *
     * @return Array of deceased pet names
     */
    public static String[] getDeceasedPets() {
        return deceasedPets;
    }

    /**
     * Sets time restrictions for when the game can be played.
     * Currently bypasses parent pass check for testing purposes.
     *
     * @param startTime The start time of allowed play period
     * @param endTime   The end time of allowed play period
     */
    public static void setTimeRestrictions(LocalTime startTime, LocalTime endTime) {
        if (true)// (parentPass)
        {
            timeRestrictions[0] = startTime;
            timeRestrictions[1] = endTime;
        } else {
            System.out.println("Parent pass required to set time restrictions");
        }
    }

    /**
     * Checks if the current time is within the set play time restrictions.
     *
     * @return true if current time is within restrictions, false otherwise
     */
    public static boolean isWithinTimeRestrictions() {
        if (timeRestrictions[0] == null || timeRestrictions[1] == null) {
            return true; // If no restrictions set, allow play at any time
        }
        LocalTime currentTime = LocalTime.now();
        return currentTime.isAfter(timeRestrictions[0]) && currentTime.isBefore(timeRestrictions[1]);
    }

    /**
     * Gets the total time spent playing the game.
     *
     * @return Duration of total play time
     */
    public static Duration getTotalTime() {
        return totalTimeSpent;
    }

    /**
     * Calculates the average session duration.
     *
     * @return Average session duration in minutes
     */
    public static float getAverageSession() {
        return numberOfSessions == 0 ? 0 : totalTimeSpent.toMinutes() / numberOfSessions;
    }

    /**
     * Gets the start time of the play time restrictions.
     *
     * @return Start time of allowed play period
     */
    public static LocalTime getStartTime() {
        return timeRestrictions[0];
    }

    /**
     * Gets the end time of the play time restrictions.
     *
     * @return End time of allowed play period
     */
    public static LocalTime getEndTime() {
        return timeRestrictions[1];
    }

    /**
     * Increments the number of play sessions.
     */
    public static void incrementSession() {
        numberOfSessions++;
    }

    /**
     * Increments the total time spent by one second.
     */
    public static void incrementTime() {
        totalTimeSpent = totalTimeSpent.plusSeconds(1);
    }

    /**
     * Retrieves all player data in a Map format.
     *
     * @return Map containing all player data
     */
    public static Map<String, Object> getPlayerData() {
        String[] restrictions = new String[timeRestrictions.length];
        for (int i = 0; i < timeRestrictions.length; i++) {
            restrictions[i] = (timeRestrictions[i] == null) ? null : timeRestrictions[i].toString();
        }
        Map<String, Object> playerData = new HashMap<>();
        playerData.put("numberOfSessions", numberOfSessions);
        playerData.put("totalTimeSpent", String.valueOf(totalTimeSpent.getSeconds()));
        playerData.put("parentPass", parentPass);
        playerData.put("alivePets", alivePets);
        playerData.put("deceasedPets", deceasedPets);
        playerData.put("timeRestrictions", restrictions);
        return playerData;
    }

    /**
     * Sets player data from a Map.
     * Handles conversion of various data types from the saved format.
     *
     * @param playerData Map containing player data to restore
     */
    public static void setPlayerData(LinkedHashMap<String, Object> playerData) {
        // Safe numeric conversion
        Object sessions = playerData.get("numberOfSessions");
        Player.numberOfSessions = (sessions instanceof Number)
                ? ((Number) sessions).intValue()
                : Integer.parseInt(sessions.toString());

        // Duration from ISO string or seconds
        Object duration = playerData.get("totalTimeSpent");
        if (duration.toString().startsWith("PT")) {
            Player.totalTimeSpent = Duration.parse(duration.toString()); // e.g., PT5M30S
        } else {
            Player.totalTimeSpent = Duration.ofSeconds(Long.parseLong(duration.toString()));
        }

        // Boolean
        Player.parentPass = Boolean.parseBoolean(playerData.get("parentPass").toString());

        // List to String[]
        Player.alivePets = ((List<?>) playerData.get("alivePets"))
                .stream()
                .map(obj -> obj == null ? null : obj.toString())
                .toArray(String[]::new);

        Player.deceasedPets = ((List<?>) playerData.get("deceasedPets"))
                .stream()
                .map(obj -> obj == null ? null : obj.toString())
                .toArray(String[]::new);

        // List to LocalTime[]
        Player.timeRestrictions = ((List<?>) playerData.get("timeRestrictions"))
                .stream()
                .map(obj -> obj == null ? null : LocalTime.parse(obj.toString()))
                .toArray(LocalTime[]::new);

    }

    /**
     * Handles the death of a pet by moving it from alive to deceased list
     * and saving the game state.
     *
     * @param petName Name of the pet that died
     */
    public static void petDied(String petName) {
        for (int i = 0; i < alivePets.length; i++) {
            if (alivePets[i] == null)
                break;
            if (alivePets[i].equals(petName)) {
                alivePets[i] = null;
                for (int j = i; j < alivePets.length - 1; j++) {
                    alivePets[j] = alivePets[j + 1];
                }
                alivePets[alivePets.length - 1] = null;

                break;
            }
        }

        if (deceasedPets[deceasedPets.length - 1] != null)
            deceasedPets = expandArray(deceasedPets, deceasedPets.length * 2);
        for (int i = 0; i < deceasedPets.length; i++) {
            if (deceasedPets[i] == null) {
                deceasedPets[i] = petName;
                break;
            }
        }

        GameState.saveAll();
    }

    /**
     * Revives a deceased pet by moving it back to the alive list
     * and restoring its state.
     *
     * @param petName Name of the pet to revive
     */
    public static void revivePet(String petName) {
        for (int i = 0; i < deceasedPets.length; i++) {
            if (deceasedPets[i] == null)
                break;
            if (deceasedPets[i].equals(petName)) {
                deceasedPets[i] = null;
                for (int j = i; j < deceasedPets.length - 1; j++) {
                    deceasedPets[j] = deceasedPets[j + 1];
                }
                deceasedPets[deceasedPets.length - 1] = null;

                break;
            }
        }

        GameState.loadPet(petName);
        PetClass.Setup(petName, PetClass.getType());
        GameState.createNewPet();
    }

    /**
     * Creates a new pet if possible and adds it to the alive pets list.
     *
     * @return true if pet was created successfully, false otherwise
     */
    public static boolean createPet() {
        if (alivePets[alivePets.length - 1] != null)
            alivePets = expandArray(alivePets, alivePets.length * 2);

        for (int i = 0; i < deceasedPets.length; i++) {
            if (deceasedPets[i] != null) {
                if (deceasedPets[i].equals(PetClass.getName().toLowerCase()))
                    return false;
            }
        }

        for (int i = 0; i < alivePets.length; i++) {
            if (alivePets[i] == null) {
                alivePets[i] = PetClass.getName().toLowerCase();
                return true;
            }
            if (alivePets[i].equals(PetClass.getName().toLowerCase()))
                return false;
        }

        return false;
    }

    /**
     * Expands a String array to a larger size while preserving existing elements.
     *
     * @param original The original array to expand
     * @param newSize  The desired new size of the array
     * @return The expanded array
     * @throws IllegalArgumentException if newSize is not greater than original size
     */
    public static String[] expandArray(String[] original, int newSize) {
        if (newSize <= original.length) {
            throw new IllegalArgumentException("New size must be greater than current size");
        }

        // Create new array with the larger size
        String[] expanded = new String[newSize];

        // Copy all elements from the original array to the expanded one
        System.arraycopy(original, 0, expanded, 0, original.length);

        return expanded;
    }
}
