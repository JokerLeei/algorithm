package com.example.leetcode.editor.cn;

//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意：答案中不可以包含重复的四元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [], target = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 双指针 排序 
// 👍 881 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        System.out.println(solution.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
        System.out.println(solution.fourSum(new int[] { -2, -1, -1, 1, 1, 2, 2 }, 0));
//        System.out.println("-----");
//        System.out.println(solution.fourSum2(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
//        System.out.println(solution.fourSum2(new int[] { -2, -1, -1, 1, 1, 2, 2 }, 0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        for (int one = 0; one < nums.length; one++) {
            if (one > 0 && nums[one] == nums[one - 1]) {
                continue;
            }

            for (int two = one + 1; two < nums.length; two++) {
                if (two > one + 1 && nums[two] == nums[two - 1]) {
                    continue;
                }

                int three = two + 1;
                int four = nums.length - 1;
                while (three < four) {
                    int sum = nums[one] + nums[two] + nums[three] + nums[four];
                    if (sum == target) {
                        result.add(new ArrayList<>(Arrays.asList(nums[one], nums[two], nums[three], nums[four])));

                        while (three < four && nums[three] == nums[three + 1]) {
                            three++;
                        }
                        while (three < four && nums[four] == nums[four - 1]) {
                            four--;
                        }

                        // ⚠️这里必须放最后再进行游标的加减操作
                        three++;
                        four--;
                    }
                    else if (sum > target) {
                        four--;
                    }
                    else {
                        three++;
                    }
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}