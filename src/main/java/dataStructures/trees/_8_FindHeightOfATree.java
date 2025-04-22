package dataStructures.trees;

public class _8_FindHeightOfATree {
    public static void main(String[] args) {
        // Height of a tree : the number of edges from the leaf node to the particular node in the longest path.
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(15);
        tree.add(10);
        tree.add(20);
        tree.add(8);
        tree.add(12);
        tree.add(17);
        tree.add(25);
        tree.add(6);
        tree.add(11);
        tree.add(16);
        tree.add(27);
        tree.add(19);
        tree.add(5);
        tree.add(30);

        TreeNode root = tree.getRoot();
        System.out.println("Height of tree : " + findHeightOfTree(root)); // Output should be 4.
    }

    /**
     * The height of a tree is the number of edges on the longest path from the root node to a leaf node.
     **/
    private static int findHeightOfTree(TreeNode node) {
        int heightOfTree;
        if (node == null) {
            heightOfTree = -1; // Return -1 for height of an empty tree
        } else {
            heightOfTree = 1 + Math.max(findHeightOfTree(node.left), findHeightOfTree(node.right));
        }
        return heightOfTree;
    }
}
