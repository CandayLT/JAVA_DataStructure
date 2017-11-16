package LinkedList;

/**
 * Created by TangChen on 17/11/13.
 */
public class LinkedList<E> {
    Node first;
    Node last;
    private int size;

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

    public E get(int position) {
        if (size < position + 1)
            return null;
        else
            return find(position).e;
    }

    public void add(int position, E e) {
        if(position - 1 > size)
            return;

        size++;

        if(position == 0) {
            first = new Node(e, first);
            return;
        }

        Node pNode = find(position - 1);
        pNode.next = new Node(e, pNode.next);
    }

    public boolean remove(int position) {
        if(size > position + 1) {
            if(position == 0)
                first = first.next;
            else
                find(position - 1).next = find(position).next;
            return true;
        }

        return false;
    }

    public Node find(int position) {
        Node search = first;
        for (int i = 0; i < position; i++)
            search = search.next;

        return search;
    }

    public int size() {
        return size;
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