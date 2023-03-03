package libraries.java.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * @author TomAndersen
 * @see java.util.Collections
 */
public class CollectionsAPI {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{3, 2, 5, 6, 1};
        List<Integer> list1 = Arrays.asList(array);
        System.out.println("list1 = " + list1);


        // Collections.sort(List<T> list)
        // sort the list in ascending order
        Collections.sort(list1);
        System.out.println("Collections.sort(list1) = " + list1);

        // Collections.sort(List<T> list, Comparator<? super T> c)
        // sort the list in specific order
        Collections.sort(list1, (x, y) -> y - x);
        System.out.println("Collections.sort(list1, (x, y) -> y - x) = " + list1);

        // Collections.shuffle(List<?> list)
        // shuffle the list into random order
        Collections.shuffle(list1);
        System.out.println("Collections.shuffle(list1) = " + list1);
    }

    static void convertArrayToList() {
        // method1: Arrays.asList(T... a)
        Arrays.asList();

        // method2: List.as()
    }
}
