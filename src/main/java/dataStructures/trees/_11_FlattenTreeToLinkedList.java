package dataStructures.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class _11_FlattenTreeToLinkedList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("Before Flattening (Pre-order Traversal):");
        preOrderTraversal(root);
        System.out.println("End\n");

        //FlattenTreeToLLSolution solution = new FlattenTreeToLLSolution();
        FlattenTreeToLLSolution2 solution = new FlattenTreeToLLSolution2();
        solution.flatten(root);

        System.out.println("After Flattening (Right-pointer Linked List):");
        printRightLinkedList(root);
        System.out.println("End");
    }

    // Pre-order traversal to show the original structure
    private static void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.printf("%d -> ", root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static void printRightLinkedList(TreeNode root) {
        while (root != null) {
            System.out.printf("%d -> ", root.value);
            root = root.right;
        }
        System.out.println("null");
    }
}

class FlattenTreeToLLSolution {

    // Recursive preorder solution
    // Memory optimised solution
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}

class FlattenTreeToLLSolution2 {

    // stack based solution preorder traversal
    Deque<TreeNode> stack = new ArrayDeque<>();

    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode prev = null;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (prev != null) {
                prev.right = current;
                prev.left = null;
            }

            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);

            prev = current;
        }
    }
}



