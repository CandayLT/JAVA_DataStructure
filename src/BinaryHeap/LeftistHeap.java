package BinaryHeap;

/**
 * Created by TangChen on 17/11/24.
 */
public class LeftistHeap implements ILeftistHeap {
    public HeapNode root;

    @Override
    public LeftistHeap merge(LeftistHeap h) {
        return merge1(this.root, h.root).getExternal();
    }

    public LeftistHeap() {

    }

    @Override
    public LeftistHeap insert(int e) {
        HeapNode node = merge1(new HeapNode(0, e, null, null), this.root);
        return (node.num < root.num ? root = node : node).getExternal();
    }

    @Override
    public LeftistHeap deleteMin() {
        return merge1(root.right, root.left).getExternal();
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
        if (h1.left == null)
            h1.left = h2;

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
        public int npl = -1;
        public int num;
        public HeapNode left;
        public HeapNode right;

        HeapNode(int npl, int num, HeapNode left, HeapNode right) {
            this.npl = npl;
            this.num = num;
            this.left = left;
            this.right = right;

            if(LeftistHeap.this.root == null)
                LeftistHeap.this.root = this;
        }

        LeftistHeap getExternal() {
            return LeftistHeap.this;
        }
    }
}