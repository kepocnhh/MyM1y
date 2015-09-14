package delaemcode.mym1y.units;

import android.content.ContentValues;

public class Systemtag
        extends Tag
{
    public Systemtag(String uid, String n, String c)
    {
        super(uid, n, c);
    }

    @Override
    protected ContentValues getContentValues(ContentValues cv)
    {
        return cv;
    }

    enum TypeTag
    {
        date,
        time,
        from,
        to,
        rating,
        photo,
        comment,
        map;
    }

    TypeTag type;

}