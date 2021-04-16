package com.example.demo.list;

import java.util.*;

/**
 * 树 数据结构
 * MPQ/2020/11/24
 */
public class TreeNode {
    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
//        root.preOrder(root);
        root.getNodeCount(root);
    }

    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * 默认数组
     */
    private final static int[] ARRS = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    /**
     * 默认初始化创建二叉树-不带零
     *
     * @return
     */
    public static TreeNode init() {
        if (ARRS == null || ARRS.length == 0) {
            return new TreeNode();
        }
        List<TreeNode> nodes = new ArrayList<>(ARRS.length);
        for (int v : ARRS) {
            TreeNode treeNode = new TreeNode();
            treeNode.data = v;
            nodes.add(treeNode);
        }
        for (int i = 0; i < ARRS.length / 2 - 1; i++) {
            TreeNode node = nodes.get(i);
            node.left = nodes.get(i * 2 + 1);
            node.right = nodes.get(i * 2 + 2);
        }
        // 只有当总节点数是奇数时，最后一个父节点才有右子节点
        int lastPNodeIndex = ARRS.length / 2 - 1;
        TreeNode lastPNode = nodes.get(lastPNodeIndex);
        lastPNode.left = nodes.get(lastPNodeIndex * 2 + 1);
        if (ARRS.length % 2 != 0) {
            lastPNode.right = nodes.get(lastPNodeIndex * 2 + 2);
        }
        return nodes.get(0);
    }

    /**
     * 根据数组创建二叉树-不带零
     *
     * @param arrs
     * @return
     */
    public static TreeNode createTree(int[] arrs) {
        if (arrs == null || arrs.length == 0) {
            return new TreeNode();
        }
        List<TreeNode> nodes = new ArrayList<>(arrs.length);
        for (int v : arrs) {
            TreeNode treeNode = new TreeNode();
            treeNode.data = v;
            nodes.add(treeNode);
        }
        for (int i = 0; i < arrs.length / 2 - 1; i++) {
            TreeNode node = nodes.get(i);
            node.left = nodes.get(i * 2 + 1);
            node.right = nodes.get(i * 2 + 2);
        }
        // 只有当总节点数是奇数时，最后一个父节点才有右子节点
        int lastPNodeIndex = arrs.length / 2 - 1;
        TreeNode lastPNode = nodes.get(lastPNodeIndex);
        lastPNode.left = nodes.get(lastPNodeIndex * 2 + 1);
        if (arrs.length % 2 != 0) {
            lastPNode.right = nodes.get(lastPNodeIndex * 2 + 2);
        }
        return nodes.get(0);
    }

    /**
     * 递归-先序遍历
     *
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 实现思路，首先需要先从栈顶取出节点，然后访问该节点，如果该节点不为空，则访问该节点，
     * 同时把该节点的右子树先入栈，然后左子树入栈。
     * 循环结束的条件是栈中不在有节点。即 !s.empty()
     *
     * @param root
     */
    public void preOrderStack(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode p = null;
        while (!s.empty()) {
            p = s.pop();
            if (p != null) {
                System.out.print(p.data + " ");
                s.push(p.right);
                s.push(p.left);
            }
        }
    }

    /**
     * 递归-中序遍历
     *
     * @param root
     */
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        System.out.print(root.data + " ");
        preOrder(root.right);
    }

    /**
     * 实现思路，中序遍历是要先遍历左子树，然后跟节点，最后遍历右子树。所以需要先把跟节点入栈然后在一直把左子树入栈
     * 直到左子树为空，此时停止入栈。栈顶节点就是我们需要访问的节点，取栈顶节点p并访问。然后该节点可能有右子树，所以
     * 访问完节点p后还要判断p的右子树是否为空，如果为空则接下来要访问的节点在栈顶，所以将p赋值为null。如果不为空则
     * 将p赋值为其右子树的值。 循环结束的条件是p不为空或者栈不为空。
     *
     * @param root
     */
    public void inOrderStack(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        do {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            System.out.print(p.data + " ");
            if (p.right != null) {
                p = p.right;
            } else p = null;
        } while (p != null || !s.empty());
    }

    /**
     * 递归-后序遍历
     *
     * @param root
     */
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    /**
     * 实现思路，在进行后序遍历的时候是先要遍历左子树，然后在遍历右子树，最后才遍历根节点。所以在非递归的实现中要先把根节点入栈
     * 然后再把左子树入栈直到左子树为空，此时停止入栈。此时栈顶就是需要访问的元素，所以直接取出访问p。在访问结束后，还要判断被访
     * 问的节点p是否为栈顶节点的左子树，如果是的话那么还需要访问栈顶节点的右子树，所以将栈顶节点的右子树取出赋值给p。如果不是的
     * 话则说明栈顶节点的右子树已经访问完了，那么现在可以访问栈顶节点了，所以此时将p赋值为null。判断结束的条件是p不为空或者栈
     * 不为空，若果两个条件都不满足的话，说明所有节点都已经访问完成。
     *
     * @param root
     */
    public void postOrderStack(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null || !s.empty()) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            System.out.print(p.data + " ");
            //这里需要判断一下，当前p是否为栈顶的左子树，如果是的话那么还需要先访问右子树才能访问根节点
            //如果已经是不是左子树的话，那么说明左右子书都已经访问完毕，可以访问根节点了，所以讲p复制为NULL
            //取根节点
            if (!s.empty() && p == s.peek().left) {
                p = s.peek().right;
            } else p = null;
        }
    }

    /**
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public void BFS(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.print(treeNode.data + " ");
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
    }

    /**
     * 获取节点个数
     *
     * @param root
     * @return
     */
    public int getNodeCount(TreeNode root) {//获取某个结点构成的子树的结点总数
        if (root == null) {
            return 0;
        }
        return 1 + getNodeCount(root.left) + getNodeCount(root.right);
    }

    /**
     * 获取树的深度
     *
     * @param root
     * @return
     */
    public int getHeight(TreeNode root) {//某结点构成的子树
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    /**
     * 获取当前节点的父节点
     *
     * @param start   二叉树
     * @param current 当前节点
     * @return
     */
    public TreeNode getParent(TreeNode start, TreeNode current) {
        if (start == null) {
            return null;
        }
        if (start.left == current || start.right == current)
            return start;
        TreeNode p;
        if ((p = getParent(start.left, current)) != null) {
            return p;
        } else {
            return getParent(start.right, current);
        }
    }
}
