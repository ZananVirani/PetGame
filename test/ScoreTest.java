import static org.junit.Assert.*;
import org.junit.Test;

public class ScoreTest {

   @Test
   public void testScoreCreation() {
      Score score = new Score(100);
      assertEquals(100, score.getScore());
   }

   @Test
   public void testScoreModification() {
      Score score = new Score(50);

      // Test increase
      score.increase(30);
      assertEquals(80, score.getScore());

      // Test decrease
      score.decrease(20);
      assertEquals(60, score.getScore());
   }

   @Test
   public void testScoreToString() {
      Score score = new Score(75);
      assertEquals("75", score.toString());
   }
}