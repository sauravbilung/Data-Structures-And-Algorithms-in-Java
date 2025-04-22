package dataStructures.trees;

public class _13_DeleteANodeInBST {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(8);
        tree.add(7);
        tree.add(9);
        tree.add(12);
        tree.add(11);
        tree.add(13);
        tree.add(5);
        tree.add(14);
        TreeNode root = tree.getRoot();
        System.out.println("Before :");
        _1_TreeTraversals.preOrderTraversal(root);
        int deleteVal = 10;
        delete(root, deleteVal);
        System.out.printf("\n%d deleted", deleteVal);
        System.out.println("\nAfter : ");
        _1_TreeTraversals.preOrderTraversal(root);
    }


    private static TreeNode delete(TreeNode node, int value) {
        if (node == null) return null;

        if (value < node.value)
            node.left = delete(node.left, value);
        else if (value > node.value)
            node.right = delete(node.right, value);
        else {
            // Node with only one child or no child
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;

            // Node with two children: get the inorder successor
            node.value = findMin(node.right);
            node.right = delete(node.right, node.value);
        }
        return node;
    }

    private static int findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

}
