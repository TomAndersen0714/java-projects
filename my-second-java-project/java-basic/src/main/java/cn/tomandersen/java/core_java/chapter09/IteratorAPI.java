package cn.tomandersen.java.core_java.chapter09;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorAPI {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("Tom");
        names.add("Alise");
        names.add("John");

        // 1. for statement without iterator
        System.out.println("This is a for statement iteration demo: ");
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i));
            System.out.print(" ");
        }
        System.out.println();

        // 2. using 'haxNext' and 'next' method of iterator explicitly
        System.out.println("This is a iterator api iteration demo: ");
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
            System.out.print(" ");
        }
        System.out.println();

        // 3. using for-each statement to call iterator implicitly
        System.out.println("This is a for-each statement iteration demo: ");
        for (String name : names) {
            System.out.print(name);
            System.out.print(" ");
        }
        System.out.println();


        // 4. using 'forEachRemaining' method of iterator with lambda expression (i.e. anonymous method)
        System.out.println("This is a 'forEachRemaining' iteration demo: ");
        Iterator<String> iterator = names.iterator();
        iterator.forEachRemaining(name -> {
            System.out.print(name);
            System.out.print(" ");
        });
        System.out.println();
    }
}
