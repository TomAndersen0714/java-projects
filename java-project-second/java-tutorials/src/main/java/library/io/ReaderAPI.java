package library.io;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Reader和InputStream最大的区别在于, InputStream是面向字节流的, 而Reader是面向字符流的.
 * 即Reader是将InputStream封装一层后生成的, 其作用是基于配置好的字符集, 将输入字节流InputStream
 * 挨个转义为对应的字符, 从而实现可读.
 * <p>
 * 由于Reader是建立在InputStream之上的封装类, 因此Reader的实现类, 通常都需要基于某个
 * 已经存在的InputStream对象来进一步实例化. 如InputStreamReader是针对InputStream的封装,
 * FileReader是针对FileInputStream的封装.
 * <p>
 * 需要特别说明的是, Reader家族中的BufferedReader, 是针对Reader本身进行一层封装后生成的,
 * 其主要作用是增强Reader, 使其支持了缓冲区的功能.
 * <p>
 * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/InputStreamReader.html
 *
 * @author TomAndersen
 * @see java.io.InputStreamReader
 * @see java.io.BufferedReader
 * @see java.io.Reader
 */
public class ReaderAPI {
    public static void main(String[] args) throws IOException {

        // InputStreamReader
        // using the default charset
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);


        // Reader.read()
        // Read a character and return it
        System.out.println("inputStreamReader.read() = " + inputStreamReader.read());

        // Reader.read(char[])
        // Read characters into char array and return the number of characters
        char[] chars = new char[10];
        int charCnt = inputStreamReader.read(chars); // the number of characters
        System.out.println("inputStreamReader.read(chars) = " + charCnt);
        System.out.println("chars: " + Arrays.toString(chars));

        // BufferedReader
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        // BufferedReader.readLine
        System.out.println("bufferedReader.readLine() = " + bufferedReader.readLine());

    }
}
