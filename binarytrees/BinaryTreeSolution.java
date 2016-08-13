package binarytrees;

public class BinaryTreeSolution {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		/* 
        			1
    			/       \
   		       2          3
 		     /   \       /  \
		    4     5    null  null
		  /   \
		null null
*/

//		bt.preorderTraversal(bt.root);
//		bt.postorderTraversal(bt.root);
//		bt.inorderTraversal(bt.root);

		
		// With nodes in the same level coming together.
		/*
		 * 1
		 * 2 3
		 * 4 5
		 */
//		bt.levelorderTraversal(bt.root);
//		bt.levelorderTraversalUsingQueue(bt.root);
		
//		bt.inorderWithoutRecursion(bt.root);
		int size = bt.size(bt.root);
		System.out.println(size);
//		bt.printSpiralRecursive(bt.root);
//		bt.printSpiralIterative(bt.root);
	
//		System.out.println(bt.findDiameter(bt.root));
//		bt.inorderTraversal(bt.root);
//		System.out.println("Sum is " + bt.SumOfNodesInLeftSubtree(bt.root));
//		bt.inorderTraversal(bt.root);
		System.out.println(bt.checkBalanced(bt.root));
		System.out.println(bt.CheckIfBinarySearchTree(bt.root));
		bt.findPaths(bt.root, 7);
	}

}
