package library;

/**
 * @author TomAndersen
 */
public class Utils {
    public static String getClassName(Object o) {
        return o.getClass().getName();
    }

    public static String getCurrentClassName() {
        // the first element is the method getStackTrace of class Thread,
        // second one is the method getCurrentClass of current class,
        // and the third one is the caller method of caller class
        return Thread.currentThread().getStackTrace()[2].getClassName();
    }

    public static String getCurrentMethodName() {
        // the first element is the method getStackTrace of class Thread,
        // second one is the method getCurrentClass of current class,
        // and the third one is the caller method of caller class
        return Thread.currentThread().getStackTrace()[2].getClassName()
            + ":" +
            Thread.currentThread().getStackTrace()[2].getMethodName()
            + "()";
    }
}
