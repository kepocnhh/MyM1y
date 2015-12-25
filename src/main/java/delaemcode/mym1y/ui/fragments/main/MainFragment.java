package delaemcode.mym1y.ui.fragments.main;

import android.view.View;

import delaemcode.mym1y.R;
import delaemcode.mym1y.listeners.fragments.main.IMainFragmentClick;
import delaemcode.mym1y.ui.fragments.MyMyFragment;

public class MainFragment
        extends MyMyFragment
{
    static public MainFragment newInstance()
    {
        return new MainFragment();
    }

    public MainFragment()
    {
        super(R.layout.main_fragment, R.string.MainFragment);
    }

    @Override
    protected void findViews(View v)
    {
        super.findViews(v);
        v.findViewById(R.id.main_enter).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getClickListener().enter();
            }
        });
        v.findViewById(R.id.main_test).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getClickListener().test();
            }
        });
        init();
    }
    private void init()
    {

    }

    private IMainFragmentClick getClickListener()
    {
        return (IMainFragmentClick) clickListener;
    }
}