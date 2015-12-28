package delaemcode.mym1y.core;

import java.util.List;

public class Transaction
        extends MyMy
{
    public int parent;
    public int from;
    public String summ;
    public List<Tag> tags;

    public Transaction setSumm(String n)
    {
        this.summ = n;
        return this;
    }
    public Transaction setParent(int n)
    {
        this.parent = n;
        return this;
    }
    public Transaction setFrom(int n)
    {
        this.from = n;
        return this;
    }

}
