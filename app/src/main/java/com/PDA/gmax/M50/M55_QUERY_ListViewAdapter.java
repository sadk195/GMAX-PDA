package com.PDA.gmax.M50;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.PDA.gmax.R;

import java.util.ArrayList;

public class M55_QUERY_ListViewAdapter extends BaseAdapter {

    private ArrayList<M55_QUERY> listViewItem = new ArrayList<M55_QUERY>();

    public M55_QUERY_ListViewAdapter() {

    }

    @Override
    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    public int getCount() {
        return listViewItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void ClearItem() { listViewItem.clear(); }


    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_view_m55_query, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        LinearLayout ContentView    = (LinearLayout)convertView.findViewById(R.id.ContentView);
        TextView fabric_nm          = (TextView) convertView.findViewById(R.id.fabric_nm);
        TextView type               = (TextView) convertView.findViewById(R.id.type);
        TextView width              = (TextView) convertView.findViewById(R.id.width);
        TextView length             = (TextView) convertView.findViewById(R.id.length);
        TextView qty                = (TextView) convertView.findViewById(R.id.qty);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        M55_QUERY item2 = listViewItem.get(position);

        fabric_nm.setText(item2.getFABRIC_NM());
        type.setText(item2.getTYPE());
        width.setText(item2.getWIDTH());
        length.setText(item2.getLENGTH());
        qty.setText(item2.getQTY());

        return convertView;
    }


    public void addItem(String FABRIC_NM,String TYPE,String WIDTH,String LENGTH,String QTY) {
        M55_QUERY item = new M55_QUERY();


        item.setFABRIC_NM(FABRIC_NM);
        item.setTYPE(TYPE);
        item.setWIDTH(WIDTH);
        item.setLENGTH(LENGTH);
        item.setQTY(QTY);

    }

    protected void addPkgItem(M55_QUERY item) {
        listViewItem.add(0,item);
        //listViewItem.add(item);
        //notifyDataSetChanged();
    }


}
