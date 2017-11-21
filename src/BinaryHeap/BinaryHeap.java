package BinaryHeap;

/**
 * 二叉堆
 * Created by TangChen on 17/11/22.
 */
public class BinaryHeap implements IHeap {
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

        for(i = 1; 2 * i <= size; i = child) {
            child = 2 * i;

            if(child + 1 <= size && elements[child + 1] < elements [child])
                child++;

            if(lastElement > elements[child])
                elements[i] = elements[child];
            else
                break;
        }

        elements[i] = lastElement;
        return minElement;
    }

    @Override
    public boolean insert(Integer element) {
        if (size + 1 >= capacity)
            return false;

        int i = ++size;
        for (; elements[i / 2] > element; i /= 2)
            elements[i] = elements[i / 2];

        elements[i] = element;
        return true;
    }
}