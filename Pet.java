 

public class Pet {
   private static String petName;
   private static int health;
   private static int fullness;
   private static int happiness;
   private static int sleep;
   private static int score;
   private static String currentState;

   public static void Setup(String name){
      petName = name;
      health = 100;
      fullness = 100;
      happiness = 100;
      sleep = 100;
      score = 0;
      currentState = null;
   }

   public static void increaseVital(int vital, int value) {
      vital += value;
   }

   public static void decreaseVital(int vital, int value) {
      vital -= value;
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
      petData.put("petName", Pet.classpetName);
      petData.put("health", Pet.health);
      petData.put("fullness", Pet.fullness);
      petData.put("happiness", Pet.happiness);
      petData.put("sleep", Pet.sleep);
      petData.put("score", Pet.score);
      petData.put("currentState", Pet.currentState);
      return petData;
   }

   public static void setPetData(Map<String, Object> petData) {
      Pet.petName = (String) petData.get("petName");
      Pet.health = (int) petData.get("health");
      Pet.fullness = (int) petData.get("fullness");
      Pet.happiness = (int) petData.get("happiness");
      Pet.sleep = (int) petData.get("sleep");
      Pet.score = (int) petData.get("score");
      Pet.currentState = (String) petData.get("currentState");
   }

}
