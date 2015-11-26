package delaemcode.mym1y.ui.adapters.cashAccounts;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import delaemcode.mym1y.R;
import delaemcode.mym1y.database.contract.CashAccount;
import delaemcode.mym1y.listeners.cashAccounts.ICashAccountsListListener;
import delaemcode.mym1y.ui.adapters.MyMyAdapter;
import delaemcode.mym1y.ui.holders.MyMyHolder;
import delaemcode.mym1y.ui.holders.cashAccounts.CashAccountsHolder;

public class CashAccountsAdapter
        extends MyMyAdapter
{
//    public static final String STATE = "state";

    private int state = -1;

    public CashAccountsAdapter(Activity context, List<Map<String, String>> d, ICashAccountsListListener l)
    {
        super(context, d, l, R.layout.cashaccountitem);
    }

    @Override
    protected MyMyHolder initItems(View vi)
    {
        CashAccountsHolder holder = new CashAccountsHolder();
        holder.ico_cash_account = (ImageView) vi.findViewById(R.id.ico_cash_account);
        holder.name_cash_account = (TextView) vi.findViewById(R.id.name_cash_account);
        holder.balance_cash_account = (TextView) vi.findViewById(R.id.balance_cash_account);
        holder.currency_cash_account = (TextView) vi.findViewById(R.id.currency_cash_account);
        holder.detail_cash_account = (LinearLayout) vi.findViewById(R.id.detail_cash_account);
        holder.add_transaction = (Button) vi.findViewById(R.id.add_transaction);
        return holder;
    }

    @Override
    protected void realizeItem(MyMyHolder holder, final int p)
    {
        getHolder(holder).name_cash_account.setText(getMap(p).get(CashAccount.NAME));
        getHolder(holder).balance_cash_account.setText(getMap(p).get(CashAccount.BALANCE));
        getHolder(holder).currency_cash_account.setText(getMap(p).get(CashAccount.CURRENCY));
        if(state == p)
        {
            getHolder(holder).detail_cash_account.setVisibility(View.VISIBLE);
            getHolder(holder).add_transaction.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    getCashAccountsListener().addTransaction(getMap(p).get(CashAccount.ID));
                }
            });
        }
        else
        {
            getHolder(holder).detail_cash_account.setVisibility(View.GONE);
        }
    }

    @Override
    protected void pressItem(int p)
    {
        if(state == p)
        {
            state = -1;
        }
        else
        {
            state = p;
        }
        notifyDataSetChanged();
    }

    private ICashAccountsListListener getCashAccountsListener()
    {
        return (ICashAccountsListListener) getListener();
    }
    private CashAccountsHolder getHolder(MyMyHolder h)
    {
        return (CashAccountsHolder) h;
    }
    private Map<String, String> getMap(int p)
    {
        return (Map<String, String>) data.get(p);
    }
}