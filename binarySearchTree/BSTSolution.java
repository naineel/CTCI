package binarySearchTree;

import binarySearchTree.BinarySearchTree;
import binarySearchTree.Node;

public class BSTSolution {

	public static void main(String[] args) {
		BinarySearchTree bt = new BinarySearchTree(50);
		bt.root.left = new Node(30);
		bt.root.right = new Node(70);
		bt.root.left.left = new Node(20);
		bt.root.left.right = new Node(40);
		bt.root.right.left = new Node(60);
		bt.root.right.right = new Node(80);
		
		bt.inorderTraversal(bt.root);
		bt.delete(bt.root, 50);
		System.out.println("Modified tree: ");
		bt.inorderTraversal(bt.root);
	}

}
