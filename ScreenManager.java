import greenfoot.*;
import java.util.Stack;

/**
 * Write a description of class ScreenManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScreenManager {
    private static Stack<World> worldStack = new Stack<>();

    public static void push(World newWorld) {
        worldStack.push(newWorld);
        Greenfoot.setWorld(newWorld);
    }

    public static void pop() {
        if (!worldStack.isEmpty()){
            worldStack.pop();
            if (!worldStack.isEmpty())
            Greenfoot.setWorld(worldStack.peek());
        }
    }

    public static void clearStack() {
        worldStack.clear();
    }
}
