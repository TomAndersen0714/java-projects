package libraries.java.util;


import java.lang.reflect.Field;
import java.util.ArrayList;

public class ArrayListAPI {
    /**
     * return the capacity of specific list
     */
    static int getArrayListCapacity(ArrayList<?> arrayList) throws NoSuchFieldException, IllegalAccessException {
        Class<?> arrayListClass = arrayList.getClass();
        Field field = arrayListClass.getDeclaredField("elementData");
        field.setAccessible(true);

        return ((Object[]) field.get(arrayList)).length;
    }

    /**
     * @see libraries.java.util.ListAPI
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
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
}
