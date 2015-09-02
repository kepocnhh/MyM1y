package delaemcode.mym1y;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import delaemcode.mym1y.fragments.FragmentTransactionPattern;

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

    public abstract void initFragments();
    public abstract void initViews();
}
