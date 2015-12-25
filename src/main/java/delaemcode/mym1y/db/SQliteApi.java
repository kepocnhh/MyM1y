package delaemcode.mym1y.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class SQliteApi
{
    public static DatabaseHelper dbHelper;
    public static volatile SQLiteDatabase sdb;
    public static String DB_NAME = "mym1y";
    public static int DB_VERSION = 1512251940;

    public static void createDb(Context context)
    {
        dbHelper = new DatabaseHelper(context, DB_NAME, null, DB_VERSION);
        sdb = dbHelper.getWritableDatabase();
        createDBTables(sdb);
    }

    public static void startTransaction()
    {
        sdb.beginTransaction();
    }

    public static void endTransaction()
    {
        sdb.setTransactionSuccessful();
        sdb.endTransaction();
    }

    // INSERT
    /* ************************************************************************ */
    public static long insertCashAccountType(ContentValues content)
    {
        return sdb.insertWithOnConflict(Tables.CashAccountTypes.TABLE_NAME, null, content, SQLiteDatabase.CONFLICT_REPLACE);
    }
    public static long insertCurrency(ContentValues content)
    {
        return sdb.insertWithOnConflict(Tables.Currencies.TABLE_NAME, null, content, SQLiteDatabase.CONFLICT_REPLACE);
    }
    public static long insertCashAccount(ContentValues content)
    {
        return sdb.insertWithOnConflict(Tables.CashAccounts.TABLE_NAME, null, content, SQLiteDatabase.CONFLICT_REPLACE);
    }

    // GET ALL
    /* ************************************************************************ */
    public static Cursor getCashAccountTypes()
    {
        Cursor main = sdb.query(Tables.CashAccountTypes.TABLE_NAME, null, null, null, null, null, null);
        return main;
    }
    public static Cursor getCurrencies()
    {
        Cursor main = sdb.query(Tables.Currencies.TABLE_NAME, null, null, null, null, null, null);
        return main;
    }
    public static Cursor getCashAccounts()
    {
        Cursor cursor = sdb.rawQuery(
                "SELECT " //+ "* "
                        + Tables.Currencies.TABLE_NAME + "." + BaseColumns._ID + " AS " + Tables.Currencies.CURRENCIES_ID + ", "
                        + Tables.Currencies.TABLE_NAME + "." + Tables.NAME + " AS " + Tables.Currencies.CURRENCIES_NAME + ", "
                        + Tables.Currencies.TABLE_NAME + "." + Tables.Currencies.MEASURE + ", "
                        + Tables.CashAccountTypes.TABLE_NAME + "." + BaseColumns._ID + " AS " + Tables.CashAccountTypes.CASHACCOUNTTYPES_ID + ", "
                        + Tables.CashAccountTypes.TABLE_NAME + "." + Tables.NAME + " AS " + Tables.CashAccountTypes.CASHACCOUNTTYPES_NAME + ", "
                        + Tables.CashAccounts.TABLE_NAME + "." + BaseColumns._ID + ", "
                        + Tables.CashAccounts.TABLE_NAME + "." + Tables.NAME + ", "
                        + Tables.CashAccounts.TABLE_NAME + "." + Tables.CashAccounts.BALANCE + ", "
                        + Tables.CashAccounts.TABLE_NAME + "." + Tables.CashAccounts.ACCOUNTNUMBER + ", "
                        + Tables.CashAccounts.TABLE_NAME + "." + Tables.CashAccounts.ICO + " "
                + "FROM " + Tables.CashAccounts.TABLE_NAME + " "
                        + "JOIN " + Tables.Currencies.TABLE_NAME + " "
//                        + "ON " + Tables.CashAccounts.TABLE_NAME + "." + Tables.CashAccounts.CURRENCY + "=" + Tables.Currencies.TABLE_NAME + "." + BaseColumns._ID + " "
                        + "ON " + Tables.CashAccounts.TABLE_NAME + "." + Tables.CashAccounts.CURRENCY + "=" + Tables.Currencies.CURRENCIES_ID + " "
                        + "JOIN " + Tables.CashAccountTypes.TABLE_NAME + " "
                        + "ON " + Tables.CashAccounts.TABLE_NAME + "." + Tables.CashAccounts.TYPE + "=" + Tables.CashAccountTypes.TABLE_NAME + "." + BaseColumns._ID + " "
//                + where
//                + "ORDER BY " + Tables.PostSimple_date_COLUMN + " DESC" + " "
//                + "LIMIT " + page * 10 + "; "
                , new String[]{});
        return cursor;
    }

    // CLEAR DB TABLES
    /* ************************************************************************ */
    public static void clearDB(SQLiteDatabase db)
    {
        db.execSQL("drop table if exists " + Tables.CashAccounts.TABLE_NAME);
        db.execSQL("drop table if exists " + Tables.CashAccountTypes.TABLE_NAME);
        db.execSQL("drop table if exists " + Tables.Currencies.TABLE_NAME);
    }

    // CREATE DB TABLES
    /* ************************************************************************ */
    public static void createDBTables(SQLiteDatabase db)
    {
        db.execSQL(Tables.CashAccounts.CREATE_TABLE);
        db.execSQL(Tables.CashAccountTypes.CREATE_TABLE);
        db.execSQL(Tables.Currencies.CREATE_TABLE);
    }
}