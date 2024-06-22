package dataStructures.trees;

public class _3_CountLeafNodes {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);
        System.out.println("Number of leaf nodes : "+ tree.countLeafNodes()); // output : 4
    }
}
