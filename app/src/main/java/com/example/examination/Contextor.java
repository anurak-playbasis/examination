package com.example.examination;

import android.content.Context;

public class Contextor {
    private static Contextor instance;
    private Context mContext;

    private Contextor() {
    }

    public static Contextor getInstance() {
        if (instance == null)
            instance = new Contextor();

        return instance;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return mContext;
    }
}
