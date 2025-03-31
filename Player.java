import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Player {
   private static Pet pet;
   private static int numberOfSessions;
   private static Duration totalTimeSpent;
   private static boolean parentPass;
   private static String[] alivePets;
   private static String[] deceasedPets;
   private static LocalTime[] timeRestrictions; // Array to store start and end times

   public static void Setup() {
      pet = null;
      numberOfSessions = 0;
      totalTimeSpent = Duration.ZERO;
      parentPass = false;
      alivePets = new String[3];
      deceasedPets = new String[3];
      timeRestrictions = new LocalTime[2]; // Initialize array for start and end times
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
}
