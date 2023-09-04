package libraries.java.util.stream;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author TomAndersen
 * {@link java.util.stream.Stream}
 */
public interface StreamAPI {
    public static void main(String[] args) {
        ArrayListToIntArrayPerformanceTest();
    }

    public static void ArrayListToIntArrayPerformanceTest() {
        // create an array list with 1 million elements
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(i);
        }

        // using stream() method to convert and calculate execution time
        long startTimeStream = System.currentTimeMillis();
        int[] intArrayStream = arrayList.stream().mapToInt(Integer::intValue).toArray();
        long endTimeStream = System.currentTimeMillis();
        System.out.println("Using stream() took " + (endTimeStream - startTimeStream) + " milliseconds.");

        // using loop expression to convert and calculate execution time
        long startTimeLoop = System.currentTimeMillis();
        int[] intArrayLoop = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            intArrayLoop[i] = arrayList.get(i);
        }
        long endTimeLoop = System.currentTimeMillis();
        System.out.println("Using loop took " + (endTimeLoop - startTimeLoop) + " milliseconds.");

        // compare the two arrays
        boolean arraysEqual = Arrays.equals(intArrayStream, intArrayLoop);
        System.out.println("Arrays are equal: " + arraysEqual);
    }
}
