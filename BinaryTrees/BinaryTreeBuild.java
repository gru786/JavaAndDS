package BinaryTrees;

public class BinaryTreeBuild {
 
    
    public static void main(String[] args){
        int[] inOrder  = {4,2,5,1,3};
        int[] postOrder = {4,5,2,3,1};

        BinaryTreeNode<Integer> root = buildTree(postOrder, inOrder);
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
    public static BinaryTreeNode<Integer> buildTreeHelper(int[] postOrder, int siPo, int eiPo, int[] inOrder, int siIn, int eiIn){
        if(eiPo < siPo){
            return null;
        }
        int rootData = postOrder[eiPo];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        int rootIndex  = -1;
        for(int i= siIn; i <= eiIn; i++){
            if(rootData == inOrder[i]){
                rootIndex = i;
                break;
            }
        }
        if(rootIndex == -1){
            return null;
        }
        int leftInSi = siIn;
        int leftInEi = rootIndex - 1;
        int rightInSi = rootIndex +1;
        int rightInEi = eiIn;
        
        int leftInLength = leftInEi - leftInSi +1;
        
        int leftPoSi = siPo;
        int leftPoEi = leftInLength - 1;
        int rightPoSi = leftPoEi +1;
        int rightPoEi = eiPo -1;
        
        BinaryTreeNode<Integer> leftSubTree = buildTreeHelper(postOrder,leftPoSi, leftPoEi, inOrder, leftInSi, leftInEi);
        BinaryTreeNode<Integer> rightSubTree =buildTreeHelper(postOrder,rightPoSi, rightPoEi, inOrder, rightInSi, rightInEi);
        root.left = leftSubTree;
        root.right = rightSubTree;
        
        return root;
    }
    

	public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
		//Your code goes here
        BinaryTreeNode<Integer> root = buildTreeHelper(postOrder, 0, postOrder.length - 1, inOrder, 0, inOrder.length-1);
        return root;
	}

}

