package delaemcode.mym1y.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import delaemcode.mym1y.R;
import delaemcode.mym1y.database.Contract;
import delaemcode.mym1y.database.contract.CashAccount;

public class CashAccountsCursorAdapter
        extends MyMyCursorAdapter
{
    static class CashAccountsCursorHolder
        extends MyMyCursorHolder
    {
        TextView namecashaccount;
        TextView amountcashaccount;
        ImageView icocashaccount;
        public CashAccountsCursorHolder(View v)
        {
            super(v);
            namecashaccount = (TextView) v.findViewById(R.id.namecashaccount);
            amountcashaccount = (TextView) v.findViewById(R.id.amountcashaccount);
            icocashaccount = (ImageView) v.findViewById(R.id.icocashaccount);
        }
    }

    public CashAccountsCursorAdapter(Context context, Cursor c)
    {
        super(context, c, R.layout.cashaccountitem);
    }

    @Override
    protected View newView(View view, Cursor cursor)
    {
        return view;
    }

    @Override
    protected MyMyCursorHolder initHolder(View view)
    {
        CashAccountsCursorHolder holder = new CashAccountsCursorHolder(view);
        return holder;
    }

    @Override
    public void bindView(MyMyCursorHolder h, Cursor cursor)
    {
        CashAccountsCursorHolder holder = getHolder(h);
        holder.namecashaccount.setText(cursor.getString(cursor.getColumnIndex(Contract.NAME)));
        holder.amountcashaccount.setText(cursor.getString(cursor.getColumnIndex(CashAccount.BALANCE)));
    }

    private CashAccountsCursorHolder getHolder(MyMyCursorHolder h)
    {
        return (CashAccountsCursorHolder)h;
    }
}