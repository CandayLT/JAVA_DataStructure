package Graph;

public class Main {

    public static void main(String[] args) {
        char[] vertexElement = new char[8];

        vertexElement[0] = 'a';
        vertexElement[1] = 'b';
        vertexElement[2] = 'c';
        vertexElement[3] = 'd';
        vertexElement[4] = 'e';
        vertexElement[5] = 'f';
        vertexElement[6] = 'g';
        vertexElement[7] = 'h';


        Relation[] relations = new Relation[9];

        for(int i = 0; i < relations.length; i++) {
            relations[i] = new Relation();
        }

        relations[0].setRelation('a', 'b');
        relations[1].setRelation('a', 'c');
        relations[2].setRelation('b', 'd');
        relations[3].setRelation('b', 'e');
        relations[4].setRelation('d', 'h');
        relations[5].setRelation('e', 'h');
        relations[6].setRelation('c', 'f');
        relations[7].setRelation('c', 'g');
        relations[8].setRelation('f', 'g');

        Graph graph = new Graph(vertexElement);

        graph.creatGraph(relations);

        DFS dfs = new DFS(graph);
        dfs.toDFS('a');
        System.out.println();
        for(int i = 0; i < dfs.DFSList.size(); i++){
            //System.out.println(dfs.DFSList.get(i));
        }
    }
}
