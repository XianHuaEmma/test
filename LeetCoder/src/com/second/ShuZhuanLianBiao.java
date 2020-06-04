package com.second;

/**
 * @Author：liubingan
 * @date: 114
 * @描述：
 */
public class ShuZhuanLianBiao {
    public void flatten(TreeNode root) {
        //
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode leftBrach = root.left;
                while (leftBrach.right != null) {
                    leftBrach = leftBrach.right;
                }
                leftBrach.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }

}

