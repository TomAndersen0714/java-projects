package library.lang;

/**
 * @author TomAndersen
 * @see java.lang.Thread
 * @see java.lang.StackTraceElement
 */
public class StackTraceElementAPI {
    /**
     * @param args
     * @see ThreadAPI
     */
    public static void main(String[] args) {
        System.out.println("Thread.currentThread().getStackTrace(): ");
        for (StackTraceElement trace : Thread.currentThread().getStackTrace()) {
            System.out.println("trace = " + trace);
        }

        StackTraceElement currentTraceElement = Thread.currentThread().getStackTrace()[1];
        System.out.println("currentTraceElement = " + currentTraceElement);

        // NOTE: instance method
        // getModuleName()
        System.out.println("currentTraceElement.getModuleName() = " + currentTraceElement.getModuleName());
        // getModuleVersion()
        System.out.println("currentTraceElement.getModuleVersion() = " + currentTraceElement.getModuleVersion());

        // getClassName()
        System.out.println("currentTraceElement.getClassName() = " + currentTraceElement.getClassName());
        // getClassLoaderName()
        System.out.println("currentTraceElement.getClassLoaderName() = " + currentTraceElement.getClassLoaderName());

        // getMethodName()
        System.out.println("currentTraceElement.getMethodName() = " + currentTraceElement.getMethodName());
        // isNativeMethod()
        System.out.println("currentTraceElement.isNativeMethod() = " + currentTraceElement.isNativeMethod());

        // getFileName()
        System.out.println("currentTraceElement.getFileName() = " + currentTraceElement.getFileName());
        // getLineNumber()
        System.out.println("currentTraceElement.getLineNumber() = " + currentTraceElement.getLineNumber());
    }
}
