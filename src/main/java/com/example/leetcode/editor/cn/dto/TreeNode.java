package com.example.leetcode.editor.cn.dto;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import lombok.Data;

/**
 * 二叉树结点
 *
 * @author: lijiawei04
 * @date: 2021/6/16 7:26 下午
 */
@Data
public class TreeNode {

     public int val;

     public TreeNode left;
     public TreeNode right;

     public TreeNode(int x) {
          val = x;
     }

     /**
      * 中序遍历
      */
     public static void midForEach(TreeNode root) {
          if (root != null) {
               System.out.print(root.val + " ");
               midForEach(root.left);
               midForEach(root.right);
          }
     }

     /**
      * 广度遍历
      */
     public static void BFS(TreeNode root) {
          if (root == null) {
               return;
          }

          Deque<TreeNode> queue = new LinkedList<>();
          queue.offer(root);

          while (!queue.isEmpty()) {
               List<TreeNode> pollList = new ArrayList<>();
               while (!queue.isEmpty()) {
                    pollList.add(queue.poll());
               }

               for (TreeNode p : pollList) {
                    System.out.print(p.val + " ");

                    if (p.left != null) {
                         queue.offer(p.left);
                    }
                    if (p.right != null) {
                         queue.offer(p.right);
                    }
               }

               System.out.println();
          }
     }

     /**
      * 用BFS来构造二叉树
      * null的结点也得传参数
      */
     public static TreeNode of(Integer... args) {
          if (args == null || args.length <= 0) {
               return null;
          }

          int index = 0;
          TreeNode root = new TreeNode(args[index]);
          Deque<TreeNode> queue = new LinkedList<>();
          queue.offer(root);

          while (!queue.isEmpty()) {
               TreeNode poll = queue.poll();

               if (index < args.length - 1 && args[++index] != null) {
                    poll.left = new TreeNode(args[index]);
                    queue.offer(poll.left);
               }
               if (index < args.length - 1 && args[++index] != null) {
                    poll.right = new TreeNode(args[index]);
                    queue.offer(poll.right);
               }
          }

          return root;
     }

     public static void main(String[] args) {
          TreeNode root = new TreeNode(1);
          root.left = new TreeNode(2);
          root.right = new TreeNode(3);
          root.left.right = new TreeNode(5);

          TreeNode.BFS(root);

          TreeNode.BFS(TreeNode.of(1, 2, 3, null, 5));
     }

}
