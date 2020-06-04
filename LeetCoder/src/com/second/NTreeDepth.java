package com.second;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：liubingan
 * @date: 559
 * @描述：
 */
public class NTreeDepth {
    public static void main(String[] args) {
        NTreeDepth depth = new NTreeDepth();
        List<Node> children = new ArrayList<>();
        List<Node> children2 = new ArrayList<>();
        Node node11 = new Node(5, null);
        Node node12 = new Node(6, null);
        children2.add(node11);
        children2.add(node12);
        Node node1 = new Node(3, children2);
        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);
        children.add(node1);
        children.add(node2);
        children.add(node4);
        Node root = new Node(1, children);
        System.out.println(depth.maxDepth(root));
    }

    public int maxDepth(Node root) {
        int max = Integer.MIN_VALUE;
        if (root == null) {
            return 0;
        }
        if (root.children == null) {
            return 1;
        }
        for (Node node : root.children) {
            int cur = 1;
            cur += maxDepth(node);
            max = Math.max(cur, max);
        }
        return max;

    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
