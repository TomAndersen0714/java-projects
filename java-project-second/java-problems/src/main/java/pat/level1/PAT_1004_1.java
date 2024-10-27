package pat.level1;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
// https://www.nowcoder.com/pat/6/problem/4040

/**
 * @author TomAndersen
 */
public class PAT_1004_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String a1 = bf.readLine();
        String a2 = bf.readLine();
        String b1 = bf.readLine();
        String b2 = bf.readLine();

        String[] week = new String[]{"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        String day = "", hour = "", minute = "";
        // the hour and minute might have leading zero

        // get the day
        int len = Math.min(a1.length(), a2.length());
        int cur = 0;
        for (short i = 0; i < len; i++) {
            if (a1.charAt(i) == a2.charAt(i)) {
                if (a1.charAt(i) >= 'A' && a1.charAt(i) <= 'G') {
                    day = week[a1.charAt(i) - 'A'];
                    cur = i + 1;
                    break;
                }

            }
        }
        // OUT: cur == i+1

        // get the hour
        for (int i = cur; i < len; i++) {
            if (a1.charAt(i) == a2.charAt(i)) {
                if (a1.charAt(i) >= '0' && a1.charAt(i) <= '9') {
                    hour = "0" + (a1.charAt(i) - '0');
                    break;
                }
                else if (a1.charAt(i) >= 'A' && a1.charAt(i) <= 'N') {
                    hour = String.valueOf(a1.charAt(i) - 'A' + 10);
                    break;
                }
            }
        }

        // get the minute
        len = Math.min(b1.length(), b2.length());
        for (short i = 0; i < len; i++) {
            if (b1.charAt(i) == b2.charAt(i) && isAlphabet(b1.charAt(i))) {
                if (i <= 9) {
                    minute = "0" + i;
                }
                else {
                    minute = String.valueOf(i);
                }
                break;
            }
        }

        // print the time string
        System.out.println(day + " " + hour + ":" + minute);

    }

    private static boolean isAlphabet(char c) {
        if (c >= 'a' && c <= 'z') return true;
        if (c >= 'A' && c <= 'Z') return true;
        else return false;
    }
}
