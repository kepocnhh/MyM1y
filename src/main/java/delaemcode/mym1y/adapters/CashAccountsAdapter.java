package delaemcode.mym1y.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import delaemcode.mym1y.R;

public class CashAccountsAdapter
        extends MyMyAdapter
{
    final static public String NAMEKEY = "name";

    static class CashAccountsHolder
            extends MyMyHolder
    {
        TextView name;
        TextView value;
        ImageView ico;
    }

    public interface ICashAccountsListener
        extends MyMyAdapterListener
    {
    }

    public CashAccountsAdapter(Activity context, ArrayList<Map<String, String>> d, ICashAccountsListener l)
    {
        super(context, d, l, R.layout.cashaccountitem);
    }


    @Override
    protected MyMyHolder initItems(View vi)
    {
        CashAccountsHolder holder = new CashAccountsHolder();
        holder.ico = (ImageView) vi.findViewById(R.id.icocashaccount);
        holder.name = (TextView) vi.findViewById(R.id.namecashaccount);
        holder.value = (TextView) vi.findViewById(R.id.amountcashaccount);
        return holder;
    }

    @Override
    protected void realizeItem(MyMyHolder holder, int p)
    {
        CashAccountsHolder h = (CashAccountsHolder) holder;
        h.name.setText(data.get(p).get(NAMEKEY));
    }
}
