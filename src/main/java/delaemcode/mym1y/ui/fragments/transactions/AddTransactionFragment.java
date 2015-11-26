package delaemcode.mym1y.ui.fragments.transactions;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import delaemcode.mym1y.R;
import delaemcode.mym1y.database.Contract;
import delaemcode.mym1y.database.DBHelper;
import delaemcode.mym1y.database.contract.CashAccount;
import delaemcode.mym1y.ui.fragments.MyMyFragment;

public class AddTransactionFragment
        extends MyMyFragment
{
    //__________VIEWS
    TextView transaction_from_name;

    public static final String CASH_ACCOUNT_ID_KEY = "cash_account_id";

    public static AddTransactionFragment newInstance(String cai)
    {
        AddTransactionFragment fragment = new AddTransactionFragment();
        Bundle bundle = fragment.getArguments();
        bundle.putString(CASH_ACCOUNT_ID_KEY, cai);
        fragment.setArguments(bundle);
        return fragment;
    }

    String cash_account_id;

    public AddTransactionFragment()
    {
        super(R.layout.transaction_add_transaction);
    }

    @Override
    protected void findViews(View v)
    {
        transaction_from_name = (TextView) v.findViewById(R.id.transaction_from_name);
    }

    @Override
    protected void init()
    {
        cash_account_id = getArguments().getString(CASH_ACCOUNT_ID_KEY);
        String from_name = DBHelper.getInstance(getActivity()).getStringFromOption(
                Contract.TABLE_NAME_CASHACCOUNT,
                CashAccount.ID, cash_account_id,
                CashAccount.NAME);
        transaction_from_name.setText(from_name);
    }
}