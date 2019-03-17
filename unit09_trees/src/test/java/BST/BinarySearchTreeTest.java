package BST;

import AVL.AVLTree;
import Randomizer.IRandomizer;
import Randomizer.Randomizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private static final int __MAX = 1000;
    private static final int __MIN = 0;
    private static final int __LENGTH = 1000;

    private static final int __COUNT = 1000;

    private BinarySearchTree __tree;
    private IRandomizer __randomizer;

    @BeforeEach
    void setUp(){
        __randomizer = new Randomizer();
        __tree = new BinarySearchTree ();
    }

    @Test
    void testKeepsBalanceWhileInserting(){
        int [] keys = __randomizer.getUniques(__MIN, __MAX);

        for (int k : keys) {
            __tree.insert(k, __randomizer.getRandomSequence(__MIN, __MAX, 20));
            assertTrue(__tree.isBinarySearchTree(Integer.MIN_VALUE, Integer.MAX_VALUE));
        }
    }

    @Test
    void testKeepsBalanceWhileRemoving(){
        int [] keys = __randomizer.getUniques(__MIN, __MAX);

        for (int k : keys) {
            __tree.insert(k, __randomizer.getRandomSequence(__MIN, __MAX, 20));
        }

        for (int k : keys) {
            __tree.remove(k);
            assertTrue(__tree.isBinarySearchTree(Integer.MIN_VALUE, Integer.MAX_VALUE));
        }
    }
}