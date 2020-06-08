import java.io.BufferedReader;
import java.io.FileReader;

public class HashTableMain {

	public static void main(String args[]) {

		HashTable linearProbing = new HashTable();
		linearProbing.insertKeyInHashTable("Harry");
		linearProbing.insertKeyInHashTable("Harry");
		linearProbing.insertKeyInHashTable("Harry");
		linearProbing.insertKeyInHashTable("Harry");
		linearProbing.insertKeyInHashTable("Harry");
		linearProbing.insertKeyInHashTable("Harry");
		linearProbing.insertKeyInHashTable("Jerry");
		linearProbing.insertKeyInHashTable("Kerry");
		linearProbing.insertKeyInHashTable("Lerry");
		linearProbing.insertKeyInHashTable("Perry");
		linearProbing.insertKeyInHashTable("Nerry");
		linearProbing.insertKeyInHashTable("Merry");
		linearProbing.insertKeyInHashTable("Juma");
		linearProbing.printHashTable();

		HashTable ht = new HashTable();
		// BufferedReader reader;

		try {
			System.out.println("in try block to find values from file");

			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			String input = reader.readLine();
			System.out.println("working...");
			// boolean cx = true;

			while (input != null) {
// as long as there is a line following the current line we are at...then do the
// following

				// System.out.println("Hi I am working!!!!");
				String[] inn;
				inn = input.split(" ");

				for (String value : inn) {
					ht.insertKeyInHashTable(value);
					// System.out.println(value);
				}
				System.out.println("next line");
				input = reader.readLine();

			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not working...");
		}

		System.out.println("-----------------Here is the hash table-------------------------");
		ht.printHashTable();
		System.out.println(ht.noOfCellsUsed);

	}

}