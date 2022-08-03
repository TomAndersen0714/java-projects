package cn.tomandersen.java.core_java.chapter03;

public class SystemAPI {
    static void getPropertyDemo() {
        // System.getProperty
        System.out.println("os name: " + System.getProperty("os.name"));
        System.out.println("os version: " + System.getProperty("os.version"));
        System.out.println();

        System.out.println("java vendor: " + System.getProperty("java.vendor"));
        System.out.println("java vendor url: " + System.getProperty("java.vendor.url"));
        System.out.println("java version: " + System.getProperty("java.version"));
        System.out.println("java home(JRE): " + System.getProperty("java.home"));
        System.out.println();

        System.out.println("java VM specification vendor: " + System.getProperty("java.vm.specification.vendor")); // Java虚拟机规范提供商
        System.out.println("java VM specification name: " + System.getProperty("java.vm.specification.name")); // Java虚拟机规范名称
        System.out.println("java VM specification version: " + System.getProperty("java.vm.specification.version")); // Java虚拟机规范版本号
        System.out.println();

        System.out.println("java VM vendor: " + System.getProperty("java.vm.vendor")); // Java虚拟机提供商
        System.out.println("java VM name: " + System.getProperty("java.vm.name")); // Java虚拟机名称
        System.out.println("java VM version: " + System.getProperty("java.vm.version")); // Java虚拟机版本号
        System.out.println();

        System.out.println("java specification vendor: " + System.getProperty("java.specification.vendor")); // Java规范提供商
        System.out.println("java specification version: " + System.getProperty("java.specification.version")); // Java规范版本号
        System.out.println("java specification name: " + System.getProperty("java.specification.name")); // Java规范名称
        System.out.println();

        System.out.println("java class version: " + System.getProperty("java.class.version")); // Java类版本号
        System.out.println("java class path: " + System.getProperty("java.class.path")); // Java类路径
        System.out.println("java library path: " + System.getProperty("java.library.path")); // Java lib路径
        System.out.println();

        System.out.println("java io tmpdir: " + System.getProperty("java.io.tmpdir")); // Java输入输出临时路径
        System.out.println("java compiler" + System.getProperty("java.compiler")); // Java编译器
        System.out.println("java ext dirs" + System.getProperty("java.ext.dirs")); // Java执行路径
        System.out.println();

        System.out.println("file separator: " + System.getProperty("file.separator"));
        System.out.println("path separator: " + System.getProperty("path.separator"));

        System.out.println("line separator: " + System.getProperty("line.separator").
                replace("\n", "\\n").replace("\r", "\\r")
        );
        System.out.println();

        System.out.println("user name: " + System.getProperty("user.name"));
        System.out.println("user home: " + System.getProperty("user.home"));
        System.out.println("user dir(work dir): " + System.getProperty("user.dir"));
        System.out.println();
    }

    public static void main(String[] args) {
        getPropertyDemo();
    }
}
