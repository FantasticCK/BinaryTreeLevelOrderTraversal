package com.CK;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(7);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(4);
        TreeNode node9 = new TreeNode(8);
        TreeNode node10 = new TreeNode(9);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(4);
        TreeNode node13 = new TreeNode(9);
        TreeNode node14 = new TreeNode(8);

        root.left = node1;
        root.right = node2;
//        node1.left = node3;
//        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
//        node4.left = node9;
//        node4.right = node10;
//        node6.left = node13;
//        node6.right = node14;

        root.printTree();
        Solution solution = new Solution();
        solution.levelOrder(root);
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> resList = new ArrayList<>();
        List<TreeNode> bfArray = new ArrayList<>();
        bfArray.add(root);
        bfArray.add(null);
        traverseBF(bfArray, resList);
        return resList;
    }

    public void traverseBF(List<TreeNode> bfArray, List<List<Integer>> resList) {
        while (bfArray.size() > 1) {
            TreeNode node = this.shiftArray(bfArray);
            if (node == null) {
                resList.add(new ArrayList<>());
                bfArray.add(node);
            } else {
                if (resList.isEmpty()) {
                    resList.add(new ArrayList<>());
                    resList.get(0).add(node.val);
                } else resList.get(resList.size() - 1).add(node.val);
                if (node.left != null) bfArray.add(node.left);
                if (node.right != null) bfArray.add(node.right);
            }
            traverseBF(bfArray, resList);
        }
    }

    private TreeNode shiftArray(List<TreeNode> arr) {
        TreeNode res = new TreeNode(0);
        if (!arr.isEmpty()) {
            res = arr.get(0);
            arr.remove(0);
        }
        return res;
    }
}