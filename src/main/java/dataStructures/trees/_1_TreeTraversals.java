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

        System.out.print("In-order traversal: ");
        tree.inOrderTraversal();  // Output: 20 30 40 50 60 70 80
        System.out.println();

        System.out.print("Pre-order traversal: ");
        tree.preOrderTraversal();  // Output: 50 30 20 40 70 60 80
        System.out.println();

        System.out.print("Post-order traversal: ");
        tree.postOrderTraversal();  // Output: 20 40 30 60 80 70 50
    }
}


