package com.example.examination.database.table;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.examination.database.DDLHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class UserTable extends BaseTable{
    public UserTable(SQLiteDatabase sqLiteDatabase) {
        super(sqLiteDatabase);
    }

    public UserTable(Context context) {
        super(context);
    }

    public long insertUser(String name, String mobile, String address){
        ContentValues values = new ContentValues();
        values.put(DDLHelper.COLUMN_NAME, name);
        values.put(DDLHelper.COLUMN_MOBILE, mobile);
        values.put(DDLHelper.COLUMN_ADDRESS, address);

        return db.insert(DDLHelper.TABLE_NAME, null, values);
    }
    public ArrayList<HashMap<String, String>> getUserAll() {
        ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
        String sqlCmd = "select id,Name, Mobile, Address " +
                "from  User " +
                "order by id ASC ";
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(
                    sqlCmd,
                    null);

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        map = new HashMap<String, String>();
                        map.put("id", cursor.getString(0));
                        map.put("Name", cursor.getString(1));
                        map.put("Mobile", cursor.getString(2));
                        map.put("Address", cursor.getString(3));
                        data.add(map);
                    } while (cursor.moveToNext());
                }
            }
        } catch (Exception e) {
            Log.e("UserTable",""+e);
        } finally {
            if (null != cursor) {
                cursor.close();
            }
        }
        return data;
    }
    public int deleteData(long id){
        String whereArgs[] = {""+id};
        int count = db.delete(DDLHelper.TABLE_NAME,DDLHelper._ID + "=?",whereArgs);
        return count;
    }
  /*  public ArrayList<HashMap<String, String>> getSOCompanyId(int saleOrderId) {
        ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
        int soCompanyId = 0;
        String sqlCmd = "select so.SOCompanyId, so.LocalBranchName " +
                "from  TB_VSMS_SOCompanyBranch AS so " +
                "join TB_VSMS_SaleOrderSKU AS sa " +
                "on sa.SOCompanyBranchId = so.SOCompanyBranchId " +
                "where sa.SaleOrderId = ? "+
                "group by so.SOCompanyId ";
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(
                    sqlCmd,
                    new String[]{String.valueOf(saleOrderId)});

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        map = new HashMap<String, String>();
                        map.put("SOCompanyId", cursor.getString(0));
                        map.put("LocalBranchName", cursor.getString(1));
                        data.add(map);
                    } while (cursor.moveToNext());
                }
            }
        } catch (Exception e) {
            FileHelper.saveExceptionToLogFile(e);
        } finally {
            if (null != cursor) {
                cursor.close();
            }
        }
        return data;
    }*/
}
