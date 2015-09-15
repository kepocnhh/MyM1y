package delaemcode.mym1y.units;

import android.content.ContentValues;

public class Transaction
    extends Unit
{
    int from;

    public Transaction(String uid, String name, int f)
    {
        super(uid, name);
        this.from = f;
    }

    @Override
    protected ContentValues getContentValues(ContentValues cv)
    {
        return cv;
    }
}
