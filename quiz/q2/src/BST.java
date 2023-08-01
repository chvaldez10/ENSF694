/**
 *  Implementation of binary tree
 *
 *  Uses: Node.java, Queue.java, QNode.java
 *
 *  @author Christian Valdez
 */


public class BST {
	public Node createNode(int data){
		Node BSTNode = new Node();
		BSTNode.data = data;
		BSTNode.left = null;
		BSTNode.right = null;
		return BSTNode;
	}

	public Node insert(int data, Node root) {
		if(root == null) return createNode(data);
		if(data <= root.data) root.left = insert(data, root.left);
		else if (data > root.data) root.right = insert(data, root.right);
		return root;
	}

	/**
	 * Traverse the left subtree, root, right subtree.
	 *
	 * @param BSTNode
	 */
	public void inOrder(Node BSTNode) {
		if (BSTNode == null) return;
		inOrder(BSTNode.left);
		System.out.print(BSTNode.data + " ");
		inOrder(BSTNode.right);
	}

	/**
	 * Traverse the root, left subtree, right subtree.
	 *
	 * @param BSTNode
	 */
	public void preOrder(Node BSTNode) {
		if (BSTNode == null) return;
		System.out.print(BSTNode.data + " ");
		preOrder(BSTNode.left);
		preOrder(BSTNode.right);
	}

	/**
	 * Traverse the left subtree, right subtree, root.
	 *
	 * @param BSTNode
	 */
	public void postOrder(Node BSTNode) {
		if (BSTNode == null) return;
		postOrder(BSTNode.left);
		postOrder(BSTNode.right);
		System.out.print(BSTNode.data + " ");
	}

	/**
	 * Traverse the tree nodes at each level.
	 *
	 * @param root
	 */
	public void breadthFirstTraversal(Node root) {
		if (root == null) return;

		Queue q = new Queue();
		q.enqueue(root);

		while(!q.isEmpty()) {
			Node node = q.dequeue();
			System.out.print(node.data + " ");
			if(node.left != null) q.enqueue(node.left);
			if(node.right != null) q.enqueue(node.right);
		}
	}

	/**
	 * Starting at the root, traverse the tree to find a node.
	 *
	 * @param BSTNode, key
	 */
	public Node searchBinarySearchTree(Node BSTNode, int key) {
		return searchRec(BSTNode, key);
	}

	// searchBinarySearchTree() helper
	private Node searchRec(Node root, int key) {
		if (root == null) return null; // BST is empty
		if (root.data == key) return root; // key found at root node
		if (key < root.data) return searchRec(root.left, key); //traverse left sub tree
		else return searchRec(root.right, key); // traverse right subtree
	}

	/**
	 * Search for the node and delete it.
	 *
	 * @param root, key
	 */
	public Node deleteNode(Node root, int key) {
		deleteNodeRecursive(root, key);
		return root;
	}

	public Node deleteNodeRecursive(Node root, int key) {
		if (root == null) return root;

		if (key < root.data) root.left = deleteNodeRecursive(root.left, key);
		else if (key > root.data) root.right = deleteNodeRecursive(root.right, key);
		else {
			if (root.left == null) return root.right;
			else if (root.right == null) return root.left;
			root.data = minValue(root.right);
			root.right = deleteNodeRecursive(root.right, root.data);
		}

		return root;
	}

	private int minValue(Node root) {
		int minValue = root.data;
		while (root.left != null) {
			minValue = root.left.data;
			root = root.left;
		}
		return minValue;
	}

	public static void main(String[] args) {
		BST tree = new BST();
		Node root = null;
//		int[] testArr = {30, 23, 43, 54, 12, 50, 45, 97};
//		int[] testArr = {32, 18, 71, 24, 43, 88, 30, 52, 95};
		int[] testArr = {82, 39, 94, 38, 59, 88, 44, 86, 93};

		for (int i : testArr) root = tree.insert(i, root);

		System.out.println("\nBreadth first traversal of the Tree");
		tree.breadthFirstTraversal(root);

		System.out.println("\n\nIn order traversal (left-root-right) of Tree1");
		tree.inOrder(root);

		System.out.println("\n\nPre order traversal (root-left-right) of Tree1");
		tree.preOrder(root);

		System.out.println("\n\nPost order traversal (left-right-root) of Tree1");
		tree.postOrder(root);

		System.out.println("\n\nTesting delete");
		tree.deleteNode(root, 88);

	}
}
