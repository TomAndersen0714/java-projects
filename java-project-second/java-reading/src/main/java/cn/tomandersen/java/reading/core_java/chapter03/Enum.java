package cn.tomandersen.java.reading.core_java.chapter03;

import cn.tomandersen.java.reading.utils.Utils;

public class Enum {
    // 实际上枚举(Enum)类型, 也是一种特殊的类(Class)
    public enum Size {SMALL, MEDIUM, LARGE, EXTRA_LARGE}

    public static void main(String[] args) {
        // enumerated type
        System.out.println(Enum.Size.SMALL);
        System.out.println(Size.SMALL);

        Enum.Size size = Size.SMALL;
        System.out.println(size);
        System.out.println(Utils.getClassName(size));
    }
}
