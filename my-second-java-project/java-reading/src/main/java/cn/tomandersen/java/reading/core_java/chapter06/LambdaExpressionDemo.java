package cn.tomandersen.java.reading.core_java.chapter06;


import javax.swing.*;
import java.util.Arrays;
import java.util.Date;

public class LambdaExpressionDemo {
    public static void main(String[] args) {
        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        // sort the array of string in dictionary order
        Arrays.sort(planets);
        System.out.println("Sorted in dictionary order: ");
        System.out.println(Arrays.toString(planets));

        // sort the array of string by the length of each element in ascending order
        Arrays.sort(planets, (o1, o2) -> o1.length() - o2.length());
        System.out.println("Sorted by length in ascending order: ");
        System.out.println(Arrays.toString(planets));

        // sort the array of string by the length of each element in descending order
        Arrays.sort(planets, (o1, o2) -> {
            return o2.length() - o1.length();
        });
        System.out.println("Sorted by length in descending order: ");
        System.out.println(Arrays.toString(planets));

        Timer timer = new Timer(1000, event -> System.out.println("The time is " + new Date()));
        timer.start();

        // keep program running until user select "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);

    }
}
