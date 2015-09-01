package delaemcode.mym1y;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import delaemcode.mym1y.fragments.FragmentTransactionPattern;
import delaemcode.mym1y.fragments.work.AccountsFragment;

public class Work
        extends AppCompatActivity
        implements AccountsFragment.IAccountsClick
{
    //__________FRAGMENTS
    private FragmentTransactionPattern fTP;
    private AccountsFragment accountsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.work);
        //
        initFragments();
    }

    public void initFragments()
    {
        fTP = new FragmentTransactionPattern(this, R.id.workfragment);
        accountsFragment = new AccountsFragment();
        fTP.add(accountsFragment);
    }
}