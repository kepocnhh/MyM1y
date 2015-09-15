package delaemcode.mym1y.database.contract;

import delaemcode.mym1y.database.Contract;

public class Transaction
        extends Contract
{
    public static final String FROM = "from";

    @Override
    protected String setTableName()
    {
        return Contract.TABLE_NAME_TRANSACTION;
    }

    @Override
    public String createTable()
    {
        return createTable(FROM, INTEGER_TYPE);
    }
}
