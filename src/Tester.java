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

	}

}
