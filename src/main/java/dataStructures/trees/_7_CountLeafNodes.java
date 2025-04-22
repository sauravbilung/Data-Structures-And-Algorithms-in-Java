package dataStructures.trees;

public class _7_CountLeafNodes {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);
        TreeNode root = tree.getRoot();
        System.out.println("Number of leaf nodes : " + countLeafNodes(root)); // output : 4
    }


    private static int countLeafNodes(TreeNode node) {
        int numberOfLeafNodes = 0;
        if (node != null) {
            if (node.left == null && node.right == null) {
                numberOfLeafNodes = 1;
            } else {
                numberOfLeafNodes = countLeafNodes(node.left) + countLeafNodes(node.right);
            }
        }
        return numberOfLeafNodes;
    }
}
