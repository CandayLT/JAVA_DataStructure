package HashTable;


/**
 * Created by TangChen on 17/11/13.
 */
public interface IHashTable {
    public void initEmptyHashTable();
    public int hash(int key);
    public void insert(int key);
    public int position(int key);
    public void makeEmpty();
    public void remove(int key);
    public int size();
}