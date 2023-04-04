package lesson1.operators;

import libraries.Utils;

import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html
 *
 * @author TomAndersen
 */
public class TypeComparisonOperator {
    public static void main(String[] args) {
        // instanceof
        System.out.println("Utils.getClassName(System.in) = " + Utils.getClassName(System.in));
        System.out.println("Utils.getClassName(System.out) = " + Utils.getClassName(System.out));

        System.out.println("(System.in instanceof InputStream) = " + (System.in instanceof InputStream));
        System.out.println("(System.in instanceof BufferedInputStream) = " + (System.in instanceof BufferedInputStream));

        Parent obj1 = new Parent();
        Parent obj2 = new Child();

        System.out.println("(obj1 instanceof Parent) = " + (obj1 instanceof Parent));
        System.out.println("(obj1 instanceof Child) = " + (obj1 instanceof Child));
        System.out.println("(obj1 instanceof MyInterface) = " + (obj1 instanceof MyInterface));
        System.out.println("(obj2 instanceof Parent) = " + (obj2 instanceof Parent));
        System.out.println("(obj2 instanceof Child) = " + (obj2 instanceof Child));
        System.out.println("(obj2 instanceof MyInterface) = " + (obj2 instanceof MyInterface));

    }

    static class Parent {
    }

    static class Child extends Parent implements MyInterface {
    }

    interface MyInterface {
    }
}

