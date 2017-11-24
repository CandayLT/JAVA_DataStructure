package BinaryHeap;

/**
 * Created by TangChen on 17/11/24.
 */
public interface ILeftistHeap {
    LeftistHeap merge(LeftistHeap h);
    LeftistHeap insert(int e);
    LeftistHeap deleteMin();
}