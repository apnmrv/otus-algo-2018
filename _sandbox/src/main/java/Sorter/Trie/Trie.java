package Sorter.Trie;

public class Trie {
    TrieNode __root;

    Trie(int alphabetLength){
        __root = new TrieNode(alphabetLength, 0);
    }
}
