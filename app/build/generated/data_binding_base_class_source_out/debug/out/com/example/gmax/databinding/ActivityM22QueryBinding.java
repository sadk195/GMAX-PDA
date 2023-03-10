// Generated by view binder compiler. Do not edit!
package com.example.gmax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gmax.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityM22QueryBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final LinearLayout boxView;

  @NonNull
  public final Button btnHide;

  @NonNull
  public final MaterialButton btnQuery;

  @NonNull
  public final Button btnShow;

  @NonNull
  public final TextInputEditText datePickerActions;

  @NonNull
  public final TextInputLayout itemCd;

  @NonNull
  public final RelativeLayout layoutBody;

  @NonNull
  public final LinearLayout layoutHideSearch;

  @NonNull
  public final RelativeLayout layoutMenuTitle;

  @NonNull
  public final CoordinatorLayout lblBtn;

  @NonNull
  public final LinearLayout lblCaption;

  @NonNull
  public final TextView lblViewTitle;

  @NonNull
  public final ListView listOrder;

  @NonNull
  public final TextInputLayout location;

  @NonNull
  public final TextInputLayout pdDt;

  @NonNull
  public final TextInputLayout prodtOrderNo;

  @NonNull
  public final TextInputLayout slCd;

  @NonNull
  public final MaterialButtonToggleGroup toggleBtn;

  private ActivityM22QueryBinding(@NonNull RelativeLayout rootView, @NonNull LinearLayout boxView,
      @NonNull Button btnHide, @NonNull MaterialButton btnQuery, @NonNull Button btnShow,
      @NonNull TextInputEditText datePickerActions, @NonNull TextInputLayout itemCd,
      @NonNull RelativeLayout layoutBody, @NonNull LinearLayout layoutHideSearch,
      @NonNull RelativeLayout layoutMenuTitle, @NonNull CoordinatorLayout lblBtn,
      @NonNull LinearLayout lblCaption, @NonNull TextView lblViewTitle, @NonNull ListView listOrder,
      @NonNull TextInputLayout location, @NonNull TextInputLayout pdDt,
      @NonNull TextInputLayout prodtOrderNo, @NonNull TextInputLayout slCd,
      @NonNull MaterialButtonToggleGroup toggleBtn) {
    this.rootView = rootView;
    this.boxView = boxView;
    this.btnHide = btnHide;
    this.btnQuery = btnQuery;
    this.btnShow = btnShow;
    this.datePickerActions = datePickerActions;
    this.itemCd = itemCd;
    this.layoutBody = layoutBody;
    this.layoutHideSearch = layoutHideSearch;
    this.layoutMenuTitle = layoutMenuTitle;
    this.lblBtn = lblBtn;
    this.lblCaption = lblCaption;
    this.lblViewTitle = lblViewTitle;
    this.listOrder = listOrder;
    this.location = location;
    this.pdDt = pdDt;
    this.prodtOrderNo = prodtOrderNo;
    this.slCd = slCd;
    this.toggleBtn = toggleBtn;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityM22QueryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityM22QueryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_m22_query, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityM22QueryBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.box_view;
      LinearLayout boxView = ViewBindings.findChildViewById(rootView, id);
      if (boxView == null) {
        break missingId;
      }

      id = R.id.btn_hide;
      Button btnHide = ViewBindings.findChildViewById(rootView, id);
      if (btnHide == null) {
        break missingId;
      }

      id = R.id.btn_query;
      MaterialButton btnQuery = ViewBindings.findChildViewById(rootView, id);
      if (btnQuery == null) {
        break missingId;
      }

      id = R.id.btn_show;
      Button btnShow = ViewBindings.findChildViewById(rootView, id);
      if (btnShow == null) {
        break missingId;
      }

      id = R.id.date_picker_actions;
      TextInputEditText datePickerActions = ViewBindings.findChildViewById(rootView, id);
      if (datePickerActions == null) {
        break missingId;
      }

      id = R.id.item_cd;
      TextInputLayout itemCd = ViewBindings.findChildViewById(rootView, id);
      if (itemCd == null) {
        break missingId;
      }

      id = R.id.layout_body;
      RelativeLayout layoutBody = ViewBindings.findChildViewById(rootView, id);
      if (layoutBody == null) {
        break missingId;
      }

      id = R.id.layout_hide_search;
      LinearLayout layoutHideSearch = ViewBindings.findChildViewById(rootView, id);
      if (layoutHideSearch == null) {
        break missingId;
      }

      id = R.id.layout_menu_title;
      RelativeLayout layoutMenuTitle = ViewBindings.findChildViewById(rootView, id);
      if (layoutMenuTitle == null) {
        break missingId;
      }

      id = R.id.lbl_btn;
      CoordinatorLayout lblBtn = ViewBindings.findChildViewById(rootView, id);
      if (lblBtn == null) {
        break missingId;
      }

      id = R.id.lbl_caption;
      LinearLayout lblCaption = ViewBindings.findChildViewById(rootView, id);
      if (lblCaption == null) {
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

      id = R.id.location;
      TextInputLayout location = ViewBindings.findChildViewById(rootView, id);
      if (location == null) {
        break missingId;
      }

      id = R.id.pd_dt;
      TextInputLayout pdDt = ViewBindings.findChildViewById(rootView, id);
      if (pdDt == null) {
        break missingId;
      }

      id = R.id.prodt_order_no;
      TextInputLayout prodtOrderNo = ViewBindings.findChildViewById(rootView, id);
      if (prodtOrderNo == null) {
        break missingId;
      }

      id = R.id.sl_cd;
      TextInputLayout slCd = ViewBindings.findChildViewById(rootView, id);
      if (slCd == null) {
        break missingId;
      }

      id = R.id.toggle_btn;
      MaterialButtonToggleGroup toggleBtn = ViewBindings.findChildViewById(rootView, id);
      if (toggleBtn == null) {
        break missingId;
      }

      return new ActivityM22QueryBinding((RelativeLayout) rootView, boxView, btnHide, btnQuery,
          btnShow, datePickerActions, itemCd, layoutBody, layoutHideSearch, layoutMenuTitle, lblBtn,
          lblCaption, lblViewTitle, listOrder, location, pdDt, prodtOrderNo, slCd, toggleBtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
