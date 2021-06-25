package com.example.leetcode.editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 1845 👎 0


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
//        System.out.println(solution.generateParenthesis(0));
//        System.out.println(solution.generateParenthesis(1));
//        System.out.println(solution.generateParenthesis(3));
        System.out.println(solution.generateParenthesis2(8).size());
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 暴力法
    // 回溯法先获得所有字符串情况，然后逐一判断是否有效，无剪枝
    // 时间 O(n * 2^2n) 前面✖的n为验证函数时间复杂度
    // 空间 O(n) 即StringBuffer
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backTrace(result, 0, 2 * n, "");
//        backTrace(result, 0, 2 * n, new StringBuffer());

        return result;
    }

    private void backTrace(List<String> result, int index, int n, String sb) {
        if (index == n) {
            if (isValid2(sb.toCharArray())) {
                System.out.println(sb);
                result.add(sb);
            }
        }
        else {
            backTrace(result, index + 1, n, sb + "(");
//            sb.deleteCharAt(index);     // 使用String的话，因为每一次尝试，都使用新的字符串变量，所以无需回溯(执行该行删除的方法)
            backTrace(result, index + 1, n, sb + ")");
//            sb.deleteCharAt(index);
        }
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == '(') {
                stack.push(charAt);
            }
            else {
                if (stack.peek() == null || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(char[] chars) {
        int balance = 0;
        for (char c : chars) {
            if (c == '(') {
                balance++;
            }
            else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    // 深度优先遍历
    // https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();

        dfs("", n, n, result);

        return result;
    }

    private void dfs(String curStr, int left, int right, List<String> result) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            result.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left < right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, result);
        }
        if (right > 0) {
            dfs(curStr + ")", left, right - 1, result);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}