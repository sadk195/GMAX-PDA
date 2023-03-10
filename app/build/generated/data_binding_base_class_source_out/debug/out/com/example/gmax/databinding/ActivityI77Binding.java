// Generated by view binder compiler. Do not edit!
package com.example.gmax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gmax.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityI77Binding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final LinearLayout appView1;

  @NonNull
  public final LinearLayout appView11;

  @NonNull
  public final LinearLayout appView2;

  @NonNull
  public final LinearLayout appView21;

  @NonNull
  public final LinearLayout appView3;

  @NonNull
  public final LinearLayout appView31;

  @NonNull
  public final LinearLayout appView4;

  @NonNull
  public final LinearLayout appView41;

  @NonNull
  public final LinearLayout appView5;

  @NonNull
  public final LinearLayout appView51;

  @NonNull
  public final LinearLayout appView6;

  @NonNull
  public final LinearLayout appView61;

  @NonNull
  public final LinearLayout appView7;

  @NonNull
  public final LinearLayout appView71;

  @NonNull
  public final LinearLayout appView8;

  @NonNull
  public final LinearLayout appView81;

  @NonNull
  public final Button btnSave;

  @NonNull
  public final ImageView imgBarcode;

  @NonNull
  public final ImageView imgItemCdBarcode;

  @NonNull
  public final ImageView imgLotNoBarcode;

  @NonNull
  public final ImageView imgStockyardBarcode;

  @NonNull
  public final ImageView imgTrackingNoBarcode;

  @NonNull
  public final RelativeLayout layoutBody;

  @NonNull
  public final RelativeLayout layoutBtn;

  @NonNull
  public final RelativeLayout layoutMenuTitle;

  @NonNull
  public final EditText lblInventoryTable;

  @NonNull
  public final TextView lblViewTitle;

  @NonNull
  public final EditText txtInventoryQty;

  @NonNull
  public final EditText txtItemCd;

  @NonNull
  public final EditText txtItemNm;

  @NonNull
  public final EditText txtLotNo;

  @NonNull
  public final EditText txtSlCd;

  @NonNull
  public final EditText txtStockyard;

  @NonNull
  public final EditText txtTrackingNo;

  private ActivityI77Binding(@NonNull RelativeLayout rootView, @NonNull LinearLayout appView1,
      @NonNull LinearLayout appView11, @NonNull LinearLayout appView2,
      @NonNull LinearLayout appView21, @NonNull LinearLayout appView3,
      @NonNull LinearLayout appView31, @NonNull LinearLayout appView4,
      @NonNull LinearLayout appView41, @NonNull LinearLayout appView5,
      @NonNull LinearLayout appView51, @NonNull LinearLayout appView6,
      @NonNull LinearLayout appView61, @NonNull LinearLayout appView7,
      @NonNull LinearLayout appView71, @NonNull LinearLayout appView8,
      @NonNull LinearLayout appView81, @NonNull Button btnSave, @NonNull ImageView imgBarcode,
      @NonNull ImageView imgItemCdBarcode, @NonNull ImageView imgLotNoBarcode,
      @NonNull ImageView imgStockyardBarcode, @NonNull ImageView imgTrackingNoBarcode,
      @NonNull RelativeLayout layoutBody, @NonNull RelativeLayout layoutBtn,
      @NonNull RelativeLayout layoutMenuTitle, @NonNull EditText lblInventoryTable,
      @NonNull TextView lblViewTitle, @NonNull EditText txtInventoryQty,
      @NonNull EditText txtItemCd, @NonNull EditText txtItemNm, @NonNull EditText txtLotNo,
      @NonNull EditText txtSlCd, @NonNull EditText txtStockyard, @NonNull EditText txtTrackingNo) {
    this.rootView = rootView;
    this.appView1 = appView1;
    this.appView11 = appView11;
    this.appView2 = appView2;
    this.appView21 = appView21;
    this.appView3 = appView3;
    this.appView31 = appView31;
    this.appView4 = appView4;
    this.appView41 = appView41;
    this.appView5 = appView5;
    this.appView51 = appView51;
    this.appView6 = appView6;
    this.appView61 = appView61;
    this.appView7 = appView7;
    this.appView71 = appView71;
    this.appView8 = appView8;
    this.appView81 = appView81;
    this.btnSave = btnSave;
    this.imgBarcode = imgBarcode;
    this.imgItemCdBarcode = imgItemCdBarcode;
    this.imgLotNoBarcode = imgLotNoBarcode;
    this.imgStockyardBarcode = imgStockyardBarcode;
    this.imgTrackingNoBarcode = imgTrackingNoBarcode;
    this.layoutBody = layoutBody;
    this.layoutBtn = layoutBtn;
    this.layoutMenuTitle = layoutMenuTitle;
    this.lblInventoryTable = lblInventoryTable;
    this.lblViewTitle = lblViewTitle;
    this.txtInventoryQty = txtInventoryQty;
    this.txtItemCd = txtItemCd;
    this.txtItemNm = txtItemNm;
    this.txtLotNo = txtLotNo;
    this.txtSlCd = txtSlCd;
    this.txtStockyard = txtStockyard;
    this.txtTrackingNo = txtTrackingNo;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityI77Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityI77Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_i77, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityI77Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.app_view1;
      LinearLayout appView1 = ViewBindings.findChildViewById(rootView, id);
      if (appView1 == null) {
        break missingId;
      }

      id = R.id.app_view1_1;
      LinearLayout appView11 = ViewBindings.findChildViewById(rootView, id);
      if (appView11 == null) {
        break missingId;
      }

      id = R.id.app_view2;
      LinearLayout appView2 = ViewBindings.findChildViewById(rootView, id);
      if (appView2 == null) {
        break missingId;
      }

      id = R.id.app_view2_1;
      LinearLayout appView21 = ViewBindings.findChildViewById(rootView, id);
      if (appView21 == null) {
        break missingId;
      }

      id = R.id.app_view3;
      LinearLayout appView3 = ViewBindings.findChildViewById(rootView, id);
      if (appView3 == null) {
        break missingId;
      }

      id = R.id.app_view3_1;
      LinearLayout appView31 = ViewBindings.findChildViewById(rootView, id);
      if (appView31 == null) {
        break missingId;
      }

      id = R.id.app_view4;
      LinearLayout appView4 = ViewBindings.findChildViewById(rootView, id);
      if (appView4 == null) {
        break missingId;
      }

      id = R.id.app_view4_1;
      LinearLayout appView41 = ViewBindings.findChildViewById(rootView, id);
      if (appView41 == null) {
        break missingId;
      }

      id = R.id.app_view5;
      LinearLayout appView5 = ViewBindings.findChildViewById(rootView, id);
      if (appView5 == null) {
        break missingId;
      }

      id = R.id.app_view5_1;
      LinearLayout appView51 = ViewBindings.findChildViewById(rootView, id);
      if (appView51 == null) {
        break missingId;
      }

      id = R.id.app_view6;
      LinearLayout appView6 = ViewBindings.findChildViewById(rootView, id);
      if (appView6 == null) {
        break missingId;
      }

      id = R.id.app_view6_1;
      LinearLayout appView61 = ViewBindings.findChildViewById(rootView, id);
      if (appView61 == null) {
        break missingId;
      }

      id = R.id.app_view7;
      LinearLayout appView7 = ViewBindings.findChildViewById(rootView, id);
      if (appView7 == null) {
        break missingId;
      }

      id = R.id.app_view7_1;
      LinearLayout appView71 = ViewBindings.findChildViewById(rootView, id);
      if (appView71 == null) {
        break missingId;
      }

      id = R.id.app_view8;
      LinearLayout appView8 = ViewBindings.findChildViewById(rootView, id);
      if (appView8 == null) {
        break missingId;
      }

      id = R.id.app_view8_1;
      LinearLayout appView81 = ViewBindings.findChildViewById(rootView, id);
      if (appView81 == null) {
        break missingId;
      }

      id = R.id.btn_save;
      Button btnSave = ViewBindings.findChildViewById(rootView, id);
      if (btnSave == null) {
        break missingId;
      }

      id = R.id.img_barcode;
      ImageView imgBarcode = ViewBindings.findChildViewById(rootView, id);
      if (imgBarcode == null) {
        break missingId;
      }

      id = R.id.img_item_cd_barcode;
      ImageView imgItemCdBarcode = ViewBindings.findChildViewById(rootView, id);
      if (imgItemCdBarcode == null) {
        break missingId;
      }

      id = R.id.img_lot_no_barcode;
      ImageView imgLotNoBarcode = ViewBindings.findChildViewById(rootView, id);
      if (imgLotNoBarcode == null) {
        break missingId;
      }

      id = R.id.img_stockyard_barcode;
      ImageView imgStockyardBarcode = ViewBindings.findChildViewById(rootView, id);
      if (imgStockyardBarcode == null) {
        break missingId;
      }

      id = R.id.img_tracking_no_barcode;
      ImageView imgTrackingNoBarcode = ViewBindings.findChildViewById(rootView, id);
      if (imgTrackingNoBarcode == null) {
        break missingId;
      }

      id = R.id.layout_body;
      RelativeLayout layoutBody = ViewBindings.findChildViewById(rootView, id);
      if (layoutBody == null) {
        break missingId;
      }

      id = R.id.layout_btn;
      RelativeLayout layoutBtn = ViewBindings.findChildViewById(rootView, id);
      if (layoutBtn == null) {
        break missingId;
      }

      id = R.id.layout_menu_title;
      RelativeLayout layoutMenuTitle = ViewBindings.findChildViewById(rootView, id);
      if (layoutMenuTitle == null) {
        break missingId;
      }

      id = R.id.lbl_inventory_table;
      EditText lblInventoryTable = ViewBindings.findChildViewById(rootView, id);
      if (lblInventoryTable == null) {
        break missingId;
      }

      id = R.id.lbl_view_title;
      TextView lblViewTitle = ViewBindings.findChildViewById(rootView, id);
      if (lblViewTitle == null) {
        break missingId;
      }

      id = R.id.txt_inventory_qty;
      EditText txtInventoryQty = ViewBindings.findChildViewById(rootView, id);
      if (txtInventoryQty == null) {
        break missingId;
      }

      id = R.id.txt_item_cd;
      EditText txtItemCd = ViewBindings.findChildViewById(rootView, id);
      if (txtItemCd == null) {
        break missingId;
      }

      id = R.id.txt_item_nm;
      EditText txtItemNm = ViewBindings.findChildViewById(rootView, id);
      if (txtItemNm == null) {
        break missingId;
      }

      id = R.id.txt_lot_no;
      EditText txtLotNo = ViewBindings.findChildViewById(rootView, id);
      if (txtLotNo == null) {
        break missingId;
      }

      id = R.id.txt_sl_cd;
      EditText txtSlCd = ViewBindings.findChildViewById(rootView, id);
      if (txtSlCd == null) {
        break missingId;
      }

      id = R.id.txt_stockyard;
      EditText txtStockyard = ViewBindings.findChildViewById(rootView, id);
      if (txtStockyard == null) {
        break missingId;
      }

      id = R.id.txt_tracking_no;
      EditText txtTrackingNo = ViewBindings.findChildViewById(rootView, id);
      if (txtTrackingNo == null) {
        break missingId;
      }

      return new ActivityI77Binding((RelativeLayout) rootView, appView1, appView11, appView2,
          appView21, appView3, appView31, appView4, appView41, appView5, appView51, appView6,
          appView61, appView7, appView71, appView8, appView81, btnSave, imgBarcode,
          imgItemCdBarcode, imgLotNoBarcode, imgStockyardBarcode, imgTrackingNoBarcode, layoutBody,
          layoutBtn, layoutMenuTitle, lblInventoryTable, lblViewTitle, txtInventoryQty, txtItemCd,
          txtItemNm, txtLotNo, txtSlCd, txtStockyard, txtTrackingNo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
