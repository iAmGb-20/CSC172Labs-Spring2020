
public interface BST <T extends Comparable<T>>{
	public void insert(T x);
	public void delete (T x);
	public boolean lookup (T x);
	public void printPreOrder(T x);
	public void printInOrder (T x);
	public void printPostOrder (T x);
	
}
