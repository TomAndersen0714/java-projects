package leetcode.second.medium;

import leetcode.common.Util;

import java.util.*;

/**
 * 49. Group Anagrams, 组字谜
 * https://leetcode.com/problems/group-anagrams/description/
 */
public class LeetCode49 {
    public static void main(String[] args) {
        String[] strs;
        List<List<String>> output;

        strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        output = Util.strToStrListList("[[\"bat\"],[\"nat\",\"tan\"],[\"ate\",\"eat\",\"tea\"]]");
        System.out.println(Util.compareList(new LeetCode49_1().groupAnagrams(strs), output));

        strs = new String[]{""};
        output = Util.strToStrListList("[[\"\"]]");
        System.out.println(Util.compareList(new LeetCode49_1().groupAnagrams(strs), output));

        strs = new String[]{"a"};
        output = Util.strToStrListList("[[\"a\"]]");
        System.out.println(Util.compareList(new LeetCode49_1().groupAnagrams(strs), output));


        strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        output = Util.strToStrListList("[[\"bat\"],[\"nat\",\"tan\"],[\"ate\",\"eat\",\"tea\"]]");
        System.out.println(Util.compareList(new LeetCode49_2().groupAnagrams(strs), output));

        strs = new String[]{""};
        output = Util.strToStrListList("[[\"\"]]");
        System.out.println(Util.compareList(new LeetCode49_2().groupAnagrams(strs), output));

        strs = new String[]{"a"};
        output = Util.strToStrListList("[[\"a\"]]");
        System.out.println(Util.compareList(new LeetCode49_2().groupAnagrams(strs), output));
    }
}

/**
 * HashTable + Sort
 */
class LeetCode49_1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // input
        if (strs == null || strs.length == 0) {
            return new LinkedList<>();
        }

        // transform
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // generate the hash table key by sort characters
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);

            // update the hash table
            if (map.containsKey(key)) {
                map.get(key).add(str);
            }
            else {
                LinkedList<String> list = new LinkedList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        // output
        return new LinkedList<>(map.values());

    }
}


/**
 * HashTable + Array
 */
class LeetCode49_2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // input
        if (strs == null || strs.length == 0) {
            return new LinkedList<>();
        }

        // transform
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] signs = new int[26];
            char[] chars = str.toCharArray();

            // build hash table key
            for (char c : chars) {
                signs[c - 'a'] += 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int sign : signs) {
                sb.append((char) sign + 'a');
            }
            String key = sb.toString();

            // update the hash table
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(str);
        }

        // output
        return new ArrayList<>(map.values());
    }
}
