public class Sleep extends Vital  {
   private int value;

   public Sleep(int value) {
      super(value);
   }

   public void increaseSleep(int value) {
      super.increaseValue(value);
   }

   public void decreaseSleep(int value) {
      super.decreaseValue(value);
   }  

   // public void SleepPenalty(Health health) {
   //    if(super.getValue() <= 0){
   //       //Figure out penalty amount
   //       health.decreaseHealth(10); 
   //    }
   // }
   
   
}
