import java.util.ArrayList;
import java.util.Iterator;
public class Lab3Task3 {
	public static void main(String args[]) {
		ArrayList<Integer>myInt = new ArrayList<Integer>();
		myInt.add(1);
		myInt.add(5);
		myInt.add(7);
		myInt.add(2);
		printArrayListBasicLoop(myInt);
		printArrayListEnhancedLoop (myInt);
		printArrayListForLoopListIterator (myInt);
		printArrayListWhileLoopIterator (myInt);
	}
	public static void printArrayListBasicLoop(ArrayList<Integer> a1) {
		for(int i = 0; i<a1.size();i++) {
			System.out.println(a1.get(i));
		}
	}
	public static void printArrayListEnhancedLoop (ArrayList<Integer> a1) {
		for (int x:a1) {
			System.out.println(x);
		}
	}
	public static void printArrayListForLoopListIterator (ArrayList<Integer> a1) {
		for (Iterator<Integer>myIt = a1.iterator();myIt.hasNext(); ) {
			int x = myIt.next();
			System.out.println(x);
			
		}
	}
	public static void printArrayListWhileLoopIterator (ArrayList<Integer> a1) {
		Iterator<Integer>Iterator = a1.iterator();
		while(Iterator.hasNext()) {
			int x = Iterator.next();
			System.out.println(x);
		}
	}

}
