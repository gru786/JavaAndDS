package BinaryTrees;

public class BinaryTree {
    public static void main(String[] args){
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(10);
        root.data = 10;

        BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<Integer>(8);
        BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<Integer>(14);
        root.left = rootLeft;
        root.right = rootRight;

        BinaryTreeNode<Integer> rootLeftLeft = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> rootLeftRight = new BinaryTreeNode<Integer>(9);
        BinaryTreeNode<Integer> rootRightLeft = new BinaryTreeNode<Integer>(11);
        BinaryTreeNode<Integer> rootRightRight = new BinaryTreeNode<Integer>(16);
        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;
        rootRight.left = rootRightLeft;
        rootRight.right = rootRightRight;

        printBinaryTree(root);


    }
    
    public static void printBinaryTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " : ");
        if(root.left != null){
            System.out.print("L" + root.left.data);
        }
        if(root.right != null){
            System.out.print(", R" + root.right.data);
        }
        System.out.println();

        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }
}
