public class Health extends Vital {

   public Health(int value) {
      super(value); 
   }

   public void increaseHealth(int value) {
      super.increaseValue(value);
   }

   public void decreaseHealth(int value) {
      super.decreaseValue(value);
   }

   // public void isDead() {
   //    if(super.getValue() <= 0){
   //       //End Game
   //    }
   // }
   
}
