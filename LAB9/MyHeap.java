
public class MyHeap<T extends Comparable<T>> implements Heap<T> {

	private T[] heapArr;
	private int cap;
	private int size;

	public MyHeap() {
		this.cap = 10;// default capacity if nothing is given by user
		this.heapArr = (T[]) new Comparable[cap];
		this.size = 0;
	}

	public MyHeap(int cap) {

		this.heapArr = (T[]) new Comparable[cap];
		this.cap = cap;
		this.size = 0;
	}

	public MyHeap(Comparable[] array) {
		this.cap = array.length;
		this.size = array.length;
		this.heapArr = (T[]) array;

	}

	public void sort(Integer[] arr) {
		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		// One by one extract an element from heap
		for (int i = n - 1; i >= 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	public void heapify(Integer[] arr, int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest]) {
			largest = r;
		}

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}
	public static void main(String[] args) {
		MyHeap<Integer> h1 = new MyHeap<Integer>();
		h1.insert(1);
		h1.insert(22);
		h1.insert(33);
		h1.insert(44);
		h1.insert(18);
		h1.insert(10);
		h1.insert(17);
		h1.insert(-2);
		h1.insert(23);
		h1.insert(49);
		h1.printHeap();

		System.out.println(" delete min ");
		System.out.println("the value deleted is " + h1.deleteMin());
		h1.printHeap();

		Integer[] test = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
		MyHeap<Integer> h2 = new MyHeap<>(test);
		System.out.println("h2: ");
		h2.printHeap();

		Integer arr[] = { 12, 11, 13, 5, 6, 7 };
		int n = arr.length;
		MyHeap ob = new MyHeap(arr);
		System.out.println("Initial array unsorted:");
		ob.printArray(arr);// printing initial array
		ob.sort(arr);

		System.out.println("Sorted Heapifiy array is");
		ob.printArray(arr);

	}

	public void bubbleUp() {
		bubbleUp(size - 1);// sends the value of the last index
	}

	public void bubbleUp(int nodeIndex) {
		T temp;
		int parentIndex;

		if (nodeIndex != 0) {// not reached the top of the heap
			parentIndex = getParentIndex(nodeIndex);
			// if the parent's value is greater than that of the child then we swap it
			if (heapArr[parentIndex].compareTo(heapArr[nodeIndex]) > 0) {
				temp = heapArr[parentIndex];
				heapArr[parentIndex] = heapArr[nodeIndex];
				heapArr[nodeIndex] = temp;
				bubbleUp(parentIndex);// keep calling the method recursively with the parent index
			}
		}

	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}

		return false;
	}

	@Override
	public int size() {
		return size;
	}

	public int getLeftChildIndex(int nodeIndex) {
		return 2 * nodeIndex + 1;
	}

	public int getRightChildIndex(int nodeIndex) {
		return 2 * nodeIndex + 2;
	}

	public int getParentIndex(int nodeIndex) {// finds the parent index by knowing the index of the node
		return (nodeIndex - 1) / 2;
	}

	@Override
	public T deleteMin() {

		T temp = heapArr[0];
		heapArr[0] = heapArr[size - 1];
		size--;

		bubbleDown();

		return temp;// first element of the min heap that is deleted
	}

	public void swap(int i, int j) {
		T temp = heapArr[i];
		heapArr[i] = heapArr[j];
		heapArr[j] = temp;
	}

	public int getMinChildIndex(int nodeIndex) {
		int leftChildIndex = getLeftChildIndex(nodeIndex);
		if (leftChildIndex > size - 1) {// reached the end
			return -1;
		}
		int rightChildIndex = getRightChildIndex(nodeIndex);
		if (rightChildIndex > size - 1) {
			return leftChildIndex;
		}
		T rightChild = heapArr[rightChildIndex];
		T leftChild = heapArr[leftChildIndex];
		int minChildIndex = rightChildIndex;// default value given to the minimum child
		if (leftChild.compareTo(rightChild) < 0) {
			minChildIndex = leftChildIndex;
		}
		return minChildIndex;
	}

	public void bubbleDown() {

		int nodeIndex = 0;
		boolean terminate = false;

		while (nodeIndex < size && !terminate) {

			int minChildIndex = getMinChildIndex(nodeIndex);
			if (minChildIndex == -1) {
				terminate = true;
				continue;
			}

			T minChild = heapArr[minChildIndex];
			T current = heapArr[nodeIndex];
			if (current.compareTo(minChild) < 0) {
				terminate = true;
				continue;
			}
			swap(minChildIndex, nodeIndex);
			nodeIndex = minChildIndex;

		}

	}

	@Override
	public void insert(Comparable item) {
		if (size >= cap) {
			increaseCapacity();
		}
		size++;
		heapArr[size - 1] = (T) item;
		bubbleUp();

	}

	public void printHeap() {
		for (int i = 0; i < size; i++) {
			System.out.println(heapArr[i]);
		}
	}

	static void printArray(Comparable arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void increaseCapacity() {
		cap *= 2;

		T[] tempData = (T[]) new Comparable[cap];// creating temporary array with increased capacity

		for (int i = 0; i < size; i++) {
			tempData[i] = heapArr[i];
		}
		heapArr = tempData;
	}

}
