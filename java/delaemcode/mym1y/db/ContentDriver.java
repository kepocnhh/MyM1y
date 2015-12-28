package delaemcode.mym1y.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

import java.util.Date;
import java.util.Random;

import delaemcode.mym1y.core.CashAccount;
import delaemcode.mym1y.core.CashAccountType;
import delaemcode.mym1y.core.Currency;
import delaemcode.mym1y.core.Tag;
import delaemcode.mym1y.core.Transaction;
import delaemcode.mym1y.helpers.SQliteHelper;

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
    static public ContentValues getContentValues(CashAccountType a)
    {
        ContentValues cv = new ContentValues();
        if(a.ID > 0)
        {
            cv.put(BaseColumns._ID, a.ID);
        }
        cv.put(Tables.NAME, a.name);
        return cv;
    }
    static public ContentValues getContentValues(CashAccount a)
    {
        ContentValues cv = new ContentValues();
        if(a.ID > 0)
        {
            cv.put(BaseColumns._ID, a.ID);
        }
        cv.put(Tables.NAME, a.name);
        cv.put(Tables.CashAccounts.BALANCE, a.balance);
        cv.put(Tables.CashAccounts.ACCOUNTNUMBER, a.accountnumber);
        cv.put(Tables.CashAccounts.ICO, a.ico);
        cv.put(Tables.CashAccounts.CURRENCY, a.currency.ID);
        cv.put(Tables.CashAccounts.TYPE, a.type.ID);
        return cv;
    }
    static public ContentValues getContentValues(Tag a)
    {
        ContentValues cv = new ContentValues();
        if(a.ID > 0)
        {
            cv.put(BaseColumns._ID, a.ID);
        }
        cv.put(Tables.NAME, a.name);
        cv.put(Tables.Tags.COLOR, a.color);
        cv.put(Tables.Tags.PARENT, a.parent);
        return cv;
    }
    static public ContentValues getContentValues(Transaction a)
    {
        ContentValues cv = new ContentValues();
        if(a.ID > 0)
        {
            cv.put(BaseColumns._ID, a.ID);
        }
        else
        {
            int id = getUID();
            cv.put(BaseColumns._ID, id);
            a.ID = id;
        }
        cv.put(Tables.Transactions.PARENT, a.parent);
        cv.put(Tables.Transactions.SUMM, a.summ);
        cv.put(Tables.Transactions.FROM, a.from);
        return cv;
    }


    //__________________________________SET_CONTENT_VALUES
    static public Currency setCurrencyContentValues(Cursor route)
    {
        return setCurrencyContentValues(route, Tables.NAME, BaseColumns._ID);
    }
    static public Currency setCurrencyContentValues(Cursor route, String name, String id)
    {
        Currency a = new Currency()
                .setName(route.getString(route.getColumnIndex(name)))
                .setMeasure(route.getString(route.getColumnIndex(Tables.Currencies.MEASURE)));
        a.ID = route.getInt(route.getColumnIndex(id));
        return a;
    }
    static public CashAccountType setCashAccountTypeContentValues(Cursor route)
    {
        return setCashAccountTypeContentValues(route, Tables.NAME, BaseColumns._ID);
    }
    static public CashAccountType setCashAccountTypeContentValues(Cursor route, String name, String id)
    {
        CashAccountType a = new CashAccountType()
                .setName(route.getString(route.getColumnIndex(name)));
        a.ID = route.getInt(route.getColumnIndex(id));
        return a;
    }
    static public CashAccount setCashAccountContentValues(Cursor route)
    {
        CashAccount a = new CashAccount()
                .setName(route.getString(route.getColumnIndex(Tables.NAME)))
                .setBalance(route.getString(route.getColumnIndex(Tables.CashAccounts.BALANCE)))
                .setAccountNumber(route.getString(route.getColumnIndex(Tables.CashAccounts.ACCOUNTNUMBER)))
                .setIco(route.getString(route.getColumnIndex(Tables.CashAccounts.ICO)));
        a.setCurrency(setCurrencyContentValues(route, Tables.Currencies.CURRENCIES_NAME, Tables.Currencies.CURRENCIES_ID));
        a.setCashAccountType(setCashAccountTypeContentValues(route, Tables.CashAccountTypes.CASHACCOUNTTYPES_NAME, Tables.CashAccountTypes.CASHACCOUNTTYPES_ID));
        a.ID = route.getInt(route.getColumnIndex(BaseColumns._ID));
        return a;
    }
    static public Tag setTagContentValues(Cursor route)
    {
        Tag a = new Tag()
                .setName(route.getString(route.getColumnIndex(Tables.NAME)))
                .setColor(route.getInt(route.getColumnIndex(Tables.Tags.COLOR)))
                .setParent(route.getInt(route.getColumnIndex(Tables.Tags.PARENT)));
        a.ID = route.getInt(route.getColumnIndex(BaseColumns._ID));
        return a;
    }
    static public Transaction setTransactionContentValues(Cursor route)
    {
        Transaction a = new Transaction()
                .setSumm(route.getString(route.getColumnIndex(Tables.Transactions.SUMM)))
                .setParent(route.getInt(route.getColumnIndex(Tables.Transactions.PARENT)))
                .setFrom(route.getInt(route.getColumnIndex(Tables.Transactions.FROM)));
        a.ID = route.getInt(route.getColumnIndex(BaseColumns._ID));
        a.tags = SQliteHelper.tryGetTagsFromTransactionId(a.ID);
        return a;
    }

    static private int getUID()
    {
        Date date = new Date();
        return ((date.getYear()-100)/4)*10000000
                        + ((date.getMonth()+1)/4)*1000000
                        + date.getDate()/4*100000
                        + date.getHours()/4*10000
                        + date.getMinutes()/4*1000
                        + date.getSeconds()/4+100
                + new Random().nextInt(100);
    }
}