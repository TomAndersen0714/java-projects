package cn.tomandersen.java.reading.utils;

public class Utils {
    public static String getClassName(Object o) {
        return o.getClass().toString();
    }

    public static String getCurrentMethodName() {
        // the first element is getStackTrace method, second one is the current method,
        // and the third one is the caller
        return Thread.currentThread().getStackTrace()[2].getClassName()
            + ":" +
            Thread.currentThread().getStackTrace()[2].getMethodName()
            + "()";
    }
}
