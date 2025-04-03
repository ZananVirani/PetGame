import static org.junit.Assert.*;
import org.junit.Test;

public class GiftTest {

   @Test
   public void testGiftCreation() {
      Gift gift = new Gift("TestGift", 15);
      assertEquals("TestGift", gift.getName());
      assertEquals(15, gift.getValue());
   }

   @Test
   public void testGiftEquality() {
      Gift gift1 = new Gift("TestGift", 15);
      Gift gift2 = new Gift("TestGift", 25); // Different value
      Gift gift3 = new Gift("DifferentGift", 15); // Different name

      assertTrue(gift1.equals(gift2)); // Should be equal because names are same
      assertFalse(gift1.equals(gift3)); // Should not be equal because names are different
      assertFalse(gift1.equals(null)); // Should not be equal to null
   }
}