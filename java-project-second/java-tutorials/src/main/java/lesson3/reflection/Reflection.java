package lesson3.reflection;

import libraries.java.lang.ClassAPI;

/**
 * https://docs.oracle.com/javase/tutorial/reflect/index.html
 *
 * @author TomAndersen
 */
public class Reflection {
    /**
     * @param args
     * @see libraries.java.lang.ClassAPI
     */
    public static void main(String[] args) {

    }

    public static void getClassDemo() throws ClassNotFoundException {
        // https://docs.oracle.com/javase/tutorial/reflect/class/classNew.html

        // method 1: Class object, using class name explicitly
        System.out.println("ClassAPI.class = " + ClassAPI.class);

        // method 2: class method Class.forName(), using class name as a parameter
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println("Class.forName(className) = " + Class.forName(className));

        // method 3: instance method getClass() of corresponding class
        Object obj = new Object();
        System.out.println("obj.getClass() = " + obj.getClass());
    }
}
