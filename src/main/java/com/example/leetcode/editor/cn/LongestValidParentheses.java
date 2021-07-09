package com.example.leetcode.editor.cn;

//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1337 👎 0


import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParentheses {

    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        System.out.println(solution.longestValidParentheses("(()"));        // 2
        System.out.println(solution.longestValidParentheses(")()())"));     // 4
        System.out.println(solution.longestValidParentheses(""));           // 0
        System.out.println(solution.longestValidParentheses("()"));         // 2
        System.out.println(solution.longestValidParentheses("()(())"));     // 6
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 动态规划
     *
     * 时间 O(n)
     * 空间 O(n)
     */
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        int res = 0;
        int length = s.length();
        int[] dp = new int[length];
//        dp[0] = 0;

        for (int i = 1; i < length; i++) {
            char ci = s.charAt(i);
            char pre = s.charAt(i - 1);

            if (ci == '(') {
//                dp[i] = 0;
                continue;
            }
            else if (ci == ')') {
                if (pre == '(') {
                    // f(...()) = f(...) + 2
                    dp[i] = 2;
                    if (i - 2 >= 0) {
                        dp[i] += dp[i - 2];
                    }
                }
                else if (pre == ')') {
                    // *((...)) 这种情况下，和 i 所匹配的字符下标为 i - dp[i - 1] - 1，* 的下标为 i - dp[i - 1] - 2
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        // 处理 ()((...)) 这种情况
                        if (i - dp[i - 1] - 2 >= 0) {
                            dp[i] += dp[i - dp[i - 1] - 2];
                        }
                    }
                }
                res = Math.max(res, dp[i]);
            }
        }

        return res;
    }

    /**
     * 栈
     *
     * 时间 O(n)
     * 空间 O(n)
     */
    public int longestValidParentheses(String s) {
        int res = 0;
        // 保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char ci = s.charAt(i);
            // 对于遇到的每个 ( 直接入栈
            if (ci == '(') {
                stack.push(i);
            }
            // 对于遇到的每个 ) 先将栈顶元素出栈，表示匹配了一个 (，然后判断栈是否为空
            // 1.栈为空, 直接入栈，当前入栈的 ) 为「最后一个没有被匹配的右括号的下标」
            // 2.栈不空, 查看栈顶元素并计算下标差值, 该差值为「以该右括号为结尾的最长有效括号的长度」
            else if (ci == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }

        return res;
    }

    /**
     * 遍历判断所有可能的子串
     * 直接超时
     *
     * 时间 O(n ^ 3)
     */
    public int longestValidParentheses3(String s) {
        int res = 0;
        int length = s.length();

        for (int i = 0; i <= length; i++) {
            for (int j = i + 1; j <= length; j++) {

                if ((j - i) % 2 != 0) {
                    continue;
                }

                if (isValid(s.substring(i, j))) {
                    res = Math.max(res, j - i);
                }
            }
        }

        return res;
    }

    public boolean isValid(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == '(' && res >= 0) {
                res++;
            }
            else if (charAt == ')') {
                res--;
            }
        }
        return res == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}