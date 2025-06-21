package dataStructures.trie;

public class Trie {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26]; // a-z
        boolean isEndOfWord = false;
    }

    private final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null)
                node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private TrieNode searchNode(String str) {
        TrieNode node = root;
        for (char ch : str.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null)
                return null;
            node = node.children[idx];
        }
        return node;
    }
}
