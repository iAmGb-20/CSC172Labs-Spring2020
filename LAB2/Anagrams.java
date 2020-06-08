import java.util.Arrays;

public class Anagrams {
	public static void main(String args[]) {
		Anagrams solution = new Anagrams();
		boolean answer = solution.isRotation("1234", "4567");
		boolean answer2 = solution.findAnagram("123", "456");
		System.out.println( "they are " + answer2 + " anagrams");
		System.out.println( "they are " + answer + " rotations");
		
	}
	public boolean findAnagram(String first, String second) {
		if (first.length()!= second.length()) return false;
		else {  
		int n = first.length();
		char[] arr1 = new char[n];
		char[] arr2 = new char[n];
		
		for (int i=0;i<n;i++) {
			arr1[i] = first.charAt(i);
			arr2[i] = second.charAt(i);
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		return Arrays.equals(arr1, arr2);
		}
		
	}
	
	public boolean isRotation(String first,String second) {
		
		if (first.length()!= second.length()) return false;
		
		else {
			int k = second.length();
			int j = first.length();
			for(int i=0;i<j;i++) {
				
				if (first.contentEquals(second)) {
					return true;
				}else {
					first = first.substring(1) + first.substring(0, 1);
				}
			}
			return false;
			
		}
	}
	 

}
