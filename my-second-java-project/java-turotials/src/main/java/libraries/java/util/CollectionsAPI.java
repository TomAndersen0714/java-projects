package libraries.java.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * @author TomAndersen
 * @see java.util.Collections
 * @see java.util.List
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


        // Collections.reverse(List)
        Collections.reverse(list1);
        System.out.println("Collections.reverse(list1) = " + list1);

        // Collections.reverseOrder
        // 构建并返回针对集合元素类型的降序 Comparator
        System.out.println("Collections.reverseOrder() = " + Collections.reverseOrder());
        Collections.sort(list1, Collections.reverseOrder());
        System.out.println("Collections.reverseOrder() = " + list1);

        // Collections.shuffle(List<?> list)
        // shuffle the list into random order
        Collections.shuffle(list1);
        System.out.println("Collections.shuffle(list1) = " + list1);

        // Collections.singleton()
        // returns an immutable set containing only the specified object
        System.out.println("Collections.singleton(\"Hello\") = " + Collections.singleton("Hello"));
        // Collections.singletonList()
        // returns an immutable list containing only the specified object
        System.out.println("Collections.singletonList(\"Hello\") = " + Collections.singletonList("Hello"));
        // Collections.singletonMap()
        // returns an immutable map, mapping only the specified key to the specified value.
        System.out.println("Collections.singletonMap(\"Tom\", 100) = " + Collections.singletonMap("Tom", 100));
    }
}
