import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Map;

public class PetClassTest {

   @Before
   public void setUp() {
      PetClass.Setup("TestPet", "Cat");
   }

   @Test
   public void testInitialSetup() {
      assertEquals("TestPet", PetClass.getName());
      assertEquals(100, PetClass.getHealth());
      assertEquals(100, PetClass.getFullness());
      assertEquals(100, PetClass.getHappiness());
      assertEquals(100, PetClass.getSleep());
      assertEquals(0, PetClass.getScore());
   }

   @Test
   public void testVitalStatsModification() {
      // Test health modifications
      PetClass.increaseHealth(20);
      assertEquals(120, PetClass.getHealth());
      PetClass.decreaseHealth(30);
      assertEquals(90, PetClass.getHealth());

      // Test fullness modifications
      PetClass.increaseFullness(15);
      assertEquals(115, PetClass.getFullness());
      int decreased = PetClass.decreaseFullness(10);
      assertEquals(95, PetClass.getFullness());
      assertEquals(20, decreased); // Cat has multiplier of 2

      // Test happiness modifications
      PetClass.increaseHappiness(25);
      assertEquals(125, PetClass.getHappiness());
      decreased = PetClass.decreaseHappiness(10);
      assertEquals(105, PetClass.getHappiness());
      assertEquals(10, decreased);

      // Test sleep modifications
      PetClass.increaseSleep(30);
      assertEquals(130, PetClass.getSleep());
      decreased = PetClass.decreaseSleep(10);
      assertEquals(110, PetClass.getSleep());
      assertEquals(10, decreased);
   }

   @Test
   public void testScoreManagement() {
      PetClass.increaseScore(50);
      assertEquals(50, PetClass.getScore());
      PetClass.decreaseScore(20);
      assertEquals(30, PetClass.getScore());
   }

   @Test
   public void testPetDataSerialization() {
      // Test getting pet data
      Map<String, Object> petData = PetClass.getPetData();
      assertEquals("TestPet", petData.get("petName"));
      assertEquals("100", petData.get("health"));
      assertEquals("100", petData.get("fullness"));
      assertEquals("100", petData.get("happiness"));
      assertEquals("100", petData.get("sleep"));
      assertEquals("0", petData.get("score"));
      assertEquals("Cat", petData.get("petType"));
      assertEquals("2", petData.get("multiplier"));
      assertEquals("fullness", petData.get("vitalMultiplier"));

      // Test setting pet data
      PetClass.setPetData(petData);
      assertEquals("TestPet", PetClass.getName());
      assertEquals(100, PetClass.getHealth());
      assertEquals(100, PetClass.getFullness());
      assertEquals(100, PetClass.getHappiness());
      assertEquals(100, PetClass.getSleep());
      assertEquals(0, PetClass.getScore());
   }
}