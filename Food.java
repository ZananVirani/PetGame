
public class Food {
    private String name;
    private int value;

    public Food(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Food other = (Food) obj;
        return name != null && name.equals(other.name);
    }
}
