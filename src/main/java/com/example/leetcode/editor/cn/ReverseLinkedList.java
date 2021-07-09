package com.example.leetcode.editor.cn;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 
// 👍 1828 👎 0


import com.example.leetcode.editor.cn.dto.ListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();

        ListNode head = ListNode.of(1, 2, 3, 4, 5, 6);
        ListNode.forEach(solution.reverseList(head));
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

    /**
     * 迭代 双指针
     *
     * 时间 O(n)
     * 空间 O(1)
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 递归
     * f(1 -> 2 -> 3)
     *  = f(2 -> 3) -> 1
     *  = f(3) -> 2 -> 1
     *  = 3 -> 2 -> 1
     *
     * 时间 O(n)
     * 空间 O(n)
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        // 假如就剩 头结点 & 除了头结点剩下的结点 这两部分没有转换好
        // 如：1 -> 4 -> 3 -> 2；这个视为 ListNode(1) -> ListNode(432)
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;   // 没有这一步会成环

        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}