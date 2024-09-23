package lesson1.variable_types;

/**
 * @author TomAndersen
 */
public class ConstantVariable {
    public static void main(String[] args) {
        // NOTE: If a variable is declared with the 'Final' modifier,
        //  it means that the variable cannot be modified and is considered a constant.
        final int c = 123;
        // c = 234;
        System.out.println("c = " + c);

        int v = 123;
        v = 456;
        System.out.println("v = " + v);
    }
}
