// Generated by view binder compiler. Do not edit!
package com.example.gmax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gmax.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ListViewI38DtlBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView badOnHandQty;

  @NonNull
  public final TextView basicUnit;

  @NonNull
  public final TextView blank22;

  @NonNull
  public final TextView blank32;

  @NonNull
  public final TextView blank42;

  @NonNull
  public final TextView blank5;

  @NonNull
  public final TextView blank52;

  @NonNull
  public final TextView goodOnHandQty;

  @NonNull
  public final TextView itemCd;

  @NonNull
  public final TextView location;

  @NonNull
  public final TextView location2;

  @NonNull
  public final TextView lotNo;

  @NonNull
  public final TextView lotSubNo;

  @NonNull
  public final TextView slCd;

  @NonNull
  public final TextView trackingNo;

  private ListViewI38DtlBinding(@NonNull LinearLayout rootView, @NonNull TextView badOnHandQty,
      @NonNull TextView basicUnit, @NonNull TextView blank22, @NonNull TextView blank32,
      @NonNull TextView blank42, @NonNull TextView blank5, @NonNull TextView blank52,
      @NonNull TextView goodOnHandQty, @NonNull TextView itemCd, @NonNull TextView location,
      @NonNull TextView location2, @NonNull TextView lotNo, @NonNull TextView lotSubNo,
      @NonNull TextView slCd, @NonNull TextView trackingNo) {
    this.rootView = rootView;
    this.badOnHandQty = badOnHandQty;
    this.basicUnit = basicUnit;
    this.blank22 = blank22;
    this.blank32 = blank32;
    this.blank42 = blank42;
    this.blank5 = blank5;
    this.blank52 = blank52;
    this.goodOnHandQty = goodOnHandQty;
    this.itemCd = itemCd;
    this.location = location;
    this.location2 = location2;
    this.lotNo = lotNo;
    this.lotSubNo = lotSubNo;
    this.slCd = slCd;
    this.trackingNo = trackingNo;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ListViewI38DtlBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ListViewI38DtlBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.list_view_i38_dtl, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ListViewI38DtlBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bad_on_hand_qty;
      TextView badOnHandQty = ViewBindings.findChildViewById(rootView, id);
      if (badOnHandQty == null) {
        break missingId;
      }

      id = R.id.basic_unit;
      TextView basicUnit = ViewBindings.findChildViewById(rootView, id);
      if (basicUnit == null) {
        break missingId;
      }

      id = R.id.blank2_2;
      TextView blank22 = ViewBindings.findChildViewById(rootView, id);
      if (blank22 == null) {
        break missingId;
      }

      id = R.id.blank3_2;
      TextView blank32 = ViewBindings.findChildViewById(rootView, id);
      if (blank32 == null) {
        break missingId;
      }

      id = R.id.blank4_2;
      TextView blank42 = ViewBindings.findChildViewById(rootView, id);
      if (blank42 == null) {
        break missingId;
      }

      id = R.id.blank5;
      TextView blank5 = ViewBindings.findChildViewById(rootView, id);
      if (blank5 == null) {
        break missingId;
      }

      id = R.id.blank5_2;
      TextView blank52 = ViewBindings.findChildViewById(rootView, id);
      if (blank52 == null) {
        break missingId;
      }

      id = R.id.good_on_hand_qty;
      TextView goodOnHandQty = ViewBindings.findChildViewById(rootView, id);
      if (goodOnHandQty == null) {
        break missingId;
      }

      id = R.id.item_cd;
      TextView itemCd = ViewBindings.findChildViewById(rootView, id);
      if (itemCd == null) {
        break missingId;
      }

      id = R.id.location;
      TextView location = ViewBindings.findChildViewById(rootView, id);
      if (location == null) {
        break missingId;
      }

      id = R.id.location2;
      TextView location2 = ViewBindings.findChildViewById(rootView, id);
      if (location2 == null) {
        break missingId;
      }

      id = R.id.lot_no;
      TextView lotNo = ViewBindings.findChildViewById(rootView, id);
      if (lotNo == null) {
        break missingId;
      }

      id = R.id.lot_sub_no;
      TextView lotSubNo = ViewBindings.findChildViewById(rootView, id);
      if (lotSubNo == null) {
        break missingId;
      }

      id = R.id.sl_cd;
      TextView slCd = ViewBindings.findChildViewById(rootView, id);
      if (slCd == null) {
        break missingId;
      }

      id = R.id.tracking_no;
      TextView trackingNo = ViewBindings.findChildViewById(rootView, id);
      if (trackingNo == null) {
        break missingId;
      }

      return new ListViewI38DtlBinding((LinearLayout) rootView, badOnHandQty, basicUnit, blank22,
          blank32, blank42, blank5, blank52, goodOnHandQty, itemCd, location, location2, lotNo,
          lotSubNo, slCd, trackingNo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
