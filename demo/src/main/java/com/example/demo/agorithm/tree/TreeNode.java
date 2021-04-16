package com.example.demo.agorithm.tree;

/**
 * 树的类结构
 *
 * @author wmqing
 * @Date 2021/4/16 9:59
 **/
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
