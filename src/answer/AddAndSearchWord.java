package answer;

public class AddAndSearchWord {
	/**
	 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
	 */
	class TrieNode {
		public char val;
		public TrieNode[] children = new TrieNode[26];
		public boolean isWord;
		
		public TrieNode(char ch) {
			val = ch;
		}
	}
	
	private TrieNode root = new TrieNode(' ');
	// Adds a word into the data structure.
    public void addWord(String word) {
    	TrieNode node = root;
    	char[] array = word.toCharArray();
    	for (char ch : array) {
    		if (node.children[ch - 'a'] == null) {
    			node.children[ch - 'a'] = new TrieNode(ch);
    		}
    		node = node.children[ch - 'a'];
    	}
    	node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	return helper(0, word, root);
    }
    
    private boolean helper(int start, String word, TrieNode node) {
    	if (start >= word.length() && node.isWord == true)
    		return true;
    	
    	if (start >= word.length())
    		return false;
    	
    	if (word.charAt(start) == '.') {
    		for (int i = 0; i < 26; ++i) {
    			if (node.children[i] != null && helper(start + 1, word, node.children[i]))
    				return true;
    		}
    	} else {
    		int i = (int)(word.charAt(start) - 'a');
    		if (node.children[i] != null && helper(start + 1, word, node.children[i]))
    				return true;
    	}
    	
    	return false;
    }
    
    public static void main(String[] args) {
    	AddAndSearchWord a = new AddAndSearchWord();
    	a.addWord("bad");
    	a.addWord("dad");
    	System.out.println(a.search("pa."));
    }
}
