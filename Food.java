/**
 * Food class represents a food item that can be used to increase a pet's
 * fullness.
 * Each food item has a name and a value that determines how much it increases
 * fullness.
 * 
 * @author Group78
 */
public class Food {
    private String name;
    private int value;

    /**
     * Constructs a new Food item with the specified name and value.
     *
     * @param name  The name of the food item
     * @param value The amount of fullness this food item provides
     */
    public Food(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Gets the value (fullness increase) of this food item.
     *
     * @return The value of the food item
     */
    public int getValue() {
        return value;
    }

    /**
     * Gets the name of this food item.
     *
     * @return The name of the food item
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if this food item is equal to another object.
     * Food items are considered equal if they have the same name.
     *
     * @param obj The object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Food other = (Food) obj;
        return name != null && name.equals(other.name);
    }
}
