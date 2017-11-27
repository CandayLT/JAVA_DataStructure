package BinaryHeap;

/**
 * Name : 左式堆
 * Created by TangChen on 17/11/24.
 */
public class LeftistHeap implements ILeftistHeap {
    private HeapNode root;

    public LeftistHeap() {

    }

    @Override
    public void insert(int e) {
        HeapNode newNode = new HeapNode(e);

        if (root == null) {
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

    @Override
    public LeftistHeap merge(LeftistHeap h) {
        return merge1(this.root, h.root).getExternal();
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
                swapNode(h1);
            }

            h1.npl = h1.right.npl + 1; //父节点npl=最小节点npl+1（即右儿子npl+1）
        }

        return h1;
    }

    private void swapNode(HeapNode h) {
        HeapNode temp = h.left;
        h.left = h.right;
        h.right = temp;
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