package delaemcode.mym1y.units;

public abstract class Tag
        extends Unit
{
    String name;
    String color;

    public Tag(String uid, String n, String c)
    {
        super(uid);
        name = n;
        color = c;
    }
}