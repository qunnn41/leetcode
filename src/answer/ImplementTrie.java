package answer;

public class ImplementTrie {
	/**
	 * https://leetcode.com/problems/implement-trie-prefix-tree/
	 */
	class TrieNode {
	    // Initialize your data structure here.
		public char val;
		public TrieNode[] children = new TrieNode[26];
		public boolean isWord;
	    public TrieNode() {
	    	
	    }
	    
	    public TrieNode(char ch) {
	    	this();
	    	val = ch;
	    }
	}

	public class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode(' ');
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
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

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        TrieNode node = root;
	        char[] array = word.toCharArray();
	        for (char ch : array) {
	        	if (node.children[ch - 'a'] == null)
	        		return false;
	        	node = node.children[ch - 'a'];
	        }
	        
	        return node.isWord;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	    	TrieNode node = root;
	        char[] array = prefix.toCharArray();
	        for (char ch : array) {
	        	if (node.children[ch - 'a'] == null)
	        		return false;
	        	node = node.children[ch - 'a'];
	        }
	        
	        return true;
	    }
	}
}
