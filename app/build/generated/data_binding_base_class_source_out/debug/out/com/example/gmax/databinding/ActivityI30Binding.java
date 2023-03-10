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

public final class ActivityI30Binding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final AppBarLayout appBarLayout;

  @NonNull
  public final LinearLayout boxView1;

  @NonNull
  public final LinearLayout boxView2;

  @NonNull
  public final LinearLayout boxView3;

  @NonNull
  public final LinearLayout boxView4;

  @NonNull
  public final MaterialButton btnOutOfPlan;

  @NonNull
  public final MaterialButton btnProdLocationGoodsStatus;

  @NonNull
  public final MaterialButton btnProdLocationMove;

  @NonNull
  public final MaterialButton btnProdLocationMoveQuery;

  @NonNull
  public final MaterialButton btnProdReleaseRegistration;

  @NonNull
  public final MaterialButton btnProdReleaseRegistrationLocation;

  @NonNull
  public final MaterialButton btnProdShipmentStatus;

  @NonNull
  public final MaterialButton btnReservationStatus;

  @NonNull
  public final RelativeLayout lblViewBody;

  @NonNull
  public final MaterialToolbar materialToolbar;

  private ActivityI30Binding(@NonNull RelativeLayout rootView, @NonNull AppBarLayout appBarLayout,
      @NonNull LinearLayout boxView1, @NonNull LinearLayout boxView2,
      @NonNull LinearLayout boxView3, @NonNull LinearLayout boxView4,
      @NonNull MaterialButton btnOutOfPlan, @NonNull MaterialButton btnProdLocationGoodsStatus,
      @NonNull MaterialButton btnProdLocationMove, @NonNull MaterialButton btnProdLocationMoveQuery,
      @NonNull MaterialButton btnProdReleaseRegistration,
      @NonNull MaterialButton btnProdReleaseRegistrationLocation,
      @NonNull MaterialButton btnProdShipmentStatus, @NonNull MaterialButton btnReservationStatus,
      @NonNull RelativeLayout lblViewBody, @NonNull MaterialToolbar materialToolbar) {
    this.rootView = rootView;
    this.appBarLayout = appBarLayout;
    this.boxView1 = boxView1;
    this.boxView2 = boxView2;
    this.boxView3 = boxView3;
    this.boxView4 = boxView4;
    this.btnOutOfPlan = btnOutOfPlan;
    this.btnProdLocationGoodsStatus = btnProdLocationGoodsStatus;
    this.btnProdLocationMove = btnProdLocationMove;
    this.btnProdLocationMoveQuery = btnProdLocationMoveQuery;
    this.btnProdReleaseRegistration = btnProdReleaseRegistration;
    this.btnProdReleaseRegistrationLocation = btnProdReleaseRegistrationLocation;
    this.btnProdShipmentStatus = btnProdShipmentStatus;
    this.btnReservationStatus = btnReservationStatus;
    this.lblViewBody = lblViewBody;
    this.materialToolbar = materialToolbar;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityI30Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityI30Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_i30, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityI30Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.appBarLayout;
      AppBarLayout appBarLayout = ViewBindings.findChildViewById(rootView, id);
      if (appBarLayout == null) {
        break missingId;
      }

      id = R.id.box_view1;
      LinearLayout boxView1 = ViewBindings.findChildViewById(rootView, id);
      if (boxView1 == null) {
        break missingId;
      }

      id = R.id.box_view2;
      LinearLayout boxView2 = ViewBindings.findChildViewById(rootView, id);
      if (boxView2 == null) {
        break missingId;
      }

      id = R.id.box_view3;
      LinearLayout boxView3 = ViewBindings.findChildViewById(rootView, id);
      if (boxView3 == null) {
        break missingId;
      }

      id = R.id.box_view4;
      LinearLayout boxView4 = ViewBindings.findChildViewById(rootView, id);
      if (boxView4 == null) {
        break missingId;
      }

      id = R.id.btn_out_of_plan;
      MaterialButton btnOutOfPlan = ViewBindings.findChildViewById(rootView, id);
      if (btnOutOfPlan == null) {
        break missingId;
      }

      id = R.id.btn_prod_location_goods_status;
      MaterialButton btnProdLocationGoodsStatus = ViewBindings.findChildViewById(rootView, id);
      if (btnProdLocationGoodsStatus == null) {
        break missingId;
      }

      id = R.id.btn_prod_location_move;
      MaterialButton btnProdLocationMove = ViewBindings.findChildViewById(rootView, id);
      if (btnProdLocationMove == null) {
        break missingId;
      }

      id = R.id.btn_prod_location_move_query;
      MaterialButton btnProdLocationMoveQuery = ViewBindings.findChildViewById(rootView, id);
      if (btnProdLocationMoveQuery == null) {
        break missingId;
      }

      id = R.id.btn_prod_release_registration;
      MaterialButton btnProdReleaseRegistration = ViewBindings.findChildViewById(rootView, id);
      if (btnProdReleaseRegistration == null) {
        break missingId;
      }

      id = R.id.btn_prod_release_registration_location;
      MaterialButton btnProdReleaseRegistrationLocation = ViewBindings.findChildViewById(rootView, id);
      if (btnProdReleaseRegistrationLocation == null) {
        break missingId;
      }

      id = R.id.btn_prod_shipment_status;
      MaterialButton btnProdShipmentStatus = ViewBindings.findChildViewById(rootView, id);
      if (btnProdShipmentStatus == null) {
        break missingId;
      }

      id = R.id.btn_reservation_status;
      MaterialButton btnReservationStatus = ViewBindings.findChildViewById(rootView, id);
      if (btnReservationStatus == null) {
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

      return new ActivityI30Binding((RelativeLayout) rootView, appBarLayout, boxView1, boxView2,
          boxView3, boxView4, btnOutOfPlan, btnProdLocationGoodsStatus, btnProdLocationMove,
          btnProdLocationMoveQuery, btnProdReleaseRegistration, btnProdReleaseRegistrationLocation,
          btnProdShipmentStatus, btnReservationStatus, lblViewBody, materialToolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
