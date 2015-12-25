package delaemcode.mym1y.db;

import android.provider.BaseColumns;

public class Tables
{
    public static final String NAME = "name";

    public static class CashAccounts
    {
        public static final String TABLE_NAME = "cashaccounts" + "table";

        public static final String CURRENCY = "currency";
        public static final String BALANCE = "balance";
        public static final String TYPE = "type";
        public static final String ACCOUNTNUMBER = "accountnumber";
        public static final String ICO = "ico";

        public static final String CREATE_TABLE = "create table if not exists " +
                TABLE_NAME + "(" +
                BaseColumns._ID + " integer primary key autoincrement" + ", " +
                NAME + " text" + ", " +
                CURRENCY + " integer" + ", " +
                BALANCE + " text" + ", " +
                TYPE + " integer" + ", " +
                ACCOUNTNUMBER + " text" + ", " +
                ICO + " text" + //", " +
                ");";
    }

    public static class Currencies
    {
        public static final String TABLE_NAME = "currencies" + "table";

        public static final String MEASURE = "measure";

        public static final String CREATE_TABLE = "create table if not exists " +
                TABLE_NAME + "(" +
                BaseColumns._ID + " integer primary key autoincrement" + ", " +
                NAME + " text" + ", " +
                MEASURE + " text" + //", " +
                ");";
    }

    public static class CashAccountTypes
    {
        public static final String TABLE_NAME = "cashaccounttypes" + "table";

        public static final String CREATE_TABLE = "create table if not exists " +
                TABLE_NAME + "(" +
                BaseColumns._ID + " integer primary key autoincrement" + ", " +
                NAME + " text" + //", " +
                ");";
    }
}