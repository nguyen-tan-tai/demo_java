package com.example.algorithm.leetcode.studyplan75;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-05
 * tags: java, algorithm, remove star, stack
 */
class DeleteBSTNodeTest {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 4
     * 2 7
     * 1 3
     */
    public static TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        System.out.println(root.val);
        if (root.val > val) {
            root.left = deleteNode(root.left, val);
            return root;
        }
        if (root.val < val) {
            root.right = deleteNode(root.right, val);
            return root;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode successor = root.right;
        while (successor.left != null) {
            successor = successor.left;
        }
        successor.left = root.left;
        root = root.right;
        return root;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n1 = new TreeNode(1);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n3 = new TreeNode(3);
        TreeNode n31 = new TreeNode(31);
        TreeNode n32 = new TreeNode(32);
        root.left = n2;
        root.right = n7;
        n7.left = n8;
        n2.left = n1;
        n2.right = n3;
        n1.left = n9;
        n1.right = n10;
        n3.left = n31;
        n3.right = n32;
        deleteNode(root, 2);
        assertThat(root.left.val).isEqualTo(3);
        assertThat(n3.left.val).isEqualTo(1);
    }
}
