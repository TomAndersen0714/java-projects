package cn.tomandersen.java.reading.core_java.chapter09;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        List<String> staffs = new LinkedList<>();
        staffs.add("Amy");
        staffs.add("Bob");
        staffs.add("Carl");

        Iterator<String> iterator = staffs.iterator();
        String first = iterator.next();
        String second = iterator.next();
        iterator.remove(); // remove 'second' element in the LinkedList
        System.out.println("first: " + first + ", second: " + second);

        // print the remaining elements in the list
        staffs.forEach(x -> {
            System.out.print(x);
            System.out.print(" ");
        });

        // contains()
        System.out.println(staffs.contains("Amy"));
    }
}
