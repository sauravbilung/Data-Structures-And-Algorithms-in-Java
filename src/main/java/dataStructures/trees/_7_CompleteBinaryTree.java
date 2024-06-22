package dataStructures.trees;

public class _7_CompleteBinaryTree {
    public static void main(String[] args) {
        // Complete Binary Tree = All nodes should have 0 or complete children
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(8);
        tree.add(7);
        tree.add(9);
        tree.add(12);
        tree.add(11);
        tree.add(13);
        System.out.println("Is complete binary tree : "+tree.isCompleteBinaryTree()); // Output = true;
        tree.add(14);
        System.out.println("Is complete binary tree :"+tree.isCompleteBinaryTree()); // Output = false;
    }
}
