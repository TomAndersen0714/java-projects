package library.util;

import java.util.StringJoiner;

/**
 * StringJoiner can be replaced by String.join()
 * @see String#join(CharSequence, Iterable)
 */
public class StringJoinerAPI {
    public static void main(String[] args) {
        // java.util.StringJoiner
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");

        // java.util.StringJoiner.add
        stringJoiner.add("Tom");
        stringJoiner.add("Jim");
        stringJoiner.add("John");

        System.out.println(stringJoiner);
    }
}
