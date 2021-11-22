package com.example.examination.database.table;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.examination.database.DatabaseHelper;

public class BaseTable {
    protected SQLiteDatabase db;

    public BaseTable(SQLiteDatabase sqLiteDatabase){
        db = sqLiteDatabase;
    }
    public BaseTable(Context context){
        DatabaseHelper databaseHelper = new DatabaseHelper(context.getApplicationContext());
        db = databaseHelper.getWritableDatabase();
    }
    public void beginTransaction(){
        db.beginTransaction();
    }

    public void endTransaction(){
        db.endTransaction();
    }

    public void setTransactionSuccessful(){
        db.setTransactionSuccessful();
    }

}
