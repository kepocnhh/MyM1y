package delaemcode.mym1y.ui.holders.adapters.work;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import delaemcode.mym1y.R;

public class CashAccountsRecyclerHolder
        extends RecyclerView.ViewHolder
{
    public TextView cash_account_name;

    public CashAccountsRecyclerHolder(View v)
    {
        super(v);
        cash_account_name = (TextView) v.findViewById(R.id.cash_account_name);
    }
}