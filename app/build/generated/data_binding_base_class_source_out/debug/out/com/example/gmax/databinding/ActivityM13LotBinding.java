// Generated by view binder compiler. Do not edit!
package com.example.gmax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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

public final class ActivityM13LotBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView appTitle;

  @NonNull
  public final LinearLayout boxView;

  @NonNull
  public final Button btnEnd;

  @NonNull
  public final ImageView imgLot;

  @NonNull
  public final EditText itemNm;

  @NonNull
  public final RelativeLayout layoutBody;

  @NonNull
  public final RelativeLayout layoutBtn;

  @NonNull
  public final RelativeLayout layoutMenuTitle;

  @NonNull
  public final LinearLayout lblCnt;

  @NonNull
  public final TextView lblCount;

  @NonNull
  public final TextView lblCountScan;

  @NonNull
  public final LinearLayout lblSubTitle;

  @NonNull
  public final TextView lblText;

  @NonNull
  public final ListView listLot;

  @NonNull
  public final EditText lotNo;

  @NonNull
  public final EditText lotQty;

  private ActivityM13LotBinding(@NonNull RelativeLayout rootView, @NonNull TextView appTitle,
      @NonNull LinearLayout boxView, @NonNull Button btnEnd, @NonNull ImageView imgLot,
      @NonNull EditText itemNm, @NonNull RelativeLayout layoutBody,
      @NonNull RelativeLayout layoutBtn, @NonNull RelativeLayout layoutMenuTitle,
      @NonNull LinearLayout lblCnt, @NonNull TextView lblCount, @NonNull TextView lblCountScan,
      @NonNull LinearLayout lblSubTitle, @NonNull TextView lblText, @NonNull ListView listLot,
      @NonNull EditText lotNo, @NonNull EditText lotQty) {
    this.rootView = rootView;
    this.appTitle = appTitle;
    this.boxView = boxView;
    this.btnEnd = btnEnd;
    this.imgLot = imgLot;
    this.itemNm = itemNm;
    this.layoutBody = layoutBody;
    this.layoutBtn = layoutBtn;
    this.layoutMenuTitle = layoutMenuTitle;
    this.lblCnt = lblCnt;
    this.lblCount = lblCount;
    this.lblCountScan = lblCountScan;
    this.lblSubTitle = lblSubTitle;
    this.lblText = lblText;
    this.listLot = listLot;
    this.lotNo = lotNo;
    this.lotQty = lotQty;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityM13LotBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityM13LotBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_m13_lot, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityM13LotBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.app_title;
      TextView appTitle = ViewBindings.findChildViewById(rootView, id);
      if (appTitle == null) {
        break missingId;
      }

      id = R.id.box_view;
      LinearLayout boxView = ViewBindings.findChildViewById(rootView, id);
      if (boxView == null) {
        break missingId;
      }

      id = R.id.btn_end;
      Button btnEnd = ViewBindings.findChildViewById(rootView, id);
      if (btnEnd == null) {
        break missingId;
      }

      id = R.id.img_lot;
      ImageView imgLot = ViewBindings.findChildViewById(rootView, id);
      if (imgLot == null) {
        break missingId;
      }

      id = R.id.item_nm;
      EditText itemNm = ViewBindings.findChildViewById(rootView, id);
      if (itemNm == null) {
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

      id = R.id.lbl_cnt;
      LinearLayout lblCnt = ViewBindings.findChildViewById(rootView, id);
      if (lblCnt == null) {
        break missingId;
      }

      id = R.id.lbl_count;
      TextView lblCount = ViewBindings.findChildViewById(rootView, id);
      if (lblCount == null) {
        break missingId;
      }

      id = R.id.lbl_count_scan;
      TextView lblCountScan = ViewBindings.findChildViewById(rootView, id);
      if (lblCountScan == null) {
        break missingId;
      }

      id = R.id.lbl_sub_title;
      LinearLayout lblSubTitle = ViewBindings.findChildViewById(rootView, id);
      if (lblSubTitle == null) {
        break missingId;
      }

      id = R.id.lbl_text;
      TextView lblText = ViewBindings.findChildViewById(rootView, id);
      if (lblText == null) {
        break missingId;
      }

      id = R.id.listLot;
      ListView listLot = ViewBindings.findChildViewById(rootView, id);
      if (listLot == null) {
        break missingId;
      }

      id = R.id.lot_no;
      EditText lotNo = ViewBindings.findChildViewById(rootView, id);
      if (lotNo == null) {
        break missingId;
      }

      id = R.id.lot_qty;
      EditText lotQty = ViewBindings.findChildViewById(rootView, id);
      if (lotQty == null) {
        break missingId;
      }

      return new ActivityM13LotBinding((RelativeLayout) rootView, appTitle, boxView, btnEnd, imgLot,
          itemNm, layoutBody, layoutBtn, layoutMenuTitle, lblCnt, lblCount, lblCountScan,
          lblSubTitle, lblText, listLot, lotNo, lotQty);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
