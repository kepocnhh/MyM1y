package delaemcode.mym1y;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main
        extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void enter(View view)
    {
        startActivityForResult(new Intent(this, Work.class), 0);
    }
}