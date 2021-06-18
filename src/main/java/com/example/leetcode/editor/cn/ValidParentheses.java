package com.example.leetcode.editor.cn;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2453 👎 0


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {

    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("{[()]}"));
        System.out.println(solution.isValid("{[()][]}"));
        System.out.println(solution.isValid("[{()]}"));
        System.out.println(solution.isValid("["));
        System.out.println(solution.isValid("){"));
        System.out.println(solution.isValid("(("));
        System.out.println(solution.isValid("[{}]"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // {[()][]}
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>() {{
           put('{', '}');
           put('[', ']');
           put('(', ')');
        }};

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (map.containsKey(charAt)) {
                // 左括号直接全部压栈
                stack.push(charAt);
            }
            else {
                // 来右括号时，和栈顶比较进行抵消操作，抵消不了则为false
                if (stack.peek() == null || charAt != map.get(stack.peek())) {
                    return false;
                }
                stack.pop();
            }
        }

        // 返回：栈内左括号全部被抵消？
        // 如果直接返回true，"(("这种过不去
        return stack.isEmpty();
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}