import java.util.Random;

/**
 * MathBackend handles the generation of math questions for the math game.
 * 
 * This class provides functionality to generate random math questions of
 * different types
 * (addition, subtraction, multiplication, and division) with appropriate
 * difficulty levels.
 * Questions are generated with clean integer results and no negative numbers
 * for subtraction.
 * 
 * @author Group 78
 */
public class MathBackend {
    /**
     * Generates a new math question and its answer.
     * 
     * The method randomly selects one of four operations (addition, subtraction,
     * multiplication, or division) and generates appropriate numbers for the
     * operation.
     * For subtraction, it ensures no negative results. For multiplication, it
     * limits
     * to 12×12 tables. For division, it ensures clean integer division.
     * 
     * @return A String array where:
     *         - index 0 contains the question string (e.g., "5 + 3 = ")
     *         - index 1 contains the correct answer as a string
     */
    public static String[] newQuestion() {
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
