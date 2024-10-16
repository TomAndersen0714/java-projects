package library.lang;

/**
 * @author TomAndersen
 */
public class StringBuilderAPI {
    public static void main(String[] args) {
        // StringBuilder, applied to single thread
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("Hello");
        stringBuilder.append(" ");
        stringBuilder.append("World!");
        stringBuilder.insert(0, "Hi! ");
        stringBuilder.delete(0, 4);
        System.out.println(stringBuilder.toString());
    }
}
