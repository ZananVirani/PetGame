import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import greenfoot.World;
import greenfoot.Greenfoot;

public class ScreenManagerTest {
   private World testWorld1;
   private World testWorld2;
   private World testWorld3;

   @Before
   public void setUp() {
      // Create test worlds
      testWorld1 = new World(100, 100, 1) {
      };
      testWorld2 = new World(100, 100, 1) {
      };
      testWorld3 = new World(100, 100, 1) {
      };

      // Clear the stack before each test
      ScreenManager.clearStack();
   }

   @Test
   public void testPush() {
      ScreenManager.push(testWorld1);
      assertEquals("World should be set to testWorld1", testWorld1, Greenfoot.getWorld());
   }

   @Test
   public void testPop() {
      // Push multiple worlds
      ScreenManager.push(testWorld1);
      ScreenManager.push(testWorld2);
      ScreenManager.push(testWorld3);

      // Pop one world
      ScreenManager.pop();
      assertEquals("World should be set to testWorld2", testWorld2, Greenfoot.getWorld());
   }

   @Test
   public void testPopToMainMenu() {
      // Push one world
      ScreenManager.push(testWorld1);

      // Pop should return to MainMenu
      ScreenManager.pop();
      assertTrue("World should be an instance of MainMenu",
            Greenfoot.getWorld() instanceof MainMenu);
   }

   @Test
   public void testPopEmptyStack() {
      // Pop from empty stack should go to BlackScreen
      ScreenManager.pop();
      assertTrue("World should be an instance of BlackScreen",
            Greenfoot.getWorld() instanceof BlackScreen);
   }

   @Test
   public void testReplace() {
      // Push initial world
      ScreenManager.push(testWorld1);

      // Replace with new world
      ScreenManager.replace(testWorld2);
      assertEquals("World should be set to testWorld2", testWorld2, Greenfoot.getWorld());
   }

   @Test
   public void testClearStack() {
      // Push multiple worlds
      ScreenManager.push(testWorld1);
      ScreenManager.push(testWorld2);
      ScreenManager.push(testWorld3);

      // Clear stack
      ScreenManager.clearStack();

      // Next push should be the only world in stack
      ScreenManager.push(testWorld1);
      ScreenManager.pop();
      assertTrue("World should be an instance of MainMenu",
            Greenfoot.getWorld() instanceof MainMenu);
   }
}