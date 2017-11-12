package Graph;

import java.util.*;

/**
 * Created by TangChen on 17/11/7.
 */
public class DFS {
    Graph graph;
    Map<Character, Boolean> isVisit = new HashMap<>();
    List<Character> DFSList = new ArrayList<>();

    public DFS(Graph graph) {
        this.graph = graph;

        for (int i = 0; i < graph.graphNum; i++) {
            isVisit.put(graph.vertexElement[i], false);
        }
    }

    public void toDFS(char c) {
        if (!isVisit.get(c)) {
            System.out.print(c + " -> ");
            isVisit.put(c, true);

            for (int i = 0; i < graph.graphNum; i++) {
                if (graph.matrix[graph.locElement(c)][i] == 1) {
                    toDFS(graph.vertexElement[i]);
                }
            }
        }
    }
}