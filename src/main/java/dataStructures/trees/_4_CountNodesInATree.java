package dataStructures.trees;

public class _4_CountNodesInATree {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(56);
        tree.add(40);
        tree.add(60);
        tree.add(80);
        TreeNode root = tree.getRoot();
        System.out.println("Number of nodes in the tree: " + countNodes(root));  // Output: 8
    }

    private static int countNodes(TreeNode node) {
        int numberOfNodes = 0;

        if (node != null) {
            int leftCount = countNodes(node.left);
            int rightCount = countNodes(node.right);
            numberOfNodes = 1 + leftCount + rightCount;
        }

        return numberOfNodes;
    }
}


