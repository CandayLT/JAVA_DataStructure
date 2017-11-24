package BinaryHeap;

/**
 * Created by TangChen on 17/11/24.
 */
public class LeftistHeap implements ILeftistHeap {
    public HeapNode root;

    @Override
    public void merge(LeftistHeap h) {
        merge1(this.root, h.root).getExternal();
    }

    public LeftistHeap() {

    }

    @Override
    public void insert(int e) {
        HeapNode newNode = new HeapNode(e);

        if(root == null) {
            root = newNode;
            return;
        }

        HeapNode node = merge1(newNode, root);

        if (node.num < root.num) {
            root = node;
        }
    }

    @Override
    public int deleteMin() {
        int min = root.num;
        root = merge1(root.right, root.left);
        return min;
    }

    private HeapNode merge1(HeapNode h1, HeapNode h2) {
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;

        if (h1.num < h2.num)
            return mergeNode(h1, h2);
        else
            return mergeNode(h2, h1);
    }

    private HeapNode mergeNode(HeapNode h1, HeapNode h2) {
        if (h1.left == null) {
            h1.left = h2;
        }

        else {
            h1.right = merge1(h1.right, h2);
            if (h1.left.npl < h1.right.npl) {
                HeapNode temp = h1.left;
                h1.left = h1.right;
                h1.right = temp;
            }

            h1.npl = h1.right.npl + 1;
        }

        return h1;
    }

    public class HeapNode {
        int npl;
        int num;
        HeapNode left = null;
        HeapNode right = null;

        HeapNode(int num) {
            this.num = num;
        }

        LeftistHeap getExternal() {
            return LeftistHeap.this;
        }
    }
}