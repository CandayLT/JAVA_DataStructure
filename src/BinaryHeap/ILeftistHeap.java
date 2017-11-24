package BinaryHeap;

/**
 * Created by TangChen on 17/11/24.
 */
public interface ILeftistHeap {
    void merge(LeftistHeap h);
    void insert(int e);
    int deleteMin();
}