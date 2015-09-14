package delaemcode.mym1y.database.contract;

import delaemcode.mym1y.database.Contract;

public class CashAccount
    extends Contract
{
    public static final String CURRENCY="currency";
    public static final String BALANCE="balance";
    public static final String TYPE="type";
    public static final String ACCOUNTNUMBER="accountnumber";
    public static final String ICO="ico";

    @Override
    protected String setTableName()
    {
        return Contract.TABLE_NAME_CASHACCOUNT;
    }

    @Override
    public String createTable()
    {
        return createTable(CURRENCY, INTEGER_TYPE,
                BALANCE, TEXT_TYPE,
                TYPE, INTEGER_TYPE,
                ACCOUNTNUMBER, INTEGER_TYPE,
                ICO, TEXT_TYPE);
    }
}
