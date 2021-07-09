package com.example.leetcode.editor.cn;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3422 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        System.out.println(solution.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
        System.out.println(solution.threeSum(new int[] { 1, -1, -1, 0 }));
        System.out.println(solution.threeSum(new int[] { 2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4 }));
        System.out.println(solution.threeSum(new int[] { 0 }));
        System.out.println(solution.threeSum(new int[] { }));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 排序 + 双指针
    // 时间 O(n^2)
    // 空间 O(log n)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;

        List<List<Integer>> result = new ArrayList<>();

        for (int one = 0; one < length; one++) {
            if (nums[one] > 0) {
                break;  // 第一个数大于 0，后面的数都比它大，肯定不成立了
            }
            if (one > 0 && nums[one] == nums[one - 1]) {
                continue;   // 去掉重复情况
            }

            int target = -nums[one];
            int two = one + 1;
            int three = length - 1;
            while (two < three) {
                if (nums[two] + nums[three] == target) {
                    result.add(new ArrayList<>(Arrays.asList(nums[one], nums[two], nums[three])));
                    // 现在要增加 left，减小 right，但是不能重复，
                    // 比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    while (two < three && nums[two] == nums[two + 1]) {
                        two++;
                    }
                    while (two < three && nums[three] == nums[three - 1]) {
                        three--;
                    }

                    two++;
                    three--;
                }
                else if (nums[two] + nums[three] > target) {
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