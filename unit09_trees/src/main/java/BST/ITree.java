package BST;

/**
 * @param <T1>
 * @param <T2>
 */
public interface ITree<T1 extends Comparable<T1>, T2> {

    /**
     * @param key
     * @return
     */
    T2 get(T1 key);

    /**
     * @param key
     * @param value
     */
    void insert(T1 key, T2 value);

    /**
     * @param key
     */
    void remove(T1 key);
}
