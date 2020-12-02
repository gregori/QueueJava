public class ObjectQueue<T> implements Queue<T> {
    private Node<T> first;
    private Node<T> last;

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    @Override
    public void enqueue(T data) {
        Node<T> aux = new Node<>(data);
        if (isEmpty()) {
            last = aux;
            aux.next = first;
            first = aux;
        } else {
            aux.next = null;
            last.next = aux;
            last = aux;
        }
    }

    @Override
    public T dequeue() {
        Node<T> aux;
        T data;

        if (!isEmpty()) {
            aux = first;
            first = first.next;
            data = aux.getData();

            if (first == null) {
                last = null;
            }

            return data;
        } else {
            throw new IndexOutOfBoundsException("Fila vazia!");
        }
    }

    public T getFirst() {
        return first.data;
    }

    public T getLast() {
        return last.data;
    }

    @Override
    public boolean isEmpty() {
        return (first == null && last == null);
    }
}
