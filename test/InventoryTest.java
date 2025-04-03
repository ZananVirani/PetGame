import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class InventoryTest {
   private Inventory inventory;
   private Food testFood;
   private Gift testGift;

   @Before
   public void setUp() {
      inventory = new Inventory();
      testFood = new Food("TestFood", 10);
      testGift = new Gift("TestGift", 15);
   }

   @Test
   public void testInitialInventory() {
      assertTrue(inventory.getFoodItems().isEmpty());
      assertTrue(inventory.getGiftItems().isEmpty());
   }

   @Test
   public void testAddRandomItems() {
      Food addedFood = inventory.addFood();
      Gift addedGift = inventory.addGift();

      assertNotNull(addedFood);
      assertNotNull(addedGift);
      assertEquals(1, inventory.getFoodItems().size());
      assertEquals(1, inventory.getGiftItems().size());
   }

   @Test
   public void testAddItemsByName() {
      inventory.addFoodFromName("Hamburger");
      inventory.addGiftFromName("Blue Gift");

      assertEquals(1, inventory.getFoodItems().size());
      assertEquals(1, inventory.getGiftItems().size());
      assertEquals("Hamburger", inventory.getFoodItems().get(0).getName());
      assertEquals("Blue Gift", inventory.getGiftItems().get(0).getName());
   }

   @Test
   public void testHasItems() {
      inventory.addFoodFromName("Hamburger");
      inventory.addGiftFromName("Blue Gift");

      assertTrue(inventory.hasFood(new Food("Hamburger", 20)));
      assertTrue(inventory.hasGift(new Gift("Blue Gift", 15)));
      assertFalse(inventory.hasFood(new Food("Pizza", 15)));
      assertFalse(inventory.hasGift(new Gift("Red Gift", 5)));
   }

   @Test
   public void testUseItems() {
      // Setup PetClass for testing
      PetClass.Setup("TestPet", "Cat");

      // Add and use food
      inventory.addFoodFromName("Hamburger");
      inventory.useFood(new Food("Hamburger", 20));
      assertEquals(0, inventory.getFoodItems().size());
      assertEquals(120, PetClass.getFullness()); // 100 + 20

      // Add and use gift
      inventory.addGiftFromName("Blue Gift");
      inventory.useGift(new Gift("Blue Gift", 15));
      assertEquals(0, inventory.getGiftItems().size());
      assertEquals(115, PetClass.getHappiness()); // 100 + 15
   }

   @Test
   public void testClearInventory() {
      inventory.addFoodFromName("Hamburger");
      inventory.addGiftFromName("Blue Gift");

      inventory.clear();
      assertTrue(inventory.getFoodItems().isEmpty());
      assertTrue(inventory.getGiftItems().isEmpty());
   }

   @Test
   public void testExtractNames() {
      inventory.addFoodFromName("Hamburger");
      inventory.addGiftFromName("Blue Gift");

      List<String> foodNames = Inventory.extractFoodNames(inventory.getFoodItems());
      List<String> giftNames = Inventory.extractGiftNames(inventory.getGiftItems());

      assertEquals(1, foodNames.size());
      assertEquals(1, giftNames.size());
      assertEquals("Hamburger", foodNames.get(0));
      assertEquals("Blue Gift", giftNames.get(0));
   }
}