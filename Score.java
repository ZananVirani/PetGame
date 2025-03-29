public class Score {
    private int value;

    public Score(int initial) {
        value = initial;
    }

    public void increase(int amount) {
        value += amount;
    }
    
    public void decrease(int amount) {
        value -= amount;
    }

    public int getScore() {
        return value;
    }
    
    public String toString(){
        return String.format("%d", value);
    }
}
