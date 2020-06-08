import java.util.Arrays;
import java.util.ArrayList;

public class Lab3Task1 {

	public static void print2Darray(int[][] array) {

		for (int i = 0; i < array.length;i++) {
			for (int j = 0;j< array.length;j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void print2DList(ArrayList<ArrayList<Integer>> list) {
		for (ArrayList<Integer> x : list) {
			for (int j : x) {
				System.out.print(j + "\t");
			}
			System.out.println();
		}

	}

	

	public static void main(String args[]) {
		
		
		// creating the four lists here
		ArrayList<Integer> list1 = new ArrayList<Integer>();

		list1.add(10);
		list1.add(15);
		list1.add(30);
		list1.add(40);

		ArrayList<Integer> list2 = new ArrayList<Integer>();

		list2.add(15);
		list2.add(5);
		list2.add(8);
		list2.add(2);

		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(20);
		list3.add(2);
		list3.add(4);
		list3.add(2);

		ArrayList<Integer> list4 = new ArrayList<Integer>();

		list4.add(1);
		list4.add(4);
		list4.add(5);
		list4.add(0);

		ArrayList<ArrayList<Integer>> myArrayList = new ArrayList<ArrayList<Integer>>();

		myArrayList.add(list1);
		myArrayList.add(list2);
		myArrayList.add(list3);
		myArrayList.add(list4);

		int[][] Myarr = { { 10, 15, 30, 40 }, { 15, 5, 8, 2 }, { 20, 2, 4, 2 }, { 1, 4, 5, 0 } };
		//System.out.println("test for the arrays printing method");
		print2Darray(Myarr);
		System.out.println();
		//System.out.println("here is the test for the array list");
		System.out.println();
		print2DList(myArrayList);
		System.out.println();

		
		
		
	}

}
