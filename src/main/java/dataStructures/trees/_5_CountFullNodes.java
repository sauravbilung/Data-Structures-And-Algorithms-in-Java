package dataStructures.trees;

public class _5_CountFullNodes {
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
        System.out.println("Number of full nodes : "+ tree.countFullNodes()); // Output = 4;
    }
}
