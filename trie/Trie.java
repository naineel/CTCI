package trie;

import java.util.HashMap;
import java.util.Set;

public class Trie {
	TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void Insert(String word) {
		HashMap<Character, TrieNode> children = root.children;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode t;
			if (children.containsKey(c)) {
				t = children.get(c);
			} else {
				t = new TrieNode(c);
				children.put(c, t);
			}
			children = t.children;
			
			if (i == word.length()-1) {
				t.isLeaf = true;
			}
		}
	}
	
	public boolean search(String word, TrieNode root) {
		TrieNode t = searchNode(word, root);
		if (t != null && t.isLeaf) {
			return true;
		} else {
			return false;
		}
	}
	
	private TrieNode searchNode(String word, TrieNode root) {
		HashMap<Character, TrieNode> children = root.children;
		TrieNode t = null;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (children.containsKey(c)) {
				t = children.get(c);
				children = t.children;
			} else {
				return null;
			}
		}
		return t;
	}
	
	private void printNode(TrieNode n, StringBuilder s) {
		if (n.children.size() > 0) {

			HashMap<Character, TrieNode> children = n.children;
			Set<Character> cha = children.keySet();
			for (Character character : cha) {
				TrieNode child = children.get(character);
				s.append(n.c);
				if (n.isLeaf) {
					System.out.println(s);
				}
				printNode(child, s);
			}

		}
	}

	static class TrieNode {
		char c;
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		Boolean isLeaf;
		
		public TrieNode() { 
			this.isLeaf = false;
		}
		
		public TrieNode(char c) {
			this.c = c;
			this.isLeaf = false;
		}
	}
	
	public static void main(String[] args) {
		Trie t = new Trie();
		t.Insert("an");
		t.Insert("ant");
		t.Insert("all");
		t.Insert("allot");
		t.Insert("alloy");
		t.Insert("aloe");
		t.Insert("are");
		t.Insert("ate");
		t.Insert("be");
		System.out.println(t.search("ant", t.root));
		
		StringBuilder s = new StringBuilder();
		t.printNode(t.root, s);
	}
	
}
