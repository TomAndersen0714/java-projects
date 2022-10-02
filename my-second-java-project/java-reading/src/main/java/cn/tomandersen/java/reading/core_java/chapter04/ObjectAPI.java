package cn.tomandersen.java.reading.core_java.chapter04;

/**
 * @see java.lang.Object
 */
public class ObjectAPI {
    public static void main(String[] args) {
        // anonymous class based on extends
        Object obj = (Object) new Employee("Tom Andersen", 16000) {
            @Override
            public String toString() {
                return "name: " + this.getName() + ", "
                    + "salary: " + this.getSalary();
            }
        };

        // hashCode
        System.out.println("Object.hashCode(): ");
        System.out.println(obj.hashCode());

        // toString
        System.out.println("Object.toString(): ");
        System.out.println(obj.toString());

        // getClass
        System.out.println("Object.getClass(): ");
        System.out.println(obj.getClass());

    }
}
