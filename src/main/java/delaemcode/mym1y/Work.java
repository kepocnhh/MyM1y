package delaemcode.mym1y;

import delaemcode.mym1y.fragments.work.AccountsFragment;

public class Work
        extends MyMyActivity
        implements AccountsFragment.IAccountsClick
{
    //__________FRAGMENTS
    private AccountsFragment accountsFragment;

    public Work()
    {
        super(R.layout.work, R.id.workfragment);
    }

    @Override
    public void initFragments()
    {
        accountsFragment = new AccountsFragment();
        addFragment(accountsFragment);
    }

    @Override
    public void initViews()
    {

    }
}