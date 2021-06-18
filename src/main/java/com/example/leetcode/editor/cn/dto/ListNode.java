package com.example.leetcode.editor.cn.dto;

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
        ListNode preHead = new ListNode(-1);
        ListNode p = preHead;
        for (int arg : args) {
            p.next = new ListNode(arg);
            p = p.next;
        }
        return preHead.next;
    }

    public void print() {
        ListNode p = this;
        while (p != null) {
            System.out.print("[" + p.val + "]");
            p = p.next;
            if (p != null) {
                System.out.print("=>");
            }
        }
    }

    public static void forEach(ListNode root) {
        ListNode p = root;
        while (p != null) {
            System.out.print("[" + p.val + "]");
            p = p.next;
            if (p != null) {
                System.out.print("=>");
            } else {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        ListNode node2 = new ListNode(10);
        ListNode node3 = new ListNode(3);

        node.next = node2;
        node2.next = node3;

        node.print();
        reverse(node);
        node3.print();


//        ListNode $node = ListNode.of(2, 3, 5, 7);
//        $node.print();
    }

    public static void reverse(ListNode root) {
        ListNode pre = null;
        ListNode next = null;

        while (root != null) {
            next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }
    }

}
