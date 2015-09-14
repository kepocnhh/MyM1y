package delaemcode.mym1y.units;

import android.content.ContentValues;

public class Transaction
    extends Unit
{

    public Transaction(String uid, String name)
    {
        super(uid, name);
    }

    @Override
    protected ContentValues getContentValues(ContentValues cv)
    {
        return cv;
    }
}
