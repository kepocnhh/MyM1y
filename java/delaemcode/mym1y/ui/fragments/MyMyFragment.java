package delaemcode.mym1y.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import delaemcode.mym1y.listeners.fragments.IMyMyFragmentClick;

public abstract class MyMyFragment
        extends Fragment
{
    protected View container;
    private String fragmentTag;
    private int fragmentTagId;

    public String getFragmentTag()
    {
        return fragmentTag;
    }

    protected IMyMyFragmentClick clickListener;

    public MyMyFragment(int lay, int id)
    {
        Bundle args = new Bundle();
        args.putInt("layout", lay);
        setArguments(args);
        fragmentTagId = id;
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
        fragmentTag = getActivity().getResources().getString(fragmentTagId);
    }

    protected void findViews(View v)
    {
        container = v;
    }
}