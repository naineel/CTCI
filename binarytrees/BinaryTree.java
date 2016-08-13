package binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	Node root;

	public BinaryTree(int data) {
		root = new Node(data);
	}

	public BinaryTree() {
		root = null;
	}

	public void preorderTraversal(Node rootNode) {
		if (rootNode == null)
			return;
		System.out.println("The data is " + rootNode.data);
		preorderTraversal(rootNode.left);
		preorderTraversal(rootNode.right);
	}

	public void postorderTraversal(Node rootNode) {
		if (rootNode == null)
			return;
		postorderTraversal(rootNode.left);
		postorderTraversal(rootNode.right);
		System.out.println("The data is " + rootNode.data);
	}

	public void inorderTraversal(Node rootNode) {
		if (rootNode == null)
			return;
		inorderTraversal(rootNode.left);
		System.out.println("The data is " + rootNode.data);
		inorderTraversal(rootNode.right);

	}

	public void levelorderTraversal(Node rootNode) {
		int height = height(rootNode);
		int i;
		for (i = 1; i <= height; i++) {
			printlevel(rootNode, i);
			System.out.println();
		}
	}

	private void printlevel(Node rootNode, int i) {
		if (rootNode == null) {
			return;
		}
		if (i == 1) {
			System.out.print("Data is " + rootNode.data + " ");
		} else {
			// i-1 is very important
			printlevel(rootNode.left, i - 1);
			printlevel(rootNode.right, i - 1);
		}

	}

//	/* The better implementation of height is =
//	 * static int height(Node node)
//    {
//        /* base case tree is empty */
//        if (node == null)
//            return 0;
// 
//        /* If tree is not empty then height = 1 + max of left
//           height and right heights */
//        return (1 + Math.max(height(node.left), height(node.right)));
//    }
	 
	private int height(Node rootNode) {
		if (rootNode == null) {
			return 0;
		} else {
			int hleft = height(rootNode.left);
			int hright = height(rootNode.right);
			if (hleft > hright) {
				// Plus 1 is the most important step!!!
				return hleft + 1;
			} else {
				return hright + 1;
			}
		}
	}
	
	

	public void levelorderTraversalUsingQueue(Node rootNode) {
		if (rootNode == null) return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(rootNode);
		while (!q.isEmpty()) {
			int nodeCount = q.size();
			if (nodeCount == 0) {
				break;
			}
			
			while (nodeCount > 0) {
				Node temp = q.poll();
				System.out.print(temp.data + " ");

				if (temp.left != null) {
					q.add(temp.left);
				}

				if (temp.right != null) {
					q.add(temp.right);
				}
				nodeCount--;
			}
			System.out.println();
		}
	}

	public void inorderWithoutRecursion(Node rootNode) {
		if (rootNode == null) return;
		
		Stack<Node> s = new Stack<Node>();
		Node current = rootNode;
		
		while (current != null) {
			s.push(current);
			current = current.left;
		}
		
		while (s.size() > 0) {
			
			current = s.pop();
			System.out.println(current.data + "");
			
			if (current.right != null) {
				current = current.right;
				
				while (current != null) {
					s.push(current);
					current = current.left;
				}
			}
			
		}
		
	}
	
	public int size(Node rootNode) {
		if (rootNode == null) {
			return 0;
		} else {
			int leftSize = size(rootNode.left);
			int rightSize = size(rootNode.right);
			
			//Don't forget +1
			return leftSize + rightSize + 1;
		}
	}
	
	public void printSpiralRecursive(Node rootNode) {
		boolean flagBit = false;
		int height = height(rootNode);
		for (int i=1; i <= height; i++) {
			printLevelForSpiralRecursive(i, rootNode, flagBit);
			flagBit = !flagBit;
		}
	}

	private void printLevelForSpiralRecursive(int i, Node rootNode, boolean flagBit) {
		if (rootNode == null) {
			return;
		}
		
		if (i == 1) {
			System.out.println("The data is " + rootNode.data);
		} else if (i > 1) {
			if (flagBit) {
				printLevelForSpiralRecursive(i-1, rootNode.left, flagBit);
				printLevelForSpiralRecursive(i-1, rootNode.right, flagBit);
			} else {
				printLevelForSpiralRecursive(i-1, rootNode.right, flagBit);
				printLevelForSpiralRecursive(i-1, rootNode.left, flagBit);
			}
		}
		
	}
	
	public void printSpiralIterative(Node rootNode) {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		
		s1.push(rootNode);
		
		while (!s1.empty() || !s2.empty()) {
			
			while (!s1.empty()) {
				Node temp = s1.pop();
				System.out.println(temp.data);
				if (temp.right != null)
					s2.push(temp.right);
				if (temp.left != null)
					s2.push(temp.left);
			} 
			
			while (!s2.empty()) 
			{
				Node temp = s2.pop();
				System.out.println(temp.data);
				if (temp.left != null)
					s1.push(temp.left);
				if (temp.right != null)
					s1.push(temp.right);
			
			}
		}
	}

	// Complexity - O(n*n)
	public int findDiameter(Node rootNode) {
		if (rootNode == null) return 0;
		
		int lheight = height(rootNode.left);
		int rheight = height(rootNode.right);
		
		int ldiameter = findDiameter(rootNode.left);
		int rdiameter = findDiameter(rootNode.right);
		
		return Math.max(1 + lheight + rheight, Math.max(ldiameter ,rdiameter));
	}
	
	public int SumOfNodesInLeftSubtree(Node rootNode) {
		if (rootNode == null) {
			return 0;
		}
		
		if (rootNode.left == null && rootNode.right == null) {
			return rootNode.data;
		}
		
		int leftsum = SumOfNodesInLeftSubtree(rootNode.left);
		int rightsum = SumOfNodesInLeftSubtree(rootNode.right);
		
		rootNode.data += leftsum;
		
		return rootNode.data + rightsum;
		
	}
	
	// CTCI question 1
	public boolean checkBalanced(Node rootNode) {
		if (checkHeight(rootNode) == -1) {
			return false;
		} else {
			return true;
		}
	}

	private int checkHeight(Node rootNode) {
		if (rootNode == null) {
			return 0;
		}
		
		int lheight = checkHeight(rootNode.left);
		if (lheight == -1) {
			return -1;
		}
		
		int rheight = checkHeight(rootNode.right);
		if (rheight == -1) {
			return -1;
		}
		
		int diff = lheight - rheight;
		if (Math.abs(diff) > 1) {
			return -1;
		} else {
			return Math.max(lheight, rheight) + 1;
		}
		
	}
	
	//CTCI 4.4 Trees and Graphs
	public ArrayList<LinkedList<Node>> getLevelLinkedLists(Node nodeRoot) {
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		createLevelLinkedList(lists, nodeRoot, 0);
		return lists;
	}

	private void createLevelLinkedList(ArrayList<LinkedList<Node>> lists, Node nodeRoot, int level) {
		if (nodeRoot == null) {
			return;
		}
		
		LinkedList<Node> list = null;
		
		if(lists.size() == level) {
			list = new LinkedList<Node>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		
		list.add(nodeRoot);
		
		createLevelLinkedList(lists, nodeRoot.left, level+1);
		createLevelLinkedList(lists, nodeRoot.right, level+1);
		
	}

	public boolean CheckIfBinarySearchTree(Node node) {
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		return CheckIfBinaryTreeHelper(node, min, max);
	}

	private boolean CheckIfBinaryTreeHelper(Node node, int min, int max) {
		if (node == null){
			return true; 
		}
		
		if (node.data <= min || node.data > max) {
			return false;
		}
		
		//Most important replace Max with node.data for left subtree and Min with node.data for right subtree
		if (!CheckIfBinaryTreeHelper(node.left, min, node.data) || !CheckIfBinaryTreeHelper(node.right, node.data, max)) {
			return false;
		}
		
		return true;
	}
	
	// CTCI 4.6 Trees and Graphs
//	public Node findInOrderSuccessor(Node rootNode) {
//		if (rootNode == null) {
//			return null;
//		}
//		
//		if (rootNode.right != null) {
//			return leftMostChild(rootNode.right);
//		} else {
//			Node q = rootNode;
//			Node x = q.parent;
//			while (x != null && x.left != q) {
//				q = x;
//				x = x.parent;
//			}
//			return x;
//		}
//	}
//
//	private Node leftMostChild(Node right) {
//		while (right.left != null) {
//			right = right.left;
//		}
//		return right;
//	}

	public Node commonAncestor(Node rootNode, Node p, Node q) {
		if (!covers(rootNode, p) || !covers(rootNode, q)) {
			return null;
		}
		return commonAncestorHelper(rootNode, p, q);
	}

	private Node commonAncestorHelper(Node rootNode, Node p, Node q) {
		if (rootNode == null) {
			return null;
		}
		
		if (rootNode.data == p.data || rootNode.data == q.data) return rootNode;
		
		boolean isPOnLeft = covers(rootNode.left, p);
		boolean isQOnLeft = covers(rootNode.right, q);
		
		if (isPOnLeft != isQOnLeft) return rootNode;
		
		Node child = isPOnLeft ? rootNode.left : rootNode.right;
		return commonAncestorHelper(child, p, q);
	}

	private boolean covers(Node rootNode, Node p) {
		if (rootNode == null) {
			return false;
		}
		
		if (rootNode == p) {
			return true;
		}
		
		return (covers(rootNode.left, p) || covers(rootNode.right, p));
	}
	
	public boolean containsTree(Node b, Node s) {
		if (s == null) {
			return true;
		}
		return compareTrees(b, s);
	}

	private boolean compareTrees(Node b, Node s) {
		if (b == null) {
			return false;
		}
		
		if (b.data == s.data) {
			if (matchTrees(b, s)) return true;
		}
		
		return compareTrees(b.left, s) || compareTrees(b.right, s);
	}

	private boolean matchTrees(Node b, Node s) {
		if (b == null && s == null) {
			return true;
		}
		
		if (b == null || s == null) {
			return false;
		}
		
		if (b.data != s.data) {
			return false;
		}
		
		return (matchTrees(b.left, s.left) && matchTrees(b.right, s.right));
	}

	//Time complexity - O(nlogn)
	//Space complexity - O(logn)
	public void findPaths(Node rootNode, int sum) {
		int height = height(rootNode);
		int[] path = new int[height];
		
		findPath(rootNode, path, sum, 0);
	}

	private void findPath(Node rootNode, int[] path, int sum, int level) {
		if (rootNode == null) {
			return;
		}
		// Current data into path
		path[level] = rootNode.data;
		
		int p = 0;
		
		for (int i = level; i >= 0; i--) {
			p += path[i];
			if (p == sum) {
				printPath(path, i, level);
			}
		}
		
		findPath(rootNode.left, path, sum, level+1);
		findPath(rootNode.right,path, sum, level+1);
	}

	private void printPath(int[] path, int start, int end) {
		//DOn't forget <=
		for (int i=start;i <= end; i++) {
			System.out.println(path[i]);
		}
		System.out.println();
	}
		
}
