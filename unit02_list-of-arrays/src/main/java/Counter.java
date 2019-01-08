public class Counter {
    private int _numberOfElements;
    private int _numberOfArrays;
    private int _arrayCapacity;

    Counter(int arrayCapacity){
        _numberOfElements = 0;
        _numberOfArrays = 0;
        _arrayCapacity = arrayCapacity;
    }

    void addArray(){
        ++_numberOfArrays;
    }

    void addElement(){
        ++_numberOfElements;
    }

    void removeArray(){
        --_numberOfArrays;
    }

    void removeElement(){
        --_numberOfElements;
    }

    int arrays(){
        return _numberOfArrays;
    }

    int elements(){
        return _numberOfElements;
    }

    public int arrayCapacity() {
        return _arrayCapacity;
    }
}
