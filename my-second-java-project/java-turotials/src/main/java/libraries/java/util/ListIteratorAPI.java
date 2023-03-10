package libraries.java.util;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author TomAndersen
 */
public interface ListIteratorAPI {
    public static void main(String[] args) {
        // construct
        List<String> staffs = new LinkedList<>(List.of("Tom", "Alise", "John"));
        ListIterator<String> listIterator = staffs.listIterator();


    }
}
