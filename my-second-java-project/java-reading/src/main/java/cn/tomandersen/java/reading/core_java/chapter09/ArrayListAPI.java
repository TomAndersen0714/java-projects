package cn.tomandersen.java.reading.core_java.chapter09;

import cn.tomandersen.java.reading.core_java.chapter03.Array;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static cn.tomandersen.java.reading.utils.Utils.getCurrentMethodName;

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

        // trimToSize()
        System.out.print("Before trimToSize(): ");
        System.out.println("Capacity: " + getArrayListCapacity(staffs) + ", size: " + staffs.size());
        System.out.print("After trimToSize(): ");
        staffs.trimToSize();
        System.out.println("Capacity: " + getArrayListCapacity(staffs) + ", size: " + staffs.size());
    }
}
