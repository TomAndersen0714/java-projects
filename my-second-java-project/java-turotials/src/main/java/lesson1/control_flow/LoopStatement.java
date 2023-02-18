package lesson1.control_flow;

/**
 * @author TomAndersen
 */
public class LoopStatement {
    public static void main(String[] args) {

    }

    /**
     * for loop statement
     */
    static void forDemo() {
        // i.e. for (declare counter; loop condition; update counter)
        for (int i = 0, j = 10; i <= j; i++) {


            // continue, i.e. skip current turn in loop statement
            if (i == 2) continue;


            // break, i.e. break out of the current loop
            if (i == 3) break;
            else System.out.println(i);
        }
    }


    /**
     * while loop statement
     */
    static void whileDemo() {

        double balance = 0d, goal = 100_0000d;
        double payment = 100000;
        double interest, interestRate = 2;
        int year = 0;

        while (balance <= goal) {
            balance += payment;
            interest = balance * interestRate / 100;
            balance += interest;
            year++;
        }
        System.out.println(year);
    }

    /**
     * do-while loop statement
     */
    static void doWhileDemo() {
        double balance = 0d, goal = 100_0000d;
        double payment = 100000;
        double interest, interestRate = 2;
        int year = 0;

        do {
            balance += payment;
            interest = balance * interestRate / 100;
            balance += interest;
            year++;
        }
        while (year <= 20);
        System.out.println(balance);
    }


}
