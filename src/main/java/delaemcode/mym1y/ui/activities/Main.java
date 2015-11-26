package delaemcode.mym1y.ui.activities;

import android.content.Intent;
import android.view.View;

import delaemcode.mym1y.R;

public class Main
        extends MyMyActivity
{

    public Main()
    {
        super(R.layout.main, R.id.mainframe);
    }


    @Override
    protected void initFragments()
    {

    }

    @Override
    protected void initViews()
    {
    }

    @Override
    protected void init()
    {

    }

    //______________BUTTONS_ACTIONS
    public void enter(View view)
    {
        startActivityForResult(new Intent(this, Work.class), 0);
    }
    public void test(View view)
    {
//        startActivityForResult(new Intent(this, ScanActivity.class), 0);
    }
}