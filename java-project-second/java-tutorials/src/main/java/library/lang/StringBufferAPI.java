package library.lang;

/**
 * @author TomAndersen
 */
public class StringBufferAPI {
    public static void main(String[] args) {
        // StringBuffer, applied to multiple thread, a safe Object
        // sample api as StringBuilder
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Hello");
        stringBuffer.append(" ");
        stringBuffer.append("World!");
        System.out.println(stringBuffer.toString());
    }
}
