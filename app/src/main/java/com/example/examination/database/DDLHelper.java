package com.example.examination.database;

public class DDLHelper {
    public static final String TABLE_NAME = "User";
    public static final String _ID = "id";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_MOBILE = "Mobile";
    public static final String COLUMN_ADDRESS = "Address";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_MOBILE + " TEXT," +
                    COLUMN_ADDRESS + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
