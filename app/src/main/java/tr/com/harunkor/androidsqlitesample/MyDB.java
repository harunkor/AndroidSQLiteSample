package tr.com.harunkor.androidsqlitesample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by OGR2BİL on 06.05.2017.
 */

public class MyDB {
    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase database;
    public final static String MY_TABLE = "MYTABLE";
    public final static String MY_ID="_id";
    public final static String MY_NAME="name";

public MyDB(Context context)
{
     dbHelper=new MyDatabaseHelper(context);
     database=dbHelper.getWritableDatabase();

}

public long createValue(String id,String name)
{
    ContentValues contentValues= new ContentValues();
    contentValues.put(MY_ID,id);
    contentValues.put(MY_NAME,name);

    return database.insert(MY_TABLE,null,contentValues);

}

    public boolean deleteValue(String id)
    {
        return database.delete(MY_TABLE, MY_ID+"="+id,null) > 0 ;


    }

    public boolean updateValue(String id,String name)
    {
       // boolean temp= true;
        ContentValues contentValues=new ContentValues();
        contentValues.put(MY_NAME,name);
        database.update(MY_TABLE,contentValues,MY_ID+"="+id,null);

//        try {
//
//            database.execSQL("UPDATE "+MY_TABLE+" SET "+MY_NAME+"="+name+" WHERE "+MY_ID+"="+id);
//
//        }catch (SQLException se)
//        {
//            temp=false;
//        }

        return  database.update(MY_TABLE,contentValues,MY_ID+"="+id,null)>0;
    }


    public ArrayList<String> allValues()
    {
        Cursor cursor = database.rawQuery("select * from "+MY_TABLE,null);
        ArrayList<String> arrayListAllValues = new ArrayList<String>();

        if(cursor.moveToFirst())
        {
           while (cursor.isAfterLast() == false)
           {
               String name = cursor.getString(cursor.getColumnIndex(MY_NAME));
               arrayListAllValues.add(name);

               cursor.moveToNext();
           }
        }


        return arrayListAllValues;

    }




}
