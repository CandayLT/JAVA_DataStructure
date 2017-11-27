package BinaryHeap;

/**
 * Name : 二叉堆
 * Created by TangChen on 17/11/22.
 */
public class BinaryHeap implements IBinaryHeap {
    private Integer[] elements;
    private int size;
    private int capacity; //容量

    public BinaryHeap(int capacity) {
        this.capacity = capacity;
        elements = new Integer[capacity];
        elements[0] = -0xff;
    }

    @Override
    public void destory() {

    }

    @Override
    public Integer findMin() {
        return elements[1];
    }

    @Override
    public Integer deleteMin() {
        int minElement = elements[1];
        int lastElement = elements[size--];

        int i, child;

        for (i = 1; 2 * i <= size; i = child) {
            child = 2 * i;

            if (child + 1 <= size && elements[child + 1] < elements[child])
                child++;

            if (lastElement < elements[child])
                break;

            elements[i] = elements[child];
        }

        elements[i] = lastElement;

        return minElement;
    }

    @Override
    public boolean buildHeap(Integer... elements) {
        if(elements.length > capacity)
            return false;

        size = elements.length - 1;
        this.elements = elements;

        for(int i = size / 2; i > 0; i--) {
            down(i);
        }

        return true;
    }

    @Override
    public boolean down(int p) {
        if(p >= size)
            return false;

        int child;
        for(; 2 * p <= size; p = child) {
            child = p * 2;

            if(child + 1 <= size && elements[child + 1] < elements[child])
                child++;

            if(elements[p] > elements[child]) {
                int temp = elements[p];
                elements[p] = elements[child];
                elements[child] = temp;
            } else
                break;
        }

        return true;
    }

    @Override
    public boolean insert(Integer element) {
        if (size + 1 >= capacity)
            return false;

        int i = ++size;
        for(; elements[i / 2] > element; i /= 2)
            elements[i] = elements[i / 2];

        elements[i] = element;
        return true;
    }

    public void printBinaryHeap() {
        for(int i = 1; i <= size; i++)
            System.out.print(elements[i] + " ");
    }
}