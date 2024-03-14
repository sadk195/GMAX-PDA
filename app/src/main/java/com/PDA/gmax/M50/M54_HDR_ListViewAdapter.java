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

public class M54_HDR_ListViewAdapter extends BaseAdapter {

    private ArrayList<M54_HDR> listViewItem = new ArrayList<M54_HDR>();

    public M54_HDR_ListViewAdapter() {

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
            convertView = inflater.inflate(R.layout.list_view_m54_hdr, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        LinearLayout ContentView    = (LinearLayout)convertView.findViewById(R.id.ContentView);
        TextView wk_ord_no              = (TextView) convertView.findViewById(R.id.wk_ord_no);            //품번
        TextView item_cd                = (TextView) convertView.findViewById(R.id.item_cd);            //품번
        TextView item_nm                = (TextView) convertView.findViewById(R.id.item_nm);            //품번
        TextView mat                    = (TextView) convertView.findViewById(R.id.mat);            //품번
        TextView seal                   = (TextView) convertView.findViewById(R.id.seal);            //품번

        TextView h_code                 = (TextView) convertView.findViewById(R.id.h_code);            //품번
        TextView qty                    = (TextView) convertView.findViewById(R.id.qty);          //길이

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        M54_HDR item2 = listViewItem.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        //투입된 아이템 Y 미투입 N
        wk_ord_no.setText(item2.getWK_ORD_NO());
        item_cd.setText(item2.getITEM_CD());
        item_nm.setText(item2.getITEM_NM());
        mat.setText(item2.getMAT());
        seal.setText(item2.getSEAL());
        h_code.setText(item2.getH_CODE());
        qty.setText(item2.getQTY());


        return convertView;
    }


    public void addItem(String WK_ORD_NO,String ITEM_CD,String ITEM_NM,String H_CODE,String MAT,String SEAL,String QTY) {
        M54_HDR item = new M54_HDR();

        item.setWK_ORD_NO(WK_ORD_NO);
        item.setITEM_CD(ITEM_CD);
        item.setITEM_NM(ITEM_NM);
        item.setMAT(MAT);
        item.setSEAL(SEAL);
        item.setH_CODE(H_CODE);
        item.setQTY(QTY);

    }

    protected void addItem(M54_HDR item) {
        listViewItem.add(0,item);

        //listViewItem.add(item);
    }


}
