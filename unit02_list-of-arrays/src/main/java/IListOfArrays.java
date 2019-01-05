public interface IListOfArrays <T>{
    T get(int i);
    void add (int index, T item);
    void remove(int index);
}
