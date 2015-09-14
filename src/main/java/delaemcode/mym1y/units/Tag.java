package delaemcode.mym1y.units;

public abstract class Tag
        extends Unit
{
    String color;

    public Tag(String uid, String n, String c)
    {
        super(uid, n);
        color = c;
    }
}