package delaemcode.mym1y.units;

public class Systemtag
        extends Tag
{
    public Systemtag(String uid, String n, String c)
    {
        super(uid, n, c);
    }

    enum TypeTag
    {
        date,
        time,
        from,
        to,
        rating,
        photo,
        comment,
        map;
    }

    TypeTag type;

}