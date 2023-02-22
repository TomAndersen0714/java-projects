package lesson2.object_oriented;

import libraries.Utils;

/**
 * @author TomAndersen
 */
public class Enum {
    public enum Size {SMALL, MEDIUM, LARGE, EXTRA_LARGE}

    public static void main(String[] args) {
        // enumerated type
        System.out.println(Size.SMALL);
        System.out.println(Size.SMALL);

        Size size = Size.SMALL;
        System.out.println(size);
        // 实际上枚举(Enum)类型, 也是一种特殊的类(Class)
        System.out.println(Utils.getClassName(size));
    }
}
