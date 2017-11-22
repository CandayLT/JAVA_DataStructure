package BinaryHeap;

/**
 * Created by TangChen on 17/11/22.
 */
public interface IHeap {
    void destory();
    Integer findMin();
    Integer deleteMin();
    boolean buildHeap(Integer... elements);
    boolean down(int p);
    boolean insert(Integer element);
}