

public class LAB2 {
	
	public static void printArrayNonGen (Object [] myArray) {
		for (Object x: myArray) {
			System.out.printf("%s ", x);
		}
		System.out.println();
	}
	public static void printArray (Integer [] array) {
		for (Integer x : array) {
			System.out.printf("%s ", x);
		}
		System.out.println();
	}
	public static void printArray (Character [] array) {
		for (Character x : array) {
			System.out.printf("%s ", x);
		}
		System.out.println();
	}
	
	public static void printArray (String [] array) {
		for (String s : array) {
			System.out.printf("%s ", s);
		}
		System.out.println();
	}
	
	public static void printArray (Double [] array) {
		for (Double d : array) {
			System.out.printf("%s ", d);
		}
		System.out.println();
	}
	public static <A>void printArrayGen (A [] theArray){
		for (A Gen : theArray) {
			System.out.printf("%s ", Gen);
		}
		System.out.println();
	}
	public static Comparable getMax (Comparable [] anArray) {
		
		if (anArray.length == 1) {
			return anArray[0];
			
		}
		
		Comparable maximum = anArray[0];
		
		
		for (int i = 1; i< anArray.length; i++) {
			if (anArray[i].compareTo(maximum) > 0) {
				maximum = anArray[i];
					
			}
		}
		
		return maximum;
		
	}
	
	public static <anyType extends Comparable<? super anyType>>anyType getMaxGen (anyType[] arr){
		int biggest = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].compareTo(arr[biggest]) > 0) {
				biggest = i;
				
			}
		}
		return arr[biggest];
	}

	public static void main(String args[]) {
		Integer [] intArray = {1,2,3,4,5};
		Double [] doubleArray = {1.1,2.2,3.3,4.4};
		Character [] characterArray = {'H', 'E', 'L', 'L', 'O'};
		String [] stringArray = {"once", "upon", "a", "time"};
		
		System.out.println("The array of integer contains: ");
		printArray(intArray);
		
		System.out.println("\nThe array of double contains: ");
		printArray(doubleArray);
		
		System.out.println("\nThe array of characters contains: ");
		printArray(characterArray);
		
		System.out.println("\nThe array of strings contains: ");
		printArray(stringArray);
		System.out.println();
		
		
		System.out.println("here is the test for the non gen method");
		printArrayNonGen(intArray);
		System.out.println();
		printArrayNonGen(doubleArray);
		System.out.println();
		printArrayNonGen(characterArray);
		System.out.println();
		printArrayNonGen(stringArray);
		System.out.println();
		
		System.out.println("here is the test for the generic method");
		System.out.println("maximum element in an integer array is " + getMax(intArray));
		System.out.println();
		System.out.println("maximum element in an double array is " + getMax(doubleArray));
		System.out.println();
		System.out.println("maximum element in an character array is " + getMax(characterArray));
		System.out.println();
		System.out.println("maximum element in the string array is " + getMax(stringArray));
		System.out.println();
		
		
		System.out.println("here is the test for the type safe method with generics");
		System.out.println("maximum element in an integer array is " + getMaxGen(intArray));
		System.out.println();
		System.out.println("maximum element in an double array is " + getMaxGen(doubleArray));
		System.out.println();
		System.out.println("maximum element in an character array is " + getMaxGen(characterArray));
		System.out.println();
		System.out.println("maximum element in the string array is " + getMaxGen(stringArray));
		System.out.println();
		
		//getMaxGen(intArray);
	}

}
