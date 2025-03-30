public class Vital {
    private int value;
    private int criticalValue;
    
    public Vital(int value) {
       this.value = value;
       this.criticalValue = value * 0.5;
    }
 
    public int getValue() {
       return value;
    }
 
    public void increaseValue(int value) {
       this.value += value;
    }
 
    public void decreaseValue(int value) {
       this.value -= value;
    }
 
    public boolean isCritical() {
       if (this.value <= criticalValue) {
          return true;
       }
       return false;
    }
 }