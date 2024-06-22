package dataStructures.trees;

public class _4_CountNonLeafNodes {
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
        System.out.println("Number of non leaf nodes : "+ tree.countNonLeafNodes()); // Output = 5
    }
}
