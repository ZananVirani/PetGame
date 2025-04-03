import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.time.Duration;
import java.time.LocalTime;

public class PlayerTest {

   @Before
   public void setUp() {
      // Reset static fields before each test
      Player.setup();
   }

   @Test
   public void testSetup() {
      // Test initial values after setup
      assertEquals(0, Player.getTotalTime().getSeconds());
      assertArrayEquals(new String[10], Player.getAlivePets());
      assertArrayEquals(new String[10], Player.getDeceasedPets());
   }

   @Test
   public void testTimeRestrictions() {
      LocalTime startTime = LocalTime.of(9, 0);
      LocalTime endTime = LocalTime.of(17, 0);

      Player.setTimeRestrictions(startTime, endTime);
      assertEquals(startTime, Player.getStartTime());
      assertEquals(endTime, Player.getEndTime());
   }

   @Test
   public void testSessionAndTimeTracking() {
      Player.incrementSession();
      Player.incrementTime();

      assertEquals(1, Player.getTotalTime().getSeconds());
      assertEquals(1.0f, Player.getAverageSession(), 0.001f);
   }

   @Test
   public void testPetManagement() {
      // Test adding a pet
      assertTrue(Player.createPet());

      // Test pet death
      Player.petDied("testpet");
      String[] deceased = Player.getDeceasedPets();
      assertEquals("testpet", deceased[0]);

      // Test pet revival
      Player.revivePet("testpet");
      String[] alive = Player.getAlivePets();
      assertTrue(alive[0] != null);
   }

   @Test
   public void testArrayExpansion() {
      String[] original = new String[2];
      original[0] = "test1";
      original[1] = "test2";

      String[] expanded = Player.expandArray(original, 4);
      assertEquals(4, expanded.length);
      assertEquals("test1", expanded[0]);
      assertEquals("test2", expanded[1]);
   }
}