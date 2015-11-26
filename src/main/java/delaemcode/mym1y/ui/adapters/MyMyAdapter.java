package delaemcode.mym1y.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import java.util.List;

import delaemcode.mym1y.listeners.MyMyAdapterListener;
import delaemcode.mym1y.ui.holders.MyMyHolder;

public abstract class MyMyAdapter
        extends SimpleAdapter
{

    private Activity activity;
    private MyMyAdapterListener listener;
    private LayoutInflater inflater;
    protected List data;
    protected int resourceID;

    public MyMyAdapter(Activity context, List d, MyMyAdapterListener l, int id)
    {
        super(context, d, id, new String[]{}, new int[]{});
        resourceID = id;
        activity = context;
        listener = l;
        data = d;
        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private MyMyHolder init(View vi)
    {
        MyMyHolder holder = initItems(vi);
        holder.parent = vi;
        return holder;
    }
    private void realize(MyMyHolder holder,final int p)
    {
        holder.parent.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pressItem(p);
                listener.pressItem(p);
            }
        });
        realizeItem(holder, p);
    }

    protected abstract void pressItem(int p);
    protected abstract MyMyHolder initItems(View vi);
    protected abstract void realizeItem(MyMyHolder holder, int p);

    @Override
    public View getView(int p, View convertView, ViewGroup parent)
    {
        MyMyHolder holder;
        if (convertView == null)
        {
            convertView = inflater.inflate(resourceID, parent, false);
            holder = init(convertView);
            convertView.setTag(holder);
        }
        else
        {
            holder = (MyMyHolder) convertView.getTag();
        }
        realize(holder, p);
        return convertView;
    }

    protected MyMyAdapterListener getListener()
    {
        return listener;
    }

}