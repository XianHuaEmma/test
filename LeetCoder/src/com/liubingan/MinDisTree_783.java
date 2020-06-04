package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class MinDisTree_783 {
    TreeNode pre = null;

    public int minDiffInBST(TreeNode root) {

        int min = Integer.MAX_VALUE;

        if (root.left != null) {
            min = Math.min(minDiffInBST(root.left), min);
        }
        if (root == null || pre == null) {
            min = Integer.MAX_VALUE;
        } else {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;

        if (root.right != null) {
            min = Math.min(minDiffInBST(root.right), min);
        }

        return min;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
