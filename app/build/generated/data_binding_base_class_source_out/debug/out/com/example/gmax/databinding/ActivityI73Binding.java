// Generated by view binder compiler. Do not edit!
package com.example.gmax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public final class ActivityI73Binding implements ViewBinding {
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
  public final LinearLayout boxView1;

  @NonNull
  public final Button btnDel;

  @NonNull
  public final TextView inventorySaveNo;

  @NonNull
  public final RelativeLayout layoutBody;

  @NonNull
  public final RelativeLayout layoutBtn;

  @NonNull
  public final RelativeLayout layoutMenuTitle;

  @NonNull
  public final EditText lblInventoryCountDate;

  @NonNull
  public final TextView lblViewTitle;

  @NonNull
  public final ListView listOrder;

  @NonNull
  public final TextView slCd;

  private ActivityI73Binding(@NonNull RelativeLayout rootView, @NonNull LinearLayout appView1,
      @NonNull LinearLayout appView11, @NonNull LinearLayout appView2,
      @NonNull LinearLayout appView21, @NonNull LinearLayout appView3,
      @NonNull LinearLayout appView31, @NonNull LinearLayout boxView1, @NonNull Button btnDel,
      @NonNull TextView inventorySaveNo, @NonNull RelativeLayout layoutBody,
      @NonNull RelativeLayout layoutBtn, @NonNull RelativeLayout layoutMenuTitle,
      @NonNull EditText lblInventoryCountDate, @NonNull TextView lblViewTitle,
      @NonNull ListView listOrder, @NonNull TextView slCd) {
    this.rootView = rootView;
    this.appView1 = appView1;
    this.appView11 = appView11;
    this.appView2 = appView2;
    this.appView21 = appView21;
    this.appView3 = appView3;
    this.appView31 = appView31;
    this.boxView1 = boxView1;
    this.btnDel = btnDel;
    this.inventorySaveNo = inventorySaveNo;
    this.layoutBody = layoutBody;
    this.layoutBtn = layoutBtn;
    this.layoutMenuTitle = layoutMenuTitle;
    this.lblInventoryCountDate = lblInventoryCountDate;
    this.lblViewTitle = lblViewTitle;
    this.listOrder = listOrder;
    this.slCd = slCd;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityI73Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityI73Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_i73, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityI73Binding bind(@NonNull View rootView) {
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

      id = R.id.box_view1;
      LinearLayout boxView1 = ViewBindings.findChildViewById(rootView, id);
      if (boxView1 == null) {
        break missingId;
      }

      id = R.id.btn_del;
      Button btnDel = ViewBindings.findChildViewById(rootView, id);
      if (btnDel == null) {
        break missingId;
      }

      id = R.id.inventory_save_no;
      TextView inventorySaveNo = ViewBindings.findChildViewById(rootView, id);
      if (inventorySaveNo == null) {
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

      id = R.id.lbl_inventory_count_date;
      EditText lblInventoryCountDate = ViewBindings.findChildViewById(rootView, id);
      if (lblInventoryCountDate == null) {
        break missingId;
      }

      id = R.id.lbl_view_title;
      TextView lblViewTitle = ViewBindings.findChildViewById(rootView, id);
      if (lblViewTitle == null) {
        break missingId;
      }

      id = R.id.listOrder;
      ListView listOrder = ViewBindings.findChildViewById(rootView, id);
      if (listOrder == null) {
        break missingId;
      }

      id = R.id.sl_cd;
      TextView slCd = ViewBindings.findChildViewById(rootView, id);
      if (slCd == null) {
        break missingId;
      }

      return new ActivityI73Binding((RelativeLayout) rootView, appView1, appView11, appView2,
          appView21, appView3, appView31, boxView1, btnDel, inventorySaveNo, layoutBody, layoutBtn,
          layoutMenuTitle, lblInventoryCountDate, lblViewTitle, listOrder, slCd);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
