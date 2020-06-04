package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 * 将左子树插入到右子树的地方
 * 将原来的右子树接到左子树的最右边节点
 * 考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
 */
public class TreeTolink_114 {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}
