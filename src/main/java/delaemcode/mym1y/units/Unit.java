package delaemcode.mym1y.units;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.Date;

import delaemcode.mym1y.database.Contract;

public abstract class Unit
{
    String UID;
    String name;

    public Unit(String uid, String name)
    {
        this.UID = uid;
        this.name = name;
    }

    protected abstract ContentValues getContentValues(ContentValues cv);
    public ContentValues getContentValues()
    {
        ContentValues cv = new ContentValues();
        if(UID == null)
        {
            UID = new Date().getTime()+"";
        }
        cv.put(Contract.ID, UID);
        cv.put(Contract.NAME, name);
        cv = getContentValues(cv);
        return cv;
    }
}