package delaemcode.mym1y.fragments.work;

import android.database.Cursor;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import delaemcode.mym1y.R;
import delaemcode.mym1y.adapters.CashAccountsAdapter;
import delaemcode.mym1y.adapters.CashAccountsCursorAdapter;
import delaemcode.mym1y.database.Contract;
import delaemcode.mym1y.database.DBHelper;

public class AccountsFragment
        extends WorkFragment
{

    public interface IAccountsClick
            extends IMyMyFragmentClick
    {
    }

    ListView cashaccountslist;
    CashAccountsAdapter cashAccountsAdapter;
    CashAccountsCursorAdapter cashAccountsCursorAdapter;

    public AccountsFragment()
    {
        super(R.layout.cashaccounts);
    }

    @Override
    protected void findViews(View v)
    {
        super.findViews(v);
        //
        cashaccountslist = (ListView) v.findViewById(R.id.cashaccountslist);
//        ArrayList<Map<String, String>> data = new ArrayList<>();
//        Map<String, String> map = new HashMap<>();
//        map.put(CashAccountsAdapter.NAMEKEY, "сбербанк");
//        Map<String, String> map2 = new HashMap<>();
//        map2.put(CashAccountsAdapter.NAMEKEY, "наличка");
//        data.add(map);
//        data.add(map2);
//
//        cashAccountsAdapter = new CashAccountsAdapter(getActivity(), data, new CashAccountsAdapter.ICashAccountsListener()
//        {
//            @Override
//            public void pressItem(int pos)
//            {
//                int i=0;
//                i++;
//            }
//        });
        Cursor data = DBHelper.getInstance(getActivity()).query(Contract.getContract(Contract.TABLE_NAME_CASHACCOUNT), null, null, null, null);
        cashAccountsCursorAdapter = new CashAccountsCursorAdapter(getActivity(), data);
        cashaccountslist.setAdapter(cashAccountsCursorAdapter);
        cashAccountsCursorAdapter.notifyDataSetChanged();
    }
}
