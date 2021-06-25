package com.example.leetcode.editor.cn;

//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 排序 
// 👍 804 👎 0


import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        System.out.println(solution.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
        System.out.println(solution.threeSumClosest(new int[] { 1, 1, 1, 1 }, 3));
        System.out.println(solution.threeSumClosest(new int[] { 1, 1, 1, 0 }, 100));
        System.out.println(solution.threeSumClosest(new int[] { -3, -2, -5, 3, -4}, -1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 排序 + 双指针
    // 时间 O(n^2)
    // 空间 O(log n)
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];
        int length = nums.length;

        for (int one = 0; one < length; one++) {
            if (one > 0 && nums[one] == nums[one - 1]) {
                continue;
            }

            int two = one + 1;
            int three = length - 1;
            while (two < three) {
                int sum = nums[one] + nums[two] + nums[three];
                if (sum == target) {
                    return sum;
                }

                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }

                if (sum > target) {
                    three--;
                }
                else {
                    two++;
                }
            }
        }

        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}