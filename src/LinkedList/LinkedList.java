package LinkedList;

/**
 * Created by TangChen on 17/11/13.
 */
public class LinkedList<E> {
    Node first;
    Node last;
    int size;

    public void add(E e) {
        Node newNode = new Node(e, null);
        if(first == null)
            first = last = newNode;
        else {
            last.next = newNode;
            last = newNode;
        }

        size++;
    }

    public E get(int num) {
        if (size < num + 1)
            return null;
        else {
            return find(num).e;
        }
    }

    public boolean remove(int num) {
        if(size > num + 1) {
            find(num - 1).next = find(num).next;
            return true;
        }

        return false;
    }

    public Node find(int num) {
        Node search = first;
        for (int i = 0; i < num; i++) {
            search = search.next;
        }

        return search;
    }


    private class Node {
        E e;
        Node next;

        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }
}