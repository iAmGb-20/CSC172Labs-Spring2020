
public class myQueue<AnyType> implements Queue<AnyType> {

	//the size of the queue is 1 because my linkedlist file takes in data as a parameter
	//therefore the size of the queue begins with one and is incrememented as more elements
	//are added to it
	int sizeQueue = 1;

	

	URLinkedList<AnyType> myNewList;

	public myQueue(AnyType k) {

		myNewList = new URLinkedList<AnyType>(k);

	}

	//check if the queue is empty
	public boolean isEmpty() {

		if (sizeQueue == 0) {

			return true;

		}

		return false;

	}

	//add elements to the queue
	public void enqueue(AnyType x) {

		myNewList.add(x);

		

		System.out.println("Element " + sizeQueue + " is added into queue");
		sizeQueue++;
	}

	//remove elements from the queue in the FIFO principle
	public AnyType dequeue() {

		if (isEmpty()) {

			return null;

		}

		sizeQueue--;

		return myNewList.pollFirst();

	}

	//check what is at the top of the queue
	public AnyType peek() {

		if (isEmpty()) {

			return null;

		}

		

		return myNewList.peekFirst();

	}
//main method which has test cases shown
	public static void main(String args[]) {

		myQueue theQueue = new myQueue(9);

		theQueue.enqueue(100);

		theQueue.enqueue(200);

		theQueue.enqueue(300);

		theQueue.enqueue(400);

		System.out.println("removing/dequeing of element " + "'" + theQueue.dequeue() + "'");
		System.out.println("removing/dequeing of element " + "'" + theQueue.dequeue() + "'");

		System.out.println("removing/dequeing of element " + "'" + theQueue.dequeue() + "'");
		System.out.println("removing/dequeing of element " + "'" + theQueue.dequeue() + "'");
		// System.out.println("the top of the stack contains "+ theStack.peek());

		System.out.println();
		System.out.println("here is the current size of the queue: " + theQueue.sizeQueue);

		System.out.println("peeking element on top of the queue " + theQueue.peek());

		// System.out.println(
		// "here is the check for the method " + theQueue.topOfStack + " the size is " +
		// theStack.sizeOfStack);

	}

}