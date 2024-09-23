package cn.tomandersen.java.reading.core_java.chapter09;

import java.util.List;
import java.util.ArrayList;

public class ListAPI {
    public static void main(String[] args) {
        // List.of()
        System.out.println("List.of(): ");
        List<String> staffs = List.of("Tom", "Andersen");
        System.out.println(staffs.getClass());
        System.out.println(staffs);

        // List.addAll()
        ArrayList<String> names = new ArrayList<String>();
        System.out.println("List.addAll(): ");
        names.addAll(staffs);
        System.out.println(names);

    }
}
