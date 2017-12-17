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
        for (Relation r : relations) {
            char[] e = r.getRelation();
            GraphNode point = headPoints[findElement(e[0])];

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
        for (int i = 0; i < eNum; i++) {
            GraphNode node = headPoints[i];
            while (node.next != null) {
                System.out.print(node.e + " - ");
                node = node.next;
            }
            System.out.print(node.e);
            System.out.println();
        }
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