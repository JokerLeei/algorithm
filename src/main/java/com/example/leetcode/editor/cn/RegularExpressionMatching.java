package com.example.leetcode.editor.cn;

//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4： 
//
// 
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5： 
//
// 
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 20 
// 0 <= p.length <= 30 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
// Related Topics 字符串 动态规划 回溯算法 
// 👍 2173 👎 0


public class RegularExpressionMatching {

    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
//        System.out.println(solution.isMatch("aa", "*a"));       // Error 保证每次出现字符 * 时，前面都匹配到有效的字符
        System.out.println(solution.isMatch("aa", "a*"));       // true
        System.out.println(solution.isMatch("ab", ".*"));       // true
        System.out.println(solution.isMatch("aab", "c*a*b"));   // true
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));  // false
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public boolean isMatch2(String s, String p) {
//        return isMatch(s.toCharArray(), p.toCharArray());
//    }
//
//    private boolean isMatch(char[] s, char[] p) {
//        int m = s.length;
//        int n = p.length;
//
//        // 这里dp矩阵是要大一圈的，用来处理s或者p为空串的情况，矩阵的行标i对应s的i-1，矩阵的列标j对应p的j-1
//        // 即s.charAt(i) 对应矩阵 i+1；p.charAt(j) 对应矩阵 j+1
//        boolean[][] dp = new boolean[m + 1][n + 1];
//
//        // s和p都是空串的时候自然true
//        dp[0][0] = true;
//
////        // 若s为非空串，p为空串，则结果必然false，默认为false无需处理
////        for (int i = 1; i <= m; i++) {
////            dp[i][0] = false;
////        }
//        // 若s为空串，p为非空串，则只有p为"x*"、"x*x*"、"x*x*x*"···才能匹配
//        for (int j = 1; j <= n; j++) {
//            if (p[j - 1] == '*') {
//                dp[0][j] = dp[0][j - 2];
//            }
//        }
//
//        // 迭代
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                // 文本串和模式串末位字符能匹配上
//                if (s[i - 1] == p[j - 1] || p[j - 1] == '.') {
//                    dp[i][j] = dp[i - 1][j - 1];
//                }
//                // 模式串末位是*
//                else if (p[j - 1] == '*') {
//                    // 模式串*的前一个字符能够跟文本串的末位匹配上
//                    if (s[i - 1] == p[j - 2] || p[j - 2] == '.') {
//                        dp[i][j] = dp[i][j - 2]     // *匹配0次的情况
//                                || dp[i - 1][j];    // *匹配1次或多次的情况
//                    }
//                    // 模式串*的前一个字符不能够跟文本串的末位匹配
//                    else {
//                        dp[i][j] = dp[i][j - 2];    // *只能匹配0次
//                    }
//                }
//            }
//        }
//
//        return dp[m][n];
//    }
//
//    public boolean isMatch3(String s, String p) {
//        int m = s.length();
//        int n = p.length();
//
//        boolean[][] f = new boolean[m + 1][n + 1];
//        // f[0][0]代表s和p均为空字符串，f[1][1]代表s和p的第一个字符（即在s和p中下标为0的字符）
//        f[0][0] = true;
//
//        // i从0开始，因为要考虑s串为空串的情况。
//        // s串为空串时，只有p串为"x*"、"x*x*"、"x*x*x*"···，x为任意字符，才能返回true
//        for (int i = 0; i <= m; i++) {
//            // j从1开始，因为若p串为空，s串不为空(s为空已经在上面f[0][0]=true了)，必然返回false
//            for (int j = 1; j <= n; j++) {
//                // p的第j个字符为*
//                if (p.charAt(j - 1) == '*') {
//                    if (matches(s, p, i, j - 1)) {  // 如果p的第j个字符是*，则看这个*前面的字符和s的第i个字符匹配情况
//                        f[i][j] = f[i - 1][j]       // p中*前面的字符在s中出现多次
//                                || f[i][j - 2];     // p中*前面的字符在s中出现1次
//                    }
//                    else {
//                        f[i][j] = f[i][j - 2];      // p中*前面的字符在s中出现0次
//                    }
//                }
//                else {  // p的第j个字符不为*
//                    if (matches(s, p, i, j)) {      // s的第i个字符和p的第j个字符是否匹配
//                        f[i][j] = f[i - 1][j - 1];  // 匹配成功，状态转移；匹配不成功，默认是false
//                    }
//                }
//            }
//        }
//        return f[m][n];
//    }
//
//    public boolean matches(String s, String p, int i, int j) {
//        if (i == 0) {
//            return false;
//        }
//        if (p.charAt(j - 1) == '.') {
//            return true;
//        }
//        return s.charAt(i - 1) == p.charAt(j - 1);
//    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i - 1][j]
                                || dp[i][j - 2];
                    }
                    else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
                else if (matches(s, p, i, j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}