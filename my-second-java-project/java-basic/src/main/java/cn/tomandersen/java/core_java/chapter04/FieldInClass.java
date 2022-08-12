package cn.tomandersen.java.core_java.chapter04;

public class FieldInClass {
    // static field
    private static int nextId = 1; // static variable(field)
    private static final int idDelta = 1; // static final variable(field)

    // instance field
    private int id = 1;

    // constructor method
    public FieldInClass(int id) { // parameter list (形参列表)
        System.out.println("This is a constructor method!");
        // 'this' is implicit argument, and 'id' is explicit argument
        this.id = id;
    }

    // static method
    public static void main(String[] args) {

    }
}
