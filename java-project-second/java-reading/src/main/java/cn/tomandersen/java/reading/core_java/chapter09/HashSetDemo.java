package cn.tomandersen.java.reading.core_java.chapter09;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Iterator;

/**
 * This program use a set to print all unique words in System.in.
 *
 * @author TomAndersen
 * @version 1.0 2022-09-27
 */
public class HashSetDemo {
    static void stdinDemo() {
        HashSet<String> words = new HashSet<>();
        long totalTimeMs = 0;

        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTimeMs += callTime;
            }
        }

        Iterator<String> setIter = words.iterator();
        for (int i = 1; i <= 20 && setIter.hasNext(); i++) {
            System.out.print(setIter.next());
            System.out.print(" ");
        }
        System.out.println(". . .");
        System.out.println(words.size() + " distinct words. " + totalTimeMs + " milliseconds.");
    }

    static void fileInDemo() throws IOException {
        HashSet<String> words = new HashSet<>();
        String userDir = System.getProperty("user.dir");
        String fileName = "java-reading/src/main/resources/test.txt";
        Path path = Path.of(userDir, fileName);

        long totalTimeMs = 0;
        System.out.println("user.dir: " + userDir);
        System.out.println("path: " + path);

        try (
                Scanner in = new Scanner(path, StandardCharsets.UTF_8)
        ) {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTimeMs += callTime;
            }
        } catch (IOException e) {
            throw e;
        }

        Iterator<String> setIter = words.iterator();
        for (int i = 1; i <= 20 && setIter.hasNext(); i++) {
            System.out.print(setIter.next());
            System.out.print(" ");
        }
        System.out.println(". . .");
        System.out.println(words.size() + " distinct words. " + totalTimeMs + " milliseconds.");
    }

    public static void main(String[] args) throws IOException {
//        stdinDemo();
        fileInDemo();
    }
}
