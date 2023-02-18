package lesson1.control_flow;

/**
 * @author TomAndersen
 */
public class CodeBlock {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // code block
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
}
