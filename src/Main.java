import BinaryHeap.*;
import Graph.*;
import HashTable.*;
import LinkedList.*;
import LinkedList.LinkedList;
import Sort.InsertionSort;
import Sort.ShellSort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        testSort();
        printLeftistHeap();
        printBinaryHeap();
        testHashTable0(); //分离链接法
        testHashTable1(true); //开放地址法（true线性探测 false平方探测）
        testHashTable1(false);
        testDFS();
        testLinkedList();
    }

    private static void testSort() {
        Set<Integer> testArray = new HashSet<>();

        Random random = new Random();

        for (int i = 1; i <= 2 << 18; i++)
            testArray.add(random.nextInt(2 << 20));

        showSortCostTime("Sort.InsertionSort", testArray.toArray(new Integer[]{}));
        showSortCostTime("Sort.ShellSort", testArray.toArray(new Integer[]{}));
        showSortCostTime("Sort.HeapSort", testArray.toArray(new Integer[]{}));
        showSortCostTime("Sort.MergeSort", testArray.toArray(new Integer[]{}));
    }

    private static void showSortCostTime(String name, Integer[] input) {
        try {
            Class sortClass = Class.forName(name);
            Method sortMethod = sortClass.getMethod("sort", Integer[].class);

            long nowTime = System.currentTimeMillis();
            sortMethod.invoke(null, (Object) input);
            long finishTime = System.currentTimeMillis();
            double time = (finishTime - nowTime) / 1000.0;
            System.out.println(sortClass.getSimpleName() + "(" + input.length + " data）cost : " + time + "s");
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void printLeftistHeap() {
        LeftistHeap leftistHeap = new LeftistHeap();

        for (int i = 1; i <= 10; i++)
            leftistHeap.insert(i);

        leftistHeap.insert(0); //min == 0

        leftistHeap.deleteMin(); // min == 1
    }

    private static void printBinaryHeap() {
        BinaryHeap heap = new BinaryHeap(21);
        Integer[] arrays = new Integer[]{-0xff, 150, 80, 40, 30, 10, 50, 110, 100, 20, 90, 60, 70, 120, 140, 130};
        heap.buildHeap(arrays);
        heap.printBinaryHeap();
        System.out.println();

        BinaryHeap heap2 = new BinaryHeap(11);
        for (int i = 10; i >= 1; i--)
            heap2.insert(i);
        heap2.printBinaryHeap();
        System.out.println();
        System.out.println();
    }

    private static void testHashTable1(boolean type) {
        OpenAddressingHashing hashTable = new OpenAddressingHashing(100, type);
        //linearProbing == false为平方探测，true为线性探测

        for (int i = 1; i <= 50; i++) {
            hashTable.insert(i * (i + 1));
        }

        for (int i = 0; i < hashTable.tableSize; i++) {
            System.out.print(i + " : ");
            if (hashTable.hashEntries[i].getStatus() == OpenAddressingHashing.elementStatus.NORMAL)
                System.out.print(hashTable.hashEntries[i].getE());
            System.out.println();
        }
    }

    private static void testHashTable0() {
        SeparateChainingHashing hashTable = new SeparateChainingHashing(10);

        for (int i = 0; i < 10; i++) {
            hashTable.insert(i * i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(i + " : ");

            for (int j = 0; j < hashTable.hashTable[i].size(); j++) {
                System.out.print(hashTable.hashTable[i].get(j) + " -> ");
            }
            System.out.println();
        }

        System.out.println();
    }

    private static void testLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        for (int i = 0; i <= 100; i++) {
            linkedList.add(i << 2);
        }

        linkedList.remove(3);
        for (int i = 0; i <= 99; i++) {
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

        for (int i = 0; i < relations.length; i++) {
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
        dfs.toDFS('f');
        System.out.println();
    }
}
