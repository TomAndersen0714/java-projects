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

    // todo: 修复二维List的比较失败问题
    public static <E> boolean collEquals(Collection<E> x, Collection<E> y) {
        List<E> collectedListX = x.stream().sorted().collect(Collectors.toList());
        List<E> collectedListY = y.stream().sorted().collect(Collectors.toList());
        return collectedListX.equals(collectedListY);
    }

    public static List<Object> arrayDeepToList(Object array) {
        if (array == null || !array.getClass().isArray()) {
            return null;
        }

        // 获取数组的元素类型
        Class<?> componentType = array.getClass().getComponentType();

        int length = Array.getLength(array);
        List<Object> list = new ArrayList<>(length);
        // 如果元素类型是数组，则递归调用
        if (componentType.isArray()) {
            for (int i = 0; i < length; i++) {
                list.add(arrayDeepToList(Array.get(array, i)));
            }
        }
        else {
            // 否则，将数组转换为List
            for (int i = 0; i < length; i++) {
                list.add(Array.get(array, i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] randomIntArray = randomIntArray(4);
        System.out.println(Arrays.toString(randomIntArray));

        System.out.println("collEquals(List.of(1,2,3), List.of(3,1,2)) = "
            + collEquals(List.of(1, 2, 3), List.of(3, 1, 2))
        );

        collEquals(arrayDeepToList(new int[][]{{1, 2, 3}, {3, 1, 2}}), arrayDeepToList(new int[][]{{1, 2, 3}, {3, 1, 2}}));

        System.out.println("arrayDeepToList(new int[][]{{1, 2, 3}, {3, 4, 5}}) = "
            + arrayDeepToList(new int[][]{{1, 2, 3}, {3, 4, 5}})
        );

        System.out.println("arrayDeepToList(new int[]{1, 2, 3}) = "
            + arrayDeepToList(new int[]{1, 2, 3})
        );

        System.out.println("Arrays.equals(new int[]{1, 2, 3}, new int[]{3, 2, 1}) = "
            + Arrays.equals(new int[]{1, 2, 3}, new int[]{3, 2, 1})
        );
    }
}
