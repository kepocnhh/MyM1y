package delaemcode.mym1y.units;

import android.content.ContentValues;

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

    @Override
    protected ContentValues getContentValues(ContentValues cv)
    {
        return cv;
    }
}