package delaemcode.mym1y.core;

public class Currency
    extends MyMy
{
    public String name;
    public String measure;

    public Currency setName(String n)
    {
        this.name = n;
        return this;
    }
    public Currency setMeasure(String m)
    {
        this.measure = m;
        return this;
    }
}