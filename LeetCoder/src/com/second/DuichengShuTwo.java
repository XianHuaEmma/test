package com.second;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author：liubingan
 * @date: 101
 * @描述：
 */
public class DuichengShuTwo {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root, root);
    }

    private boolean check(TreeNode tree1, TreeNode tree2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree1);
        queue.offer(tree2);
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if (first == null && second == null) {
                continue;
            }
            if (first == null || second == null || first.val != second.val) {
                return false;
            }
            queue.offer(tree1.left);
            queue.offer(tree2.right);
            queue.offer(tree1.right);
            queue.offer(tree2.left);


        }
        return true;
    }
}
