package delaemcode.mym1y.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.View;

import delaemcode.mym1y.R;

public class TransactionsCursorAdapter
        extends MyMyCursorAdapter
{
    static class TransactionsCursorHolder
            extends MyMyCursorHolder
    {
        public TransactionsCursorHolder(View v)
        {
            super(v);
        }
    }

    public TransactionsCursorAdapter(Context context, Cursor c)
    {
        super(context, c, R.layout.transactionsitem);
    }

    @Override
    protected View newView(View view, Cursor cursor)
    {
        return view;
    }

    @Override
    protected MyMyCursorHolder initHolder(View view)
    {
        TransactionsCursorHolder holder = new TransactionsCursorHolder(view);
        return holder;
    }

    @Override
    public void bindView(MyMyCursorHolder h, Cursor cursor)
    {
        TransactionsCursorHolder holder = getHolder(h);
    }

    private TransactionsCursorHolder getHolder(MyMyCursorHolder h)
    {
        return (TransactionsCursorHolder)h;
    }
}