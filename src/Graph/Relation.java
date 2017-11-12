package Graph;

/**
 * Created by TangChen on 17/11/7.
 */
public class Relation {
    public char[] relation;

    public void setRelation(char r1, char r2) {
        relation = new char[2];
        relation[0] = r1;
        relation[1] = r2;
    }

    public char[] getRelation() {
        return relation;
    }
}
