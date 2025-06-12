package com.example.algorithm.leetcode.studyplan75;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-05
 * tags: java, algorithm, remove star, stack
 */
class BinarySearchTreeTest {
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

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.val = 4;
        TreeNode n2 = new TreeNode(1);
        n2.val = 2;
        TreeNode n7 = new TreeNode(1);
        n7.val = 7;
        TreeNode n1 = new TreeNode(1);
        n1.val = 1;
        TreeNode n3 = new TreeNode(1);
        n3.val = 3;
        root.left = n2;
        root.right = n7;
        n2.left = n1;
        n2.right = n3;

        TreeNode r = searchBST(root, 2);
        assertThat(r.val).isEqualTo(2);
        assertThat(r.left.val).isEqualTo(1);
        assertThat(r.right.val).isEqualTo(3);
    }
}
