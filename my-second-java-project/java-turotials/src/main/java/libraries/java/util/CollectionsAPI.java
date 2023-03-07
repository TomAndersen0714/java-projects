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
        Integer[] array = new Integer[]{3, 2, 5, 6, 1, 1};
        List<Integer> list1 = Arrays.asList(array);
        System.out.println("list1 = " + list1);


        // Collections.replace
        Collections.replaceAll(list1, 1, 2);
        System.out.println("Collections.replaceAll(list1, 1, 2) = " + list1);

        // Collections.sort(List<T> list)
        Collections.sort(list1);
        System.out.println("Collections.sort(list1) = " + list1);

        // Collections.sort(List<T> list, Comparator<? super T> c)
        Collections.sort(list1, (x, y) -> y - x);
        System.out.println("Collections.sort(list1, (x, y) -> y - x) = " + list1);


        // Collections.reverseOrder
        // 构建并返回针对集合元素类型的降序 Comparator
        System.out.println("Collections.reverseOrder() = " + Collections.reverseOrder());
        Collections.sort(list1, Collections.reverseOrder());
        System.out.println("Collections.reverseOrder() = " + list1);

        // Collections.shuffle(List<?> list)
        // shuffle the list into random order
        Collections.shuffle(list1);
        System.out.println("Collections.shuffle(list1) = " + list1);
    }
}
