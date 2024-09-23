package nowcoder;

/**
 * @author TomAndersen
 */
public class BM83 {
    /*
    Two pointers
     */
    public String trans(String s, int n) {
        // exclude boundary situation
        if (s == null || s.isEmpty() || n <= 1) {
            return s;
        }

        // solve problem
        int len = s.length();
        StringBuilder sb = new StringBuilder(len);
        int left = len - 1, right = len;
        while (left >= 0) {
            // if current character is space
            if (s.charAt(left) == ' ') {
                sb.append(' ');
                right = left;

                // move the cursor
                left -= 1;
            }

            // if current character is an alphabet
            else {
                // then get entire word
                int next = left - 1;
                while (next >= 0 && s.charAt(next) != ' ') {
                    left = next;
                    next = left - 1;
                }

                // convert the word
                for (int i = left; i < right; i++) {
                    char c = s.charAt(i);
                    if (Character.isLowerCase(c)) {
                        sb.append(Character.toUpperCase(c));
                    }
                    else {
                        sb.append(Character.toLowerCase(c));
                    }
                }

                // move the cursor
                left -= 1;
            }
        }

        // return
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("SAMPLE A IS tHIS".equals(new BM83().trans("This is a sample", 16)));
        System.out.println("NOWCODER".equals(new BM83().trans("nowcoder", 8)));
        System.out.println("Ios".equals(new BM83().trans("iOS", 3)));
        System.out.println("I H ".equals(new BM83().trans(" h i", 4)));
    }
}
