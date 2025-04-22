package dataStructures.trees;

/**
 * A full binary tree is a binary tree in which every node has either 0 or 2 children — never exactly one child.
 */
public class _9_FullBinaryTree {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(8);
        tree.add(7);
        tree.add(9);
        tree.add(12);
        tree.add(11);
        tree.add(13);
        TreeNode root = tree.getRoot();
        System.out.println("Is full binary tree : " + isFullBinaryTree(root)); // Output = true;
        tree.add(14);
        System.out.println("Is full binary tree : " + isFullBinaryTree(root)); // Output = false;
    }

    private static boolean isFullBinaryTree(TreeNode node) {
        boolean isFull;
        if (node == null) {
            isFull = true;
        } else if (node.left == null && node.right == null) {
            isFull = true;
        } else if (node.left != null && node.right != null) {
            isFull = isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
        } else {
            isFull = false;
        }

        return isFull;
    }
}
