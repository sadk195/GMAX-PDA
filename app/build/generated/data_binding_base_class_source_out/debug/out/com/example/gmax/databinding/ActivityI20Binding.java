// Generated by view binder compiler. Do not edit!
package com.example.gmax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gmax.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityI20Binding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final AppBarLayout appBarLayout;

  @NonNull
  public final LinearLayout boxBox4;

  @NonNull
  public final RelativeLayout boxView;

  @NonNull
  public final LinearLayout btnBox1;

  @NonNull
  public final LinearLayout btnBox2;

  @NonNull
  public final LinearLayout btnBox3;

  @NonNull
  public final MaterialButton btnItemQtyMove;

  @NonNull
  public final MaterialButton btnMove;

  @NonNull
  public final MaterialButton btnQuery;

  @NonNull
  public final MaterialButton btnStockyard;

  @NonNull
  public final MaterialButton btnTracking;

  @NonNull
  public final MaterialButton btnWarehouse;

  @NonNull
  public final MaterialButton btnWorkplace;

  @NonNull
  public final RelativeLayout lblViewBody;

  @NonNull
  public final MaterialToolbar materialToolbar;

  private ActivityI20Binding(@NonNull RelativeLayout rootView, @NonNull AppBarLayout appBarLayout,
      @NonNull LinearLayout boxBox4, @NonNull RelativeLayout boxView, @NonNull LinearLayout btnBox1,
      @NonNull LinearLayout btnBox2, @NonNull LinearLayout btnBox3,
      @NonNull MaterialButton btnItemQtyMove, @NonNull MaterialButton btnMove,
      @NonNull MaterialButton btnQuery, @NonNull MaterialButton btnStockyard,
      @NonNull MaterialButton btnTracking, @NonNull MaterialButton btnWarehouse,
      @NonNull MaterialButton btnWorkplace, @NonNull RelativeLayout lblViewBody,
      @NonNull MaterialToolbar materialToolbar) {
    this.rootView = rootView;
    this.appBarLayout = appBarLayout;
    this.boxBox4 = boxBox4;
    this.boxView = boxView;
    this.btnBox1 = btnBox1;
    this.btnBox2 = btnBox2;
    this.btnBox3 = btnBox3;
    this.btnItemQtyMove = btnItemQtyMove;
    this.btnMove = btnMove;
    this.btnQuery = btnQuery;
    this.btnStockyard = btnStockyard;
    this.btnTracking = btnTracking;
    this.btnWarehouse = btnWarehouse;
    this.btnWorkplace = btnWorkplace;
    this.lblViewBody = lblViewBody;
    this.materialToolbar = materialToolbar;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityI20Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityI20Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_i20, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityI20Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.appBarLayout;
      AppBarLayout appBarLayout = ViewBindings.findChildViewById(rootView, id);
      if (appBarLayout == null) {
        break missingId;
      }

      id = R.id.box_box4;
      LinearLayout boxBox4 = ViewBindings.findChildViewById(rootView, id);
      if (boxBox4 == null) {
        break missingId;
      }

      id = R.id.box_view;
      RelativeLayout boxView = ViewBindings.findChildViewById(rootView, id);
      if (boxView == null) {
        break missingId;
      }

      id = R.id.btn_box1;
      LinearLayout btnBox1 = ViewBindings.findChildViewById(rootView, id);
      if (btnBox1 == null) {
        break missingId;
      }

      id = R.id.btn_box2;
      LinearLayout btnBox2 = ViewBindings.findChildViewById(rootView, id);
      if (btnBox2 == null) {
        break missingId;
      }

      id = R.id.btn_box3;
      LinearLayout btnBox3 = ViewBindings.findChildViewById(rootView, id);
      if (btnBox3 == null) {
        break missingId;
      }

      id = R.id.btn_item_qty_move;
      MaterialButton btnItemQtyMove = ViewBindings.findChildViewById(rootView, id);
      if (btnItemQtyMove == null) {
        break missingId;
      }

      id = R.id.btn_move;
      MaterialButton btnMove = ViewBindings.findChildViewById(rootView, id);
      if (btnMove == null) {
        break missingId;
      }

      id = R.id.btn_query;
      MaterialButton btnQuery = ViewBindings.findChildViewById(rootView, id);
      if (btnQuery == null) {
        break missingId;
      }

      id = R.id.btn_stockyard;
      MaterialButton btnStockyard = ViewBindings.findChildViewById(rootView, id);
      if (btnStockyard == null) {
        break missingId;
      }

      id = R.id.btn_tracking;
      MaterialButton btnTracking = ViewBindings.findChildViewById(rootView, id);
      if (btnTracking == null) {
        break missingId;
      }

      id = R.id.btn_warehouse;
      MaterialButton btnWarehouse = ViewBindings.findChildViewById(rootView, id);
      if (btnWarehouse == null) {
        break missingId;
      }

      id = R.id.btn_workplace;
      MaterialButton btnWorkplace = ViewBindings.findChildViewById(rootView, id);
      if (btnWorkplace == null) {
        break missingId;
      }

      id = R.id.lbl_view_body;
      RelativeLayout lblViewBody = ViewBindings.findChildViewById(rootView, id);
      if (lblViewBody == null) {
        break missingId;
      }

      id = R.id.materialToolbar;
      MaterialToolbar materialToolbar = ViewBindings.findChildViewById(rootView, id);
      if (materialToolbar == null) {
        break missingId;
      }

      return new ActivityI20Binding((RelativeLayout) rootView, appBarLayout, boxBox4, boxView,
          btnBox1, btnBox2, btnBox3, btnItemQtyMove, btnMove, btnQuery, btnStockyard, btnTracking,
          btnWarehouse, btnWorkplace, lblViewBody, materialToolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
