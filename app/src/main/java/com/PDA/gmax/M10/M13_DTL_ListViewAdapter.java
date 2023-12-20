package com.PDA.gmax.M10;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.PDA.gmax.R;

import java.util.ArrayList;

public class M13_DTL_ListViewAdapter extends BaseAdapter {

    private ArrayList<M13_DTL> listViewItem = new ArrayList<M13_DTL>();

    public M13_DTL_ListViewAdapter() {

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

    public Object getItemFromLotno(String lot_no) {

        for(M13_DTL dtl : listViewItem){
            if(dtl.getLOT_NO().equals(lot_no)){
                return dtl;
            }
        }
        return null;
    }

    protected void setSelected(int idx) {

        for (int i = 0; i < listViewItem.size(); i++) {
            if (idx == i) {
                listViewItem.get(i).setSelected(true);
                continue;
            }
            listViewItem.get(i).setSelected(false);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void ClearItem() { listViewItem.clear(); }

    public ArrayList<M13_DTL> getLotArray() {
        return listViewItem;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_view_m13_dtl, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        LinearLayout ContentView    = (LinearLayout)convertView.findViewById(R.id.ContentView);
        TextView item_cd            = (TextView) convertView.findViewById(R.id.item_cd);            //품번
        TextView item_nm            = (TextView) convertView.findViewById(R.id.item_nm);            //품명
        TextView lot_no            = (TextView) convertView.findViewById(R.id.lot_no);            //품명
        //TextView dlv_qty            = (TextView) convertView.findViewById(R.id.dlv_qty);            //수량
        //TextView chk_qty            = (TextView) convertView.findViewById(R.id.chk_qty);            //BOX수
        TextView chk                = (TextView) convertView.findViewById(R.id.chk);                //확인


        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        M13_DTL item = listViewItem.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        item_cd.setText(item.getITEM_CD());
        item_nm.setText(item.getITEM_NM());
        //dlv_qty.setText(item.getDLV_QTY());
        lot_no.setText(item.getLOT_NO());
        //chk_qty.setText(item.getCHK_QTY());

        chk.setText(item.getCHK()? "OK":"X");


        if(item.getCHK()){
            //chk.setBackgroundColor(Color.parseColor("#99CCFF"));

            item_nm.setBackgroundColor(Color.parseColor("#82FF66"));
            lot_no.setBackgroundColor(Color.parseColor("#82FF66"));
            chk.setBackgroundColor(Color.parseColor("#82FF66"));
            if(item.getINSP_FLG().equals("Y")){
                item_nm.setBackgroundColor(Color.parseColor("#FFFF33"));
                lot_no.setBackgroundColor(Color.parseColor("#FFFF33"));
                chk.setBackgroundColor(Color.parseColor("#FFFF33"));
            }

        }
        else{
            //chk.setBackgroundColor(Color.parseColor("#FFFFCC"));
            chk.setBackgroundColor(Color.parseColor("#FFFFCC"));
            item_nm.setBackgroundColor(Color.parseColor("#FFFFFF"));
            lot_no.setBackgroundColor(Color.parseColor("#FFFFFF"));

        }

        System.out.println("item.selected:"+item.getSelected());
        if(item.getSelected()){
            convertView.setBackgroundColor(Color.parseColor("#DDDDDD"));
            chk.setBackgroundColor(Color.parseColor("#DDDDDD"));
            item_nm.setBackgroundColor(Color.parseColor("#DDDDDD"));
            lot_no.setBackgroundColor(Color.parseColor("#DDDDDD"));
        }

        return convertView;
    }


    public void addItem(String ITEM_CD, String ITEM_NM, String DLV_QTY, boolean CHK) {
        M13_DTL item = new M13_DTL();

        item.setITEM_CD(ITEM_CD);
        item.setITEM_NM(ITEM_NM);
        //item.setDLV_QTY(DLV_QTY);
        item.setCHK(CHK);
        listViewItem.add(item);
    }

    protected void addPkgItem(M13_DTL item) {
        listViewItem.add(item);
    }
    protected void updatePkgItem(M13_DTL item) {
        listViewItem.set(item.getIDX(),item);

    }

    public void updateLotItem(ArrayList<M13_DTL> Lot_Info){
        listViewItem= Lot_Info;

    }

}
