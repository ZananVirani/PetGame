import static org.junit.Assert.*;
import org.junit.Test;

public class FoodTest {

   @Test
   public void testFoodCreation() {
      Food food = new Food("TestFood", 10);
      assertEquals("TestFood", food.getName());
      assertEquals(10, food.getValue());
   }

   @Test
   public void testFoodEquality() {
      Food food1 = new Food("TestFood", 10);
      Food food2 = new Food("TestFood", 20); // Different value
      Food food3 = new Food("DifferentFood", 10); // Different name

      assertTrue(food1.equals(food2)); // Should be equal because names are same
      assertFalse(food1.equals(food3)); // Should not be equal because names are different
      assertFalse(food1.equals(null)); // Should not be equal to null
   }
}