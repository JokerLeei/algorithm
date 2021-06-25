package com.example.leetcode.editor.cn;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯算法 
// 👍 1367 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("3"));
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations(""));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 回溯算法
    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> map = new HashMap<Character, List<Character>>() {{
            put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
            put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
            put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
            put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
            put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
            put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
            put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
            put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
        }};

        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        backTrace(result, map, 0, digits, "");
//        backTrace(result, map, 0, digits, new StringBuffer());
        return result;
    }

    private void backTrace(List<String> result, Map<Character, List<Character>> map, int index, String digits, String temp) {
        if (index == digits.length()) {
            result.add(temp);
        }
        else {
            List<Character> charList = map.get(digits.charAt(index));
            for (Character c : charList) {
                backTrace(result, map, index + 1, digits, temp + c);
                // 使用String的话，因为每一次尝试，都使用新的字符串变量，所以无需回溯(回去temp.deleteCharAt(index))
//                backTrace(result, map, index + 1, digits, temp.append(c));
//                temp.deleteCharAt(index);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}