package lesson1.control_flow;

/**
 * @author TomAndersen
 */
public class ForStatement {
    public static void main(String[] args) {
        // i.e. for (declare counter; loop condition; update counter)
        for (int i = 0, j = 10; i <= j; i++) {


            // continue, i.e. skip current turn in loop statement
            if (i == 2) continue;


            // break, i.e. break out of the current loop
            if (i == 3) break;
            else System.out.println(i);
        }
        System.out.println();

        // traversal with step size of 2
        for (int i = 0, j = 10; i <= j; i += 2) {

            // continue, i.e. skip current turn in loop statement
            if (i == 2) continue;


            // break, i.e. break out of the current loop
            if (i == 3) break;
            else System.out.println(i);
        }
    }
}
