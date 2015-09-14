package delaemcode.mym1y;

import delaemcode.mym1y.database.Contract;
import delaemcode.mym1y.database.DBHelper;
import delaemcode.mym1y.fragments.work.AccountsFragment;
import delaemcode.mym1y.units.CashAccount;
import delaemcode.mym1y.units.Currency;

public class Work
        extends MyMyActivity
        implements AccountsFragment.IAccountsClick
{

    //__________FRAGMENTS
    private AccountsFragment accountsFragment;

    public Work()
    {
        super(R.layout.work, R.id.workfragment);
    }

    @Override
    public void initFragments()
    {
//        initDB();
        accountsFragment = new AccountsFragment();
        addFragment(accountsFragment);
//        Cursor locationData = DBHelper.getInstance(this).query(Contract.cashAccount, null, null, null, null);
    }

    private void initDB()
    {
        Currency currency = new Currency("0", "Рубль", "руб");
        CashAccount cashAccountSber = new CashAccount("0", "Сбербанк", currency, "0", CashAccount.TypeAccount.card, "1234567890", "icosberbank");
        CashAccount cashAccountNal = new CashAccount("1", "Наличные", currency, "0", CashAccount.TypeAccount.cash, "", "iconalichko");
        DBHelper.getInstance(this).insert(Contract.getContract(Contract.TABLE_NAME_CURRENCY), currency.getContentValues());
        DBHelper.getInstance(this).insert(Contract.getContract(Contract.TABLE_NAME_CASHACCOUNT), cashAccountSber.getContentValues());
        DBHelper.getInstance(this).insert(Contract.getContract(Contract.TABLE_NAME_CASHACCOUNT), cashAccountNal.getContentValues());
    }

    @Override
    public void initViews()
    {

    }
}