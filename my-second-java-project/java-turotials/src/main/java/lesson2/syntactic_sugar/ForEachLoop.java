package lesson2.syntactic_sugar;

/**
 * @author TomAndersen
 */
public class ForEachLoop {

    public static void main(String[] args) {
        // for-each statement
        // i.e. for (variable : collection)
        System.out.println("This is a for-each demo: ");
        int[] nums = {1, 2, 3, 4};
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
