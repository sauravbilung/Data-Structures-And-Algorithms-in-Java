package dataStructures.trees;

public class _6_FindHeightOfATree {
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
        System.out.println("Height of tree :"+tree.findHeightOfTree()); // Output should be 4.
    }
}
