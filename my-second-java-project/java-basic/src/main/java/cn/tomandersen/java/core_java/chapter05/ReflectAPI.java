package cn.tomandersen.java.core_java.chapter05;

import java.util.Random;

public class ReflectAPI {
    public static void main(String[] args) throws ClassNotFoundException {

        // How to get Class object?
        // The Class object contains the information about class.
        // 1. using the 'getClass' method of Object
        Random randomGenerator = new Random();
        Class<? extends Random> cls1 = randomGenerator.getClass();

        // 2. using static method 'forName' of Class with full qualified name of the class
        String className = "java.util.Random";
        Class<?> cls2 = Class.forName(className);

        // 3. using the class to get corresponding Class object
        Class<Random> cls3 = Random.class;


    }
}
