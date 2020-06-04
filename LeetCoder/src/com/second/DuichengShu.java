package com.second;

import sun.reflect.generics.tree.Tree;

/**
 * @Author：liubingan
 * @date: 101
 * @描述：
 */
public class DuichengShu {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return false;
        }
        return check(root,root);

    }
    private boolean check(TreeNode tree1, TreeNode tree2){
        if(tree1==null &&tree2==null){
            return true;
        }
        if(tree1==null||tree2==null){
            return false;
        }
        return tree1.val==tree2.val&&check(tree1.left,tree2.right)&&check(tree1.right,tree2.left);
    }
}
