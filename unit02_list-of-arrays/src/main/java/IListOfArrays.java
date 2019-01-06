public interface IListOfArrays <T>{
    T get(int i);
    void add (T item);
    void insert (int index, T item);
    void remove(int index);
}
