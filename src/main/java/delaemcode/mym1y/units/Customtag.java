package delaemcode.mym1y.units;

import java.util.List;

public class Customtag
        extends Tag
{
    Customtag parent;
    List<Customtag> childs;

    public Customtag(String uid, String n, String c)
    {
        super(uid, n, c);
    }
}