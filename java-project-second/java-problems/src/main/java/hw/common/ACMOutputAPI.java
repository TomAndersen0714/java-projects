package hw.common;

import java.util.List;
import java.util.StringJoiner;

/**
 * @see java.util.StringJoiner
 * @see library.util.StringJoinerAPI
 */
public class ACMOutputAPI {
    public static void main(String[] args) {
        // java.util.StringJoiner
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        stringJoiner.add("Tom");
        stringJoiner.add("Jim");
        stringJoiner.add("John");

        System.out.println("stringJoiner = " + stringJoiner);

        // java.lang.String.join(java.lang.CharSequence, java.lang.Iterable<? extends java.lang.CharSequence>)
        System.out.println(String.join(",", List.of("Tom", "John", "Alice")));

        // java.lang.StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(12);
        stringBuilder.append(13);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println("stringBuilder = " + stringBuilder);
    }
}
