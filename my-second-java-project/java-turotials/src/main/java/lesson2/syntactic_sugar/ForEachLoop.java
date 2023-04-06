package lesson2.syntactic_sugar;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/guides/language/foreach.html
 *
 * @author TomAndersen
 */
public class ForEachLoop {

    public static void main(String[] args) {
        // NOTE: for-each statement, since JDK 5
        // i.e. for (variable : collection)
        System.out.println("This is a for-each demo: ");
        int[] nums = {1, 2, 3, 4};
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
