import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {

		String[] lang = { "a", "abc", "afn", "jsfb", "shbfkhs" };
		Trie t = new Trie(lang);
		System.out.println(t.legalWord("a")); // true
		System.out.println(t.legalWord("abc")); // true
		System.out.println(t.legalWord("jsf")); // false
		System.out.println(t.legalWord("jsfb")); /// true
		System.out.println(t.legalWord("ab")); // false
		System.out.println(t.legalWord("s")); // false
		System.out.println();
		System.out.println();
		System.out.println();
		int[] arr = { 1, 2, 3 };
		printSubSets(arr);
		System.out.println();
		hanoi(3);
		System.out.println();
		System.out.println(tripleSteps(3));
		System.out.println();
		print(3, 6, new int[3]);
		System.out.println();
		catalan(5);
		System.out.println(makeChange(100));

	}

	public static int makeChange(int amount, int[] denoms, int index, int[][] map) {
		if (index >= denoms.length - 1)
			return 1;
		else if (map[amount][index] > 0)
			return map[amount][index];
		int ways = 0;
		int denomAmount = denoms[index];
		for (int i = 0; i * denomAmount <= amount; i++) {
			int amountRemaining = amount - i * denomAmount;
			if (map[amount][index] == 0)
				ways += makeChange(amountRemaining, denoms, index + 1, map);
		}
		map[amount][index] = ways;
		return ways;
	}

	public static int makeChange(int n) {
		int[] denoms = { 25, 10, 5, 1 };
		int[][] map = new int[n + 1][denoms.length];
		return makeChange(n, denoms, 0, map);
	}

	public static int tripleSteps(int n) {
		int[] table = new int[n + 1];
		return tripleSteps(n, table);
	}

	public static void catalan(int n) {

		catalan(n, 0, 0, new String(""));

	}

	public static void catalan(int n, int open, int close, String acc) {
		if (open == n & close == n)
			System.out.println(acc);
		else if (close > open)
			return;
		else if (open == n)
			catalan(n, open, close + 1, acc + ")");
		else {
			catalan(n, open + 1, close, acc + "(");
			catalan(n, open, close + 1, acc + ")");
		}
	}

	public static int tripleSteps(int n, int[] table) {
		if (n == 0)
			return 1;
		else if (n < 0)
			return 0;
		else if (table[n] == 0) {
			table[n] = tripleSteps(n - 1, table) + tripleSteps(n - 2, table) + tripleSteps(n - 3, table);
		}

		return table[n];
	}

	public static void print(int n, int k, int[] A) {
		if (n <= 0) {
			System.out.println(Arrays.toString(A));
		} else {
			for (int i = 1; i <= k; i++) {
				A[n - 1] = i;
				print(n - 1, k, A);
			}
		}
	}

	public static void hanoi(int numOfDiscs) {
		hanoi(numOfDiscs, 'a', 'c', 'b');
	}

	public static void hanoi(int numOfDiscs, char destination, char target, char helper) {
		if (numOfDiscs > 0) {
			hanoi(numOfDiscs - 1, destination, helper, target);
			System.out.println("Move from " + destination + " to " + target);
			hanoi(numOfDiscs - 1, helper, target, destination);
		}
	}

	public static void printSubSets(int[] arr) {
		printSubSets(arr, 0, new String(""));
	}

	public static void printSubSets(int[] arr, int i, String acc) {
		if (i == arr.length)
			System.out.println("{" + acc + "}");
		else {
			printSubSets(arr, i + 1, acc);
			printSubSets(arr, i + 1, acc + arr[i]);
		}
	}

}
