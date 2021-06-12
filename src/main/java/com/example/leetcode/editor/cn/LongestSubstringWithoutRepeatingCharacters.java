package com.example.leetcode.editor.cn;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5371 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 暴力破解
    // 时间 O(n^2)
    // 空间 O(n)
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if (!sb.toString().contains(String.valueOf(s.charAt(j)))) {
                    sb.append(s.charAt(j));
                } else {
                    break;
                }
            }
            if (sb.length() > max) {
                max = sb.length();
            }
        }
        return max;
    }

    // 滑动窗口法
    // 时间 O(2n) = O(n)
    // 空间 O(min(m, n))  空间大小为set的大小，取决于字符串n的大小以及字符集/字母m的大小
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                result = Math.max(result, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }

    // 优化后的滑动窗口法
    public int lengthOfLongestSubstring3(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            result = Math.max(result, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}