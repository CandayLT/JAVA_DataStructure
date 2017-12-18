package Graph;

/**
 * Created by TangChen on 17/11/7.
 */
public class GraphMatrix implements IGraph {
    public int graphNum; //顶点个数
    public char[] vertexElement; //顶点元素集合
    public int[][] matrix; //邻接矩阵

    public GraphMatrix(char[] vertexElement) {
        this.vertexElement = vertexElement;
        this.graphNum = this.vertexElement.length;
        this.matrix = new int[graphNum][graphNum];
    }

    public void initGraph(Relation[] relations) {
        for (Relation relation : relations) {
            char[] e = relation.getRelation();
            matrix[findElement(e[0])][findElement(e[1])] = 1;
            matrix[findElement(e[1])][findElement(e[0])] = 1;
        }
    }

    public void printMatrix() {
        System.out.println();
        System.out.println("Graph by Matrix : ");
        for (int i = 0; i < graphNum; i++) {
            if (i == 0) {
                System.out.print("   ");
                for (int x = 0; x < graphNum; x++) {
                    System.out.print(vertexElement[x] + "  ");
                }
                System.out.println();
            }

            for (int j = 0; j < graphNum; j++) {
                if (j == 0) {
                    System.out.print(vertexElement[i] + "  ");
                }
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public int findElement(char c) {
        for (int i = 0; i < graphNum; i++) {
            if (c == vertexElement[i]) {
                return i;
            }
        }

        return -1;
    }
}
