package cn.tomandersen.java.reading.core_java.chapter06;

public class CloneableAPI {
    /**
     * @see java.lang.Cloneable
     * @see java.lang.CloneNotSupportedException
     */
    public static void main(String[] args) {
        System.out.println(
            "Cloneable interface is a tagging interface(or marker interface) which does not define any method."
                + "And if the clone method of a class was called, which does not implements Cloneable interface , "
                + "it will throws a CloneNotSupportedException."
        );
    }
}
