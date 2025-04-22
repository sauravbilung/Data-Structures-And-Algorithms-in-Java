package dataStructures.trees;

public class _5_CountNonLeafNodes {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(20);
        tree.add(1);
        tree.add(18);

        TreeNode root = tree.getRoot();
        System.out.println("Number of non leaf nodes : " + countNonLeafNodes(root)); // Output = 5
    }

    private static int countNonLeafNodes(TreeNode node) {
        int numberOfNonLeafNodes = 0;
        if (node != null) {
            if (node.left != null || node.right != null) {
                numberOfNonLeafNodes = 1;
            }
            numberOfNonLeafNodes += countNonLeafNodes(node.left);
            numberOfNonLeafNodes += countNonLeafNodes(node.right);
        }
        return numberOfNonLeafNodes;
    }
}
