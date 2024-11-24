package hw.common;

import java.io.*;
import java.util.Scanner;

public class ACMInputAPI {
    public static void main(String[] args) throws IOException {
        // InputStream
        String input = "1\n2\n3 4\n5 6";
        System.setIn(new BufferedInputStream(new ByteArrayInputStream(input.getBytes())));

        // Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("scanner.nextInt() = " + scanner.nextInt());

        // BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("bufferedReader.readLine() = " + bufferedReader.readLine());

    }
}
