package delaemcode.mym1y.ui.fragments.work;

import android.database.Cursor;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import delaemcode.mym1y.R;
import delaemcode.mym1y.db.SQliteApi;
import delaemcode.mym1y.listeners.fragments.work.ICashAccountsFragmentListener;
import delaemcode.mym1y.ui.adapters.work.CashAccountsRecyclerAdapter;
import delaemcode.mym1y.ui.fragments.MyMyFragment;

public class CashAccountsFragment
        extends MyMyFragment
{

    //___________________VIEWS
    RecyclerView cash_accounts_recycler;

    //_______________FIELDS
    private CashAccountsRecyclerAdapter adapter;
    private LinearLayoutManager layoutManager;

    static public CashAccountsFragment newInstance()
    {
        return new CashAccountsFragment();
    }

    public CashAccountsFragment()
    {
        super(R.layout.cash_accounts_fragment, R.string.CashAccountsFragment);
    }

    @Override
    protected void findViews(View v)
    {
        super.findViews(v);
        cash_accounts_recycler = (RecyclerView) v.findViewById(R.id.cash_accounts_recycler);
        initList();
        init();
    }
    private void initList()
    {
        adapter = new CashAccountsRecyclerAdapter(getActivity());
        layoutManager = new LinearLayoutManager(getActivity());
        cash_accounts_recycler.setLayoutManager(layoutManager);
        cash_accounts_recycler.setAdapter(adapter);
    }
    private void init()
    {
        Cursor c = null;
        c = SQliteApi.getCashAccounts();
        adapter.swapCursor(c);
        Log.e("init", "CashAccountsCount = " + c.getCount());
    }

    private ICashAccountsFragmentListener getClickListener()
    {
        return (ICashAccountsFragmentListener) clickListener;
    }
}