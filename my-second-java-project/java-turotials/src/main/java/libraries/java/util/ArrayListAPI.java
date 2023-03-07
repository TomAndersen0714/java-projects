package libraries.java.util;


import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author TomAndersen
 */
public class ArrayListAPI {
    /**
     * @see libraries.java.util.ListAPI
     * @see libraries.java.util.ArraysAPI
     * @see libraries.java.util.CollectionAPI
     * @see libraries.java.util.CollectionsAPI
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // note: ArrayList的API大多数都是覆盖的父类或接口, 具体使用方式参考javadoc中相关的接口和父类即可
        // ArrayList()
        ArrayList<String> staffs = new ArrayList<>();

        // ArrayList(int initialCapacity)
        ArrayList<String> tmp = new ArrayList<>(16);

        // trimToSize()
        System.out.print("Before trimToSize(): ");
        System.out.println("Capacity: " + getArrayListCapacity(staffs) + ", size: " + staffs.size());
        System.out.print("After trimToSize(): ");
        staffs.trimToSize();
        System.out.println("Capacity: " + getArrayListCapacity(staffs) + ", size: " + staffs.size());
    }

    /**
     * return the capacity of specific list
     */
    static int getArrayListCapacity(ArrayList<?> arrayList) throws NoSuchFieldException, IllegalAccessException {
        Class<?> arrayListClass = arrayList.getClass();
        Field field = arrayListClass.getDeclaredField("elementData");
        field.setAccessible(true);

        return ((Object[]) field.get(arrayList)).length;
    }
}
