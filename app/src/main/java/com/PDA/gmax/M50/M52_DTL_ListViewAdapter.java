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

public class M52_DTL_ListViewAdapter extends BaseAdapter {

    private ArrayList<M52_DTL> listViewItem = new ArrayList<M52_DTL>();

    public M52_DTL_ListViewAdapter() {

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
            convertView = inflater.inflate(R.layout.list_view_m52_dtl, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        LinearLayout ContentView    = (LinearLayout)convertView.findViewById(R.id.ContentView);
        // TextView no                 = (TextView) convertView.findViewById(R.id.no);            //순번
        TextView fabric               = (TextView) convertView.findViewById(R.id.fabric);        //원단
        TextView fabric_no               = (TextView) convertView.findViewById(R.id.fabric_no);        //원단

        TextView width             = (TextView) convertView.findViewById(R.id.width);         //폭
        TextView length             = (TextView) convertView.findViewById(R.id.length);        //길이
        TextView insrt_dt             = (TextView) convertView.findViewById(R.id.insrt_dt);        //길이

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        M52_DTL item2 = listViewItem.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        //no.setText(item2.getNO());
        fabric.setText(item2.getFABRIC());
        fabric_no.setText(item2.getFABRIC_NO());
        width.setText(item2.getWIDTH());
        length.setText(item2.getLENGTH());
        insrt_dt.setText(item2.getINSRT_DT());

        return convertView;
    }


    public void addItem(int NO,String FABRIC,String FABRIC_NO,String WIDTH,String LENGTH,String INSRT_DT) {
        M52_DTL item = new M52_DTL();

        item.setNO(NO);
        item.setFABRIC(FABRIC);
        item.setFABRIC_NO(FABRIC_NO);
        item.setWIDTH(WIDTH);
        item.setLENGTH(LENGTH);
        item.setINSRT_DT(INSRT_DT);

    }

    protected void addPkgItem(M52_DTL item) {
        listViewItem.add(0,item);
        //listViewItem.add(item);
        //notifyDataSetChanged();
    }


}
