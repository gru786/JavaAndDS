package BinaryTrees;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BinaryTree {

    public static BinaryTreeNode<Integer> takeInputLevelOrder(){
        System.out.println("Enter the root");
        Scanner sc = new Scanner(System.in);
        int rootData = sc.nextInt();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();
        pendingChildren.add(root);
        while(!pendingChildren.isEmpty()){
            BinaryTreeNode<Integer> current = pendingChildren.remove();
            System.out.println("Enter the left child of :" + current.data);
            int leftData = sc.nextInt();

            if(leftData != -1){
                BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(leftData);
                current.left = left;
                pendingChildren.add(left);
            }

            System.out.println("Enter the right child of :" + current.data);
            int rightData = sc.nextInt();

            if(rightData != -1){
                BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(rightData);
                current.right = right;
                pendingChildren.add(right);
            }
        }
        return root;
    }


    public static BinaryTreeNode<Integer> takeInput(boolean isRoot, int parentData, boolean isLeft){
        if(isRoot){
            // TODO:
            System.out.println("Enter the root of the tree:");
        }
        else{
            if(isLeft){
                System.out.println("Enter the left child of " + parentData);
            }
            else{
                System.out.println("Enter the right child of " + parentData);
            }

        }
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if(data == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);

        BinaryTreeNode<Integer> rootLeft = takeInput(false, root.data, true);
        BinaryTreeNode<Integer> rootRight = takeInput(false, root.data, false);
        root.left = rootLeft;
        root.right = rootRight;
        return root;


    }
    public static void main(String[] args){
        // BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(10);
        // root.data = 10;

        // BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<Integer>(8);
        // BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<Integer>(14);
        // root.left = rootLeft;
        // root.right = rootRight;

        // BinaryTreeNode<Integer> rootLeftLeft = new BinaryTreeNode<Integer>(4);
        // BinaryTreeNode<Integer> rootLeftRight = new BinaryTreeNode<Integer>(9);
        // BinaryTreeNode<Integer> rootRightLeft = new BinaryTreeNode<Integer>(11);
        // BinaryTreeNode<Integer> rootRightRight = new BinaryTreeNode<Integer>(16);
        // rootLeft.left = rootLeftLeft;
        // rootLeft.right = rootLeftRight;
        // rootRight.left = rootRightLeft;
        // rootRight.right = rootRightRight;
        // BinaryTreeNode<Integer> root = takeInput(true, 1, false);
        BinaryTreeNode<Integer> root = takeInputLevelOrder();
        printBinaryTree(root);
        System.out.println("Number of Nodes are: " + numOfNodes(root));
        System.out.println("Largest node is: " + findLargest(root));
        System.out.println("Number of Leaf Nodes are: " + numOfLeafNodes(root));


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

    public static int numOfNodes(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int rootLeftCount = numOfNodes(root.left);
        int rootRightCount = numOfNodes(root.right);
        return 1+ rootLeftCount + rootRightCount;
    }

    public static int findLargest(BinaryTreeNode<Integer> root){
        if(root == null){
            return -1;
        }
        int leftLargest = findLargest(root.left);
        int rightLargest = findLargest(root.right);
        return Math.max(root.data, Math.max(leftLargest, rightLargest));
    }

    public static int numOfLeafNodes(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
         
        return numOfLeafNodes(root.left) + numOfLeafNodes(root.right);
    }

    
}
