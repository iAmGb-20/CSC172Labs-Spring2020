import java.util.Collection;
import java.util.Iterator;


public class URLinkedList<E> implements Iterable<E>, URList<E> {
	URNode<E> head;
	URNode<E> lastNode;
	

	URLinkedList(E data) {
		//constructor initializing the data
		URNode<E> a = new URNode<E>(data, null, null);
		head = a;
		lastNode = a;
	}

	private int mySize = size();

	public void addFirst(E e) throws NullPointerException{
		URNode<E> newNode = new URNode<E>(e, null, null);
		if (head == null) {
			//if the list is empty
			head = newNode;
		}else {
			//the element is added to the beginning of the Linked list
			head.setPrev(newNode);
			newNode.setNext(head);
			newNode.setPrev(null);
			head=newNode;
			mySize++;
		}
	}
	public void addLast(E e) {
		URNode<E> lastone = new URNode<E>(e, null, null);

		lastNode.setNext(lastone);//lastnode becomes lastone
		lastone.setPrev(lastNode);//the previous of lastone becomes lastnode
		lastNode = lastone;//lastone is the new lastnode
		mySize++;
	}

	public boolean add(E e) {
		URNode<E> myNode = new URNode<E>(e, null, null);
		//adding node with element e at the end of the list
		lastNode.setNext(myNode);
		myNode.setPrev(lastNode);
		lastNode = myNode;

		return true;
	}

	@Override
	public void add(int index, E element) {
		//adding element at given index
		int count = 0;
		
		URNode<E> myNode = new URNode<E>(element, null, null);
		URNode<E> current = head;
		while (count < index-1) {
			//iterating till we reach that index we are going to add node
			count++;
			if (current.next() != null)
				current = current.next();
		}
		current.next().setPrev(myNode);
		myNode.setNext(current.next());

		current.setNext(myNode);
		myNode.setPrev(current);
		mySize++;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		//Adding all elements in the collection
		for (E i : c) {
			add(i);
			mySize++; 
		}
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		//adding all elements in the collection at the given index
		for (E i : c) {
			add(index, i);
			index++;
			mySize++;
		}
		return true;
	}

	@Override
	public void clear() {
		
		URNode<E> a = new URNode<E>(null, null, null);
		head = a;
		lastNode = a;
		mySize = 0;
	}

	@Override
	public boolean contains(Object o) {
		URNode<E> temp = head;
		//iterating through the linkedlist to look for the object
		while (temp.next() != null) {
			temp = temp.next();
			if (temp.element().equals(o)) {
				return true;
			}
		}

		return false;
	}

	public boolean containsAll(Collection<?> c) {
		URNode<E> temp = head;
		int x = 0, y = 0;
		while (temp.next() != null) {
			temp = temp.next();
			for (Object i : c) {
				x++;//x checks the number of elements in the collection
				if (temp.element().equals(i)) {
					y++;//number of times a match is found
				}
			}

		}
		if (x == y) {
			return true;
		}
		return false;
	}

	@Override
	public E get(int index) throws NullPointerException {
		int count = 0;
		if (head == null) {
			throw new NullPointerException();
		}
		URNode<E> toGet = head;

		while (count < index) {
		//iterate till we reach the index
			count++;
			if (toGet.next() != null)
				toGet = toGet.next();
		}

		return toGet.element();
	}

	public int indexOf(Object o) {
		int counter = 0;
		URNode<E> temp = head;
		while (temp.next() != null) {
			temp = temp.next();
			counter++;
			if (temp.element().equals(o)) {
				return counter;//finds the element and returns the index

			}

		}
		return -1;//if element is not found
	}

	public boolean isEmpty() {

		return head.element().equals(null);
	}

	// added size here
	public E remove(int index) {
	//removes the node at that index
		int count = 0;
		int mySize = size();
		URNode<E> removehim = head;
		while (count < index) {

			count++;
			if (removehim.next() != null)
				removehim = removehim.next();
		}
		removehim.prev().setNext(removehim.next());
		removehim.next().setPrev(removehim.prev());
		mySize--;

		return removehim.element();
	}

	public boolean remove(Object o) {
		int counter = 0;
		URNode<E> temp = head;
		while (temp.next() != null) {
			temp = temp.next();
			counter++;
			if (temp.element().equals(o)) {
				remove(counter);//calls remove method on found counter
				return true;
			}

		}
		mySize--;
		return false;
	}

	public boolean removeAll(Collection<?> c) {
		for (Object i : c) {//removes all Objects in the collection
			remove(i);
			mySize--;
		}
		return true;
	}

	public E set(int index, E element) {
		int count = 0;
		URNode<E> setHim = head;
		while (count < index) {
			count++;
			if (setHim.next() != null) {
				setHim = setHim.next();
			}
		}
		setHim.setElement(element);

		return setHim.element();
	}

	public int size() {
		if (head == null)
			return 0;
		int counter = 0;
		URNode<E> temp = head;
		while (temp.next() != null) {
			temp = temp.next();
			counter++;

		}
		return counter;
	}

	// additional method that returns a node in an index
	public URNode<E> getNode(int index) throws IndexOutOfBoundsException {
		URNode<E> check = head;
		int countMe = 0;
		while (check != null) {
			if (countMe == index)
				return check;
			countMe++;
			check = check.next();
		}
		throw new NullPointerException();
	}

	// additional method to add a node to a list, should i increment size?
	public void addNode(URNode<E> node) {
		if (head == null) {
			head = node;
		} else {
			getLastNode().setNext(node);
		}
		
	}

	// additional method to get the last node in the list
	public URNode<E> getLastNode() throws NullPointerException {
		URNode<E> temp = head;
		while (temp.next() != null) {
			temp = temp.next();
		}
		return temp;
	}
	
	public URList<E> subList(int fromIndex, int toIndex) throws NullPointerException {
		if (fromIndex < 0  || toIndex < fromIndex ) {
			throw new NullPointerException();
		}

		URLinkedList<E> mySubList = new URLinkedList<E>(null);
		URNode<E> intheIndex = getNode(fromIndex);
		
		int i = 0;
		int difference = toIndex - fromIndex;
		while (intheIndex != null) {
			if (i <= difference) {
				mySubList.addNode(intheIndex);
			}
			intheIndex = intheIndex.next();
			i++;
		}

		return mySubList;
	}
	
	public void printAnyList(URList<E>c) {
		
	}

	public Object[] toArray() {
		int counter = 0;

		URNode<E> loop = head;
		while (loop.next() != null) {
			loop = loop.next();
			counter++;
		}
		Object[] myArray = new Object[counter];
		URNode<E> loop2 = head;
		int i = 0;
		while (loop2.next() != null) {
			myArray[i] = loop2.element();
			loop2 = loop2.next();
			i++;
		}
		return myArray;
	}

	public E peekFirst() throws NullPointerException {
		if (head != null) {
			return head.element();
		} else {
			throw new NullPointerException();
		}
	}

	public E peekLast() throws NullPointerException {
		if (isEmpty()) {
			throw new NullPointerException();
		}
		return getLastNode().element();
	}

	public E pollFirst() {
		
		URNode<E> temp = head;
		if (isEmpty()) {
			throw new NullPointerException();
		} else {
			head.next().setPrev(null);
			head = head.next();
			
		}
		return temp.element();
	}

	public E pollLast() {
		URNode<E>notNeeded = new URNode<E>(lastNode.element(), null, null);
		if (isEmpty()) {
			throw new NullPointerException();
		} else {
			getLastNode().prev().setNext(null);
			
		}
		return notNeeded.element();
	}

	
	public void removingDuplicateElements() {
		if (head == null)
			return;
		int counter = 0;
		URNode<E> temp = head;
		while (temp.next() != null) {
			temp = temp.next();
			counter++;

		}
		for (int i = 0; i < size(); i++) {
			for (int j = 1; j < size()-1; j++) {
				if (getNode(i).element().equals(getNode(j).element())) {
					counter = counter - 1;

				}
			}
		}
	}

	public boolean hasNext() {
		URNode<E> currentNode = head;
		return currentNode.next() != null;
	}

	public E Next() {
		URNode<E> currentNode = head;
		if (!hasNext()) {
			throw new NullPointerException();
		}
		E element = currentNode.element();
		currentNode = currentNode.next();
		return element;
	}

	// additional method
	public void printmyList() {
		URNode<E> temp = head;
		while (iterator().hasNext()) {
			
		}
	}

	// print without iterator
	public void printList() throws NullPointerException {
		URNode<E> temp = head;
		if (isEmpty())
			throw new NullPointerException();
		System.out.println("here are the nodes of my doubly linked list: ");
		while (temp != null) {
			System.out.println(temp.element() + " ");
			temp = temp.next();
		}
	}

	public Iterator<E> iterator() {

		return this.iterator();

	}
	public static void main(String[] args) {
		URLinkedList<Integer> linkedlist=new URLinkedList<Integer>(1);
		//testing for all the methods
		linkedlist.printList();
		linkedlist.add(22);
		linkedlist.printList();
		linkedlist.addFirst(30);
		linkedlist.printList();
		linkedlist.addFirst(10);
		linkedlist.printList();
		System.out.println("here is the test for pollfirst");
		System.out.println("here is the test for object to array");
		//System.out.println(linkedlist.toArray().toString());
		linkedlist.set(0, 1000);
		linkedlist.printList();
		
		
				
		
	}

}
