package com.example.leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3722 👎 0


public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome2("zdcbcd"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 暴力破解法
     * 时间 O(n^3)
     */
    public String longestPalindrome2(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                // 先用下标判断子串长度是否大于临时结果串长度，若<=直接跳过，否则频繁计算subString()解答直接超时
                if (j - i + 1 > result.length() && isPalindromicString(s.substring(i, j))) {
                    result = s.substring(i, j);
                }
            }
        }
        return result;
    }

    /**
     * 判断是否是一个回文字符串
     */
    public boolean isPalindromicString(String s) {
        if (s == null || s.length() == 1) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 中心扩展法
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     *
     * z a b c b a
     * 0 1 2 3 4 5
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = centerSpread(s, i, i);
            int len2 = centerSpread(s, i, i + 1);
            int currLen = Math.max(len1, len2);
            if (currLen > end - start) {
                start = i - (currLen - 1) / 2;
                end = i + currLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 中心扩散法，计算第i位字符最大扩散回文串长度
     * zabccba 4 - 6+1/2    4 +
     * zabccba 3 - 6+1/2    3 +
     */
    private int centerSpread(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * 动态规划
     * 时间复杂度 O(n^2)
     */
    public String longestPalindrome3(String s) {
        return "";
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}