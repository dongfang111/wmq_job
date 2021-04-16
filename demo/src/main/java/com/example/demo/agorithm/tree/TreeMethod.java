package com.example.demo.agorithm.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wmqing
 * @Date 2021/4/16 10:05
 **/
public class TreeMethod {

    public static void main(String[] args) {
        TreeNode root = init();
        //1.计算树的深度
        int height = minDepth(root);
        //2.广度优先遍历
        List<Integer> levelOrderNodes = levelOrder(root);
        System.out.println(levelOrderNodes);
    }

    /**
     * 计算二叉树的最大深度
     * 时间复杂度 o(n) 空间复杂度o(height)
     *
     * @param root 二叉树根节点
     * @return
     */
    public static final int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        return height;
    }

    /**
     * 计算二叉树的最小深度
     * 时间复杂度 o(n) 空间复杂度o(height)
     *
     * @param root 二叉树根节点
     * @return
     */
    public static final int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 1 + Math.min(minDepth(root.left), minDepth(root.right));
        return height;
    }

    public static final TreeNode init() {
        TreeNode root = new TreeNode(5);
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);

        TreeNode b6 = new TreeNode(6);
        TreeNode b7 = new TreeNode(7);
        TreeNode b8 = new TreeNode(8);
        TreeNode b9 = new TreeNode(9);

        root.left = a3;
        a3.left = a2;
        a3.right = a4;
        a2.left = a1;

        root.right = b7;
        b7.left = b6;
        b7.right = b9;
        b9.left = b8;
        return root;
    }

    /**
     * 广度优先遍历，即层序遍历
     *
     * @param root
     * @return
     */
    public static final List<Integer> levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = (TreeNode) queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return list;
    }
}
