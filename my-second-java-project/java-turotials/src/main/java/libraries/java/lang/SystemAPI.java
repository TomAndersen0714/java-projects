package libraries.java.lang;

import libraries.Utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

/**
 * {@link java.lang.System}
 */
public class SystemAPI {
    static void demo() {
        // System.getProperty
        System.out.println("os name: " + System.getProperty("os.name"));
        System.out.println("os version: " + System.getProperty("os.version"));
        System.out.println();

        System.out.println("java vendor: " + System.getProperty("java.vendor"));
        System.out.println("java vendor url: " + System.getProperty("java.vendor.url"));
        System.out.println("java version: " + System.getProperty("java.version"));
        System.out.println("java home(JRE): " + System.getProperty("java.home"));

        System.out.println("file.encoding: " + System.getProperty("file.encoding"));
        System.out.println();

        // Java虚拟机规范提供商
        System.out.println("java VM specification vendor: " + System.getProperty("java.vm.specification.vendor"));
        // Java虚拟机规范名称
        System.out.println("java VM specification name: " + System.getProperty("java.vm.specification.name"));
        // Java虚拟机规范版本号
        System.out.println("java VM specification version: " + System.getProperty("java.vm.specification.version"));
        System.out.println();

        // Java虚拟机提供商
        System.out.println("java VM vendor: " + System.getProperty("java.vm.vendor"));
        // Java虚拟机名称
        System.out.println("java VM name: " + System.getProperty("java.vm.name"));
        // Java虚拟机版本号
        System.out.println("java VM version: " + System.getProperty("java.vm.version"));
        System.out.println();

        // Java规范提供商
        System.out.println("java specification vendor: " + System.getProperty("java.specification.vendor"));
        // Java规范版本号
        System.out.println("java specification version: " + System.getProperty("java.specification.version"));
        // Java规范名称
        System.out.println("java specification name: " + System.getProperty("java.specification.name"));
        System.out.println();

        // Java类版本号
        System.out.println("java class version: " + System.getProperty("java.class.version"));
        // Java类路径
        System.out.println("java class path: " + System.getProperty("java.class.path"));
        // Java lib路径
        System.out.println("java library path: " + System.getProperty("java.library.path"));
        System.out.println();

        // Java输入输出临时路径
        System.out.println("java io tmpdir: " + System.getProperty("java.io.tmpdir"));
        // Java编译器
        System.out.println("java compiler" + System.getProperty("java.compiler"));
        // Java执行路径
        System.out.println("java ext dirs" + System.getProperty("java.ext.dirs"));
        System.out.println();

        System.out.println("file separator: " + System.getProperty("file.separator"));
        System.out.println("path separator: " + System.getProperty("path.separator"));

        System.out.println("line separator: " + System.getProperty("line.separator").replace("\n", "\\n").replace("\r", "\\r"));
        System.out.println();

        System.out.println("user name: " + System.getProperty("user.name"));
        System.out.println("user home: " + System.getProperty("user.home"));
        System.out.println("user dir(work dir): " + System.getProperty("user.dir"));
        System.out.println();

        // System.arraycopy
        int[] a = new int[]{3, 1, 2, 5};
        int[] b = new int[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        System.out.println("Array a: " + Arrays.toString(a));
        System.out.println("Array b: " + Arrays.toString(b));


        // System.setIn
        // reassigns the "standard" input stream
        System.out.println("Utils.getClassName(System.in) = " + Utils.getClassName(System.in));
        System.setIn(new BufferedInputStream(
            new ByteArrayInputStream("Hello world".getBytes(StandardCharsets.UTF_8)))
        );
        System.out.println("Utils.getClassName(System.in) = " + Utils.getClassName(System.in));

        System.out.println("new Scanner(System.in).nextLine() = " + new Scanner(System.in).nextLine());

        // System.setOut
        System.out.println("Utils.getClassName(System.out) = " + Utils.getClassName(System.out));

    }

    public static void main(String[] args) {
        demo();
    }
}
