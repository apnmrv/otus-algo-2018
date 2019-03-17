package AVL;
import Randomizer.IRandomizer;
import Randomizer.Randomizer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest<T1 extends Comparable<T1>, T2> {

    private static final int __MAX = 1000;
    private static final int __MIN = 0;
    private static final int __LENGTH = 1000;

    private static final int __COUNT = 1000;

    private AVLTree __tree;
    private IRandomizer __randomizer;

    @BeforeEach
    void setUp(){
        __randomizer = new Randomizer();
        __tree = new AVLTree ();
    }

    @Test
    void testKeepsBalanceWhileInserting(){
        int [] keys = __randomizer.getUniques(__MIN, __MAX);

        for (int k : keys) {
            __tree.insert(k, __randomizer.getRandomSequence(__MIN, __MAX, 20));
            assertTrue(__tree.isBalanced());
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
            assertTrue(__tree.isBalanced());
        }
    }
}