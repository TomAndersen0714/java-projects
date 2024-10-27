package leetcode.common;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author TomAndersen
 */
public class Util {
    public static int[] randomIntArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }

        return array;
    }

    public static <E> boolean collEquals(Collection<E> x, Collection<E> y) {
        List<E> collectedListX = x.stream().sorted().collect(Collectors.toList());
        List<E> collectedListY = y.stream().sorted().collect(Collectors.toList());
        return collectedListX.equals(collectedListY);
    }

    public static List<?> arrayToList(Object array) {
        if (array == null) {
            return null;
        }

        // 获取数组的组件类型
        Class<?> componentType = array.getClass().getComponentType();

        // 如果组件类型是数组，则递归调用
        if (componentType.isArray()) {
            int length = Array.getLength(array);
            List<Object> list = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                list.add(arrayToList(Array.get(array, i)));
            }
            return list;
        }
        else {
            // 否则，将数组转换为List
            int length = Array.getLength(array);
            List<Object> list = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                list.add(Array.get(array, i));
            }
            return list;
        }
    }

    public static void main(String[] args) {
        int[] randomIntArray = randomIntArray(4);
        System.out.println(Arrays.toString(randomIntArray));

        System.out.println("equals(List.of(1,2,3), List.of(3,1,2)) = "
            + collEquals(List.of(1, 2, 3), List.of(3, 1, 2))
        );

        System.out.println("arrayToList(new int[][]{{1, 2, 3}, {3, 4, 5}}) = "
            + arrayToList(new int[][]{{1, 2, 3}, {3, 4, 5}})
        );

        System.out.println("Arrays.equals(new int[]{1, 2, 3}, new int[]{3, 2, 1}) = "
            + Arrays.equals(new int[]{1, 2, 3}, new int[]{3, 2, 1})
        );
    }
}
