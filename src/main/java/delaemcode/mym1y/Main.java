package delaemcode.mym1y;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import delaemcode.mym1y.database.DBHelper;

public class Main
        extends MyMyActivity
{

    public Main()
    {
        super(R.layout.main, R.id.mainframe);
    }


    @Override
    public void initFragments()
    {

    }

    @Override
    public void initViews()
    {
    }

    //______________BUTTONS_ACTIONS
    public void enter(View view)
    {
        startActivityForResult(new Intent(this, Work.class), 0);
    }
}