package library.util;

import java.util.BitSet;

/**
 * @author TomAndersen
 */
public class BitSetAPI {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet(256);

        // write
        // java.util.BitSet.set(int, boolean)
        bitSet.set(10, true);
        bitSet.set(8, false);
        // java.util.BitSet.set(int)
        bitSet.set(11);
        bitSet.set(12);
        // java.util.BitSet.clear(int)
        bitSet.clear(10);

        // read
        System.out.println("bitSet = " + bitSet);
    }
}
