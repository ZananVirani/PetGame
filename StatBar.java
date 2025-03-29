import greenfoot.*;

/**
 * StatBar represents a visual and logical stat bar for the pet's health, happiness, etc.
 * Each stat has its own color and label. Uses Greenfoot-compatible colors only.
 */
public class StatBar extends Actor
{
    private int value;
    private int maxValue;
    private String statName;
    private GreenfootImage barImage;

    /**
     * Constructor to create a stat bar with a name and initial value.
     * @param name The stat name (e.g., "health")
     * @param initialValue Starting value of the stat
     */
    public StatBar(String name, int initialValue)
    {
        this.statName = name.toLowerCase(); // normalize
        this.maxValue = 100;
        this.value = initialValue;
        barImage = new GreenfootImage(150, 20); // space for label + bar
        updateBar();
    }

    /**
     * Decrease the stat value.
     * @param amount How much to decrease
     */
    public void decrease(int amount)
    {
        value = Math.max(0, value - amount);
        updateBar();
    }

    /**
     * Increase the stat value.
     * @param amount How much to increase
     */
    public void increase(int amount)
    {
        value = Math.min(maxValue, value + amount);
        updateBar();
    }

    /**
     * Updates the visual representation of the bar and label.
     */
    private void updateBar()
    {
        barImage.clear();

        // Draw label
        barImage.setColor(Color.BLACK);
        barImage.setFont(barImage.getFont().deriveFont(12f));
        barImage.drawString(capitalize(statName), 5, 15);

        // Draw background
        barImage.setColor(Color.GRAY);
        barImage.fillRect(60, 5, 80, 10);

        // Draw filled bar
        barImage.setColor(getColorForStat(statName));
        int fillWidth = (int)(80 * (value / (double)maxValue));
        barImage.fillRect(60, 5, fillWidth, 10);

        setImage(barImage);
    }

    /**
     * Returns a Greenfoot color based on the stat type.
     */
    private Color getColorForStat(String stat)
    {
        switch (stat)
        {
            case "health":
                return (value < maxValue / 2) ? Color.RED : Color.GREEN;
            case "happiness":
                return Color.YELLOW;
            case "hunger":
                return Color.ORANGE; // Not available — fallback below
            case "energy":
                return Color.BLUE;
            default:
                return Color.WHITE;
        }
    }

    /**
     * Capitalizes the first letter of a word.
     */
    private String capitalize(String word)
    {
        if (word.length() == 0) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    /**
     * @return the current stat value
     */
    public int getValue()
    {
        return value;
    }

    /**
     * @return the stat's name
     */
    public String getStatName()
    {
        return statName;
    }
}
