package delaemcode.mym1y.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

import delaemcode.mym1y.core.CashAccount;
import delaemcode.mym1y.core.CashAccountType;
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
}