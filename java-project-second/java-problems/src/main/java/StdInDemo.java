import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author TomAndersen
 */
public class StdInDemo {
    private static void stdInScannerDemo() {
        // open scanner for stdin
        Scanner scanner = new Scanner(System.in);

        // read stdin
        String nextLine = scanner.nextLine();
        System.out.println("nextLine = " + nextLine);

        String nextWord = scanner.next();
        System.out.println("nextWord = " + nextWord);

        int nextInt = scanner.nextInt();
        System.out.println("nextInt = " + nextInt);

        // close the scanner
        scanner.close();
    }

    private static void stdInReaderDemo() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // read next line, return null if read the end of stream
        String nextLine = bf.readLine();
        System.out.println("nextLine = " + nextLine);

        // split the input line into fragments
        String[] nums = nextLine.split(" ");
        System.out.println(Arrays.toString(nums));

        // read next character, return -1 if reach the end of stream
        int nextChar = bf.read();
        if (nextChar >= 0) {
            char c = (char) nextChar;
            System.out.println(c);
        }

    }

    public static void main(String[] args) throws IOException {
        String input = "Hello World!\nI'm 21";
        System.setIn(new BufferedInputStream(new ByteArrayInputStream(input.getBytes())));

        // stdInScannerDemo();
        stdInReaderDemo();
    }
}
