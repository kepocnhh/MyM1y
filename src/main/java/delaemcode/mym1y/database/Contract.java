package delaemcode.mym1y.database;

import android.net.Uri;

import delaemcode.mym1y.database.contract.CashAccount;
import delaemcode.mym1y.database.contract.Currency;
import delaemcode.mym1y.database.contract.Transaction;

public abstract class Contract
{
    private static final String AUTHORITY="delaemcode.mym1y.provider";
    private static final Uri AUTHORITY_URI= Uri.parse("content://" + AUTHORITY);
    private final String CONTENT_TYPE_PATH="vnd.android.cursor.dir/"+AUTHORITY+".";
    private final String CONTENT_ITEM_TYPE_PATH="vnd.android.cursor.item/"+AUTHORITY+".";

    public static final String TABLE_NAME_CASHACCOUNT="cashaccountstable";
    public static final String TABLE_NAME_CURRENCY="currencytable";
    public static final String TABLE_NAME_TRANSACTION="transactionstable";

    public static final Contract[] contracts = {
            new CashAccount(),
            new Currency(),
            new Transaction()
    };
    public static Contract getContract(String tn)
    {
        for(int i=0; i< Contract.contracts.length; i++)
        {
            if(Contract.contracts[i].TABLE_NAME.equals(tn))
            {
                return Contract.contracts[i];
            }
        }
        return null;
    }

    protected final String INTEGER_TYPE = "integer";
    protected final String TEXT_TYPE = "text";

    public final Uri CONTENT_URI;
    public final String CONTENT_TYPE;
    public final String CONTENT_ITEM_TYPE;

    public static final String ID="_id";
    public static final String NAME="name";

    public final String TABLE_NAME;

    protected abstract String setTableName();
    public String getTableName()
    {
        return TABLE_NAME;
    }

    public Contract()
    {
        TABLE_NAME = setTableName();
        CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, TABLE_NAME);
        CONTENT_TYPE=CONTENT_TYPE_PATH+TABLE_NAME;
        CONTENT_ITEM_TYPE=CONTENT_ITEM_TYPE_PATH+TABLE_NAME;
    }

    protected String createTable(String... args)
    {
        String s = "create table "+
                TABLE_NAME+"("+
                ID+" "+INTEGER_TYPE+"," +
                NAME + " "+ TEXT_TYPE;
        for(int i=0; i<args.length; i+=2)
        {
            s += ","+args[i]+" "+args[i+1];
        }
        s+=");";
        return s;
    }

    public abstract String createTable();

    public String dropTable()
    {
        return "drop table if exists " + TABLE_NAME;
    }
}
