package delaemcode.mym1y.helpers;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import delaemcode.mym1y.core.Tag;
import delaemcode.mym1y.core.Transaction;
import delaemcode.mym1y.db.ContentDriver;
import delaemcode.mym1y.db.SQliteApi;
import delaemcode.mym1y.db.Tables;

public class SQliteHelper
{
    //______________________TRANSACTIONS
    static public void saveTransaction(Transaction a)
    {
        SQliteApi.insertTransaction(ContentDriver.getContentValues(a));
        if(a.tags != null && a.tags.size() > 0)
        {
            saveTagsForTransaction(a.tags, a.ID);
        }
    }
    static public void saveTagsForTransaction(List<Tag> tags, int id)
    {
        for(int i = 0; i < tags.size(); i++)
        {
            if(SQliteApi.getOneTransactionAndTag(id, tags.get(i).ID).getCount()>0)
            {
                continue;
            }
            ContentValues values = new ContentValues();
            values.put(Tables.TransactionsAndTags.TRANSACTIONID, id);
            values.put(Tables.TransactionsAndTags.TAGID, tags.get(i).ID);
            SQliteApi.insertTransactionAndTag(values);
        }
    }

    static public List<Tag> tryGetTagsFromTransactionId(int id)
    {
        List<Tag> units = new ArrayList<>();
        Cursor cursor = SQliteApi.getTagsFromTransactionId(id);
        while(cursor.moveToNext())
        {
            Tag a = ContentDriver.setTagContentValues(cursor);
            units.add(a);
        }
        cursor.close();
        return units;
    }
}