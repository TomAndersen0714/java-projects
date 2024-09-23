package cn.tomandersen.java.reading.core_java.chapter05;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * This program demonstrates the use of proxies.
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];

        // fill elements with proxies for the integers 1...1000
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            Class<?>[] interfaces = new Class[]{Comparable.class};

            Object proxy = Proxy.newProxyInstance(
                    classLoader,
                    interfaces,
                    new TraceHandler(value)
            );

            elements[i] = proxy;
        }

        // construct a random integer as the key
        Integer key = (int) (Math.random() * elements.length * 2) + 1;
        System.out.println("The key is: " + key);
        // search for the key
        int result = Arrays.binarySearch(elements, key);
        // print the matched element if found
        if (result >= 0) {
            System.out.println("The found result is: " + elements[result]);
        } else {
            System.out.println("The key doesn't exist in the elements.");
        }

        // ternary operator
        System.out.println(
                (result >= 0)
                        ? ("The found result is: " + elements[result])
                        : ("The key doesn't exist in the elements.")
        );
    }
}

/**
 * An invocation handler that prints out the method name and parameters. then invokes the original method
 */
class TraceHandler implements InvocationHandler {
    private final Object target;

    /**
     * Constructs a TraceHandler
     *
     * @param o the implicit parameter of the method call
     */
    public TraceHandler(Object o) {
        this.target = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // print implicit argument
        System.out.print(target);

        // print method name
        System.out.print("." + method.getName() + "(");

        // print explicit argument
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) System.out.print(",");
            }
        }
        System.out.println(")");

        // invoke actual method
        return method.invoke(target, args);
    }
}
