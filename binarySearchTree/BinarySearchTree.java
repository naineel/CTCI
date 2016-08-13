package binarySearchTree;

public class BinarySearchTree {
	Node root;

	public BinarySearchTree(int data) {
		root = new Node(data);
	}

	public BinarySearchTree() {
		root = null;
	}
	
	// Complexity - O(h) h is the height of the tree.
	public Node search(Node root, int key) {
		if (root == null || root.data == key) {
			return root;
		}
		
		if (root.data > key) {
			return search(root.left, key);
		}
		
		return search(root.right, key);
	}
	
	public Node insert(Node rootNode, int key) {
		if (rootNode == null) {
			rootNode = new Node(key);
			return rootNode;
		}
		
		if (key < rootNode.data) {
			rootNode.left = insert(root.left, key);
		} else {
			rootNode.right = insert(root.right, key);
		}
		
		return rootNode;
	}
	
	public void inorderTraversal(Node rootNode) {
		if (rootNode == null) {
			return;
		}
		inorderTraversal(rootNode.left);
		System.out.println(rootNode.data + "");
		inorderTraversal(rootNode.right);
	}
	
	public Node delete(Node rootNode, int key) {
		if (rootNode == null) {
			return rootNode;
		}
		
		if (key < rootNode.data) {
			rootNode.left = delete(rootNode.left, key);
		} else if (key > rootNode.data) {
			rootNode.right = delete(rootNode.right, key);
		} else {
			if (rootNode.left == null) {
				return rootNode.right;
			} else if (rootNode.right == null) {
				return rootNode.left;
			}
			rootNode.data = minValue(rootNode.right);
			rootNode.right = delete(rootNode.right, rootNode.data);
		}
		return rootNode;
	}

	private int minValue(Node node) {
		int minVal = node.data;
		
		while (node.left != null) {
			minVal = node.left.data;
			node = node.left;
		}
		
		return minVal;
	}
	
	//CTCI Trees and Graphs question 2 
	public Node createMinimalBST(int array[]) {
		return createMinimalBSTHelper(array, 0, array.length -1);
	}

	private Node createMinimalBSTHelper(int[] array, int start, int end) {
		if (end < start) {
			return null;
		}
		
		int mid = (start + end)/2;
		Node n = new Node(array[mid]);
		
		// Don't forget mid-1 and mid+1 as mid is already used
		n.left = createMinimalBSTHelper(array, start, mid-1);
		n.right = createMinimalBSTHelper(array, mid+1, end);
		
		return n;
	}
	
	
	
}
