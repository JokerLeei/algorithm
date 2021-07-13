package com.example.leetcode.editor.cn;

//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 
// 👍 115 👎 0


import com.example.leetcode.editor.cn.dto.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CongShangDaoXiaDaYinErChaShuIiLcof {

    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
        /*
               1
              /  \
              2   3
               \   \
                5   7
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(solution.levelOrder(root));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> pollList = new ArrayList<>();
            while (!queue.isEmpty()) {
                pollList.add(queue.poll());
            }

            result.add(pollList.stream().map(t -> t.val).collect(Collectors.toList()));

            for (TreeNode node : pollList) {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}