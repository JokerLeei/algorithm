package com.example.leetcode.editor.cn;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治算法 
// 👍 4172 👎 0


import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        int a = 0, b = 0;
        for (int i = 0; i < nums1.length + nums2.length; i++) {
            if (a >= nums1.length) {
                list.add(nums2[b]);
                b++;
                continue;
            }
            if (b >= nums2.length) {
                list.add(nums1[a]);
                a++;
                continue;
            }
            if (nums1[a] < nums2[b]) {
                list.add(nums1[a]);
                a++;
            } else {
                list.add(nums2[b]);
                b++;
            }
        }

        if (list.size() == 1) {
            return list.get(0);
        }
        if (list.size() % 2 == 0) {
            return (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2.0;
        }
        return list.get(list.size() / 2);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}