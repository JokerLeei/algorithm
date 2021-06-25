package com.example.leetcode.editor.cn;

//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 104 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 940 👎 0


public class ImplementStrstr {

    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
//        System.out.println(solution.strStr("hello", "ll"));
//        System.out.println(solution.strStr("aaaaa", "bba"));
//        System.out.println(solution.strStr("", ""));
        System.out.println(solution.strStr("mississippi", "issipp"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int allLen = haystack.length();
        int subLen = needle.length();
        if (allLen < subLen) {
            return -1;
        }

        for (int i = 0; i < allLen; i++) {
            if (i + subLen > allLen) {
                break;  // 如果haystack.subString(i)长度小于needle.length()则直接退出循环
            }
            boolean flag = true;
            for (int j = 0; j < subLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}