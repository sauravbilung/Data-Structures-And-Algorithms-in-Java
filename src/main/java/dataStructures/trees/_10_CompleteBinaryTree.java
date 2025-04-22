package dataStructures.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A complete binary tree is a binary tree where all levels are completely filled, except possibly the last level, which is filled from left to right
 */
public class _10_CompleteBinaryTree {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(8);
        tree.add(7);
        tree.add(9);
        tree.add(12);
        tree.add(13);
        TreeNode root = tree.getRoot();
        System.out.println("Is complete binary tree : " + isCompleteBinaryTree(root)); // Output = false;
        tree.add(11);
        System.out.println("Is complete binary tree : " + isCompleteBinaryTree(root)); // Output = true;
    }

    public static boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean end = false; // Flag to indicate that we’ve seen a non-full node

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Case 1: Left child exists
            if (current.left != null) {
                if (end) return false; // After a non-full node, we shouldn't see any more children
                queue.offer(current.left);
            } else {
                end = true; // No left child means we've hit a non-full node
            }

            // Case 2: Right child exists
            if (current.right != null) {
                if (end) return false; // Again, shouldn't see a child after end is true
                queue.offer(current.right);
            } else {
                end = true; // No right child also sets the flag
            }
        }

        return true;
    }
}
