import java.util.Arrays;
import java.util.Scanner;

public class SortTestAlgo {
	private static int count;
	static int size;
	static Integer[] a;
	static Integer[] b;

	public static void main(String args[]) {

		long startTime, endTime, elapsedTime;

		Scanner s = new Scanner(System.in);
		size = s.nextInt();
		a = new Integer[size];
		b = new Integer[size];
		System.out.println("size" + size);
		for (int i = 0; i < a.length; i++) {
			a[i] = b[i] = (int) (Math.random() * 100);
		}
		System.out.println("the original array is: ");
		System.out.println(Arrays.toString(a));
		count = 0;
		startTime = System.currentTimeMillis();
		bubblesort(a);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.println("Array after bubble sort");
		System.out.println(Arrays.toString(a));
		System.out.println("bubblesort took " + count + " moves to sort " + size + " items");
		System.out.println("\t in : " + elapsedTime + " millesec");

		// Reset count and array
		count = 0;
		for (int i = 0; i < size; i++) {
			a[i] = b[i];
		}
		long startTime2, endTime2, elapsedTime2;
		startTime2 = System.currentTimeMillis();
		insertionSort(a);
		endTime2 = System.currentTimeMillis();
		elapsedTime2 = endTime2 - startTime2;
		System.out.println("Array after insertion sort");
		System.out.println(Arrays.toString(a));
		System.out.println("Insertion took " + count + " moves to sort " + size + " items");
		System.out.println("\t in : " + elapsedTime2 + " millesec");

		// Reset count and array
		count = 0;
		for (int i = 0; i < size; i++) {
			a[i] = b[i];
		}
		long startTime3, endTime3, elapsedTime3;
		startTime3 = System.currentTimeMillis();
		shellSort(a);
		endTime3 = System.currentTimeMillis();
		elapsedTime3 = endTime3 - startTime3;
		System.out.println("Array after shellsort");
		System.out.println(Arrays.toString(a));
		System.out.println("ShellSort took " + count + " moves to sort " + size + " items");
		System.out.println("\t in : " + elapsedTime3 + " millesec");

		// Reset count and array
		count = 0;
		for (int i = 0; i < size; i++) {
			a[i] = b[i];
		}
		long startTime4, endTime4, elapsedTime4;
		startTime4 = System.currentTimeMillis();
		quickSort(a, 0, a.length - 1);
		endTime4 = System.currentTimeMillis();
		elapsedTime4 = endTime4 - startTime4;
		System.out.println("array after quick sort");
		System.out.println(Arrays.toString(a));
		System.out.println("quickSort took " + count + " moves to sort " + size + " items");
		System.out.println("\t in : " + elapsedTime4 + " millesec");

		count = 0;
		for (int i = 0; i < size; i++) {
			a[i] = b[i];
		}
		long startTime5, endTime5, elapsedTime5;
		startTime5 = System.currentTimeMillis();
		Arrays.sort(a);
		endTime5 = System.currentTimeMillis();
		elapsedTime5 = endTime5 - startTime5;
		System.out.println(Arrays.toString(a));
		System.out.println("Execute normal Sorting time taken: ");
		System.out.println("\t in : " + elapsedTime5 + " millesec");
	}

	public static <AnyType extends Comparable<? super AnyType>> void bubblesort(AnyType[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					AnyType tmp = a[j];
					count++;
					a[j] = a[j + 1];
					count++;
					a[j + 1] = tmp;
					count++;

				}
			}
		}
	}

	public static void insertionSort(Integer[] b) {
		for (int i = 1; i < b.length; i++) {
			int j = i;
			count++;
			int toInsert = a[i];
			count++;
			while ((j > 0) && (b[j - 1] > toInsert)) {
				b[j] = b[j - 1];
				count++;
				j--;
				count++;

			}
			b[j] = toInsert;
			count++;

		}
	}

	public static void shellSort(Integer[] a) {
		int j;
		int temp;
		int i;

		int inc = 1;
		int k = 0;
		while (inc <= a.length + 1) {
			for (i = inc; i <= a.length - 1; i++) {
				temp = a[i];
				count++;
				j = i;

				while (j >= inc && a[j - inc] > temp) {
					a[j] = a[j - inc];
					count++;
					j = j - inc;
					count++;
				}
				a[j] = temp;
				count++;
			}
			k = k + 1;
			inc = (int) (java.lang.Math.pow(2, k)) - 1;
			// Adding hilbert increments of 2^k-1
		}
	}

	public static void quickSort(Integer arr[], int begin, int end) {
		if (begin < end) {
			Integer partitionIndex = partition(arr, begin, end);

			quickSort(arr, begin, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, end);
		}
	}

	private static Integer partition(Integer arr[], int begin, int end) {
		int pivot = arr[end];
		int i = (begin - 1);

		for (int j = begin; j < end; j++) {
			if (arr[j] <= pivot) {
				i++;

				int swapTemp = arr[i];
				count++;
				arr[i] = arr[j];
				count++;
				arr[j] = swapTemp;
				count++;
			}
		}

		int swapTemp = arr[i + 1];
		count++;
		arr[i + 1] = arr[end];
		count++;
		arr[end] = swapTemp;
		count++;

		return i + 1;
	}

}
