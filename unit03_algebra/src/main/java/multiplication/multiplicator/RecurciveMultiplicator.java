package multiplication.multiplicator;

public class RecurciveMultiplicator implements IMultiplicator {
    int _signX = 1;
    int _signY = 1;
    int _xBits;
    int _yBits;

    @Override
    public int multiply(int x, int y) {
        if(0 == x || 0 == y) return 0;

        int sign = _signX*_signY;
        setParams(x, y);
        if(1 == _xBits) return y*sign;
        if(1 == _yBits) return x*sign;
        
        return multiplyRecursively(x, y)*sign;
    }

    private int multiplyRecursively(int x, int y) {
        int [] a  = {x>>_xBits/2+1};
        return a[0];
    }

    private void setParams(int x, int y) {
        _signX = getSign(x);
        _signY = getSign(y);
        _xBits = getBinarySize(x*_signX);
        _yBits = getBinarySize(y*_signY);
    }

    private int getBinarySize(int num) {
        int result = 1;
        while(num > 1){
           num /= 2;
           result++;
        }
        return result;
    }

    private int getSign(int num) {
        int result = 1;
        if(num < 0) result *=-1;
        return result;
    }
}
