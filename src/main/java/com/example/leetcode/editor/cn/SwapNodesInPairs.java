package com.example.leetcode.editor.cn;

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 955 👎 0


import com.example.leetcode.editor.cn.dto.ListNode;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        ListNode root = ListNode.of(1, 2, 3, 4, 5);

        ListNode.forEach(root);
        // 原始链表第二个结点会变成新链表首结点，先存个引用，方便最后验证
        ListNode newHead = root.next;
        solution.swapPairs(root);
        ListNode.forEach(newHead);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // 递归大法
    // func(1 -> 2 -> 3 -> 4 -> 5)
    // 2 -> 1 -> func(3 -> 4 -> 5)
    // 2 -> 1 -> 4 -> 3 -> func(5)
    // 2 -> 1 -> 4 -> 3 -> 5
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 原始链表第一个结点为新链表的第二个节点，它的next是原始链表的next及之后已经交换完的，即swapPairs(原第二个结点.next)
        // 原始链表第二个结为为新链表的第一个节点，它的next是原始链表的首结点
        ListNode next = head.next;
        ListNode next_next = next.next;
        next.next = head;
        head.next = swapPairs(next_next);

        return next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}