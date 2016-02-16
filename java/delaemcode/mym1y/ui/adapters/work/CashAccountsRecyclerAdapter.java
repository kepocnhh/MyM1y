package delaemcode.mym1y.ui.adapters.work;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import delaemcode.mym1y.R;
import delaemcode.mym1y.db.Tables;
import delaemcode.mym1y.ui.adapters.MyMyRecyclerAdapter;
import delaemcode.mym1y.ui.holders.adapters.work.CashAccountsRecyclerHolder;

public class CashAccountsRecyclerAdapter
        extends MyMyRecyclerAdapter
{
    public CashAccountsRecyclerAdapter(Context context)
    {
        super(context, R.layout.cash_account_item);
    }

    @Override
    protected RecyclerView.ViewHolder initHolder(View v)
    {
        return new CashAccountsRecyclerHolder(v);
    }

    @Override
    protected void initView(RecyclerView.ViewHolder h, int i)
    {
        getHolder(h).cash_account_name.setText(getString(Tables.NAME));
    }

    CashAccountsRecyclerHolder getHolder(RecyclerView.ViewHolder holder)
    {
        return (CashAccountsRecyclerHolder) holder;
    }
}