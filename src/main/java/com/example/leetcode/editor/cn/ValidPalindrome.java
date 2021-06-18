package com.example.leetcode.editor.cn;

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 388 👎 0


public class ValidPalindrome {

    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 自解 直接在原字符串上判断
    // 时间 O(n)
    // 空间 O(1)
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            while (!isValidChar(leftChar) && left < right) {
                left++;
                leftChar = s.charAt(left);
            }
            while (!isValidChar(rightChar) && left < right) {
                right--;
                rightChar = s.charAt(right);
            }

            if (leftChar!= rightChar) {
                break;
            }
            else {
                left++;
                right--;
            }
        }

        return left >= right;
    }

    public boolean isValidChar(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}