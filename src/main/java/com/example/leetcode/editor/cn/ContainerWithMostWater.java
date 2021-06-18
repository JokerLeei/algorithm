package com.example.leetcode.editor.cn;

//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 数组 双指针 
// 👍 2532 👎 0


public class ContainerWithMostWater {

    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        System.out.println(solution.maxArea(new int[]{ 4,3,2,1,4 }));
        System.out.println(solution.maxArea(new int[]{ 1,8,6,2,5,4,8,3,7 }));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 排列组合暴力破解
    // 时间 O(n^2) leetcode直接超时
    public int maxArea2(int[] height) {
        int result = 0;
        int len = height.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int width = j - i;
                int high = Math.min(height[i], height[j]);
                int area = width * high;
                result = Math.max(result, area);
            }
        }

        return result;
    }

    // 双指针法
    // 时间 O(n^2) 双指针遍历一次底边宽度 N
    // 空间 O(1) 指针使用常数额外空间
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            int high = Math.min(height[left], height[right]);
            int width = right - left;
            int area = high * width;
            result = Math.max(result, area);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}