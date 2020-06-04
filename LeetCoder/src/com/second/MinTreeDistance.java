package com.second;

/**
 * @Author：liubingan
 * @date: 783
 * @描述：
 */
public class MinTreeDistance {
    private int min = Integer.MAX_VALUE;
    private int second = Integer.MAX_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        MinTreeDistance minTree = new MinTreeDistance();
        System.out.println(minTree.minDiffInBST(root));
    }

    public int minDiffInBST(TreeNode root) {
        minAndSecond(root);
        return min;
    }

    private void minAndSecond(TreeNode root) {
//        if(root != null){
//            if(root.val<min){
//                second = min;
//                min = root.val;
//            } else if(min<root.val){
//                second = second>root.val?root.val:second;
//            }
//        }
//        if(root.right!=null){
//            minAndSecond( root.right);
//        }
//        if(root.left!=null){
//            minAndSecond( root.left);
//        }
        if(root.right!=null){
            min = Math.min(min,root.right.val-root.val);
            minAndSecond( root.right);
        }
        if(root.left!=null){
            min = Math.min(min,root.val-root.left.val);
            minAndSecond( root.left);
        }

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
