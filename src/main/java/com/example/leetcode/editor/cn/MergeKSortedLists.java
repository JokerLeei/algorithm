package com.example.leetcode.editor.cn;

//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//
//
// 示例 1：
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//
//
// 示例 2：
//
// 输入：lists = []
//输出：[]
//
//
// 示例 3：
//
// 输入：lists = [[]]
//输出：[]
//
//
//
//
// 提示：
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] 按 升序 排列
// lists[i].length 的总和不超过 10^4
//
// Related Topics 链表 分治 堆（优先队列） 归并排序
// 👍 1364 👎 0


import com.example.leetcode.editor.cn.dto.ListNode;

public class MergeKSortedLists {

    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        ListNode l1 = ListNode.of(1, 4, 5);
        ListNode l2 = ListNode.of(1, 3, 4);
        ListNode l3 = ListNode.of(2, 6);

//        ListNode.forEach(solution.merge2Lists(l1, l3));

        ListNode[] lists = new ListNode[] { l1, l2, l3 };
        ListNode.forEach(solution.mergeKLists(lists));
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

    // 按顺序两两合并 lists[0]和lists[1]合并，得到的结果再和lists[2]合并······
    // 时间复杂度(n * k^2)
    // 空间复杂度(1)
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0) {
//            return null;
//        }
//        if (lists.length == 1) {
//            return lists[0];
//        }
//
//        ListNode pre = lists[0];
//        int index = 1;
//        while (index < lists.length) {
//            pre = merge2Lists(pre, lists[index++]);
//        }
//        return pre;
//    }

    // 归并排序的方式 两两合并
    // 时间复杂度(n * k * logk)
    // 空间复杂度(递归使用 logk 的栈空间)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int mid = (left + right) >> 1;
        ListNode leftList = mergeKLists(lists, left, mid);
        ListNode rightList = mergeKLists(lists, mid + 1, right);
        return merge2Lists(leftList, rightList);
    }

    // 迭代 合并两个链表
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode p = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            }
            else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        // 合并完之后最多还有一个结点没合并
        p.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    // 递归合并两个链表
//    public ListNode merge2Lists(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//        if (l1.val < l2.val) {
//            l1.next = merge2Lists(l1.next, l2);
//            return l1;
//        }
//        else {
//            l2.next = merge2Lists(l1, l2.next);
//            return l2;
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}