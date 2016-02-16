package delaemcode.mym1y.ui.activities;

import android.content.Intent;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

import delaemcode.mym1y.R;
import delaemcode.mym1y.core.CashAccount;
import delaemcode.mym1y.core.CashAccountType;
import delaemcode.mym1y.core.Currency;
import delaemcode.mym1y.core.Tag;
import delaemcode.mym1y.core.Transaction;
import delaemcode.mym1y.db.ContentDriver;
import delaemcode.mym1y.db.SQliteApi;
import delaemcode.mym1y.db.Tables;
import delaemcode.mym1y.helpers.SQliteHelper;
import delaemcode.mym1y.listeners.fragments.main.IMainFragmentListener;
import delaemcode.mym1y.ui.fragments.main.MainFragment;

public class Main
        extends MyMyActivity
        implements IMainFragmentListener
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
//        insertTags();
//        insertTransactions();
        SQliteApi.endTransaction();
        getCurrencies();
        getCashAccountTypes();
        getCashAccounts();
        getTags();
        getTransactionsAndTags();
        getTransactions();
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
        CashAccount cashAccount;
        cashAccount = new CashAccount().setName("Наличко").setBalance("503.12").setAccountNumber("").setIco("nalichkoicon").setCashAccountType(cashAccountType).setCurrency(currency);
        SQliteApi.insertCashAccount(ContentDriver.getContentValues(cashAccount));
        cashAccount = new CashAccount().setName("Ещё наличка").setBalance("124234.76").setAccountNumber("").setIco("nalichkoicon").setCashAccountType(cashAccountType).setCurrency(currency);
        SQliteApi.insertCashAccount(ContentDriver.getContentValues(cashAccount));
    }

    public void insertTags()
    {
        SQliteApi.insertTag(ContentDriver.getContentValues(new Tag().setName("Кола").setColor(344)));
        SQliteApi.insertTag(ContentDriver.getContentValues(new Tag().setName("Овощи").setColor(0)));
        SQliteApi.insertTag(ContentDriver.getContentValues(new Tag().setName("Картоха").setColor(199).setParent(1)));
    }
    public void insertTransactions()
    {
        Cursor cursor;
        //
        CashAccount cashAccount;
        cursor = SQliteApi.getCashAccounts();
        cursor.moveToNext();
        cashAccount = ContentDriver.setCashAccountContentValues(cursor);
        cursor.close();
        //
        Tag tag1;
        Tag tag2;
        cursor = SQliteApi.getTags();
        cursor.moveToNext();
        tag1 = ContentDriver.setTagContentValues(cursor);
        cursor.moveToNext();
        tag2 = ContentDriver.setTagContentValues(cursor);
        cursor.close();
        //
        Transaction transaction = new Transaction()
                        .setFrom(cashAccount.ID)
                        .setSumm("12.3");
        transaction.tags = new ArrayList<>();
        transaction.tags.add(tag1);
        transaction.tags.add(tag2);
        SQliteHelper.saveTransaction(transaction);
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
            Log.e("getCashAccounts", "CashAccount -" + " name: " + a.name + " balance: " + a.balance + " accountnumber: " + a.accountnumber + " currency: " + a.currency.name + " type: " + a.type.name + " ico: " + a.ico);
        }
        cursor.close();
    }

    public void getTags()
    {
        Cursor cursor = SQliteApi.getTags();
        while(cursor.moveToNext())
        {
            Tag a = ContentDriver.setTagContentValues(cursor);
            Log.e("getTags", "Tag - name: " + a.name + " color: " + a.color + " parent: " + a.parent);
        }
        cursor.close();
    }
    public void getTransactionsAndTags()
    {
        Cursor cursor = SQliteApi.getTransactionsAndTags();
        while(cursor.moveToNext())
        {
            Log.e("getTransactionsAndTags",
                    "TRANSACTIONID: " + cursor.getInt(cursor.getColumnIndex(Tables.TransactionsAndTags.TRANSACTIONID))
                            + " TAGID: " + cursor.getInt(cursor.getColumnIndex(Tables.TransactionsAndTags.TAGID)));
        }
        cursor.close();
    }
    public void getTransactions()
    {
        Cursor cursor = SQliteApi.getTransactions();
        while(cursor.moveToNext())
        {
            Transaction a = ContentDriver.setTransactionContentValues(cursor);
            Log.e("getTransactions", "Transaction - from: " + a.from + " summ: " + a.summ);
            if(a.tags != null && a.tags.size() > 0)
            {
                for(int i = 0; i < a.tags.size(); i++)
                {
                    Log.e("Transaction tags", "\tTag - name: " + a.tags.get(i).name + " color: " + a.tags.get(i).color + " parent: " + a.tags.get(i).parent);
                }
            }
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