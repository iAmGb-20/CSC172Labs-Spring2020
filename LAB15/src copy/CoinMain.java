public class CoinMain {

	public static int[][] table;
	static int calls = 0;

	public static void main(String args[]) {

		int[] denominations = { 100000, 50000, 2000, 1000, 500, 100, 25, 10, 5, 1 };
		calls = 0;

		int amount = 348;
		if (args.length == 1) {
			amount = Integer.parseInt(args[0]);
		}
		int[] change = makeChange(amount, denominations);

		System.out.print("Change for " + amount + " is {");

		for (int a : change) {
			System.out.print(a + ", ");
		}
		System.out.println("}");

		System.out.println("calls: " + calls);

	}

	public static int[] makeChange(int amount, int[] denominations) {
		table = new int[amount + 1][];

		int[] counts = new int[denominations.length + 1];
		recMakeChange(amount, denominations, counts);
		int[] answer = expandArray(counts, denominations);
		return answer;

	}

	public static int[] expandArray(int[] counts, int[] denominations) {
		int[] solution = new int[counts[counts.length - 1]];

		int position = 0;

		for (int i = 0; i < counts.length - 1; i++) {
			for (int j = counts[i]; j > 0; j--) {
				solution[position] = denominations[i];
				position++;
			}
		}
		return solution;
	}

	public static boolean recMakeChange(int amount, int[] denominations, int[] counts) {

		calls++;

		boolean flag = false;
		if (amount == 0) {
			return true;
		} else if (amount < 0) {
			// System.out.println("something is wrong");
			return false;
		}
		if (table[amount] != null) {
			for (int k = 0; k < counts.length; k++) {
				counts[k] = table[amount][k];
			}
			return true;
		}

		int temp[] = new int[counts.length];
		int bestSol[] = new int[counts.length];

		bestSol[counts.length - 1] = amount + 1;

		for (int i = 0; i < denominations.length; i++) {

			flag = true;
			if (recMakeChange(amount - denominations[i], denominations, temp)) {
				if (temp[temp.length - 1] < bestSol[bestSol.length - 1]) {
					temp[i] = temp[i] + 1;
					temp[temp.length - 1] = temp[temp.length - 1] + 1;
					for (int z = 0; z < bestSol.length; z++) {
						bestSol[z] = temp[z];
					}
				}

			}

		}
		if (flag) {
			table[amount] = new int[counts.length];
			for (int k = 0; k < bestSol.length; k++) {
				table[amount][k] = counts[k] = bestSol[k];
			}
		}

		return flag;
	}

}
