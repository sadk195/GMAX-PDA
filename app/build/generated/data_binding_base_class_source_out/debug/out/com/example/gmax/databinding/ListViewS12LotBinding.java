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

public final class ListViewS12LotBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView dnNo;

  @NonNull
  public final TextView endDt;

  @NonNull
  public final TextView lotNo;

  @NonNull
  public final TextView movType;

  @NonNull
  public final TextView plantCd;

  @NonNull
  public final TextView scanQty;

  @NonNull
  public final TextView shipToParty;

  @NonNull
  public final TextView slCd;

  @NonNull
  public final TextView soType;

  @NonNull
  public final TextView startDt;

  @NonNull
  public final TextView transMeth;

  private ListViewS12LotBinding(@NonNull LinearLayout rootView, @NonNull TextView dnNo,
      @NonNull TextView endDt, @NonNull TextView lotNo, @NonNull TextView movType,
      @NonNull TextView plantCd, @NonNull TextView scanQty, @NonNull TextView shipToParty,
      @NonNull TextView slCd, @NonNull TextView soType, @NonNull TextView startDt,
      @NonNull TextView transMeth) {
    this.rootView = rootView;
    this.dnNo = dnNo;
    this.endDt = endDt;
    this.lotNo = lotNo;
    this.movType = movType;
    this.plantCd = plantCd;
    this.scanQty = scanQty;
    this.shipToParty = shipToParty;
    this.slCd = slCd;
    this.soType = soType;
    this.startDt = startDt;
    this.transMeth = transMeth;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ListViewS12LotBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ListViewS12LotBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.list_view_s12_lot, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ListViewS12LotBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.dn_no;
      TextView dnNo = ViewBindings.findChildViewById(rootView, id);
      if (dnNo == null) {
        break missingId;
      }

      id = R.id.end_dt;
      TextView endDt = ViewBindings.findChildViewById(rootView, id);
      if (endDt == null) {
        break missingId;
      }

      id = R.id.lot_no;
      TextView lotNo = ViewBindings.findChildViewById(rootView, id);
      if (lotNo == null) {
        break missingId;
      }

      id = R.id.mov_type;
      TextView movType = ViewBindings.findChildViewById(rootView, id);
      if (movType == null) {
        break missingId;
      }

      id = R.id.plant_cd;
      TextView plantCd = ViewBindings.findChildViewById(rootView, id);
      if (plantCd == null) {
        break missingId;
      }

      id = R.id.scan_qty;
      TextView scanQty = ViewBindings.findChildViewById(rootView, id);
      if (scanQty == null) {
        break missingId;
      }

      id = R.id.ship_to_party;
      TextView shipToParty = ViewBindings.findChildViewById(rootView, id);
      if (shipToParty == null) {
        break missingId;
      }

      id = R.id.sl_cd;
      TextView slCd = ViewBindings.findChildViewById(rootView, id);
      if (slCd == null) {
        break missingId;
      }

      id = R.id.so_type;
      TextView soType = ViewBindings.findChildViewById(rootView, id);
      if (soType == null) {
        break missingId;
      }

      id = R.id.start_dt;
      TextView startDt = ViewBindings.findChildViewById(rootView, id);
      if (startDt == null) {
        break missingId;
      }

      id = R.id.trans_meth;
      TextView transMeth = ViewBindings.findChildViewById(rootView, id);
      if (transMeth == null) {
        break missingId;
      }

      return new ListViewS12LotBinding((LinearLayout) rootView, dnNo, endDt, lotNo, movType,
          plantCd, scanQty, shipToParty, slCd, soType, startDt, transMeth);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
