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
        TextView no                 = (TextView) convertView.findViewById(R.id.no);            //품번
        TextView item_nm               = (TextView) convertView.findViewById(R.id.item_nm);            //품번
        TextView length             = (TextView) convertView.findViewById(R.id.length);          //길이
        TextView input_dt             = (TextView) convertView.findViewById(R.id.input_dt);          //길이

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        M52_DTL item2 = listViewItem.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        no.setText(item2.getNO());
        item_nm.setText(item2.getITEM_NM());
        length.setText(item2.getLENGTH());
        input_dt.setText(item2.getINPUT_DT());

        return convertView;
    }


    public void addItem(int NO,String ITEM_NM,String LENGTH,String INPUT_DT) {
        M52_DTL item = new M52_DTL();

        item.setNO(NO);
        item.setITEM_NM(ITEM_NM);
        item.setLENGTH(LENGTH);
        item.setINPUT_DT(INPUT_DT);

    }

    protected void addPkgItem(M52_DTL item) {
        listViewItem.add(0,item);
        //listViewItem.add(item);
        //notifyDataSetChanged();
    }


}
