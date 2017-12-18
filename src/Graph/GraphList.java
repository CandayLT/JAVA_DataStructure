package Graph;

/**
 * Created by TangChen on 17/12/18.
 */
public class GraphList <E> implements IGraph{
    int eNum;
    char[] eName;
    GraphNode[] headPoints;

    public GraphList(int eNum, char[] eName) {
        this.eNum = eNum;
        this.eName = eName;
        headPoints = new GraphNode[eNum];

        for (int i = 0; i < eNum; i++)
            headPoints[i] = new GraphNode<>(eName[i], null);
    }

    @Override
    public void initGraph(Relation[] relations) {
        int identity;
        for (Relation r : relations) {
            char[] e = r.getRelation();
            identity = findElement(e[0]);

            if(identity == -1)
                return;

            GraphNode point = headPoints[identity];

            while (point.next != null)
                point = point.next;

            point.next = new GraphNode<>(e[1], null);
        }
    }

    @Override
    public int findElement(char e) {
        Object o = e;
        return findElement(o);
    }

    public <E> int findElement(E e) {
        for (int i = 0; i < eNum; i++) {
            if(headPoints[i].e == e) {
                return i;
            }
        }

        return -1;
    }

    public void printGraph() {
        System.out.println();
        System.out.println("Graph by List : ");
        for (int i = 0; i < eNum; i++) {
            GraphNode node = headPoints[i];

            for(; node.next != null; node = node.next)
                System.out.print(node.e + " - ");

            System.out.print(node.e);
            System.out.println();
        }
    }

    int[] indegree;
    public void topSort() {
        System.out.print("this GraphList TopSort is : ");
        initInDegreeArray();
        GraphNode c;

        for (int count = 0; count < eNum; count++) {
            c = findInDegreeZeroNode();

            if(c == null)
                return;

            System.out.print(c.e + ", ");

            int identity = findElement(c.e);

            if (identity == -1)
                return;

            GraphNode node = headPoints[identity];

            for(; node != null; node = node.next) {
                identity = findElement(node.e);

                if (identity == -1)
                    return;

                indegree[identity]--;
            }

        }
        System.out.println();
    }

    private void initInDegreeArray() {
        indegree = new int[eNum];
        int identity;
        for (int i = 0; i < eNum; i++) {
            GraphNode node = headPoints[i];

            for(; node.next != null; node = node.next) {
                identity = findElement(node.next.e);

                if (identity == -1)
                    return;
                indegree[identity]++;
            }
        }
    }

    private GraphNode findInDegreeZeroNode() {
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                return headPoints[i];
        }

        return null;
    }

    class GraphNode <E>{
        E e;
        GraphNode next;

        public GraphNode(E e, GraphNode next) {
            this.e = e;
            this.next = next;
        }
    }
}