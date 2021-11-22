package com.example.examination;

import com.example.examination.database.DatabaseHelper;

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        databaseHelper.close();

        Contextor.getInstance().init(getApplicationContext());
    }
}
