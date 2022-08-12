package cn.tomandersen.java.core_java.chapter04;

public class ClassMethod {
    // static field
    private static int nextId = 1; // static variable(field)
    private static final int idDelta = 1; // static final variable(field)

    // instance field
    private int id = 1;


    // static method
    public static int getNextId() {
        System.out.println("This is a static method!");
        int id = nextId;
        nextId += idDelta;
        return id;
    }

    // constructor
    public ClassMethod(int id) {
        System.out.println("This is a constructor method!");
        this.id = id;
    }

    // static method
    public static void main(String[] args) {
        System.out.println("This is static method main!");
        System.out.println(getNextId());
    }
}
