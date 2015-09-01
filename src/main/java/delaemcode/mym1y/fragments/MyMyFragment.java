package delaemcode.mym1y.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class MyMyFragment
        extends Fragment
{
    protected interface IMyMyFragmentClick
    {
    }
    protected IMyMyFragmentClick clickListener;

    public MyMyFragment(int lay)
    {
        Bundle args = new Bundle();
        args.putInt("layout", lay);
        setArguments(args);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(getArguments().getInt("layout", 0), container, false);
        findViews(v);
        return v;
    }
    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        clickListener = (IMyMyFragmentClick) activity;
    }

    protected abstract void findViews(View v);
}
