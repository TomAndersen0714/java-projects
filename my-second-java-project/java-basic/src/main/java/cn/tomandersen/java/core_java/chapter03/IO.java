package cn.tomandersen.java.core_java.chapter03;

import java.util.Scanner;

public class IO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // get first input
        System.out.println("What is your name? ");
        String name = in.nextLine();

        // get second input
        System.out.println("How old are you? ");
        int age = in.nextInt();

        // print the input on console
        System.out.println("Hello" + name + ". Next year, you'll be " + (age + 1) + ". ");

    }
}
