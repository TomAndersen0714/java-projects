package lesson1.control_flow;

/**
 * @author TomAndersen
 */
public class IfElseStatement {
    public static void main(String[] args) {
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
}
