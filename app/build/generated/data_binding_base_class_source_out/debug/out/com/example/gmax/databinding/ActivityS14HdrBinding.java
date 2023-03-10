// Generated by view binder compiler. Do not edit!
package com.example.gmax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class ActivityS14HdrBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView appTitle;

  @NonNull
  public final LinearLayout appView1;

  @NonNull
  public final LinearLayout appView11;

  @NonNull
  public final EditText dnReqNo;

  @NonNull
  public final ImageView imgBarcode;

  @NonNull
  public final RelativeLayout layoutBody;

  @NonNull
  public final LinearLayout layoutListView;

  @NonNull
  public final RelativeLayout layoutMenuTitle;

  @NonNull
  public final TextView lblCount;

  @NonNull
  public final LinearLayout lblInformation;

  @NonNull
  public final ListView listOrder;

  private ActivityS14HdrBinding(@NonNull RelativeLayout rootView, @NonNull TextView appTitle,
      @NonNull LinearLayout appView1, @NonNull LinearLayout appView11, @NonNull EditText dnReqNo,
      @NonNull ImageView imgBarcode, @NonNull RelativeLayout layoutBody,
      @NonNull LinearLayout layoutListView, @NonNull RelativeLayout layoutMenuTitle,
      @NonNull TextView lblCount, @NonNull LinearLayout lblInformation,
      @NonNull ListView listOrder) {
    this.rootView = rootView;
    this.appTitle = appTitle;
    this.appView1 = appView1;
    this.appView11 = appView11;
    this.dnReqNo = dnReqNo;
    this.imgBarcode = imgBarcode;
    this.layoutBody = layoutBody;
    this.layoutListView = layoutListView;
    this.layoutMenuTitle = layoutMenuTitle;
    this.lblCount = lblCount;
    this.lblInformation = lblInformation;
    this.listOrder = listOrder;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityS14HdrBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityS14HdrBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_s14_hdr, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityS14HdrBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.app_title;
      TextView appTitle = ViewBindings.findChildViewById(rootView, id);
      if (appTitle == null) {
        break missingId;
      }

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

      id = R.id.dn_req_no;
      EditText dnReqNo = ViewBindings.findChildViewById(rootView, id);
      if (dnReqNo == null) {
        break missingId;
      }

      id = R.id.img_barcode;
      ImageView imgBarcode = ViewBindings.findChildViewById(rootView, id);
      if (imgBarcode == null) {
        break missingId;
      }

      id = R.id.layout_body;
      RelativeLayout layoutBody = ViewBindings.findChildViewById(rootView, id);
      if (layoutBody == null) {
        break missingId;
      }

      id = R.id.layout_listView;
      LinearLayout layoutListView = ViewBindings.findChildViewById(rootView, id);
      if (layoutListView == null) {
        break missingId;
      }

      id = R.id.layout_menu_title;
      RelativeLayout layoutMenuTitle = ViewBindings.findChildViewById(rootView, id);
      if (layoutMenuTitle == null) {
        break missingId;
      }

      id = R.id.lbl_count;
      TextView lblCount = ViewBindings.findChildViewById(rootView, id);
      if (lblCount == null) {
        break missingId;
      }

      id = R.id.lbl_information;
      LinearLayout lblInformation = ViewBindings.findChildViewById(rootView, id);
      if (lblInformation == null) {
        break missingId;
      }

      id = R.id.listOrder;
      ListView listOrder = ViewBindings.findChildViewById(rootView, id);
      if (listOrder == null) {
        break missingId;
      }

      return new ActivityS14HdrBinding((RelativeLayout) rootView, appTitle, appView1, appView11,
          dnReqNo, imgBarcode, layoutBody, layoutListView, layoutMenuTitle, lblCount,
          lblInformation, listOrder);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
