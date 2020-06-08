import java.util.ArrayList;

public class HashTable {
	String[] myhashTable;
	int noOfCellsUsed;
	int capacity = 100;

	public HashTable() {
		myhashTable = new String[13];
		noOfCellsUsed = 0;
		this.capacity = capacity;

	}

	public int simpleStringFunction(String key, int mod) {
		char ch[];
		ch = key.toCharArray();
		int sum, i;

		for (sum = 0, i = 0; i < key.length(); i++) {
			sum = sum + ch[i];
		}
		//System.out.println("index from hash function is: " + sum % mod);
		return sum % mod;
	}

	public int getCapacity() {
		return capacity;
	}

	public int increaseCapacity() {
		capacity*=2;
		return capacity;
	}

	public double getLoadFactor() {
		double loadFactor = noOfCellsUsed * 1.0 / myhashTable.length;
		return loadFactor;

	}

	//little help hree, i want to make sure that if the element exists then we jsut return and do nothing
	public void insertKeyInHashTable(String value) {
		double loadfactor = getLoadFactor();

		if (loadfactor > 0.5) {// if this is the case then we need to rehash in new table, doubling the size
			System.out.println("Load factor of the table has exceed 50% so we need to rehash!\n");
			rehashKeys(value);
		} else {
			//System.out.println("Inserting " + value + " in HashTable...");
			int index = simpleStringFunction(value, myhashTable.length);
				for (int i = index; i < index + myhashTable.length; i++) {
					int newIndex = i % myhashTable.length;

					if (myhashTable[newIndex] == null && searchKeyInHashTable(value) == false) {
						myhashTable[newIndex] = value;
						System.out.println("index " + newIndex + " is blank, inserting there...");
						//System.out.println("Successfully inserted " + value + " in location: " + newIndex);
						noOfCellsUsed++;
						//System.out.println("-------------------------------------------\n");
						break;
					} else {
					//	System.out.println("Index: " + newIndex + " is already occupied. Trying next empty cell...");
					}
				}
			
		}
		//if(searchKeyInHashTable(value) == false)noOfCellsUsed++;
		//noOfCellsUsed++;
	}

	public void rehashKeys(String tobeInserted) {
		// here, we copy all the data in the old hashtable to the new one and then
		// multiply the capacity by two, then add the value
		noOfCellsUsed = 0;
		ArrayList<String> newTable = new ArrayList<String>();
		for (String s : myhashTable) {
			if (s != null) {
				newTable.add(s);
			}
		}
		newTable.add(tobeInserted);
		int newSize = increaseCapacity();
		myhashTable = new String[newSize];//make the new table with double the size
		for (String s : newTable) {
			insertKeyInHashTable(s);//push all old data to the new table
		}
	}
	public boolean searchKeyInHashTable(String tobeSearched) {
		int index = simpleStringFunction(tobeSearched, myhashTable.length);
		for(int i = index; i < index + myhashTable.length; i++) {
			int newIndex = i%myhashTable.length;
			if(myhashTable[newIndex] != null && myhashTable[newIndex].equals(tobeSearched)) {
				//System.out.println(tobeSearched + " found in HashTable at location: "+newIndex);
				return true;
			} 
		}
	//	System.out.println(tobeSearched + " not found in HashTable!");
		return false;
	}

	public void printHashTable() {
		if(myhashTable == null) {
			System.out.println("\nHashTable does not exits !");
			return;
		}else {
			System.out.println("\n---------- HashTable ---------");
			for (int i = 0; i < myhashTable.length; i++) {
				if(myhashTable[i]!= null) System.out.println("Index:" + i + ".   Key:" + myhashTable[i]);
			}
		}
		System.out.println("\n");
	}
	
	
	// end of method
	// implement insert and print(non-null)
	// insert should only add the string to the table if it was not present before
	// if asked to insert a string already present, your insert method should do
	// nothing
	// test by adding five names and then print them out

	// getter methods for its capacity
	// getter method number of items(unique) in the hashtable
	// getter method for load factor

	// Use the load factor modify your insert method to detect when the load factor
	// exceeds 50%.
	// When this happens, you should expand the array to double its original length
	// and “rehash” the strings into the new array

	// test with lorem ipsum text
}
