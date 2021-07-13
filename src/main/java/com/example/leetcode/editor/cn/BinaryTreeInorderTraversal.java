package com.example.leetcode.editor.cn;

//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 1004 👎 0


import com.example.leetcode.editor.cn.dto.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
        TreeNode t1 = TreeNode.of(1, null, 2, 3);
        System.out.println(solution.inorderTraversal(t1));  // [1, 3, 2]

        TreeNode t2 = TreeNode.of((Integer[]) null);
        System.out.println(solution.inorderTraversal(t2));  // []

        TreeNode t3 = TreeNode.of(1, 2);
        System.out.println(solution.inorderTraversal(t3));  // [2, 1]

        TreeNode t4 = TreeNode.of(1, null, 2);
        System.out.println(solution.inorderTraversal(t4));  // [1, 2]
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    /**
     * 左 -> 根 -> 右
     *
     * 迭代(显式栈)
     *
     * 时间O(n)
     * 空间O(n)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        // 和前序遍历不同，循环之前不需要压入根结点
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            // 按顺序尽可能压入左结点，循环结束之后栈顶结点即为最左结点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }

    /**
     * 递归(隐式栈)
     *
     * 时间 O(n)
     * 空间 O(n)
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        inorderTraversal(root, res);

        return res;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}