
public class MyTreeNode<T extends Comparable<T>> {
	public T data;
	public MyTreeNode<T> leftChild;
	public MyTreeNode<T> rightChild;
	public MyTreeNode<T> parent;

	public void preOrdertraversal(MyTreeNode<T> parent) {
		if (parent != null) {
			System.out.println(parent.data);

			preOrdertraversal(parent.leftChild);
			preOrdertraversal(parent.rightChild);

		}
	}

	public void postOrdertraversal(MyTreeNode parent) {
		if (parent != null) {

			postOrdertraversal(parent.leftChild);
			postOrdertraversal(parent.rightChild);
			System.out.println(parent.data);

		}

	}

	public void inOrdertraversal(MyTreeNode<T> parent) {
		if (parent != null) {

			inOrdertraversal(parent.leftChild);
			System.out.println(parent.data);
			inOrdertraversal(parent.rightChild);
		}
	}

	public MyTreeNode<T> delete(MyTreeNode<T> node, T x) {

		if (node == null)
			throw new NullPointerException();
		else if (compare(x, node.data) < 0) {
			node.leftChild = delete(node.leftChild, x);
		} else if (compare(x, node.data) > 0) {
			node.rightChild = delete(node.rightChild, x);
		} else if (node.leftChild == null)
			return node.rightChild;
		else if (node.rightChild == null)
			return node.leftChild;
		else {
			// get data from the leftmost node in the right sub-tree
			node.data = retrieveData(node.rightChild);
			// delete the node that has been retrieved by the above method
			node.leftChild = delete(node.leftChild, node.data);
		}
		return node;

	}

	private T retrieveData(MyTreeNode<T> k) {
		while (k.leftChild != null)
			k = k.leftChild;
		return k.data;
	}

	public void insert(T x) {

		// MyTreeNode newNode = new MyTreeNode();
		if (data == null) {
			// root = new MyTreeNode<T>();
			data = x;
			return;
		}

		MyTreeNode<T> node = new MyTreeNode<T>();
		node.data = x;

		if (x.compareTo(data) < 0) {
			if (leftChild == null) {
				leftChild = node;
			} else {
				leftChild.insert(x);
			}
//							pointerNode = pointerNode.leftChild;

//							if (pointerNode == null) {
//
//								parent.leftChild = insert;
//
//								return;
//
//							}
		} else if (x.compareTo(data) > 0) {
			if (rightChild == null) {
				rightChild = node;
			} else {
				rightChild.insert(x);
			}
		} else {

			if (leftChild == null) {
				leftChild = node;
			} else {
				leftChild.insert(x);
			}

			if (rightChild == null) {
				rightChild = node;
			} else {
				rightChild.insert(x);
			}

		}

	}

	private int compare(T d1, T d2) {
		int castd1 = (int) d1;
		int castd2 = (int) d2;

		int difference = castd1 - castd2;

		if (difference == 0) {
			return 0;
		} else if (difference < 0) {
			return -1;
		} else if (difference > 0) {
			return 1;
		}
		return -2;
	}

}
