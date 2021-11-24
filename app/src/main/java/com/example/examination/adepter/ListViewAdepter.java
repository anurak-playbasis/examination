package com.example.examination.adepter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.examination.R;
import com.example.examination.view.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class ListViewAdepter extends BaseAdapter  {
    private Context mContext;
    private ArrayList<HashMap<String, String>>  userList;
    private LayoutInflater mLayoutInflater;


    public ListViewAdepter(Context context, ArrayList<HashMap<String, String>> data){
        mContext = context;
        userList = data;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView) {
            convertView = mLayoutInflater.inflate(R.layout.item_user, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.setData(mContext,position, userList);
        viewHolder.deleteData(position);
        return convertView;
    }
    static class ViewHolder{
        private TextView tvName, tvMobile, tvAddress;
        private Button btEdit, btDelete;
        public ViewHolder(View root) {
            tvName = (TextView) root.findViewById(R.id.tv_name);
            tvMobile = (TextView) root.findViewById(R.id.tv_mobile);
            tvAddress = (TextView) root.findViewById(R.id.tv_address);
            btEdit = (Button) root.findViewById(R.id.bt_edit);
            btDelete = (Button) root.findViewById(R.id.bt_delete);
        }
        public void setData(Context context, int position,ArrayList<HashMap<String, String>>  userList) {
            tvName.setText(userList.get(position).get("Name"));
            tvMobile.setText(userList.get(position).get("Mobile"));
            tvAddress.setText(userList.get(position).get("Address"));

        }
        public void deleteData(int position){
            btDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //TODO delete
                    // delete user listItem
                }
            });
        }
    }
}

