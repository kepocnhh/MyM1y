package delaemcode.mym1y.database.contract;

import delaemcode.mym1y.database.Contract;

public class Currency
        extends Contract
{
    public static final String MEASURE="measure";

    @Override
    protected String setTableName()
    {
        return Contract.TABLE_NAME_CURRENCY;
    }

    @Override
    public String createTable()
    {
        return createTable(MEASURE, TEXT_TYPE);
    }
}