package tr.com.harunkor.androidsqlitesample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HARUN KOR on 06.05.2017.
 */


public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="myDataBase";
    private static final int DATA_VERSION=2;

    private static final String DATABASE_CREATE = "create table MYTABLE(_id integer primary key,name text not null);";

    public MyDatabaseHelper(Context cnt)
    {
        super(cnt,DB_NAME,null,DATA_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS MYTABLE");
        onCreate(db);

    }
}
