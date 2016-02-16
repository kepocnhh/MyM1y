package delaemcode.mym1y.ui.activities;

import delaemcode.mym1y.R;
import delaemcode.mym1y.listeners.fragments.work.ICashAccountsFragmentListener;
import delaemcode.mym1y.ui.fragments.work.CashAccountsFragment;

public class Work
        extends MyMyActivity
        implements ICashAccountsFragmentListener
{
    public Work()
    {
        super(R.layout.work, R.id.workframe);
    }

    @Override
    protected void initViews()
    {

    }

    @Override
    protected void init()
    {
        addFragment(CashAccountsFragment.newInstance());
    }
}