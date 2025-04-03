import static org.junit.Assert.*;
import org.junit.Test;
import java.util.regex.Pattern;

public class MathBackendTest {

   @Test
   public void testNewQuestionFormat() {
      String[] result = MathBackend.newQuestion();

      // Test array length
      assertEquals(2, result.length);

      // Test question format using regex
      String questionPattern = "\\d+ [+\\-x/] \\d+ = ";
      assertTrue("Question format is incorrect",
            Pattern.matches(questionPattern, result[0]));

      // Test answer format
      assertTrue("Answer should be a number",
            result[1].matches("\\d+"));
   }

   @Test
   public void testAdditionQuestion() {
      // Test multiple times to ensure we get an addition question
      boolean foundAddition = false;
      for (int i = 0; i < 10; i++) {
         String[] result = MathBackend.newQuestion();
         if (result[0].contains("+")) {
            foundAddition = true;
            int a = Integer.parseInt(result[0].split(" ")[0]);
            int b = Integer.parseInt(result[0].split(" ")[2]);
            int answer = Integer.parseInt(result[1]);
            assertEquals("Addition answer is incorrect", a + b, answer);
            break;
         }
      }
      assertTrue("No addition question found in 10 attempts", foundAddition);
   }

   @Test
   public void testSubtractionQuestion() {
      // Test multiple times to ensure we get a subtraction question
      boolean foundSubtraction = false;
      for (int i = 0; i < 10; i++) {
         String[] result = MathBackend.newQuestion();
         if (result[0].contains("-")) {
            foundSubtraction = true;
            int a = Integer.parseInt(result[0].split(" ")[0]);
            int b = Integer.parseInt(result[0].split(" ")[2]);
            int answer = Integer.parseInt(result[1]);
            assertEquals("Subtraction answer is incorrect", a - b, answer);
            assertTrue("Subtraction result should not be negative", answer >= 0);
            break;
         }
      }
      assertTrue("No subtraction question found in 10 attempts", foundSubtraction);
   }

   @Test
   public void testMultiplicationQuestion() {
      // Test multiple times to ensure we get a multiplication question
      boolean foundMultiplication = false;
      for (int i = 0; i < 10; i++) {
         String[] result = MathBackend.newQuestion();
         if (result[0].contains("x")) {
            foundMultiplication = true;
            int a = Integer.parseInt(result[0].split(" ")[0]);
            int b = Integer.parseInt(result[0].split(" ")[2]);
            int answer = Integer.parseInt(result[1]);
            assertEquals("Multiplication answer is incorrect", a * b, answer);
            assertTrue("Multiplication numbers should be between 1 and 12",
                  a >= 1 && a <= 12 && b >= 1 && b <= 12);
            break;
         }
      }
      assertTrue("No multiplication question found in 10 attempts", foundMultiplication);
   }

   @Test
   public void testDivisionQuestion() {
      // Test multiple times to ensure we get a division question
      boolean foundDivision = false;
      for (int i = 0; i < 10; i++) {
         String[] result = MathBackend.newQuestion();
         if (result[0].contains("/")) {
            foundDivision = true;
            int a = Integer.parseInt(result[0].split(" ")[0]);
            int b = Integer.parseInt(result[0].split(" ")[2]);
            int answer = Integer.parseInt(result[1]);
            assertEquals("Division answer is incorrect", a / b, answer);
            assertTrue("Division should result in clean integer division",
                  a % b == 0);
            break;
         }
      }
      assertTrue("No division question found in 10 attempts", foundDivision);
   }
}