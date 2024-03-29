package com.PDA.gmax.M40;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.PDA.gmax.R;

import java.util.ArrayList;

public class M43_DTL_ListViewAdapter extends BaseAdapter {

    private ArrayList<M40_DTL> listViewItem = new ArrayList<M40_DTL>();

    public M43_DTL_ListViewAdapter() {

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

    public ArrayList<M40_DTL> getListviewArray() {
        return listViewItem;
    }

    public int getChkCount() {
        int cnt = 0;
        for(M40_DTL dtl : listViewItem){
            if(dtl.getCHK()){cnt++;}
        }
        return cnt;
    }

    TextView textView;
    public void setTextView(TextView TextView){
        textView = TextView;
    }

    private void setChkcnt(){

        if(textView == null){
            return;
        }
        textView.setText(String.valueOf(getChkCount()));
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_view_m43_dtl, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        LinearLayout ContentView    = (LinearLayout)convertView.findViewById(R.id.ContentView);
        CheckBox chk                = (CheckBox) convertView.findViewById(R.id.chk);
        TextView code               = (TextView) convertView.findViewById(R.id.code);        //품명
        TextView roll_no            = (TextView) convertView.findViewById(R.id.roll_no);        //roll 번호
        TextView length             = (TextView) convertView.findViewById(R.id.length);         //길이
        TextView width              = (TextView) convertView.findViewById(R.id.width);          //넓이

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        M40_DTL item2 = listViewItem.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        code.setText(item2.getCODE());
        roll_no.setText(item2.getROLL_NO());
        length.setText(item2.getLENGTH());
        width.setText(item2.getWIDTH());

        //체크박스 체크하여 따로 저장 가능하도록 설정
        chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item2.setCHK(chk.isChecked());
                //체크 된 항목 수 표시
                setChkcnt();
            }
        });

        return convertView;
    }


    public void addItem(String CODE,String AREA_DENSITY,String LOT_NO,String ROLL_NO,String WIDTH,String LENGTH,String QR_VALUE_ALL,String STATUS) {
        M40_DTL item = new M40_DTL();

        item.setCODE(CODE);
        item.setAREA_DENSITY(AREA_DENSITY);
        item.setLOT_NO(LOT_NO);
        item.setROLL_NO(ROLL_NO);
        item.setWIDTH(WIDTH);
        item.setLENGTH(LENGTH);
        item.setQR_VALUE_ALL(QR_VALUE_ALL);
        item.setSTATUS(STATUS);
    }

    protected void addPkgItem(M40_DTL item) {
        listViewItem.add(0,item);

        //listViewItem.add(item);
    }


}
