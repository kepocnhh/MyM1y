package delaemcode.mym1y.listeners.cashAccounts;

import delaemcode.mym1y.listeners.MyMyAdapterListener;

public interface ICashAccountsListListener
        extends MyMyAdapterListener
{
    void addTransaction(String cai);
}