package HashTable;

import LinkedList.*;
import Utils.MathUtils;

/**
 * 分离链接法简单实现
 * Created by TangChen on 17/11/13.
 */
public final class SeparateChainingHashTable implements IHashTable{
    public int tableSize;
    public int eSize;
    public LinkedList<Integer>[] hashTable;

    public SeparateChainingHashTable(int tableSize) {
        this.tableSize = MathUtils.nextPrime(tableSize);
        initEmptyHashTable();
    }

    public final void initEmptyHashTable() {
        if (tableSize <= 0)
            return;

        hashTable = new LinkedList[tableSize];

        for(int i = 0; i < tableSize; i++) {
            hashTable[i] = new LinkedList<Integer>();
        }
    }

    @Override
    public int hash(int key) {
        return key % tableSize;
    }

    @Override
    public void insert(int key) {
        hashTable[hash(key)].add(0, key);
        eSize++;
    }

    @Override
    public int position(int key) {
        for(int i = 0; i < hashTable[hash(key)].size(); i++){
            if (((Integer)hashTable[hash(key)].get(i)) == key) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void makeEmpty() {
        initEmptyHashTable();
    }

    @Override
    public void remove(int key) {
        int p = position(key);

        if(p != -1) {
            hashTable[hash(key)].remove(p);
        }
    }

    @Override
    public int size() {
        return eSize;
    }
}
