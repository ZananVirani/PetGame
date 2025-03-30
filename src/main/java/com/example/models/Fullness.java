public class Fullness extends Vital {
   private int value;

   public Fullness(int value) {
      super(value);
   }

   public void increaseFullness(int value) {
      super.increaseValue(value);
   }

   public void decreaseFullness(int value) {
      super.decreaseValue(value);
   }

   // public void isHungry() {
   //    if(super.getValue() <= 0){
   //       //Figure out penalty amount
   //       health.decreaseHealth(10); 
   //    }
   // }
}
