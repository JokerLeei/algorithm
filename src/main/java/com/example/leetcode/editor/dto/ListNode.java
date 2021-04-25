package com.example.leetcode.editor.dto;

import lombok.Data;

/**
 * @author: lijiawei04
 * @date: 2021/4/25 3:27 下午
 */
@Data
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("args length at least 1");
        }
        ListNode result = new ListNode(args[0]);
        ListNode p = result;
        if (args.length > 1) {
            for (int i = 1; i < args.length; i++) {
                p.next = new ListNode(args[i]);
                p = p.next;
            }
        }
        return result;
    }

    public void print() {
        ListNode p = this;
        while (p != null) {
            System.out.print("[" + p.val + "]");
            p = p.next;
            if (p != null) {
                System.out.print("->");
            } else {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        node.next = new ListNode(10);
        node.next.next = new ListNode(3);

        node.print();

        ListNode node2 = ListNode.of(2, 3, 5, 7);
        node2.print();
    }

}
