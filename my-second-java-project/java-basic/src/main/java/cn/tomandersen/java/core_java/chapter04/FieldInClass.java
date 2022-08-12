package cn.tomandersen.java.core_java.chapter04;

public class FieldInClass {
    // 1.1 static field
    private static int nextId = 1; // static field (variable)
    // 1.2 static final field (variable)
    // final field cannot be changed after initialization
    private static final int idDelta = 1;
    // static final filed must be initialized

    // 2.1 instance field
    private int id = 1;

    // 2.2 instance final field
    private final String name;
    private final String home = "The Queens"; // instance final field
    // instance final filed must be initialized in declaration or the constructor, and cannot be
    // changed after initialization

    // constructor method
    public FieldInClass(int id, String name) { // parameter list
        System.out.println("This is a constructor method!");
        // 'this' is implicit argument, and 'id' is explicit argument
        this.id = id;
        this.name = name;
    }

    // static method
    public static void main(String[] args) {
        System.out.println("This is a class field demo!");
    }
}
