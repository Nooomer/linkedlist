import java.util.*;

public class LinkedList<T> implements List<T>, Deque<T> {

    Node<T> first; //first element
    Node<T> last; //last element
    int size = 0; //size of list
    /* Linked list Node*/
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
            this.data= data;
            this.next = next;
            this.prev = prev;
        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
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
    public void addFirst(T t) {
        add(0,t);
    }

    @Override
    public void addLast(T t) {
        add(t);
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
    public boolean add(T t) {
        Node<T> new_node = new Node<T>(t);
        if(this.isEmpty()){
            this.first = new_node;
            first = new_node;
        }
        else{
            Node<T> prev_node = this.last;
            while (prev_node.next != null) {
                prev_node = prev_node.next;
            }
            prev_node.next = new_node;
            new_node.prev = prev_node;
        }
        last = new_node;
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
    public boolean remove(Object o) {
        Node<T> node = node(this.indexOf(o));
        T deleted_data = node.data;
        Node<T> next = node.next;
        Node<T> prev = node.prev;

        if (prev == null) {
            first = next;
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
    public boolean containsAll(Collection<?> c) {
        for(int i = 0; i<c.size();i++){
            if(contains(c.toArray()[i])){
                continue;
            }
            else{
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
    Node<T> node(int index) {

        Node<T> node;
        if (index < size-1) {
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
        return node(index).data;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    void addBeforeNode(T t, Node<T> node) {
         Node<T> prev = node.prev;
         Node<T> newNode = new Node<>(prev, t, node);
        node.prev = newNode;
        if (prev == null)
            first = newNode;
        else
            prev.next = newNode;
        size++;
    }

    @Override
    public void add(int index, T element) {
        addBeforeNode(element, node(index));
    }

    @Override
    public T remove(int index) {
        Node<T> node = node(index);
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
    public int indexOf(Object o) {
        int index = 0;
            for (Node<T> x = first; x != null; x = x.next) {
                if (o.equals(x.data))
                    return index;
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
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
