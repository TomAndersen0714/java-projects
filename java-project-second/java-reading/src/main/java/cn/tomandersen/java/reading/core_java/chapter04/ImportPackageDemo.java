package cn.tomandersen.java.reading.core_java.chapter04;

import static java.lang.Math.*; // static import


public class ImportPackageDemo {
    public static void main(String[] args) {

        double x = 4.0, y = 4.1;
        // you can use static method without class name by static import
        System.out.println("sqrt: " + sqrt(x)); // sqrt
        System.out.println("pow: " + pow(x, 4)); // power

        System.out.println("round: " + round(y)); // round
        System.out.println("floor: " + floor(y)); // floor
        System.out.println("ceil: " + ceil(y)); // ceil

        // if there are two class of same name, you can use fully qualified name to distinguish class
        java.util.Date date;
        java.sql.Date date1;
    }
}
