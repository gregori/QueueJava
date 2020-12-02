public class ArrayQueue<T> implements Queue<T> {
    private int first;
    private int last;
    private T[] queue;
    private int capacity;

    public ArrayQueue(int size) {
        first = 0;
        last = 0;
        queue = (T[]) new Object[size];
        capacity = size;
    }

    public boolean isFull() {
        return last == capacity - 1;
    }

    @Override
    public void enqueue(T data) {
        if (isFull())
            throw new IndexOutOfBoundsException("Fila cheia!");

        queue[last++] = data;
    }

    @Override
    public T dequeue() {
        T data;

        if (isEmpty())
            throw new IndexOutOfBoundsException("Fila vazia!");

        data = queue[0];
        for (int i = 0; i < last; i++) {
            queue[i] = queue[i+1];
        }
        last--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return first == last;
    }
}
