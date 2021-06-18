package com.example.leetcode.editor.cn.dto;

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

}
