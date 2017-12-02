package HashTable;

import Utils.MathUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 哈希表的线性探测法
 * Created by TangChen on 17/11/16.
 */
public class OpenAddressingHashing implements IHashTable{
    public int tableSize;
    private int elementNum;
    public HashEntry[] hashEntries;
    private float loadFactor = 0.0f;
    private boolean linearProbing; //是否线性探测

    public enum elementStatus {
        DELETE, NORMAL, EMPTY
    }

    public OpenAddressingHashing(int tableSize, boolean linearProbing) {
        this.tableSize = MathUtils.nextPrime(tableSize);
        this.linearProbing = linearProbing;
        initEmptyHashTable();
    }

    @Override
    public void initEmptyHashTable() {
        hashEntries = new HashEntry[tableSize];

        for(int i = 0; i < hashEntries.length; i++)
            hashEntries[i] = new HashEntry(elementStatus.EMPTY, null);
    }

    @Override
    public int hash(int key) {
        return key % tableSize;
    }

    @Override
    public void insert(int key) {
        int p = position(key);

        if(hashEntries[p].getStatus() != elementStatus.NORMAL) {
            hashEntries[p].status = elementStatus.NORMAL;
            hashEntries[p].e = key;
            elementNum++;

            loadFactor = elementNum / tableSize;
        }

        if(loadFactor > 0.5)
            reHashing();
    }

    @Override
    public int position(int key) {
        int nowPos = hash(key);
        int collisionNum = 0;

        while (hashEntries[nowPos].getStatus() != elementStatus.EMPTY && hashEntries[nowPos].getE() != key) {
            if(linearProbing)
                nowPos++;
            else
                nowPos += 2 * ++ collisionNum - 1;

            if(nowPos >= tableSize)
                nowPos -= tableSize;
        }
        return nowPos;
    }

    @Override
    public void makeEmpty() {
        initEmptyHashTable();
    }

    @Override
    public void remove(int key) {
        int p = position(key);

        if(hashEntries[p].getStatus() == elementStatus.NORMAL)
            hashEntries[p].status = elementStatus.DELETE;
    }

    @Override
    public int size() {
        return elementNum;
    }

    private void reHashing() {
        tableSize = MathUtils.nextPrime(tableSize * 2);
        List<HashEntry> oldHashEntries = new ArrayList<>();

        for(HashEntry entry : hashEntries)
            if(entry.status == elementStatus.NORMAL)
                oldHashEntries.add(entry);

        initEmptyHashTable();

        for(HashEntry entry : oldHashEntries)
            this.insert(entry.e);
    }

    public class HashEntry {
        elementStatus status;
        Integer e;

        public HashEntry(elementStatus status, Integer e) {
            this.status = status;
            this.e = e;
        }

        public elementStatus getStatus() {
            return status;
        }

        public Integer getE() {
            return e;
        }
    }
}