package libraries.java.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static java.lang.Thread.sleep;

/**
 * {@link java.util.Collection}
 */
public interface CollectionAPI {
    public static void main(String[] args) throws InterruptedException {
/*        while (true) {
           System.out.println("This is a collection API demo: ");
           sleep(3000);
       } */
        System.out.println("This is a collection API demo: ");
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> otherNames = new ArrayList<>();

        names.add("Tom");
        names.add("Alise");
        names.add("John");
        otherNames.add("Tom");
        otherNames.add("Steven");

        Collection<String> collection = names;

        // Collection.size
        System.out.println("Collection#size(): " + collection.size());
        // Collection.isEmpty
        System.out.println("Collection#isEmpty(): " + collection.isEmpty());
        // Collection.contains
        System.out.println("Collection#contains(): " + collection.contains("Tom"));
        // Collection.containsAll
        System.out.println("Collection#containsAll(): " + collection.containsAll(names));

        // Collection.add
        System.out.println("Collection#add(): " + collection.add("Tom"));
        // Collection.addAll
        System.out.println("Collection#addAll(): " + collection.addAll(names));
        System.out.println(names);

        // Collection.remove
        System.out.println("Collection#remove(): " + collection.remove("Tom"));
        System.out.println(names);
        // Collection.removeAll
        System.out.println("Collection#removeAll(): " + collection.removeAll(otherNames));
        System.out.println(names);
        // Collection.removeIf, since Java 8
        // this method will return true, when it changed collection
        System.out.println(collection.removeIf((x) -> x.equals("John")));
        System.out.println(names);

        // 无法直接进行强制类型转换(type cast), 因为强制类型转换必须保证两个变量类型之间存在直系血缘关系,
        // 而 toArray 返回的是 Object[] 类型的变量, 与 String[] 类型
        // 并无直系血缘关系, 无法进行强制类型转换. 虽然编译时通过了, 但实际执行时会抛出异常 ClassCastException
        // String[] nameArr = (String[]) names.toArray();
        System.out.println(Arrays.toString(names.toArray()));
        names.clear();

    }
}
