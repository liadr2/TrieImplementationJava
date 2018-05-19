
public class Trie {

	private TrieNode root;

	public Trie(String[] lang) {
		char c = Character.MIN_VALUE;
		this.root = new TrieNode(c, 26);
		initializeLang(lang);

	}

	public void initializeLang(String[] lang) {
		for (int i = 0; i < lang.length; i++) {
			String toInsert = lang[i];
			insertToTrie(toInsert, this.root);
		}
	}

	public void insertToTrie(String toInsert, TrieNode location) {
		while (!toInsert.isEmpty()) {
			char c = toInsert.charAt(0);
			c = (char) (c - 'a');
			if (location.getChildren()[c] == null)
				location.getChildren()[c] = new TrieNode(c, 26);
			location = location.getChildren()[c];
			toInsert = toInsert.substring(1);
		}
		location.isWord = true;
	}

	public boolean legalWord(String word) {
		return legalWord(word, this.root);
	}

	public boolean legalWord(String word, TrieNode curr) {
		if (word.length() == 0) {
			if (curr.isWord)
				return true;
			return false;
		} else {
			while (!word.isEmpty()) {
				char c = word.charAt(0);
				if (curr.getChildren()[(char) c - 'a'] == null)
					return false;
				return legalWord(word.substring(1), curr.getChildren()[(char) c - 'a']);
			}
			return false;
		}

	}

	private class TrieNode {
		private char data;
		private TrieNode[] children;
		private boolean isWord;

		public TrieNode(char c, int ALPHABET_SIZE) {
			this.data = c;
			this.children = new TrieNode[ALPHABET_SIZE];
			this.isWord = false;
		}

		public TrieNode[] getChildren() {
			return this.children;
		}

	}

}
