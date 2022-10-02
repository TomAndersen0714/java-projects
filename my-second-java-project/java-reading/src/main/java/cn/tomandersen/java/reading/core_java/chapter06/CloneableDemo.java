package cn.tomandersen.java.reading.core_java.chapter06;

/**
 * This program demonstrates cloning.
 *
 * @author Tom Andersen
 * @version 1.0.0
 * @see java.lang.Cloneable
 * @see java.lang.CloneNotSupportedException
 */
public class CloneableDemo {
    public static void main(String[] args) {

    }

    void test() {
        var tmp = this.new Employee() {
            public int a = 2;

            public int getA() {
                return a;
            }
        };
        tmp.getA();

    }

    class Employee implements Cloneable {
        Employee() {

        }
    }
}
