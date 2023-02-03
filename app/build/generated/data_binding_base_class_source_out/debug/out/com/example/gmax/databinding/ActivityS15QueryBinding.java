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
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gmax.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityS15QueryBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView appTitle;

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
  public final Button btnQuery;

  @NonNull
  public final RelativeLayout layoutBody;

  @NonNull
  public final RelativeLayout layoutMenuTitle;

  @NonNull
  public final LinearLayout layoutQuery;

  @NonNull
  public final LinearLayout lblInformation;

  @NonNull
  public final ListView listOrder;

  @NonNull
  public final EditText moveDateFrom;

  @NonNull
  public final EditText moveDateTo;

  @NonNull
  public final TextView moveType;

  @NonNull
  public final Spinner storageLocation;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView txtTitle;

  private ActivityS15QueryBinding(@NonNull RelativeLayout rootView, @NonNull TextView appTitle,
      @NonNull LinearLayout appView1, @NonNull LinearLayout appView11,
      @NonNull LinearLayout appView2, @NonNull LinearLayout appView21,
      @NonNull LinearLayout appView3, @NonNull LinearLayout appView31,
      @NonNull LinearLayout boxView1, @NonNull Button btnQuery, @NonNull RelativeLayout layoutBody,
      @NonNull RelativeLayout layoutMenuTitle, @NonNull LinearLayout layoutQuery,
      @NonNull LinearLayout lblInformation, @NonNull ListView listOrder,
      @NonNull EditText moveDateFrom, @NonNull EditText moveDateTo, @NonNull TextView moveType,
      @NonNull Spinner storageLocation, @NonNull TextView textView2, @NonNull TextView txtTitle) {
    this.rootView = rootView;
    this.appTitle = appTitle;
    this.appView1 = appView1;
    this.appView11 = appView11;
    this.appView2 = appView2;
    this.appView21 = appView21;
    this.appView3 = appView3;
    this.appView31 = appView31;
    this.boxView1 = boxView1;
    this.btnQuery = btnQuery;
    this.layoutBody = layoutBody;
    this.layoutMenuTitle = layoutMenuTitle;
    this.layoutQuery = layoutQuery;
    this.lblInformation = lblInformation;
    this.listOrder = listOrder;
    this.moveDateFrom = moveDateFrom;
    this.moveDateTo = moveDateTo;
    this.moveType = moveType;
    this.storageLocation = storageLocation;
    this.textView2 = textView2;
    this.txtTitle = txtTitle;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityS15QueryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityS15QueryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_s15_query, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityS15QueryBinding bind(@NonNull View rootView) {
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

      id = R.id.btn_query;
      Button btnQuery = ViewBindings.findChildViewById(rootView, id);
      if (btnQuery == null) {
        break missingId;
      }

      id = R.id.layout_body;
      RelativeLayout layoutBody = ViewBindings.findChildViewById(rootView, id);
      if (layoutBody == null) {
        break missingId;
      }

      id = R.id.layout_menu_title;
      RelativeLayout layoutMenuTitle = ViewBindings.findChildViewById(rootView, id);
      if (layoutMenuTitle == null) {
        break missingId;
      }

      id = R.id.layout_query;
      LinearLayout layoutQuery = ViewBindings.findChildViewById(rootView, id);
      if (layoutQuery == null) {
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

      id = R.id.move_date_from;
      EditText moveDateFrom = ViewBindings.findChildViewById(rootView, id);
      if (moveDateFrom == null) {
        break missingId;
      }

      id = R.id.move_date_to;
      EditText moveDateTo = ViewBindings.findChildViewById(rootView, id);
      if (moveDateTo == null) {
        break missingId;
      }

      id = R.id.move_type;
      TextView moveType = ViewBindings.findChildViewById(rootView, id);
      if (moveType == null) {
        break missingId;
      }

      id = R.id.storage_location;
      Spinner storageLocation = ViewBindings.findChildViewById(rootView, id);
      if (storageLocation == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.txt_title;
      TextView txtTitle = ViewBindings.findChildViewById(rootView, id);
      if (txtTitle == null) {
        break missingId;
      }

      return new ActivityS15QueryBinding((RelativeLayout) rootView, appTitle, appView1, appView11,
          appView2, appView21, appView3, appView31, boxView1, btnQuery, layoutBody, layoutMenuTitle,
          layoutQuery, lblInformation, listOrder, moveDateFrom, moveDateTo, moveType,
          storageLocation, textView2, txtTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
