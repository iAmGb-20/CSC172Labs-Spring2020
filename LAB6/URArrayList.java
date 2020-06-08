import java.util.Collection;
import java.util.Iterator;

public class URArrayList<E> implements Iterable<E>, URList<E> {
	//initializing the instance variables 
	private E element = null;
	public int cap, size;//capacity of the arraylist and the size
	public E[] data;

	public URArrayList() {
		//constructor that is called when URArrayList instance is created
		this.cap = 100;
		this.data = (E[]) new Object[cap];
		this.size = 0;
	}

	public URArrayList(int cap) {
		//constructor when the user tells the size
		this.cap = cap;
		this.data = (E[]) new Object[cap];
		this.size = 0;
	}

	public boolean add(E e) {
		//adding elements to the ArrayList
		System.out.println("adding: " + e + "; cap=" + cap + "; size=" + size);
		if (cap <= size)//the capacity must be more than size for being able to add another element to the ArrayList
			biggerListCapacity();//increase the capacity
		
		data[size] = e;//element is added at that last index 

		System.out.println("added " + e + " at index = " + size);
		System.out.println(data[size]);
		size++;//increments the size of the ArrayList

		return true;
	}
	//additional  method- increases the capacity of the ArrayList
	public void biggerListCapacity() {
		cap *= 2;//capacity doubled
		E[] tempData = (E[]) new Object[cap];
		for (int i = 0; i < size; i++) {
			tempData[i] = data[i];
		}
		data = tempData;
	}

	public void add(int index, E element) throws IndexOutOfBoundsException {
		//adding element at the given index
		if (size >= cap)//the capacity must be more than size for being able to add another element to the ArrayList
			biggerListCapacity();//increase the capacity

		if (index > size) {
			System.out.println("wrong index");
			return;
		}

		for (int temp = size; temp != index; temp--)
			data[temp] = data[temp - 1];

		data[index] = element;
		size++;

	}

	public boolean addAll(int index, Collection<? extends E> c) throws IndexOutOfBoundsException, NullPointerException {
		biggerListCapacity();//to ensure that the list has space to accommodate the collection
		//enhanced for loop that sends all elements of the Collection to be added to our ArrayList
		for (E i : c) {
			add(index, i);
			index++;
		}
		return true;
	}

	public boolean addAll(Collection<? extends E> c) throws NullPointerException {
		biggerListCapacity();
		for (E i : c) {
			add(i);
		}
		return true;
	}

	public void clear() {
		E[] tempData = (E[]) new Object[cap];
		for (int i = 0; i < size; i++) {
			tempData[i] = null;//tempData is full of null elements

		}
		data = tempData;
		size = 0;
	}

	public boolean contains(Object o) throws NullPointerException {
		for (E i : data) {//enhanced for loop that goes through the arrayList and checks if it has the Object o sent to it
			if (i.equals(o)) {
				return true;
			}
		}
		return false;
	}

	public boolean remove(Object o) throws NullPointerException {
		//removes the Object sent to it
		E[] copy = (E[]) new Object[cap];
		for (int i = 0; i < size; i++) {
			copy[i] = data[i];
		}
		data = copy;

		// finding the index at which we find the object given
		int index = -1;//default value if the Object is not found
		for (int j = 0; j < size; j++) {
			if (data[j].equals(o)) {
				index = j;
			}
		}

		URArrayList<E> newArray = new URArrayList<E>(cap);
		// if index is not -1 then we try to remove the element
		if (index != -1) {

			for (int k = 0; k <= index - 1; k++) {
				newArray.add(data[k]);

			}

			for (int l = index + 1; l < size; l++) {
				newArray.add(data[l]);
			}
			size--;
			data=(E[]) newArray.toArray();
			
			return true;
		}

		return false;
	}

	public boolean containsAll(Collection<?> c) throws NullPointerException {
		E[] tempData = (E[]) new Object[cap];
		for (int i = 0; i < size; i++) {
			tempData[i] = data[i];
		}
		data = tempData;
		int collectionSize = 0;
		//find the number of elements in the collection
		for (Object a : c) {
			collectionSize++;
		}
		int counter = 0;
		for (int k = 0; k < size; k++) {
			for (Object j : c) {
				if (tempData[k].equals(j)) {
					counter++;//checks how many elements of the collection is in the ArrayList

				}
			}
		}

		return (counter == collectionSize);
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o == null) {
			throw new NullPointerException();
		}
		return false;
	}

	public E get(int index) throws IndexOutOfBoundsException {
		if(index>size||index<0)
			throw new IndexOutOfBoundsException();
	
		return data[index];//returns value at that index
	}

	public int indexOf(Object o) throws ArrayIndexOutOfBoundsException {
		//find the index of the object and returns it
		for(int i=0;i<size;i++) {
			if(data[i].equals(o))
				return i;
		}
		return -1;//if object not found
	}

	public boolean isEmpty() {
		
		return size==0;
	}

	public E remove(int index) throws NullPointerException, IndexOutOfBoundsException {
		URArrayList<E> newArray = new URArrayList<E>(cap);
	
		if (index >0||index<size) {

			for (int k = 0; k <= index - 1; k++) {
				newArray.add(data[k]);

			}
			//values are added till before the index into newArray

			for (int l = index + 1; l < size; l++) {
				newArray.add(data[l]);
			}
			//values are added from after the index to newArray
		
			data=(E[]) newArray.toArray();
			size--;
			return data[index];
			
		}

		
		throw new IndexOutOfBoundsException();
	}

	public boolean removeAll(Collection<?> c) throws NullPointerException, ClassCastException {
		for(Object i:c) {//use enhanced for loop to remove elements
			remove(i);
		}
		
		return true;
	}

	public E set(int index, E element) throws IndexOutOfBoundsException {
		data[index] = element;
		return element;
	}

	public Iterator<E> iterator() {
		
		return this.iterator();
	}

	// work on this one
	public Object[] toArray() {
		Object[] array=new Object[size];
		for(int i=0;i<size;i++) {
			array[i]=data[i];
		}
		return array;//returns Array after taking in an ArrayList
	}

	// work here
	public URList<E> subList(int fromIndex, int toIndex) {
		URArrayList<E> mySubList=new URArrayList<E>();
		//mySubList takes in values from fromIndex to toIndex
		for(int i=fromIndex;i<toIndex;i++) {
			mySubList.add(data[i]);
		}
			
		return mySubList;
	}

	public int size() {

		return size;
	}

	// special methods
	public void ensureCapacity(int minCapacity) {
		cap *= 2;
		E[] myBigCapacity = (E[]) new Object[cap];
		for (int i = 0; i < size; i++) {
			myBigCapacity[i] = data[i];
		}
		data = myBigCapacity;
	}

	
	public int getCapacity() {
		return cap;
	}

	public static void main(String args[]) {
		URArrayList<Integer> myArr = new URArrayList<Integer>();

		myArr.add(10);
		myArr.add(15);
		myArr.add(20);
		myArr.add(25);
		myArr.add(30);
		myArr.add(35);
		myArr.add(40);
		myArr.add(45);
		myArr.add(50);
		myArr.add(55);
		myArr.add(60);
		myArr.add(65);
		myArr.set(0, 5);
		myArr.clear();
		System.out.println("here is the size of the list: " + myArr.size());
		myArr.add(20);
		System.out.println(myArr.contains(20));
		myArr.add(10);
		myArr.remove(0);
		System.out.println("it does contain " + myArr.size());
		System.out.println(myArr.indexOf(1));
	}



}