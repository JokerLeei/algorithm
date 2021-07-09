package com.example.leetcode.editor.cn;

//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 
// 👍 1209 👎 0


import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        int[] a = new int[] { 1, 2, 3 };
        solution.nextPermutation(a);
        System.out.println(Arrays.toString(a)); // 1, 3, 2

        int[] b = new int[] { 3, 2, 1 };
        solution.nextPermutation(b);
        System.out.println(Arrays.toString(b)); // 1, 2, 3

        int[] c = new int[] { 1, 1, 5 };
        solution.nextPermutation(c);
        System.out.println(Arrays.toString(c)); // 1, 5, 1

        int[] d = new int[] { 1 };
        solution.nextPermutation(d);
        System.out.println(Arrays.toString(d)); // 1

        int[] e = new int[] { 1, 1 };
        solution.nextPermutation(e);
        System.out.println(Arrays.toString(e)); // 1, 1
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 这个建议看官方题解的动图版，不然看不懂
    // 时间 O(n)
    // 空间 O(1)
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        /*
        // 官方说法
        1.首先从后向前查找第一个顺序对 (i,i+1)，满足 a[i] < a[i+1]。这样「较小数」即为 a[i]。此时 [i+1,n) 必然是下降序列。
        2.如果找到了顺序对，那么在区间 [i+1,n) 中从后向前查找第一个元素 jj 满足 a[i] < a[j]。这样「较大数」即为 a[j]。
        3.交换 a[i] 与 a[j]，此时可以证明区间 [i+1,n) 必为降序。我们可以直接使用双指针反转区间 [i+1,n) 使其变为升序，而无需对该区间进行排序。

        // 通俗地讲
        1.从后往前寻找一个'非降序'数对的前者 (6241553) -查找-> (15) -前者-> 1
        2.在这个数+1及其之后的部分从后往前找第一个比i大的数j
        3.交换i和j位置
        4.反转[i + 1, num.length]
         */

        // 1.从后往前寻找第一个非降序(前<=后)数对的前者i
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {  // 这里不加'='，[1, 1]这种会下标越界
            i--;
        }

        // ⚠️上一步得到的 i 可能为-1, 仅当原数组为降序数组, 所以这里判断一下
        if (i >= 0) {
            // 2.从后往前寻找第一个大于 i 的数 j
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }

            // 3.交换 i 和 j
            swap(nums, i, j);
        }

        // 4.将(i + 1, nums.length - 1)反转
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

    private void reverse(int[] a, int left, int right) {
        while (left < right) {
            swap(a, left, right);
            left++;
            right--;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}