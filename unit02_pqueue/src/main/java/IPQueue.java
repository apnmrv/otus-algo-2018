public interface IPQueue {

    public <T> void enqueue (int priority, T item);

    public <T> T dequeue();

}
