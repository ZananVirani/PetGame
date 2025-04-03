import greenfoot.*;
import java.util.Stack;

/**
 * ScreenManager manages the navigation between different screens in the game.
 * 
 * This class implements a stack-based screen management system that allows for
 * pushing new screens, popping back to previous screens, and replacing the
 * current screen.
 * It maintains a history of visited screens and provides methods to navigate
 * between them.
 * 
 * @author Group 78
 */
public class ScreenManager {
    private static Stack<World> worldStack = new Stack<>();

    /**
     * Pushes a new screen onto the stack and displays it.
     * 
     * @param newWorld The new World to display
     */
    public static void push(World newWorld) {
        worldStack.push(newWorld);
        Greenfoot.setWorld(newWorld);
    }

    /**
     * Pops the current screen from the stack and returns to the previous screen.
     * If the stack becomes empty, returns to the MainMenu.
     * If the stack is already empty, displays a BlackScreen.
     */
    public static void pop() {
        if (!worldStack.isEmpty()) {
            worldStack.pop();
            if (!worldStack.isEmpty())
                Greenfoot.setWorld(worldStack.peek());
            else
                Greenfoot.setWorld(new MainMenu());
        } else {
            Greenfoot.setWorld(new BlackScreen());
        }
    }

    /**
     * Replaces the current screen with a new one.
     * 
     * @param newWorld The new World to display
     */
    public static void replace(World newWorld) {
        if (!worldStack.isEmpty()) {
            worldStack.pop();
        }
        push(newWorld);
    }

    /**
     * Clears the entire screen stack.
     * This is typically used when returning to the main menu or restarting the
     * game.
     */
    public static void clearStack() {
        worldStack.clear();
    }
}
