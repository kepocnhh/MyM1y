package delaemcode.mym1y.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

public abstract class MyMyCursorAdapter
        extends CursorAdapter
{
    static class MyMyCursorHolder
    {
        public MyMyCursorHolder(View v)
        {
        }
    }

    private Context context;
    protected int resourceID;
    public MyMyCursorAdapter(Context context, Cursor c, int r)
    {
        super(context, c, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        this.context = context;
        this.resourceID = r;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent)
    {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(resourceID,parent,false);
        view.setTag(initHolder(view));
        return newView(view, cursor);
    }
    protected abstract View newView(View view, Cursor cursor);
    protected abstract MyMyCursorHolder initHolder(View view);

    @Override
    public void bindView(View view, Context context, Cursor cursor)
    {
        bindView((MyMyCursorHolder)view.getTag(), cursor);
    }
    public abstract void bindView(MyMyCursorHolder h, Cursor cursor);

    public Context getContext()
    {
        return this.context;
    }
}