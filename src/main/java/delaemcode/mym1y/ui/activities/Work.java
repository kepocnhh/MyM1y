package delaemcode.mym1y.ui.activities;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import delaemcode.mym1y.R;
import delaemcode.mym1y.database.Contract;
import delaemcode.mym1y.database.DBHelper;
import delaemcode.mym1y.listeners.cashAccounts.ICashAccountsFragmentListener;
import delaemcode.mym1y.ui.fragments.work.AccountsFragment;
import delaemcode.mym1y.units.CashAccount;
import delaemcode.mym1y.units.Currency;

public class Work
        extends MyMyActivity
        implements ICashAccountsFragmentListener
{

    //__________FRAGMENTS
    private AccountsFragment accountsFragment;

    public Work()
    {
        super(R.layout.work, R.id.workfragment);
    }

    @Override
    protected void initFragments()
    {
        accountsFragment = new AccountsFragment();
        addFragment(accountsFragment);
//        Cursor locationData = DBHelper.getInstance(this).query(Contract.cashAccount, null, null, null, null);
    }

    private void addCashAccount(CashAccount cashAccount)
    {
        DBHelper.getInstance(this).insert(Contract.getContract(Contract.TABLE_NAME_CASHACCOUNT), cashAccount.getContentValues());
    }
    private void addCurrency(Currency currency)
    {
        DBHelper.getInstance(this).insert(Contract.getContract(Contract.TABLE_NAME_CURRENCY), currency.getContentValues());
    }
    public List<Currency> getCurrencys(Cursor cursor)
    {
        cursor.moveToFirst();
        List<Currency> currencys = new ArrayList<>();
        while(!cursor.isAfterLast())
        {
            String uid = cursor.getString(cursor.getColumnIndex(Contract.ID));
            String name = cursor.getString(cursor.getColumnIndex(Contract.NAME));
            String mesu = cursor.getString(cursor.getColumnIndex(delaemcode.mym1y.database.contract.Currency.MEASURE));
            currencys.add(new Currency(uid, name, mesu));
            cursor.moveToNext();
        }
        cursor.close();
        return currencys;
    }

    @Override
    protected void initViews()
    {

    }

    @Override
    protected void init()
    {
//        initDB();
    }
    private void initDB()
    {
        addCurrency(new Currency(null, "Рубль", "руб"));
        Cursor cursor = DBHelper.getInstance(this).query(Contract.getContract(Contract.TABLE_NAME_CURRENCY), null, null, null, null);
        List<Currency> currencys = getCurrencys(cursor);
        addCashAccount(new CashAccount(null, "Сбербанк", currencys.get(0), "0", CashAccount.TypeAccount.card, "1234567890", "icosberbank"));
        addCashAccount(new CashAccount(null, "Наличные", currencys.get(0), "0", CashAccount.TypeAccount.cash, "", "iconalichko"));
    }
}