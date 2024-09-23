package lesson1.control_flow;

/**
 * @author TomAndersen
 */
public class WhileStatement {
    public static void main(String[] args) {

        whileDoDemo();
        doWhileDemo();
    }

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

    static void whileDoDemo() {

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
}
