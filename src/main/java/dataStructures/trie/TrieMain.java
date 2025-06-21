package dataStructures.trie;

public class TrieMain {

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println("Adding apple to trie.");
        trie.insert("apple");
        System.out.printf("Is \"app\" present ? : %b", trie.search("app"));
        System.out.printf("\nIs \"apple\" present ? : %b", trie.search("apple"));
        System.out.printf("\nAny word starting with \"app\" ? : %b ", trie.startsWith("app"));
        System.out.printf("\nAny word starting with \"ape\" ? : %b", trie.startsWith("ape"));
    }
}
