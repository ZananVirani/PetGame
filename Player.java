import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

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
         return;
      } else {
         numberOfSessions = 0;
         totalTimeSpent = Duration.ZERO;
         parentPass = false;
         alivePets = new String[3];
         deceasedPets = new String[3];
         timeRestrictions = new LocalTime[2]; // Initialize array for start and end times
      }
   }

   public static String[] getAlivePets() {
      return alivePets;
   }

   public static void setTimeRestrictions(LocalTime startTime, LocalTime endTime) {
      if (parentPass) {
         timeRestrictions[0] = startTime;
         timeRestrictions[1] = endTime;
         System.out.println("Time restrictions set from " + startTime + " to " + endTime);
      } else {
         System.out.println("Parent pass required to set time restrictions");
      }
   }

   public static boolean isWithinTimeRestrictions() {
      if (timeRestrictions[0] == null || timeRestrictions[1] == null) {
         return true; // If no restrictions set, allow play at any time
      }
      LocalTime currentTime = LocalTime.now();
      return currentTime.isAfter(timeRestrictions[0]) && currentTime.isBefore(timeRestrictions[1]);
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

   public static Map<String, Object> getPlayerData() {
      Map<String, Object> playerData = new HashMap<>();
      playerData.put("numberOfSessions", Player.numberOfSessions);
      playerData.put("totalTimeSpent", Player.totalTimeSpent);
      playerData.put("parentPass", Player.parentPass);
      playerData.put("alivePets", Player.alivePets);
      playerData.put("deceasedPets", Player.deceasedPets);
      playerData.put("timeRestrictions", Player.timeRestrictions);
      return playerData;
   }

   public static void setPlayerData(Map<String, Object> playerData) {
      Player.numberOfSessions = (int) playerData.get("numberOfSessions");
      Player.totalTimeSpent = Duration.parse((String) playerData.get("totalTimeSpent"));
      Player.parentPass = (boolean) playerData.get("parentPass");
      Player.alivePets = (String[]) playerData.get("alivePets");
      Player.deceasedPets = (String[]) playerData.get("deceasedPets");
      Player.timeRestrictions = (LocalTime[]) playerData.get("timeRestrictions");
   }
}
