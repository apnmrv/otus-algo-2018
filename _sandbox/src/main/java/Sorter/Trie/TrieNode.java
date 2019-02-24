package Sorter.Trie;

public class TrieNode<T> {
    TrieNode [] __children;
    int __value;
    boolean __isALeaf = false;

    TrieNode(int size, int index){
        __children = new TrieNode[size];
        __value = index;
    }

    boolean isALeaf(){
        return __isALeaf;
    }

    TrieNode childNode(int idx){
        return __children[idx];
    }

    void makeALeaf(){
        __isALeaf = true;
    }

    int value(){
        return __value;
    }
}
