package delaemcode.mym1y.ui.activities.transactions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import delaemcode.mym1y.R;
import delaemcode.mym1y.listeners.transactions.IAddTransactionsFragmentListener;
import delaemcode.mym1y.ui.activities.MyMyActivity;
import delaemcode.mym1y.ui.fragments.transactions.AddTransactionFragment;

public class AddTransaction
        extends MyMyActivity
        implements IAddTransactionsFragmentListener
{
    //__________FRAGMENTS
    AddTransactionFragment addTransactionFragment;

    String cash_account_id;

    static public void startAddTransactionActivity(Context context, String cai)
    {
        Intent i = new Intent(context, AddTransaction.class);
        i.putExtra(AddTransactionFragment.CASH_ACCOUNT_ID_KEY, cai);
        context.startActivity(i);
    }

    public AddTransaction()
    {
        super(R.layout.transaction, R.id.transaction_fragment);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        cash_account_id = getIntent().getStringExtra(AddTransactionFragment.CASH_ACCOUNT_ID_KEY);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initFragments()
    {
        addTransactionFragment = AddTransactionFragment.newInstance(cash_account_id);
        addFragment(addTransactionFragment);
    }

    @Override
    protected void initViews()
    {

    }

    @Override
    protected void init()
    {

    }
}