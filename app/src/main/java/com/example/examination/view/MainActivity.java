package com.example.examination.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.examination.MainInterface;
import com.example.examination.R;
import com.example.examination.adepter.ListViewAdepter;
import com.example.examination.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainInterface.View {
    private MainInterface.Presenter mPresenter;
    ListViewAdepter listViewAdepter;
    EditText name;
    EditText phone;
    EditText address;
    Button addButton;
    ListView listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainPresenter(this);
        bindView();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(name.getText().toString())&&
                        TextUtils.isEmpty(phone.getText().toString())&&
                        TextUtils.isEmpty(address.getText().toString()))
                {
                    showToast("Please input value");
                    return;
                }else {
                    long row = mPresenter.addUser(name.getText().toString(),
                            phone.getText().toString(),address.getText().toString());
                    if (row > 0){
                        clearText();
                        updateListView();
                    }
                }

            }
        });
        listViewAdepter = new ListViewAdepter(this,mPresenter.getUserAll());
        listItem.setAdapter(listViewAdepter);

    }

    private void bindView() {
        name = (EditText) findViewById(R.id.et_name);
        phone = (EditText) findViewById(R.id.et_phone);
        address = (EditText) findViewById(R.id.et_address);
        addButton = (Button) findViewById(R.id.bt_add);
        listItem = (ListView) findViewById(R.id.list_view);

        phone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});

    }
    private boolean isEmpty(EditText etText)
    {
        return etText.getText().toString().trim().length() == 0;
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearText() {
        name.setText("");
        phone.setText("");
        address.setText("");
    }

    @Override
    public void updateListView() {
        listViewAdepter = new ListViewAdepter(this,mPresenter.getUserAll());
        listItem.setAdapter(listViewAdepter);
        listViewAdepter.notifyDataSetChanged();
    }

}