package delaemcode.mym1y.ui.fragments.work;

import android.view.View;

import delaemcode.mym1y.ui.fragments.MyMyFragment;

public abstract class WorkFragment
        extends MyMyFragment
{
    protected View container;

    public WorkFragment(int lay)
    {
        super(lay);
    }

    public void setVisibility(boolean visibility)
    {
        if(visibility)
        {
            container.setVisibility(View.VISIBLE);
        }
        else
        {
            container.setVisibility(View.INVISIBLE);
        }
    }
    @Override
    protected void findViews(View v)
    {
        container = v;
    }
}