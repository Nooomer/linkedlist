import java.util.*;

public class LinkedList<T> implements List<T>, Deque<T> {
    //Роберт Мартин, Чистый Код
    Node<T> first; //first element
    Node<T> last; //last element
    int size = 0; //size of list

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object data) {
        return indexOf(data) != -1;
    }

    @Override
    public T element() {
        return getFirst();
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public void addFirst(T element) {
        add(0, element);
    }

    @Override
    public void addLast(T element) {
        add(element);
    }

    @Override
    public boolean offerFirst(T t) {
        return false;
    }

    @Override
    public boolean offerLast(T t) {
        return false;
    }

    @Override
    public T removeFirst() {
        remove(first);
        return null;
    }

    @Override
    public T removeLast() {
        remove(last);
        return null;
    }

    @Override
    public T pollFirst() {
        return null;
    }

    @Override
    public T pollLast() {
        return null;
    }

    @Override
    public T getFirst() {
        return first.data;
    }

    @Override
    public T getLast() {
        return last.data;
    }

    @Override
    public T peekFirst() {
        return null;
    }

    @Override
    public T peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Iterator<T> descendingIterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.isEmpty()) {
            first = newNode;
        } else {
            Node<T> prevNode = last;
            while (prevNode.next != null) {
                prevNode = prevNode.next;
            }
            prevNode.next = newNode;
            newNode.prev = prevNode;
        }
        last = newNode;
        size++;
        return true;
    }

    @Override
    public boolean offer(T t) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public boolean remove(Object data) {
        Node<T> node = getNodeByIndex(this.indexOf(data));
        Node<T> next = node.next;
        Node<T> prev = node.prev;
        if (prev == null) {
            first = node.next;
        } else {
            prev.next = next;
            node.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        node.data = null;
        size--;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (int i = 0; i < collection.size(); i++) {
            if (!contains(collection.toArray()[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public void push(T t) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    Node<T> getNodeByIndex(int index) {

        Node<T> node;
        if (index < size - 1) {
            node = first;
            for (int i = 0; i < index; i++)
                node = node.next;
        } else {
            node = last;
            for (int i = size - 1; i > index; i--)
                node = node.prev;
        }
        return node;
    }

    @Override
    public T get(int index) {
        return getNodeByIndex(index).data;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    void addBeforeNode(T data, Node<T> node) {
        Node<T> prev = node.prev;
        Node<T> newNode = new Node<>(prev, data, node);
        node.prev = newNode;
        if (prev == null) first = newNode;
        else prev.next = newNode;
        size++;
    }

    @Override
    public void add(int index, T element) {
        addBeforeNode(element, getNodeByIndex(index));
    }

    @Override
    public T remove(int index) {
        Node<T> node = getNodeByIndex(index);
        T deleted_data = node.data;
        Node<T> next = node.next;
        Node<T> prev = node.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.data = null;
        size--;
        return deleted_data;
    }

    @Override
    public int indexOf(Object data) {
        int index = 0;
        for (Node<T> node = first; node != null; node = node.next) {
            if (data.equals(node.data)) return index;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }//исключение

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T d) {
            prev = null;
            data = d;
            next = null;
        }

        Node(Node<T> prev, T data, Node<T> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}
