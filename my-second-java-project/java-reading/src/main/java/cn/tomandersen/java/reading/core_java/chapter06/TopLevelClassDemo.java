package cn.tomandersen.java.reading.core_java.chapter06;

public class TopLevelClassDemo {
    /**
     * There are two kinds of classes (or interfaces)
     * a) Top level classes
     * b) Nested classes
     * b.1) Non-static nested classes (or inner classes)
     * b.1.1) Member (inner) classes
     * b.1.2) Local (inner) classes
     * b.1.3) Anonymous (inner) classes
     * b.2) Static nested classes (static member class)
     */
    public static void main(String[] args) {
        test(() -> {
            System.out.println("");
        });
    }

    static void test(TestLocalClass o) {
        o.test();
    }

    interface TestLocalClass {
        int a = 1;

        default String getString() {
            return "";
        }

        void test();

        class TestMemberClass {
            static class TestMemberClassMemberClass {
            }
        }
    }
}
