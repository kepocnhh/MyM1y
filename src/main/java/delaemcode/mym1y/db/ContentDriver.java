package delaemcode.mym1y.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

import delaemcode.mym1y.core.Currency;

public class ContentDriver
{
    //__________________________________GET_CONTENT_VALUES
    static public ContentValues getContentValues(Currency a)
    {
        ContentValues cv = new ContentValues();
        if(a.ID > 0)
        {
            cv.put(BaseColumns._ID, a.ID);
        }
        cv.put(Tables.NAME, a.name);
        cv.put(Tables.Currencies.MEASURE, a.measure);
        return cv;
    }


    //__________________________________SET_CONTENT_VALUES
    static public Currency setCurrencyContentValues(Cursor route)
    {
        Currency a = new Currency()
                .setName(route.getString(route.getColumnIndex(Tables.NAME)))
                .setMeasure(route.getString(route.getColumnIndex(Tables.Currencies.MEASURE)));
        a.ID = route.getInt(route.getColumnIndex(BaseColumns._ID));
        return a;
    }
}