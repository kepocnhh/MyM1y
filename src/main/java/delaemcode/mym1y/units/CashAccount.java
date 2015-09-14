package delaemcode.mym1y.units;

import android.content.ContentValues;

public class CashAccount
        extends Unit
{

    public enum TypeAccount
    {
        card,
        cash;
    }

    Currency currency;
    String balance;
    TypeAccount type;
    String accountnumber;
    String ico;

    public CashAccount(String uid, String name, Currency currency, String balance, TypeAccount type, String accountnumber, String ico)
    {
        super(uid, name);
        this.currency = currency;
        this.balance = balance;
        this.type = type;
        this.accountnumber = accountnumber;
        this.ico = ico;
    }

    @Override
    protected ContentValues getContentValues(ContentValues cv)
    {
        cv.put(delaemcode.mym1y.database.contract.CashAccount.CURRENCY, currency.UID);
        cv.put(delaemcode.mym1y.database.contract.CashAccount.BALANCE, balance);
        cv.put(delaemcode.mym1y.database.contract.CashAccount.TYPE, type.ordinal());
        cv.put(delaemcode.mym1y.database.contract.CashAccount.ACCOUNTNUMBER, accountnumber);
        cv.put(delaemcode.mym1y.database.contract.CashAccount.ICO, ico);
        return cv;
    }
}
