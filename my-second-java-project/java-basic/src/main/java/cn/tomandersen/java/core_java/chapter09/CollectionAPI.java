package cn.tomandersen.java.core_java.chapter09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * {@link java.util.Collection}
 */
public class CollectionAPI {
    public static void main(String[] args) {
        System.out.println("This is a collection API demo: ");
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> otherNames = new ArrayList<>();

        names.add("Tom");
        names.add("Alise");
        names.add("John");
        otherNames.add("Tom");
        otherNames.add("Steven");

        Collection<String> collection = names;

        System.out.println("Collection#size(): " + collection.size());
        System.out.println("Collection#isEmpty(): " + collection.isEmpty());
        System.out.println("Collection#contains(): " + collection.contains("Tom"));
        System.out.println("Collection#containsAll(): " + collection.containsAll(names));

        System.out.println("Collection#add(): " + collection.add("Tom"));
        System.out.println("Collection#addAll(): " + collection.addAll(names));
        System.out.println(names);

        // remove single element one time
        System.out.println("Collection#remove(): " + collection.remove("Tom"));
        System.out.println(names);
        // remote all element occurred in collection
        System.out.println("Collection#removeAll(): " + collection.removeAll(otherNames));
        System.out.println(names);
        // remote all satisfied element, since Java 8
        System.out.println(collection.removeIf((x) -> x.equals("John")));
        System.out.println(names);

        // 无法直接进行强制类型转换(type cast), 因为强制类型转换
        // 必须保证两个变量类型之间存在直系血缘关系, 而 toArray 返回的是 Object[] 类型的变量, 与 String[] 类型
        // 并无直接血缘关系, 无法进行强制类型转换. 虽然编译时通过了, 但实际执行时会抛出异常 ClassCastException
//        String[] nameArr = (String[]) names.toArray();
        System.out.println(Arrays.toString(names.toArray()));
        names.clear();

    }
}
