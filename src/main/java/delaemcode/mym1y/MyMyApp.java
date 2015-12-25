package delaemcode.mym1y;

import android.app.Application;

import delaemcode.mym1y.db.SQliteApi;

public class MyMyApp
        extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        SQliteApi.createDb(getApplicationContext());
    }
}