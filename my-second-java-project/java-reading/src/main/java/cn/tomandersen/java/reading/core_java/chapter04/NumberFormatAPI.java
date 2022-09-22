package cn.tomandersen.java.reading.core_java.chapter04;

import java.text.NumberFormat;

/**
 * {@link java.text.NumberFormat}
 */
public class NumberFormatAPI {
    public static void main(String[] args) {
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        NumberFormat percentInstance = NumberFormat.getPercentInstance();

        double x = 0.1d;
        System.out.println(currencyInstance.format(x));
        System.out.println(percentInstance.format(x));
    }
}
