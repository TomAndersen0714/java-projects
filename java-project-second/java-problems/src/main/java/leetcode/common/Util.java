package leetcode.common;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;

import java.lang.reflect.Array;
import java.util.*;

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

    // 判断两个 List 中的元素是否相同
    public static <T> boolean compareList(List<T> l, List<T> r) {
        // sort all elements in list
        l = sortList(l);
        r = sortList(r);

        // compare the string of list
        return l.toString().equals(r.toString());
    }

    // 针对 List 进行递归排序
    private static <T> List<T> sortList(List<T> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }

        // sort all elements recursively
        LinkedList<T> res = new LinkedList<>(list);
        for (int i = 0; i < res.size(); i += 1) {
            if (res.get(i) instanceof List) {
                LinkedList<?> ele = new LinkedList<>((List<?>) res.get(i));
                res.set(i, (T) sortList(ele));
            }
        }

        res.sort((x, y) -> x.toString().compareTo(y.toString()));
        return res;
    }

    // 字符串转一维数组 Array
    public static int[] strToArray(String jsonString) {
        JSONArray jsonArray = JSONUtil.parseArray(jsonString);
        int[] array = new int[jsonArray.size()];

        for (int i = 0; i < jsonArray.size(); i++) {
            array[i] = jsonArray.getInt(i);
        }
        return array;
    }

    // 字符串转二维数组 Array
    public static int[][] strToArrayArray(String jsonString) {
        JSONArray jsonArray = JSONUtil.parseArray(jsonString);
        int[][] array = new int[jsonArray.size()][];

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONArray innerArray = jsonArray.getJSONArray(i);
            array[i] = new int[innerArray.size()];
            for (int j = 0; j < innerArray.size(); j++) {
                array[i][j] = innerArray.getInt(j);
            }
        }
        return array;
    }


    // 字符串转为二维 Integer List
    public static List<List<Integer>> strToListList(String str) {
        // 去除外层括号
        str = str.substring(1, str.length() - 1);
        List<List<Integer>> result = new ArrayList<>();

        // 分割子数组
        String[] arrays = str.split("\\],\\[");
        for (String array : arrays) {
            // 清理剩余括号和空格
            array = array.replaceAll("[\\[\\]]", "").trim();
            List<Integer> subList = new ArrayList<>();

            // 处理非空数组
            if (!array.isEmpty()) {
                String[] numbers = array.split(",");
                for (String num : numbers) {
                    subList.add(Integer.parseInt(num.trim()));
                }
                result.add(subList);
            }
        }
        return result;
    }

    // 字符串转二维 String List
    public static List<List<String>> strToStrListList(String str) {
        // 去除外层括号
        str = str.substring(1, str.length() - 1);
        List<List<String>> result = new ArrayList<>();

        // 分割子数组
        String[] arrays = str.split("\\],\\[");
        for (String array : arrays) {
            // 清理剩余括号和空格
            array = array.replaceAll("[\\[\\]]", "").trim();
            List<String> subList = new ArrayList<>();

            // 处理非空数组
            if (!array.isEmpty()) {
                String[] strs = array.split(",");
                for (String string : strs) {
                    subList.add(string.trim().replaceAll("[\"']", ""));
                }
                result.add(subList);
            }
        }
        return result;
    }

    // 多维数组 Array 转多维 List
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

        // System.out.println("collEquals(List.of(1,2,3), List.of(3,1,2)) = "
        //     + collEquals(List.of(1, 2, 3), List.of(3, 1, 2))
        // );
        //
        // collEquals(arrayDeepToList(new int[][]{{1, 2, 3}, {3, 1, 2}}), arrayDeepToList(new int[][]{{1, 2, 3}, {3, 1, 2}}));

        System.out.println("compareList(List.of(1, 2, 3), List.of(2, 1, 3), true) = " + compareList(arrayDeepToList(new int[][]{{1, 2, 3}, {3, 4, 5}}), arrayDeepToList(new int[][]{{1, 2, 3}, {4, 3, 5}})));

        System.out.println("arrayDeepToList(new int[][]{{1, 2, 3}, {3, 4, 5}}) = "
            + arrayDeepToList(new int[][]{{1, 2, 3}, {3, 4, 5}})
        );

        System.out.println("arrayDeepToList(new int[]{1, 2, 3}) = "
            + arrayDeepToList(new int[]{1, 2, 3})
        );

        System.out.println("Arrays.equals(new int[]{1, 2, 3}, new int[]{3, 2, 1}) = "
            + Arrays.equals(new int[]{1, 2, 3}, new int[]{3, 2, 1})
        );

        System.out.println(strToListList("[[-1,-1,2],[-1,0,1]]").toString());

        System.out.println("strTo1DArray(\"[-1,-1,2]\") = " + Arrays.toString(strToArray("[-1,-1,2]")));
        System.out.println("strTo2DArray(\"[[-1,-1,2],[-1,0,1]]\") = " + Arrays.deepToString(strToArrayArray("[[-1,-1,2],[-1,0,1]]")));
    }
}
