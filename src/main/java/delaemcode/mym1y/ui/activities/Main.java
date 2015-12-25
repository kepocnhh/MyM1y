package delaemcode.mym1y.ui.activities;

import android.content.Intent;
import android.database.Cursor;
import android.util.Log;

import delaemcode.mym1y.R;
import delaemcode.mym1y.core.Currency;
import delaemcode.mym1y.db.ContentDriver;
import delaemcode.mym1y.db.SQliteApi;
import delaemcode.mym1y.listeners.fragments.main.IMainFragmentClick;
import delaemcode.mym1y.ui.fragments.main.MainFragment;

public class Main
        extends MyMyActivity
    implements IMainFragmentClick
{

    public Main()
    {
        super(R.layout.main, R.id.mainframe);
    }

    @Override
    protected void initViews()
    {
    }

    @Override
    protected void init()
    {
        addFragment(MainFragment.newInstance());
        initDB();
    }
    private void initDB()
    {
        SQliteApi.startTransaction();
//        insertCurrencies();
        SQliteApi.endTransaction();
        getCurrencies();
    }
    public void insertCurrencies()
    {
        SQliteApi.insertCurrency(ContentDriver.getContentValues(new Currency().setName("Рубль").setMeasure("руб")));
        SQliteApi.insertCurrency(ContentDriver.getContentValues(new Currency().setName("Доллар").setMeasure("$")));
    }
    public void getCurrencies()
    {
        Cursor cursor = SQliteApi.getCurrencies();
        while (cursor.moveToNext())
        {
            Currency a = ContentDriver.setCurrencyContentValues(cursor);
            Log.e("getCurrencies", "Currency - name: " + a.name + " measure: " + a.measure);
        }
        cursor.close();
    }

    @Override
    public void enter()
    {
        startActivityForResult(new Intent(this, Work.class), 0);
    }

    @Override
    public void test()
    {

    }
}