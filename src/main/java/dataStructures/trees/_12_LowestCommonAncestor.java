package dataStructures.trees;

/**
 * In a BST, the Lowest Common Ancestor (LCA) of two nodes is the lowest node in the tree where one node lies in the left subtree
 * and the other in the right, or one of them is the node itself.
 */
public class _12_LowestCommonAncestor {

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
        System.out.printf("LCA of %d and %d is : %d", 7, 9, lowestCommonAncestor(root, 7, 9).value);
        System.out.printf("\nLCA of %d and %d is : %d", 11, 13, lowestCommonAncestor(root, 11, 13).value);
        System.out.printf("\nLCA of %d and %d is : %d", 11, 12, lowestCommonAncestor(root, 11, 12).value);
    }

    private static TreeNode lowestCommonAncestor(TreeNode node, int num1, int num2) {
        if (node == null) return null;

        if (num1 < node.value && num2 < node.value) return lowestCommonAncestor(node.left, num1, num2);
        if (num1 > node.value && num2 > node.value) return lowestCommonAncestor(node.right, num1, num2);

        return node;
    }
}
