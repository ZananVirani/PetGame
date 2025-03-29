import java.util.Random;

/**
 * Write a description of class MathBackend here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MathBackend  
{
    public static String[] newQuestion(){
        Random rand = new Random();
        String[] result = new String[2];

        int a, b, answer = 0;
        String op;

        int type = rand.nextInt(4); // 0-add, 1-sub, 2-mul, 3-div

        switch (type) {
            case 0: // Addition
                a = rand.nextInt(50) + 1;
                b = rand.nextInt(50) + 1;
                op = "+";
                answer = a + b;
                break;

            case 1: // Subtraction
                a = rand.nextInt(50) + 1;
                b = rand.nextInt(a) + 1; // ensure no negative result
                op = "-";
                answer = a - b;
                break;

            case 2: // Multiplication (limit to 12×12)
                a = rand.nextInt(12) + 1;
                b = rand.nextInt(12) + 1;
                op = "x";
                answer = a * b;
                break;

            default: // Division (ensure clean integer division)
                b = rand.nextInt(12) + 1;
                answer = rand.nextInt(12) + 1;
                a = b * answer;
                op = "/";
                break;
        }

        result[0] = String.format("%d %s %d = ", a, op, b);
        result[1] = Integer.toString(answer);
        
        return result;

    }
}
