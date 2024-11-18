package leetcode.second.medium;

import leetcode.common.Util;

import java.util.LinkedList;
import java.util.List;

/**
 * 46. Permutations, 全排列
 * https://leetcode.com/problems/permutations/description/
 */
public class LeetCode46 {
    public static void main(String[] args) {
        int[] nums;
        List<List<Integer>> output;

        nums = Util.strToArray("[1,2,3]");
        output = Util.strToListList("[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]");
        System.out.println(Util.compareList(new LeetCode46_1().permute(nums), output));

        nums = Util.strToArray("[0,1]");
        output = Util.strToListList("[[0,1],[1,0]]");
        System.out.println(Util.compareList(new LeetCode46_1().permute(nums), output));

        nums = Util.strToArray("[1]");
        output = Util.strToListList("[[1]]");
        System.out.println(Util.compareList(new LeetCode46_1().permute(nums), output));
    }
}

/**
 * Dynamic Programming
 */
class LeetCode46_1 {
    public List<List<Integer>> permute(int[] nums) {
        // input
        if (nums == null || nums.length == 0) {
            return null;
        }

        // transform
        List<List<Integer>> res = new LinkedList<>();
        for (int num : nums) {
            res = permute(res, num);
        }

        // output
        return res;
    }

    // 输入现有排列，和待新增的数字，返回对应的排列
    private List<List<Integer>> permute(List<List<Integer>> lists, int num) {
        List<List<Integer>> res = new LinkedList<>();

        if (lists.isEmpty()) {
            res.add(List.of(num));
        }
        else {
            for (List<Integer> list : lists) {
                int size = list.size();
                for (int i = 0; i <= size; i++) {
                    LinkedList<Integer> permutation = new LinkedList<Integer>(list);
                    permutation.add(i, num);
                    res.add(permutation);
                }
            }
        }
        return res;
    }
}
