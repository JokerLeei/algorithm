package com.example.leetcode.editor.cn;

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1643 👎 0


public class LongestCommonPrefix {

    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        System.out.println(solution.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
        System.out.println(solution.longestCommonPrefix(new String[] {"abb", "abc"}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 纵向遍历
    // 时间 O(m * n) m:avg(strs[i].length()) n:strs.length
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder("");

        if (strs == null || strs.length == 0) {
            return sb.toString();
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int minLength = strs[0].length();
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        int count = strs.length;
        for (int i = 0; i < minLength; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}