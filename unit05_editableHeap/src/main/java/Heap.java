public class Heap {

    private static final int VERTEX_ID = 0;
    private int[] _data;
    private int _size;
    private int _lastChildId;
    private int _lastParentId;

    Heap(int [] data){
        _data = data;
        setParameters();
    }

    public int size(){
        return _size;
    }

    public int[] data(){
        return _data;
    }

    public void interchange(int id1, int id2) {
        int temp = _data[id1];
        _data[id1] = _data[id2];
        _data[id2] = temp;
    }

    private void setParameters(){
        _size = _data.length;
        _lastChildId = _size - 1;
        _lastParentId = (_size -1)/2 - _size %2;
    }

    public int cutVertex(){
        int vertex = _data[VERTEX_ID];
        removeNode(VERTEX_ID);
        return vertex;
    }

    public void removeNode(int id){
        if(id >=0 && id < _size) {
            _data[id] = 0;
            interchange(id, _lastChildId);
            int idToDrown = whichIsElder(id, parentOf(id));
            drown(idToDrown);
            reduceData();
        }
    }

    private int parentOf(int id) {
        return (id-1)/2;
    }

    private void reduceData() {
        _size--;
        int [] temp = new int[_size];
        for(int i = 0; i < _size; i++ ){
            temp[i] = _data[i];
        }
        _data = temp;
        setParameters();
    }

    public int lastParentId() {
        return _lastParentId;
    }

    public int vertexId(){
        return VERTEX_ID;
    }

    public int firstbornIdOf(int id) {
        int firstbornId = id*2+1;
        if(firstbornId < _lastChildId){
            firstbornId = whichIsElder(id*2+1, id*2+2);
        }
        return firstbornId;
    }

    int whichIsElder(int id1, int id2) {
        int result = id1;
        if(_data[id1] < _data[id2]) {
            result = id2;
        }
        return result;
    }

    void drown(int parentId){
        int firstbornId;
        while(parentId <= _lastParentId){
            firstbornId = firstbornIdOf(parentId);
            if(parentId != whichIsElder(parentId, firstbornId)) {
                interchange(parentId, firstbornIdOf(parentId));
            }
            parentId = firstbornId;
        }
    }
}
