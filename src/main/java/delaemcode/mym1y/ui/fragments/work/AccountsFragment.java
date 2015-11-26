package delaemcode.mym1y.ui.fragments.work;

import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import delaemcode.mym1y.R;
import delaemcode.mym1y.database.Contract;
import delaemcode.mym1y.database.DBHelper;
import delaemcode.mym1y.database.contract.CashAccount;
import delaemcode.mym1y.database.contract.Currency;
import delaemcode.mym1y.listeners.cashAccounts.ICashAccountsListListener;
import delaemcode.mym1y.ui.activities.transactions.AddTransaction;
import delaemcode.mym1y.ui.adapters.cashAccounts.CashAccountsAdapter;

public class AccountsFragment
        extends WorkFragment
{

    ListView cashaccountslist;
    CashAccountsAdapter cashAccountsAdapter;

    public AccountsFragment()
    {
        super(R.layout.cashaccounts);
    }

    @Override
    protected void findViews(View v)
    {
        super.findViews(v);
        cashaccountslist = (ListView) v.findViewById(R.id.cashaccountslist);
    }

    @Override
    protected void init()
    {
        Cursor cursor = DBHelper.getInstance(getActivity()).query(Contract.getContract(Contract.TABLE_NAME_CASHACCOUNT), null, null, null, null);
        cashAccountsAdapter = new CashAccountsAdapter(getActivity(), readCashAccounts(cursor), new ICashAccountsListListener()
        {
            @Override
            public void addTransaction(String cai)
            {
                AddTransaction.startAddTransactionActivity(getActivity(), cai);
            }

            @Override
            public void pressItem(int pos)
            {

            }
        });
        cursor.close();
        cashaccountslist.setAdapter(cashAccountsAdapter);
        cashAccountsAdapter.notifyDataSetChanged();
    }

    private List<Map<String, String>> readCashAccounts(Cursor cursor)
    {
        List<Map<String, String>> list = new ArrayList<>();
        if(cursor != null && cursor.getCount() > 0)
        {
            Log.e("readCashAccounts", cursor.getCount() + "");
            while(!cursor.isClosed() && cursor.moveToNext())
            {
                Map<String, String> map = new HashMap<>();
//                map.put(CashAccountsAdapter.STATE, "0");
                map.put(CashAccount.ID, cursor.getString(cursor.getColumnIndex(CashAccount.ID)));
                map.put(CashAccount.NAME, cursor.getString(cursor.getColumnIndex(CashAccount.NAME)));
                String measure = DBHelper.getInstance(getActivity()).getStringFromOption(
                        Contract.TABLE_NAME_CURRENCY,
                        CashAccount.ID, cursor.getString(cursor.getColumnIndex(CashAccount.CURRENCY)),
                        Currency.MEASURE);
                map.put(CashAccount.CURRENCY, measure);
                map.put(CashAccount.BALANCE, cursor.getString(cursor.getColumnIndex(CashAccount.BALANCE)));
                map.put(CashAccount.ICO, cursor.getString(cursor.getColumnIndex(CashAccount.ICO)));
                list.add(map);
            }
            cursor.close();
        }
        return list;
    }
}
