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
        public static final String CURRENCIES_ID = "currencies_id";
        public static final String CURRENCIES_NAME = "currencies_name";

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

        public static final String CASHACCOUNTTYPES_ID = "cashaccounttypes_id";
        public static final String CASHACCOUNTTYPES_NAME = "cashaccounttypes_name";

        public static final String CREATE_TABLE = "create table if not exists " +
                TABLE_NAME + "(" +
                BaseColumns._ID + " integer primary key autoincrement" + ", " +
                NAME + " text" + //", " +
                ");";
    }

    public static class Transactions
    {
        public static final String TABLE_NAME = "transactions" + "table";

        public static final String FROM = "fromcashaccount";
        public static final String SUMM = "summ";
        public static final String PARENT = "parenttransaction";

        public static final String CREATE_TABLE = "create table if not exists " +
                TABLE_NAME + "(" +
                BaseColumns._ID + " integer primary key autoincrement" + ", " +
                PARENT + " integer" + ", " +
                FROM + " integer" + ", " +
                SUMM + " text" + ", " +
                NAME + " text" + //", " +
                ");";
    }
    public static class TransactionsAndTags
    {
        public static final String TABLE_NAME = "transactionsandtags" + "table";

        public static final String TRANSACTIONID = "transactionid";
        public static final String TAGID = "tagid";

        public static final String CREATE_TABLE = "create table if not exists " +
                TABLE_NAME + "(" +
                BaseColumns._ID + " integer primary key autoincrement" + ", " +
                TRANSACTIONID + " integer" + ", " +
                TAGID + " integer" + //", " +
                ");";
    }
    public static class Tags
    {
        public static final String TABLE_NAME = "tags" + "table";

        public static final String COLOR = "color";
        public static final String PARENT = "parenttag";

        public static final String CREATE_TABLE = "create table if not exists " +
                TABLE_NAME + "(" +
                BaseColumns._ID + " integer primary key autoincrement" + ", " +
                COLOR + " integer" + ", " +
                PARENT + " integer" + ", " +
                NAME + " text" + //", " +
                ");";
    }
}