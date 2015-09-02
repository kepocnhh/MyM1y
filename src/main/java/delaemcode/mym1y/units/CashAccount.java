package delaemcode.mym1y.units;

public class CashAccount
    extends Unit
{
    enum TypeAccount
    {
        card,
        cash;
    }

    String name;
    Currency currency;
    String balance;
    TypeAccount type;
    String accountnumber;
    String ico;

    public CashAccount(String uid, String name,
                       Currency currency,
            String balance,
                       TypeAccount type,
                       String accountnumber,
                       String ico)
    {
        super(uid);
        this.name = name;
        this.currency = currency;
        this.balance = balance;
        this.type = type;
        this.accountnumber = accountnumber;
        this.ico = ico;
    }
}
