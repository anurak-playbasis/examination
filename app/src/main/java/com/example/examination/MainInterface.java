package com.example.examination;

import java.util.ArrayList;
import java.util.HashMap;

public interface MainInterface {
    interface View{
        void showToast(String msg);
        void clearText();
        void updateListView();
    }
    interface Presenter{
        long addUser(String name, String mobile, String address);
        ArrayList<HashMap<String, String>> getUserAll();
    }
}
