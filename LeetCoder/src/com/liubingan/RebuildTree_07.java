package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class RebuildTree_07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return rebuildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode rebuildTree(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        TreeNode root = new TreeNode(pre[preStart]);
        int i = 0;
        for (; i < in.length; i++) {
            if (in[i] == pre[preStart]) {
                break;
            }
        }
        int leftLength = i - inStart;
        int rightLength = inEnd - i;
        if (leftLength > 0) {
            root.left = rebuildTree(pre, in, preStart + 1, preStart + leftLength, inStart, i - 1);
        }
        if (rightLength > 0) {
            root.right = rebuildTree(pre, in, preStart + leftLength + 1, preEnd, i + 1, inEnd);
        }

        return root;
    }

    
}
