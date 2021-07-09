package com.example.leetcode.editor.cn;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1407 👎 0


import com.example.leetcode.editor.cn.dto.ListNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode root = ListNode.of(1, 2, 3, 4, 5);

        ListNode.forEach(root);
        ListNode.forEach(solution.removeNthFromEnd(root, 2));
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

    // 遍历第一次算长度，第二次删节点
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }

        if (length == 1) {
            return null;
        }

        ListNode temp = new ListNode(0, head);
        ListNode q = temp;
        for (int i = 0; i < length - n; i++) {
            q = q.next;
        }
        q.next = q.next.next;

        return temp.next;
    }

    // 骚操作 HashMap
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode p = head;
        int index = 0;
        while (p != null) {
            map.put(index, p);
            p = p.next;
            index++;
        }

        // 1 -> 2 -> 3 -> 4 -> 5
        // 0    1    2    3    4
        ListNode pre = map.get(index - n - 1);
        if (pre == null) {
            // 如果删的是第一个
            return head.next;
        } else {
            pre.next = pre.next.next;
        }
        return head;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}