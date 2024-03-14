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

public class M54_DTL_ListViewAdapter extends BaseAdapter {

    private ArrayList<M54_DTL> listViewItem = new ArrayList<M54_DTL>();

    public M54_DTL_ListViewAdapter() {

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
            convertView = inflater.inflate(R.layout.list_view_m54_dtl, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        LinearLayout ContentView    = (LinearLayout)convertView.findViewById(R.id.ContentView);
        TextView status             = (TextView) convertView.findViewById(R.id.status);            //품번
        TextView fabric_nm          = (TextView) convertView.findViewById(R.id.fabric_nm);            //품번
        TextView qty                = (TextView) convertView.findViewById(R.id.qty);            //품번
        TextView width              = (TextView) convertView.findViewById(R.id.width);            //품번
        TextView length             = (TextView) convertView.findViewById(R.id.length);          //길이

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        M54_DTL item2 = listViewItem.get(position);


        status.setText(item2.getSTATUS());
        fabric_nm.setText(item2.getFABRIC_NM());
        qty.setText(item2.getQTY());
        width.setText(item2.getWIDTH());
        length.setText(item2.getLENGTH());


        return convertView;
    }


    public void addItem(String STATUS,String FABRIC_NM, String QTY,String WIDTH,String LENGTH) {
        M54_DTL item = new M54_DTL();

        item.setSTATUS(STATUS);
        item.setFABRIC_NM(FABRIC_NM);
        item.setQTY(QTY);
        item.setWIDTH(WIDTH);
        item.setLENGTH(LENGTH);

    }

    protected void addPkgItem(M54_DTL item) {
        listViewItem.add(0,item);

        //listViewItem.add(item);
    }


}
