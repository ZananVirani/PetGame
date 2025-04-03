/**
 * Gift class represents a gift item that can be used to increase a pet's
 * happiness.
 * Each gift item has a name and a value that determines how much it increases
 * happiness.
 * 
 * @author Group78
 */
public class Gift {
    private String name;
    private int value;

    /**
     * Constructs a new Gift item with the specified name and value.
     *
     * @param name  The name of the gift item
     * @param value The amount of happiness this gift item provides
     */
    public Gift(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Gets the value (happiness increase) of this gift item.
     *
     * @return The value of the gift item
     */
    public int getValue() {
        return value;
    }

    /**
     * Gets the name of this gift item.
     *
     * @return The name of the gift item
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if this gift item is equal to another object.
     * Gift items are considered equal if they have the same name.
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
        Gift other = (Gift) obj;
        return name != null && name.equals(other.name);
    }
}
