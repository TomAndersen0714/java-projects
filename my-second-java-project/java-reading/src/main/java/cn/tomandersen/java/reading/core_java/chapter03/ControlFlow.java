package cn.tomandersen.java.reading.core_java.chapter03;

import java.util.Scanner;

public class ControlFlow {
    static void blockDemo() {
        System.out.println("Hello World!");

        {
            int x = 0;
            System.out.println("This is a block!");
            {
                // inner block can access the variable which is defined in outer block
                System.out.println("You can access the variable of outer block, such as 'x': " + x);
                // but you can not declare the same variable which is already define in outer block

                int k = 0;
                System.out.println("This is a inner block!");

            } // 'k' is only defined up to here
            // 即变量的定义仅存在于其对应的 Block 中, 除非其属于 static 类变量
        }

    }

    static void whileDemo() {
        // while statement
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

    static void doWhileDemo() {
        // do-while statement
        double balance = 0d, goal = 100_0000d;
        double payment = 100000;
        double interest, interestRate = 2;
        int year = 0;

        // do-while statement
        do {
            balance += payment;
            interest = balance * interestRate / 100;
            balance += interest;
            year++;
        } while (year <= 20);
        System.out.println(balance);
    }

    static void forDemo() {
        // for statement, i.e. for (declare counter; loop condition; update counter)
        for (int i = 0, j = 10; i <= j; i++) {
            System.out.println(i);
        }
    }

    static void forEachDemo() {
        // for-each statement, i.e. for (variable : collection)
        System.out.println("This is a for-each demo: ");
        int[] nums = {1, 2, 3, 4};
        for (int num : nums) {
            System.out.println(num);
        }
    }

    static void loopControlDemo() {
        // break statement
        System.out.println("This is a break statement demo: ");
        int[] nums = {1, 2, 3, 4};
        for (int num : nums) {
            System.out.println(num);
            if (num == 4) break;
        }


        // break label demo
        System.out.println("This is a break label demo: ");
        break_label:
        for (int num : nums) {
            System.out.println(num);
            for (int x = 0; x <= num; x++) {
                System.out.println(x);

                if (num == 4)
                    // break and jump to the position of break label, no mater
                    // how many loop there is
                    break break_label;
            }
        }

        // continue demo
        System.out.println("This is a continue statement demo: ");
        for (int num : nums) {
            System.out.println(num);
            // continue will skip the rest of current loop, and go to the head of next loop
            if (num == 4) continue;
        }
    }

    static void loopDemo() {
//        whileDemo();
//        doWhileDemo();
//        forDemo();
//        forEachDemo();
        loopControlDemo();
    }

    static void ifDemo() {
        // if condition block
        String username = "Tom";

        if (username.equals("Tom")) {
            System.out.println("Hello, Tom! It's been a long time!");
        }

        username = "Alise";
        if (username.equals("Alise")) {
            System.out.println("Hello, Alise!");
        } else if (username.equals("John")) {
            System.out.println("Hello, John!");
        }

    }

    static void switchDemo() {
        // switch statement
        Scanner in = new Scanner(System.in);
        System.out.println("Please select an option (1, 2, 3, 4) ");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                System.out.println("This is the first case!");
                break;
            case 2:
                System.out.println("This is the second case!");
                break;
            default:
                System.out.println("This is the other case!");
                break;
        }

//        // switch expression, since Java 14 (PS: not the 'switch statement')
//        int num = switch (choice) {
//            case 1 -> 2;
//            default -> 3;
//        };

//        int num = switch (choice) {
//            case 1 -> {
//                  yield 2;
//            };
//            default -> 3;
//        };

//        System.out.println("Please input your name: ");
//        String name = in.next();
//        switch (name) {
//            case "Tom":
//                System.out.println("Hello, Tom!");
//
//            // since Java 14
//            case "Alise","John":
//                System.out.println();
//        }


        // release the resources
        in.close();
    }

    static void conditionDemo() {
//        ifDemo();
        switchDemo();
    }


    public static void main(String[] args) {
//        blockDemo();
//        conditionDemo();
        loopDemo();
    }
}
