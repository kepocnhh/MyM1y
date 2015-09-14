package delaemcode.mym1y.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class DBHelper
        extends SQLiteOpenHelper
{
    private static final int VERSION = 1509141728;
    private static final String DB_NAME = "mymydatabase";

    private static DBHelper instance;

    public static DBHelper getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new DBHelper(context);
        }
        return instance;
    }

    private DBHelper(Context context)
    {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        createTables(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        if(newVersion > oldVersion)
        {
            dropTables(db);
            createTables(db);
        }
    }

    private void createTables(SQLiteDatabase db)
    {
        for(int i=0; i< Contract.contracts.length; i++)
        {
            db.execSQL(Contract.contracts[i].createTable());
        }
    }

    public void dropTables(SQLiteDatabase db)
    {
        for(int i=0; i< Contract.contracts.length; i++)
        {
            db.execSQL(Contract.contracts[i].dropTable());
        }
    }

    public Cursor query(Contract contract, String[] projection, String selection, String[] selectionArgs, String sortOrder)
    {
        Cursor cursor = null;
        SQLiteDatabase db;
        db = getWritableDatabase();
        cursor = db.query(contract.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
        return cursor;
    }

    public long insert(Contract contract, ContentValues values)
    {
        SQLiteDatabase db;
        db = getWritableDatabase();
        db.beginTransaction();
        long id = db.insert(contract.TABLE_NAME, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        return id;
    }
}