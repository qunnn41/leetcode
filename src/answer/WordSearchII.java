package answer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
	/**
	 * https://leetcode.com/problems/word-search-ii/
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
	
	class Trie {
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
	
	Set<String> result = new HashSet<String>();
	
	public List<String> findWords(char[][] board, String[] words) {
		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}
		
		int m = board.length;
		int n = board[0].length;
		
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; ++i) 
			for (int j = 0; j < n; ++j)
				dfs(board, visited, "", i, j, trie);
		
		return new ArrayList<String>(result);
	}
	
	private void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
			return;
		if (visited[x][y])
			return;
		
		str += board[x][y];
		if (!trie.startsWith(str))
			return;
		
		if (trie.search(str))
			result.add(str);
		
		visited[x][y] = true;
		dfs(board, visited, str, x + 1, y, trie);
		dfs(board, visited, str, x - 1, y, trie);
		dfs(board, visited, str, x, y + 1, trie);
		dfs(board, visited, str, x, y - 1, trie);
		visited[x][y] = false;
	}
}
