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

   public static void Setup(String name, String type){
      petName = name;
      health = 100;
      fullness = 100;
      happiness = 100;
      sleep = 100;
      score = 0;
      currentState = null;
      petType = type;
      if(petType == "Cat"){
         multiplier = 1;
         vitalMultiplier = "fullness";
      } else if(petType == "Dog"){
         multiplier = 2;
         vitalMultiplier = "happiness";
      } else if(petType == "Bear"){
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

   public static int getFullness(){
      return fullness;     
   }

   public static int getHealth(){
      return health;
   }

   public static int getHappiness(){
      return happiness;
   }

   public static int getSleep(){
      return sleep;
   }

   public static void setCurrentState(String state){
      currentState = state;
   }

   public static String getCurrentState(){
      return currentState;
   }

   public static Map<String, Object> getPetData() {
      Map<String, Object> petData = new HashMap<>();
      petData.put("petName", petName);
      petData.put("health", health);
      petData.put("fullness", fullness);
      petData.put("happiness", happiness);
      petData.put("sleep", sleep);
      petData.put("score", score);
      petData.put("currentState", currentState);
      petData.put("petType", petType);
      petData.put("multiplier", multiplier);
      petData.put("vitalMultiplier", vitalMultiplier);
      return petData;
   }

   public static void setPetData(Map<String, Object> petData) {
      petName = (String) petData.get("petName");
      health = (int) petData.get("health");
      fullness = (int) petData.get("fullness");
      happiness = (int) petData.get("happiness");
      sleep = (int) petData.get("sleep");
      score = (int) petData.get("score");
      currentState = (String) petData.get("currentState");
      petType = (String) petData.get("petType");
      multiplier = (int) petData.get("multiplier");
      vitalMultiplier = (String) petData.get("vitalMultiplier");
   }


}
