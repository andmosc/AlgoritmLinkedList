package arrLinkedList;

public class ArrLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public int size() {
        return size;
    }

    public void addFirst(T element) {
        Node<T> prev = head;
        Node<T> newNode = new Node<>(null, element, prev);

        if (head == null)
            tail = newNode;
        else
            prev.previos = newNode;

        head = newNode;
        size++;
    }

    public void addLast(T element) {
        Node<T> prev = tail;
        Node<T> newNode = new Node<>(prev, element, null);
        if (head == null) {
            head = newNode;
        } else {
            prev.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public boolean remove(T element) {
        Node<T> currentNode = head;
        for (Node<T> x = head; x != null; x = x.next) {
            if (element.equals(x.element)) {
                removeNode(x);
                return true;
            }
        }
        return false;
    }

    private T removeNode(Node<T> nodeDel) {
        Node<T> perv = nodeDel.previos;
        Node<T> next = nodeDel.next;
        T element = nodeDel.element;

        if (perv == null) {
            head = next;
        } else {
            perv.next = next;
            nodeDel.previos = null;
        }
        if (next == null) {
            tail = perv;
        } else {
            next.previos = perv;
            nodeDel.next = null;
        }

        size--;
        nodeDel.element = null;

        return element;
    }

    public T get(int index) {
        return node(index).element;
    }

    public T set(int index, T element) {
        if (index >= 0 && index <= size) {
            Node<T> currentNode = node(index);
            T oldValue = currentNode.element;
            currentNode.element = element;
            return oldValue;
        }
        return null;
    }

    Node<T> node(int index) {
        if (index < (size >> 1)) {
            Node<T> x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<T> x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.previos;
            return x;
        }
    }

    private static class Node<T> {
        Node<T> previos;
        T element;
        Node<T> next;

        public Node(Node<T> previos, T element, Node<T> next) {
            this.previos = previos;
            this.element = element;
            this.next = next;
        }
    }
}
