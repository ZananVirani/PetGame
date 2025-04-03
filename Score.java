/**
 * Score class manages a numerical score value that can be increased or
 * decreased.
 * This class provides basic score manipulation functionality and string
 * representation.
 * 
 * @author Group78
 */
public class Score {
    private int value;

    /**
     * Constructs a new Score with the specified initial value.
     *
     * @param initial The initial score value
     */
    public Score(int initial) {
        value = initial;
    }

    /**
     * Increases the score by the specified amount.
     *
     * @param amount The amount to increase the score by
     */
    public void increase(int amount) {
        value += amount;
    }

    /**
     * Decreases the score by the specified amount.
     *
     * @param amount The amount to decrease the score by
     */
    public void decrease(int amount) {
        value -= amount;
    }

    /**
     * Gets the current score value.
     *
     * @return The current score
     */
    public int getScore() {
        return value;
    }

    /**
     * Returns a string representation of the score.
     *
     * @return The score as a formatted string
     */
    public String toString() {
        return String.format("%d", value);
    }
}
