
public class BSTester {

	public static void main(String args[]) {
		myBST<Integer> tree = new myBST<Integer>();
		tree.insert(5);
		tree.insert(4);
		tree.insert(1);
		tree.insert(3);
		tree.insert(7);
		tree.insert(6);
		tree.insert(8);
		
		//before deletion
		tree.printInOrder();
		System.out.println("preorder traversal of the tree gives: \n");
	
		tree.printPreOrder();
		System.out.println("postorder traversal of the tree gives: \n");
		
		tree.printPostOrder();
		System.out.println();

		tree.delete(4);
		
		
		//after deletion
		System.out.println("inorder traversal of the tree AFTER DELETION gives: \n");

		tree.printInOrder();
		System.out.println("preorder traversal of the tree AFTER DELETION gives: \n");
	
		tree.printPreOrder();
		System.out.println("postorder traversal of the tree AFTER DELETION gives: \n");
		
		tree.printPostOrder();
		System.out.println();

		System.out.println("the tree contains 4: " + tree.lookup(4));

	}

}
