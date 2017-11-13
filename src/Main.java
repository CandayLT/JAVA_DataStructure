import Graph.*;
import HashTable.SeparateChainingHashTable;
import LinkedList.*;

public class Main {

    public static void main(String[] args) {
        testHashTable0();
        testDFS();
        testLinkedList();
    }

    private static void testHashTable0() {
        SeparateChainingHashTable hashTable = new SeparateChainingHashTable(10);

        for(int i = 0; i < 10; i++) {
            hashTable.insert(i * i);
        }

        for(int i = 0; i < 10; i++) {
            System.out.print(i + " : ");

            for(int j = 0; j < hashTable.hashTable[i].size(); j++) {
                System.out.print(hashTable.hashTable[i].get(j) + " -> ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void testLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        for(int i = 0; i <= 100; i++){
            linkedList.add(i << 2);
        }

        linkedList.remove(3);
        for(int i = 0; i <= 99; i++) {
            System.out.println("LinkedList num " + i + " is " + linkedList.get(i));
        }
    }

    static void testDFS() {
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
    }
}