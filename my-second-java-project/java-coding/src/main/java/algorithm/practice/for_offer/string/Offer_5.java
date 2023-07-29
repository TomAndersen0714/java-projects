package algorithm.practice.for_offer.string;

/**
 * https://leetcode.cn/studyplan/coding-interviews/
 * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 *
 * @author TomAndersen
 */
public class Offer_5 {
    public String replaceSpace(String s) {
        // boundary situation
        if (s == null || s.length() == 0) {
            return s;
        }

        // handle
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            }
            else {
                sb.append(c);
            }
        }

        // output
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Offer_5().replaceSpace("We are happy."));
    }
}
