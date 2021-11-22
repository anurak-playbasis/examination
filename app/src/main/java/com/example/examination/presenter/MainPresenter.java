package com.example.examination.presenter;

import com.example.examination.Contextor;
import com.example.examination.MainInterface;
import com.example.examination.database.table.UserTable;

import java.util.ArrayList;
import java.util.HashMap;

public class MainPresenter implements MainInterface.Presenter {
    private MainInterface.View mView;

    public MainPresenter(MainInterface.View view){
        this.mView = view;
    }

    @Override
    public long addUser(String name, String mobile, String address) {
        UserTable userTable = new UserTable(Contextor.getInstance().getContext());
        return userTable.insertUser(name,mobile,address);

    }

    @Override
    public ArrayList<HashMap<String, String>> getUserAll() {
        UserTable userTable = new UserTable(Contextor.getInstance().getContext());
        return userTable.getUserAll();
    }
}
