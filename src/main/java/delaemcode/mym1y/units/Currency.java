package delaemcode.mym1y.units;

import android.content.ContentValues;

public class Currency
        extends Unit
{
    String measure;

    public Currency(String uid, String name, String measure)
    {
        super(uid, name);
        this.measure = measure;
    }

    @Override
    protected ContentValues getContentValues(ContentValues cv)
    {
        cv.put(delaemcode.mym1y.database.contract.Currency.MEASURE, measure);
        return cv;
    }
}