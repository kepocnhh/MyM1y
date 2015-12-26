package delaemcode.mym1y.ui.activities;

import android.content.Intent;
import android.database.Cursor;
import android.util.Log;

import delaemcode.mym1y.R;
import delaemcode.mym1y.core.CashAccount;
import delaemcode.mym1y.core.CashAccountType;
import delaemcode.mym1y.core.Currency;
import delaemcode.mym1y.db.ContentDriver;
import delaemcode.mym1y.db.SQliteApi;
import delaemcode.mym1y.listeners.fragments.main.IMainFragmentClick;
import delaemcode.mym1y.ui.fragments.main.MainFragment;

public class Main
        extends MyMyActivity
        implements IMainFragmentClick
{

    public Main()
    {
        super(R.layout.main, R.id.mainframe);
    }

    @Override
    protected void initViews()
    {
    }

    @Override
    protected void init()
    {
        addFragment(MainFragment.newInstance());
        initDB();
    }

    private void initDB()
    {
        SQliteApi.startTransaction();
//        insertCurrencies();
//        insertCashAccountTypes();
//        insertCashAccounts();
        SQliteApi.endTransaction();
        getCurrencies();
        getCashAccountTypes();
        getCashAccounts();
    }

    public void insertCurrencies()
    {
        SQliteApi.insertCurrency(ContentDriver.getContentValues(new Currency().setName("Рубль").setMeasure("руб")));
        SQliteApi.insertCurrency(ContentDriver.getContentValues(new Currency().setName("Доллар").setMeasure("$")));
    }

    public void insertCashAccountTypes()
    {
        SQliteApi.insertCashAccountType(ContentDriver.getContentValues(new CashAccountType().setName("Наличные")));
        SQliteApi.insertCashAccountType(ContentDriver.getContentValues(new CashAccountType().setName("Банковская карта")));
    }

    public void insertCashAccounts()
    {
        Cursor cursor;
        //
        CashAccountType cashAccountType;
        cursor = SQliteApi.getCashAccountTypes();
        cursor.moveToNext();
        cashAccountType = ContentDriver.setCashAccountTypeContentValues(cursor);
        cursor.close();
        //
        Currency currency;
        cursor = SQliteApi.getCurrencies();
        cursor.moveToNext();
        currency = ContentDriver.setCurrencyContentValues(cursor);
        cursor.close();
        //
        CashAccount cashAccount = new CashAccount()
                .setName("Наличко")
                .setBalance("1.1")
                .setAccountNumber("")
                .setIco("nalichkoicon")
                .setCashAccountType(cashAccountType)
                .setCurrency(currency);
        SQliteApi.insertCashAccount(ContentDriver.getContentValues(cashAccount));
    }

    public void getCashAccountTypes()
    {
        Cursor cursor = SQliteApi.getCashAccountTypes();
        while(cursor.moveToNext())
        {
            CashAccountType a = ContentDriver.setCashAccountTypeContentValues(cursor);
            Log.e("getCashAccountTypes", "CashAccountType - name: " + a.name);
        }
        cursor.close();
    }

    public void getCurrencies()
    {
        Cursor cursor = SQliteApi.getCurrencies();
        while(cursor.moveToNext())
        {
            Currency a = ContentDriver.setCurrencyContentValues(cursor);
            Log.e("getCurrencies", "Currency - name: " + a.name + " measure: " + a.measure);
        }
        cursor.close();
    }
    public void getCashAccounts()
    {
        Cursor cursor = SQliteApi.getCashAccounts();
        while(cursor.moveToNext())
        {
            CashAccount a = ContentDriver.setCashAccountContentValues(cursor);
            Log.e("getCashAccounts", "CashAccount -"
                    + " name: "+ a.name
                            + " balance: " + a.balance
                            + " accountnumber: " + a.accountnumber
                            + " currency: " + a.currency.name
                            + " type: " + a.type.name
                            + " ico: " + a.ico
            );
        }
        cursor.close();
    }

    @Override
    public void enter()
    {
        startActivityForResult(new Intent(this, Work.class), 0);
    }

    @Override
    public void test()
    {

    }
}