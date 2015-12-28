package delaemcode.mym1y.core;

public class Tag
        extends MyMy
{
    public int parent;
    public int color;
    public String name;

    public Tag setName(String n)
    {
        this.name = n;
        return this;
    }
    public Tag setParent(int n)
    {
        this.parent = n;
        return this;
    }
    public Tag setColor(int n)
    {
        this.color = n;
        return this;
    }
}