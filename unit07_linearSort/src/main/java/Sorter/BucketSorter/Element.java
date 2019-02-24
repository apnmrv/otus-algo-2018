package Sorter.BucketSorter;

public class Element {
    private int __value;
    private Element __nextElement = null;

    Element(int element, Element nextElement) {
        __value = element;
        __nextElement = nextElement;
    }

    Element(int element) {
        __value = element;
    }

    void setNext(Element element){
        __nextElement = element;
    }

    public int value() {
        return __value;
    }

    public Element next() {
        return __nextElement;
    }
}
