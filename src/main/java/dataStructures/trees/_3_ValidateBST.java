package dataStructures.trees;

public class _3_ValidateBST {

    public static void main(String[] args) {
        TreeNode validBST = new TreeNode(10);
        validBST.left = new TreeNode(5);
        validBST.right = new TreeNode(15);
        validBST.left.left = new TreeNode(3);
        validBST.left.right = new TreeNode(7);
        validBST.right.left = new TreeNode(12);
        validBST.right.right = new TreeNode(18);


        TreeNode invalidBST = new TreeNode(10);
        invalidBST.left = new TreeNode(5);
        invalidBST.right = new TreeNode(15);
        invalidBST.left.left = new TreeNode(3);
        invalidBST.left.right = new TreeNode(12); // ❌ This violates the BST rule
        invalidBST.right.right = new TreeNode(20);

        System.out.printf("Is valid bst : %b", isValidBST(validBST, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.printf("\nIs valid bst : %b", isValidBST(invalidBST, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static boolean isValidBST(TreeNode node, int min, int max) {
        if (node == null) return true;
        else if (node.value <= min || node.value >= max) return false;
        else return isValidBST(node.left, min, node.value) && isValidBST(node.right, node.value, max);
    }
}
