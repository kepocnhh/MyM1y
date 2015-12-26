package delaemcode.mym1y.core;

public class CashAccount
        extends MyMy
{
    public String name;
    public CashAccountType type;
    public Currency currency;
    public String balance;
    public String accountnumber;
    public String ico;

    public CashAccount setName(String n)
    {
        this.name = n;
        return this;
    }
    public CashAccount setCashAccountType(CashAccountType n)
    {
        this.type = n;
        return this;
    }
    public CashAccount setCurrency(Currency n)
    {
        this.currency = n;
        return this;
    }
    public CashAccount setBalance(String n)
    {
        this.balance = n;
        return this;
    }
    public CashAccount setAccountNumber(String n)
    {
        this.accountnumber = n;
        return this;
    }
    public CashAccount setIco(String n)
    {
        this.ico = n;
        return this;
    }
}