package api.java.util;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.function.Predicate;

public class ArrayListAPI {
    static int getArrayListCapacity(ArrayList<?> arrayList) throws NoSuchFieldException, IllegalAccessException {
        Class<?> arrayListClass = arrayList.getClass();
        Field field = arrayListClass.getDeclaredField("elementData");
        field.setAccessible(true);

        return ((Object[]) field.get(arrayList)).length;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<String> staffs = new ArrayList<>();

        // add()
        System.out.print("add(): ");
        staffs.add("Tom");
        staffs.add("Allen");
        staffs.add("Jimmy");
        System.out.println(staffs);
        // addAll()
        System.out.print("addAll(): ");
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("Alise");
        staffs.addAll(tmp);

        // toString()
        System.out.print("toString(): ");
        System.out.println(staffs);

        // set()
        System.out.print("set(): ");
        staffs.set(0, "Jim");
        System.out.println(staffs);

        // removeIf
        System.out.println("removeIf(): ");
        staffs.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("Tom");
            }
        });
        System.out.println(staffs);

        // trimToSize()
        System.out.print("Before trimToSize(): ");
        System.out.println("Capacity: " + getArrayListCapacity(staffs) + ", size: " + staffs.size());
        System.out.print("After trimToSize(): ");
        staffs.trimToSize();
        System.out.println("Capacity: " + getArrayListCapacity(staffs) + ", size: " + staffs.size());
    }
}
