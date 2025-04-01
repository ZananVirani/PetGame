import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.io.File;

public class Player {
    private static int numberOfSessions;
    private static Duration totalTimeSpent;
    private static boolean parentPass;
    private static String[] alivePets;
    private static String[] deceasedPets;
    private static LocalTime[] timeRestrictions; // Array to store start and end times

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

    public static String[] getAlivePets() {
        return alivePets;
    }

    public static String[] getDeceasedPets() {
        return deceasedPets;
    }

    public static void setTimeRestrictions(LocalTime startTime, LocalTime endTime) {
        if (true)//(parentPass) 
        {
            timeRestrictions[0] = startTime;
            timeRestrictions[1] = endTime;
            System.out.println("Time restrictions set from " + timeRestrictions[0] + " to " + timeRestrictions[1]);
        } else {
            System.out.println("Parent pass required to set time restrictions");
        }
    }

    public static boolean isWithinTimeRestrictions() {
        System.out.println(timeRestrictions[0] + " " + timeRestrictions[1]);
        if (timeRestrictions[0] == null || timeRestrictions[1] == null) {
            return true; // If no restrictions set, allow play at any time
        }
        LocalTime currentTime = LocalTime.now();
        return currentTime.isAfter(timeRestrictions[0]) && currentTime.isBefore(timeRestrictions[1]);
    }

    public static Duration getTotalTime(){
        return totalTimeSpent;
    }

    public static float getAverageSession(){
        return numberOfSessions == 0 ? 0 : totalTimeSpent.toMinutes()/numberOfSessions;
    }

    public static LocalTime getStartTime() {
        return timeRestrictions[0];
    }

    public static LocalTime getEndTime() {
        return timeRestrictions[1];
    }

    public static void incrementSession() {
        numberOfSessions++;
    }

    public static void incrementTime(){
        totalTimeSpent = totalTimeSpent.plusSeconds(1);
    }

    public static Map<String, Object> getPlayerData() {
        String[] restrictions = new String[timeRestrictions.length];
        for (int i = 0; i < timeRestrictions.length; i++) {
            System.out.println(timeRestrictions[i]);
            restrictions[i] = (timeRestrictions[i] == null) ? null : timeRestrictions[i].toString();
        }
        Map<String, Object> playerData = new HashMap<>();
        playerData.put("numberOfSessions", numberOfSessions);
        playerData.put("totalTimeSpent", String.valueOf(totalTimeSpent.getSeconds()));
        playerData.put("parentPass", parentPass);
        playerData.put("alivePets", alivePets);
        playerData.put("deceasedPets", deceasedPets);
        playerData.put("timeRestrictions", restrictions);

        System.out.println(playerData);
        return playerData;
    }

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

    public static void petDied(String petName){
        for (int i=0;i<alivePets.length;i++){
            if (alivePets[i] == null) break;
            if (alivePets[i].equals(petName)){
                alivePets[i] = null;
                for (int j=i;j<alivePets.length-1;j++){
                    alivePets[j] = alivePets[j+1];
                }
                alivePets[alivePets.length-1] = null;

                break;
            }
        }

        if (deceasedPets[deceasedPets.length-1] != null) deceasedPets = expandArray(deceasedPets,deceasedPets.length * 2); 
        for (int i=0;i<deceasedPets.length;i++){
            if (deceasedPets[i] == null){
                deceasedPets[i] = petName;
                break;
            }
        }
        
        GameState.saveAll();
    }

    public static void revivePet(String petName){
        for (int i=0;i<deceasedPets.length;i++){
            if (deceasedPets[i] == null) break;
            if (deceasedPets[i].equals(petName)){
                deceasedPets[i] = null;
                for (int j=i;j<deceasedPets.length-1;j++){
                    deceasedPets[j] = deceasedPets[j+1];
                }
                deceasedPets[deceasedPets.length-1] = null;

                break;
            }
        }
        
        GameState.loadPet(petName);
        PetClass.Setup(petName, PetClass.getType());
        GameState.createNewPet();
    }

    public static boolean createPet(){
        if (alivePets[alivePets.length-1] != null) alivePets = expandArray(alivePets,alivePets.length * 2); 
        
        for (int i = 0; i < deceasedPets.length; i++){
            if (deceasedPets[i] != null){
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
