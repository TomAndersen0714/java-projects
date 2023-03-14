package libraries.java.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TomAndersen
 * @see libraries.java.util.ArrayListAPI
 */
public interface ListAPI {
    public static void main(String[] args) {
        // note: class method
        // List.of()
        // create and return an unmodifiable list containing specific elements
        System.out.println("List.of(1,2,3) = " + List.of(1, 2, 3));

        // List.copyOf()
        // create and returns an unmodifiable List containing the elements
        // of the given Collection, in its iteration order
        System.out.println("List.copyOf(List.of(1, 2, 3)) = " + List.copyOf(List.of(1, 2, 3)));


        // note: instance method
        List<String> staffs = new ArrayList<>(List.of("Sun"));
        // toString()
        System.out.println("toString(): ");
        System.out.println(staffs);

        // add()
        System.out.println("add(): ");
        staffs.add("Jim");
        staffs.add("Jim");
        staffs.add("Tom");
        staffs.add("Tom");
        System.out.println(staffs);
        // addAll()
        System.out.println("addAll(): ");
        staffs.addAll(List.of("Tom", "Andersen"));
        System.out.println(staffs);


        // set(int index, E element)
        System.out.println("set(): ");
        staffs.set(0, "Unknown");
        System.out.println(staffs);


        // remove(Object o)
        // try to remove the first occurrence of the specified element from this list
        System.out.println("remove(Object o): ");
        staffs.remove("Tom");
        System.out.println(staffs);
        // remove(int index)
        System.out.println("remove(int index): ");
        staffs.remove(0);
        System.out.println(staffs);
        // removeAll(Collection<?> c)
        System.out.println("removeAll(): ");
        staffs.removeAll(List.of("Jim"));
        System.out.println(staffs);
        // removeIf(Predicate<? super E> filter)
        System.out.println("removeIf(): ");
        staffs.removeIf((x) -> x.startsWith("A"));
        System.out.println(staffs);


    }
}
