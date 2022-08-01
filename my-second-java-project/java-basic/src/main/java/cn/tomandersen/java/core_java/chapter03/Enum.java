package cn.tomandersen.java.core_java.chapter03;

import static cn.tomandersen.java.utils.Utils.getClassName;

public class Enum {
    // 实际上枚举(Enum)类型, 也是一种特殊的类(Class)
    public enum Size {SMALL, MEDIUM, LARGE, EXTRA_LARGE}

    public static void main(String[] args) {
        // enumerated type
        System.out.println(Enum.Size.SMALL);
        System.out.println(Size.SMALL);

        Enum.Size size = Size.SMALL;
        System.out.println(size);
        System.out.println(getClassName(size));
    }
}
