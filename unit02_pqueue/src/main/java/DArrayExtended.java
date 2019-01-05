public class DArrayExtended <T> extends DArray{

    private T first;
    private T last;
    private T current;

    DArrayExtended(){
    }

    @Override
    Object get(int index) {

        T result = null;

        if(index < size()){
            result = (T) super.get(index);
        }

        return result;
    }

    @Override
    protected void add(int index, Object element) {
        if (_arr == null || _arr.length <= index)
            relocate(index+10, index);
        _arr[index] = (Object)element;
    }

    T first(){
        return first;
    }

    T last(){
        return last;
    }

    T current(){

        T curr = current;

        current = next(current);

        return curr;
    }

    private T next(T item){
        T next = null;

        for(int i = 0; i < size(); i++){
            if(get(i) == item) {
                next = (T) get(i+1);
                break;
            }
        }

        return next;
    }

    void insert(int index, Object element) {

        super.add(index, element);
        shiftPointers();
    }

    private void shiftPointers() {
        if(null != get(0)) {
            first = (T) get(0);
        }
        if(null != get(size()-1)){
            last = (T) get(size()-1);
        }
    }
}
