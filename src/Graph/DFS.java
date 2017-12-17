package Graph;

import java.util.*;

/**
 * Created by TangChen on 17/11/7.
 */
public class DFS {
    GraphMatrix graphMatrix;
    Map<Character, Boolean> isVisit = new HashMap<>();

    public DFS(GraphMatrix graphMatrix) {
        this.graphMatrix = graphMatrix;

        for (int i = 0; i < graphMatrix.graphNum; i++)
            isVisit.put(graphMatrix.vertexElement[i], false);
    }

    public void toDFS(char c) {
        if (!isVisit.get(c)) {
            System.out.print(c + " -> ");
            isVisit.put(c, true);

            for (int i = 0; i < graphMatrix.graphNum; i++) {
                if (graphMatrix.matrix[graphMatrix.findElement(c)][i] == 1)
                    toDFS(graphMatrix.vertexElement[i]);
            }
        }
    }
}