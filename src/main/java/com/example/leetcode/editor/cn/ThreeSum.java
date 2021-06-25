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
                    // 首先无论如何先要进行加减操作
                    two++;
                    three--;

                    // 现在要增加 left，减小 right，但是不能重复，
                    // 比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    while (two < three && nums[two] == nums[two - 1]) {
                        two++;
                    }
                    while (two < three && nums[three] == nums[three + 1]) {
                        three--;
                    }
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

//    public List<List<Integer>> threeSum2(int[] nums) {
//        // 先排波序
//        Arrays.sort(nums);
//
//        List<List<Integer>> result = new ArrayList<>();
//        int length = nums.length;
//
//        // 枚举 a
//        for (int first = 0; first < length; first++) {
//            // 需要和上一次枚举的数不相同
//            if (first > 0 && nums[first] == nums[first - 1]) {
//                continue;
//            }
//            // c 对应的指针初始指向数组的最右端
//            int third = length - 1;
//            int target = -nums[first];
//            // 枚举 b
//            for (int second = first + 1; second < length; second++) {
//                // 需要和上一次枚举的数不相同
//                if (second > first + 1 && nums[second] == nums[second - 1]) {
//                    continue;
//                }
//                // 需要保证 b 的指针在 c 的指针的左侧
//                while (second < third && nums[second] + nums[third] > target) {
//                    --third;
//                }
//                // 如果指针重合，随着 b 后续的增加
//                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
//                if (second == third) {
//                    break;
//                }
//                if (nums[second] + nums[third] == target) {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(nums[first]);
//                    list.add(nums[second]);
//                    list.add(nums[third]);
//                    result.add(list);
//                }
//            }
//        }
//        return result;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}