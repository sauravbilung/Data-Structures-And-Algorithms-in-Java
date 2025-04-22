package dataStructures.trees;

public class _1_TreeTraversals {

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
        System.out.print("In-order traversal: ");
        inOrderTraversal(root);  // Output: 20 30 40 50 60 70 80
        System.out.println();

        System.out.print("Pre-order traversal: ");
        preOrderTraversal(root);  // Output: 50 30 20 40 70 60 80
        System.out.println();

        System.out.print("Post-order traversal: ");
        postOrderTraversal(root);  // Output: 20 40 30 60 80 70 50
    }


    public static void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.value + " ");
            inOrderTraversal(node.right);
        }
    }

    public static void preOrderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public static void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.value + " ");
        }
    }
}


