package dataStructures.trees;


import groovyjarjarantlr4.runtime.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private TreeNode addRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    public void inOrderTraversal() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(TreeNode node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.value + " ");
            inOrderRecursive(node.right);
        }
    }

    public void preOrderTraversal() {
        preOrderRecursive(root);
    }

    private void preOrderRecursive(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }

    public void postOrderTraversal() {
        postOrderRecursive(root);
    }

    private void postOrderRecursive(TreeNode node) {
        if (node != null) {
            postOrderRecursive(node.left);
            postOrderRecursive(node.right);
            System.out.print(node.value + " ");
        }
    }

    public void levelOrderTraversal() {

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if (node == null) {
                System.out.print("null ");
                continue;
            }

            System.out.print(node.value + " ");
            queue.add(node.left);
            queue.add(node.right);

        }
    }

    public int countNodes(){
       return countNodesRecursive(root);
    }

    private int countNodesRecursive(TreeNode node) {
        int numberOfNodes = 0;

        if(node != null) {
            int leftCount = countNodesRecursive(node.left);
            int rightCount = countNodesRecursive(node.right);
            numberOfNodes = 1 + leftCount + rightCount;
        }

        return numberOfNodes;
    }

    public int countLeafNodes(){
        return countLeafNodesRecursive(root);
    }

    private int countLeafNodesRecursive(TreeNode node) {
       int numberOfLeafNodes = 0;
       if(node != null) {
        if (node.left == null && node.right == null) {
               numberOfLeafNodes = 1;
           } else {
               numberOfLeafNodes = countLeafNodesRecursive(node.left) + countLeafNodesRecursive(node.right);
           }
       }
       return numberOfLeafNodes;
    }

    public int countNonLeafNodes(){
        return countNonLeafNodesRecursive(root);
    }

    private int countNonLeafNodesRecursive(TreeNode node) {
        int numberOfNonLeafNodes = 0;
        if (node != null) {
            if (node.left != null || node.right != null) {
                numberOfNonLeafNodes = 1;
            }
            numberOfNonLeafNodes += countNonLeafNodesRecursive(node.left);
            numberOfNonLeafNodes += countNonLeafNodesRecursive(node.right);
        }
        return numberOfNonLeafNodes;
    }

    public int countFullNodes() {
        return countFullNodesRecursive(root);
    }

    private int countFullNodesRecursive(TreeNode node) {
        int numberOfFullNodes = 0;

        if (node != null) {
            int numberOfFullNodesInLST = countFullNodesRecursive(node.left);
            int numberOFFullNodesInRST = countFullNodesRecursive(node.right);
            int isCurrentNodeAFullNode = (node.left != null && node.right != null) ? 1 : 0;
            numberOfFullNodes = isCurrentNodeAFullNode + numberOfFullNodesInLST + numberOFFullNodesInRST;
        }
        return numberOfFullNodes;
    }

    public int findHeightOfTree(){
       return findHeightOfTreeRecursive(root);
    }

    private int findHeightOfTreeRecursive(TreeNode node) {
        int heightOfTree;
        if (node == null) {
            heightOfTree = -1; // Return -1 for height of an empty tree
        } else {
            heightOfTree = 1 + Math.max(findHeightOfTreeRecursive(node.left), findHeightOfTreeRecursive(node.right));
        }
        return heightOfTree;
    }

    public boolean isCompleteBinaryTree(){
        return isCompleteBinaryTreeRecursive(root);
    }

    private boolean isCompleteBinaryTreeRecursive(TreeNode node) {
        boolean isComplete = true;
        if (node == null) {
            isComplete = true;
        } else if (node.left == null && node.right == null) {
            isComplete = true;
        } else if (node.left != null && node.right != null) {
            isComplete = isCompleteBinaryTreeRecursive(node.left) && isCompleteBinaryTreeRecursive(node.right);
        } else {
            isComplete = false;
        }

        return isComplete;
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
