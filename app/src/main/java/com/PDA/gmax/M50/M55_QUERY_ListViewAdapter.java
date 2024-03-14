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

    private ArrayList<M51_DTL> listViewItem = new ArrayList<M51_DTL>();

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
        TextView no                 = (TextView) convertView.findViewById(R.id.no);            //순번
        TextView fabric               = (TextView) convertView.findViewById(R.id.fabric);        //원단
        TextView width             = (TextView) convertView.findViewById(R.id.width);         //폭
        TextView length             = (TextView) convertView.findViewById(R.id.length);        //길이

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        M51_DTL item2 = listViewItem.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        no.setText(item2.getNO());
        fabric.setText(item2.getFABRIC());
        width.setText(item2.getWIDTH());
        length.setText(item2.getLENGTH());

        return convertView;
    }


    public void addItem(int NO,String FABRIC,String AREA_DENSITY,String LOT_NO,String ROLL_NO,String WIDTH,String LENGTH,String QR_VALUE_ALL,String STATUS) {
        M51_DTL item = new M51_DTL();

        item.setNO(NO);
        item.setFABRIC(FABRIC);
        item.setWIDTH(WIDTH);
        item.setLENGTH(LENGTH);

    }

    protected void addPkgItem(M51_DTL item) {
        listViewItem.add(0,item);
        //listViewItem.add(item);
        //notifyDataSetChanged();
    }


}
