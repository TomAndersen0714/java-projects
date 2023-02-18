package lesson1.control_flow;

import java.util.Scanner;

/**
 * @author TomAndersen
 */
public class ConditionStatement {
    public static void main(String[] args) {
        ifElseStatement();
        switchStatement();
    }

    static void ifElseStatement() {
        System.out.println("ifDemo(): ");

        // if condition block
        String username = "Tom";

        if (username.equals("Tom")) {
            System.out.println("Hello, Tom! It's been a long time!");
        }

        // ternary operator
        System.out.println(username.equals("Tom") ? ("Hello, Tom! It's been a long time!") : ("Hello, guest!"));

        username = "Alise";
        if (username.equals("Alise")) {
            System.out.println("Hello, Alise!");
        }
        else if (username.equals("John")) {
            System.out.println("Hello, John!");
        }
        else System.out.println("Hello Nobody!");

    }

    static void switchStatement() {
        // switch statement
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select an option (1, 2, 3, 4) ");
        int flag = sc.nextInt();

        switch (flag) {
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

        // switch expression, since Java 14 (PS: not the 'switch statement')
//        int num = switch (flag) {
//            case 1 -> 2;
//            default -> 3;
//        };

//        int num = switch (flag) {
//            case 1 -> {
//                  yield 2;
//            };
//            default -> 3;
//        };

//        System.out.println("Please input your name: ");
//        String name = sc.next();
//        switch (name) {
//            case "Tom":
//                System.out.println("Hello, Tom!");
//
//            // since Java 14
//            case "Alise","John":
//                System.out.println();
//        }


        // try to close the source
        sc.close();
    }
}
