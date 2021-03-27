package com.example.picasso_practicum;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

public class DatabaseAccess {
    private static SQLiteDatabase db;
    private SQLiteOpenHelper openHelper;
    private static DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.db = openHelper.getWritableDatabase();
    }

    public void close() {
        if (db!=null) {
            this.db.close();
        }
    }

    public static Cursor getData() {
        //return db.query("catalog", new String[] {"_id", "name", "picture_url", "price", "description"}, null, null, null, null, null);

        return db.rawQuery("select * from catalog", null);
    }
}
