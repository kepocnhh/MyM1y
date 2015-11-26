package delaemcode.mym1y.ui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import delaemcode.mym1y.ui.fragments.FragmentTransactionPattern;

public abstract class MyMyActivity
        extends AppCompatActivity
{
    //__________FRAGMENTS
    private FragmentTransactionPattern fTP;
    private int contentView;
    private int frameView;

    public MyMyActivity(int content, int frame)
    {
        initActivity(content, frame);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(contentView);
        fTP = new FragmentTransactionPattern(this, frameView);
        //
        initFragments();
        initViews();
        init();
    }

    private void initActivity(int content, int frame)
    {
        this.contentView = content;
        this.frameView = frame;
    }
    public void addFragment(Fragment f)
    {
        fTP.add(f);
    }

    protected abstract void initFragments();
    protected abstract void initViews();
    protected abstract void init();
}
