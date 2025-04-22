package dataStructures.trees;

public class _6_CountFullNodes {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);
        tree.add(10);
        tree.add(25);
        tree.add(55);
        tree.add(85);
        tree.add(27);
        tree.add(83);

        TreeNode root = tree.getRoot();
        System.out.println("Number of full nodes : " + countFullNodes(root)); // Output = 4;
    }


    private static int countFullNodes(TreeNode node) {
        int numberOfFullNodes = 0;

        if (node != null) {
            int numberOfFullNodesInLST = countFullNodes(node.left);
            int numberOFFullNodesInRST = countFullNodes(node.right);
            int isCurrentNodeAFullNode = (node.left != null && node.right != null) ? 1 : 0;
            numberOfFullNodes = isCurrentNodeAFullNode + numberOfFullNodesInLST + numberOFFullNodesInRST;
        }
        return numberOfFullNodes;
    }
}
