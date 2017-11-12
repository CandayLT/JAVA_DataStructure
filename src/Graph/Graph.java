package Graph;

/**
 * Created by TangChen on 17/11/7.
 */
public class Graph implements IGraph{
    public int graphNum; //顶点个数
    public char[] vertexElement; //顶点元素集合
    public boolean graphKind; //图的种类
    public int[][] matrix; //邻接矩阵

    public Graph(char[] vertexElement) {
        this.vertexElement = vertexElement;
        this.graphNum = this.vertexElement.length;
        this.matrix = new int[graphNum][graphNum];
    }

    public void creatGraph(Relation[] relations) {
        for(int i = 0; i < graphNum; i++) { //初始化矩阵
            for(int j = 0; j < graphNum; j++) {
                matrix[i][j] = 0;
            }
        }

        for (Relation relation : relations) {
            char[] e = relation.getRelation();
            matrix[locElement(e[0])][locElement(e[1])] = 1;
            matrix[locElement(e[1])][locElement(e[0])] = 1;
        }
        printMatrix();
    }

    public void printMatrix() {
        for(int i = 0; i < graphNum; i++) {
            if(i == 0) {
                System.out.print("   ");
                for(int x = 0; x < graphNum; x++) {
                    System.out.print(vertexElement[x] + "  ");
                }
                System.out.println();
            }

            for(int j = 0; j < graphNum; j++) {
                if(j == 0) {
                    System.out.print(vertexElement[i] + "  ");
                }
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public int locElement(char c) {
        for(int i = 0; i < graphNum; i++){
            if(c == vertexElement[i]){
                return i;
            }
        }

        return -1;
    }
}
