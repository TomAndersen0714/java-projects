package algorithm.practice.for_offer.string;

/**
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 *
 * @author TomAndersen
 */
public class Offer_58 {
    public String reverseLeftWords(String s, int n) {
        // boundary situation
        if (s == null || s.length() == 0 || n <= 0) {
            return "";
        }

        // output
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        System.out.println(new Offer_58().reverseLeftWords("abcdefg", 2));
        System.out.println(new Offer_58().reverseLeftWords("lrloseumgh", 6));

    }
}
