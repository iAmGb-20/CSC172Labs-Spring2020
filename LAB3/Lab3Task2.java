import java.util.ArrayList;

public class Lab3Task2 {
	public static void print2Darray(int[][] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
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


	public static void runningSum2DArray(int[][] arr, int dir) {

		// left
		if (dir == 1) {

			for (int i = 0; i < arr.length; i++) {
				int sum1 = 0;
				for (int m = (arr.length - 1); m >= 0; m--) {

					sum1 += arr[i][m];

					arr[i][m] = sum1;

				}
			}
			print2Darray(arr);

		}

		// right
		else if (dir == 2) {

			for (int k = 0; k < arr.length; k++) {
				int sum = 0;
				for (int m = 0; m < arr.length; m++) {
					sum += arr[k][m];
					arr[k][m] = sum;

				}

			}
			print2Darray(arr);
		} else if (dir == 4) {
			for (int i = 0; i < arr.length; i++) {
				int sum = 0;
				for (int j = 0; j < arr.length; j++) {
					sum += arr[j][i];
					arr[j][i] = sum;
				}
			}
			print2Darray(arr);
		} else if (dir == 3) {
			for (int j = 0; j < arr.length; j++) {
				int sum1 = 0;
				for (int i = (arr.length - 1); i >= 0; i--) {

					sum1 += arr[i][j];

					arr[i][j] = sum1;

				}
			}
			print2Darray(arr);
		}
	}

	public static void runningSum2DArrayList(ArrayList<ArrayList<Integer>> list, int dir) {
		if (dir == 1) {
			for (ArrayList<Integer> arr : list) {
				for (int i = list.size() - 2; i >= 0; i--) {
					int y = arr.get(i + 1) + arr.get(i);
					arr.set(i, y);

				}

			}
			print2DList(list);
		} else if (dir == 2) {
			for (ArrayList<Integer> arr : list) {
				for (int i = 1; i < arr.size(); i++) {
					int y = arr.get(i - 1) + arr.get(i);
					arr.set(i, y);
				}
			}
			print2DList(list);
		} else if (dir == 3) {

			for (int i = list.size() - 2; i >= 0; i--) {
				for (int j = 0; j < list.size(); j++) {
					int y = list.get(i + 1).get(j) + list.get(i).get(j);
					list.get(i).set(j, y);
				}
			}
			print2DList(list);
		} else if (dir == 4) {
			for (int i = 1; i < list.size(); i++) {
				for (int j = 0; j < list.size(); j++) {
					int y = list.get(i - 1).get(j) + list.get(i).get(j);
					list.get(i).set(j, y);
				}
			}
			print2DList(list);
		}
	}



	public static void main(String args[]) {
		int[][] Myarr = { { 10, 15, 30, 40 }, { 15, 5, 8, 2 }, { 20, 2, 4, 2 }, { 1, 4, 5, 0 } };

		// here is a copy of the initial array
		int[][] arr1 = new int[Myarr.length][Myarr.length];
		for (int i = 0; i < Myarr.length; i++) {
			for (int j = 0; j < Myarr.length; j++) {
				arr1[i][j] = Myarr[i][j];
			}
		}

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

		// a copy of the arraylist
		ArrayList<Integer> l1 = new ArrayList<Integer>();

		l1.add(10);
		l1.add(15);
		l1.add(30);
		l1.add(40);

		ArrayList<Integer> l2 = new ArrayList<Integer>();

		l2.add(15);
		l2.add(5);
		l2.add(8);
		l2.add(2);

		ArrayList<Integer> l3 = new ArrayList<Integer>();
		l3.add(20);
		l3.add(2);
		l3.add(4);
		l3.add(2);

		ArrayList<Integer> l4 = new ArrayList<Integer>();

		l4.add(1);
		l4.add(4);
		l4.add(5);
		l4.add(0);
		
		ArrayList<ArrayList<Integer>> tempList = new ArrayList<ArrayList<Integer>>();
		
		tempList.add(l1);
		tempList.add(l2);
		tempList.add(l3);
		tempList.add(l4);
		
		System.out.println("the array running sum");
		runningSum2DArray(Myarr, 1);
		System.out.println();
		runningSum2DArray(Myarr, 2);
		System.out.println();
		runningSum2DArray(arr1, 3);
		System.out.println();
		runningSum2DArray(arr1, 4);
		System.out.println();
		System.out.println("the array list running sum");
		runningSum2DArrayList(myArrayList, 1);
		System.out.println();
		runningSum2DArrayList(myArrayList, 2);
		System.out.println();
		runningSum2DArrayList(tempList, 3);
		System.out.println();
		runningSum2DArrayList(tempList, 4);
		// System.out.println(myArrayList.get(0));
	}
}
