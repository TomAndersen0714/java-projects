/**
 * @author TomAndersen
 * @link <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/index.html">The Java™ Tutorials</a>
 */
public class HelloWorld {
    public static void main(String[] args) {
        String greeting = "Hello world! I am back!";

        System.out.println(greeting);
        for (int i = 0; i < greeting.length(); i++) {
            System.out.print("=");
        }
        System.out.println();

        // get the class path
        System.out.println("java.class.path: " + System.getProperty("java.class.path"));
    }
}
