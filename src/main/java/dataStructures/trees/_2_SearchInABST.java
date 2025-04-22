package dataStructures.trees;

public class _2_SearchInABST {

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
        int search = 20;
        System.out.printf("Is %d present : %b", search, contains(root, search));
    }

    private static boolean contains(TreeNode node, int value) {

        if (node == null) return false;
        else if (node.value == value) return true;
        else return value < node.value ? contains(node.left, value) : contains(node.right, value);
    }
}
