// Generated by view binder compiler. Do not edit!
package com.example.gmax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gmax.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityM11DtlBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final TextView INSPECTORNM;

  @NonNull
  public final TextView INSPRESULTNO;

  @NonNull
  public final TextView MSTS;

  @NonNull
  public final TextView MVMTNO;

  @NonNull
  public final TextView SLCDFORDEFECT;

  @NonNull
  public final TextView SLCDFORGOOD;

  @NonNull
  public final TextView STS;

  @NonNull
  public final AppBarLayout appBarLayout;

  @NonNull
  public final TextView blank;

  @NonNull
  public final TextView bpCd;

  @NonNull
  public final TextView bpNm;

  @NonNull
  public final FloatingActionButton btnSave;

  @NonNull
  public final TextView inspReqNo;

  @NonNull
  public final TextView inspectBadQty;

  @NonNull
  public final TextView inspectGoodQty;

  @NonNull
  public final TextView itemCd;

  @NonNull
  public final TextView itemNm;

  @NonNull
  public final RelativeLayout layoutBody;

  @NonNull
  public final ConstraintLayout layoutConst1;

  @NonNull
  public final ConstraintLayout layoutConst10;

  @NonNull
  public final ConstraintLayout layoutConst11;

  @NonNull
  public final ConstraintLayout layoutConst12;

  @NonNull
  public final ConstraintLayout layoutConst13;

  @NonNull
  public final ConstraintLayout layoutConst14;

  @NonNull
  public final ConstraintLayout layoutConst15;

  @NonNull
  public final ConstraintLayout layoutConst16;

  @NonNull
  public final ConstraintLayout layoutConst17;

  @NonNull
  public final ConstraintLayout layoutConst18;

  @NonNull
  public final ConstraintLayout layoutConst19;

  @NonNull
  public final ConstraintLayout layoutConst3;

  @NonNull
  public final ConstraintLayout layoutConst4;

  @NonNull
  public final ConstraintLayout layoutConst5;

  @NonNull
  public final ConstraintLayout layoutConst6;

  @NonNull
  public final ConstraintLayout layoutConst7;

  @NonNull
  public final ConstraintLayout layoutConst8;

  @NonNull
  public final ConstraintLayout layoutConst9;

  @NonNull
  public final MaterialToolbar materialToolbar;

  @NonNull
  public final TextView mvmtRcptQty;

  @NonNull
  public final TextView qty;

  @NonNull
  public final TextView topLocation;

  private ActivityM11DtlBinding(@NonNull CoordinatorLayout rootView, @NonNull TextView INSPECTORNM,
      @NonNull TextView INSPRESULTNO, @NonNull TextView MSTS, @NonNull TextView MVMTNO,
      @NonNull TextView SLCDFORDEFECT, @NonNull TextView SLCDFORGOOD, @NonNull TextView STS,
      @NonNull AppBarLayout appBarLayout, @NonNull TextView blank, @NonNull TextView bpCd,
      @NonNull TextView bpNm, @NonNull FloatingActionButton btnSave, @NonNull TextView inspReqNo,
      @NonNull TextView inspectBadQty, @NonNull TextView inspectGoodQty, @NonNull TextView itemCd,
      @NonNull TextView itemNm, @NonNull RelativeLayout layoutBody,
      @NonNull ConstraintLayout layoutConst1, @NonNull ConstraintLayout layoutConst10,
      @NonNull ConstraintLayout layoutConst11, @NonNull ConstraintLayout layoutConst12,
      @NonNull ConstraintLayout layoutConst13, @NonNull ConstraintLayout layoutConst14,
      @NonNull ConstraintLayout layoutConst15, @NonNull ConstraintLayout layoutConst16,
      @NonNull ConstraintLayout layoutConst17, @NonNull ConstraintLayout layoutConst18,
      @NonNull ConstraintLayout layoutConst19, @NonNull ConstraintLayout layoutConst3,
      @NonNull ConstraintLayout layoutConst4, @NonNull ConstraintLayout layoutConst5,
      @NonNull ConstraintLayout layoutConst6, @NonNull ConstraintLayout layoutConst7,
      @NonNull ConstraintLayout layoutConst8, @NonNull ConstraintLayout layoutConst9,
      @NonNull MaterialToolbar materialToolbar, @NonNull TextView mvmtRcptQty,
      @NonNull TextView qty, @NonNull TextView topLocation) {
    this.rootView = rootView;
    this.INSPECTORNM = INSPECTORNM;
    this.INSPRESULTNO = INSPRESULTNO;
    this.MSTS = MSTS;
    this.MVMTNO = MVMTNO;
    this.SLCDFORDEFECT = SLCDFORDEFECT;
    this.SLCDFORGOOD = SLCDFORGOOD;
    this.STS = STS;
    this.appBarLayout = appBarLayout;
    this.blank = blank;
    this.bpCd = bpCd;
    this.bpNm = bpNm;
    this.btnSave = btnSave;
    this.inspReqNo = inspReqNo;
    this.inspectBadQty = inspectBadQty;
    this.inspectGoodQty = inspectGoodQty;
    this.itemCd = itemCd;
    this.itemNm = itemNm;
    this.layoutBody = layoutBody;
    this.layoutConst1 = layoutConst1;
    this.layoutConst10 = layoutConst10;
    this.layoutConst11 = layoutConst11;
    this.layoutConst12 = layoutConst12;
    this.layoutConst13 = layoutConst13;
    this.layoutConst14 = layoutConst14;
    this.layoutConst15 = layoutConst15;
    this.layoutConst16 = layoutConst16;
    this.layoutConst17 = layoutConst17;
    this.layoutConst18 = layoutConst18;
    this.layoutConst19 = layoutConst19;
    this.layoutConst3 = layoutConst3;
    this.layoutConst4 = layoutConst4;
    this.layoutConst5 = layoutConst5;
    this.layoutConst6 = layoutConst6;
    this.layoutConst7 = layoutConst7;
    this.layoutConst8 = layoutConst8;
    this.layoutConst9 = layoutConst9;
    this.materialToolbar = materialToolbar;
    this.mvmtRcptQty = mvmtRcptQty;
    this.qty = qty;
    this.topLocation = topLocation;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityM11DtlBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityM11DtlBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_m11_dtl, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityM11DtlBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.INSPECTOR_NM;
      TextView INSPECTORNM = ViewBindings.findChildViewById(rootView, id);
      if (INSPECTORNM == null) {
        break missingId;
      }

      id = R.id.INSP_RESULT_NO;
      TextView INSPRESULTNO = ViewBindings.findChildViewById(rootView, id);
      if (INSPRESULTNO == null) {
        break missingId;
      }

      id = R.id.M_STS;
      TextView MSTS = ViewBindings.findChildViewById(rootView, id);
      if (MSTS == null) {
        break missingId;
      }

      id = R.id.MVMT_NO;
      TextView MVMTNO = ViewBindings.findChildViewById(rootView, id);
      if (MVMTNO == null) {
        break missingId;
      }

      id = R.id.SL_CD_FOR_DEFECT;
      TextView SLCDFORDEFECT = ViewBindings.findChildViewById(rootView, id);
      if (SLCDFORDEFECT == null) {
        break missingId;
      }

      id = R.id.SL_CD_FOR_GOOD;
      TextView SLCDFORGOOD = ViewBindings.findChildViewById(rootView, id);
      if (SLCDFORGOOD == null) {
        break missingId;
      }

      id = R.id.STS;
      TextView STS = ViewBindings.findChildViewById(rootView, id);
      if (STS == null) {
        break missingId;
      }

      id = R.id.appBarLayout;
      AppBarLayout appBarLayout = ViewBindings.findChildViewById(rootView, id);
      if (appBarLayout == null) {
        break missingId;
      }

      id = R.id.blank;
      TextView blank = ViewBindings.findChildViewById(rootView, id);
      if (blank == null) {
        break missingId;
      }

      id = R.id.bp_cd;
      TextView bpCd = ViewBindings.findChildViewById(rootView, id);
      if (bpCd == null) {
        break missingId;
      }

      id = R.id.bp_nm;
      TextView bpNm = ViewBindings.findChildViewById(rootView, id);
      if (bpNm == null) {
        break missingId;
      }

      id = R.id.btn_save;
      FloatingActionButton btnSave = ViewBindings.findChildViewById(rootView, id);
      if (btnSave == null) {
        break missingId;
      }

      id = R.id.insp_req_no;
      TextView inspReqNo = ViewBindings.findChildViewById(rootView, id);
      if (inspReqNo == null) {
        break missingId;
      }

      id = R.id.inspect_bad_qty;
      TextView inspectBadQty = ViewBindings.findChildViewById(rootView, id);
      if (inspectBadQty == null) {
        break missingId;
      }

      id = R.id.inspect_good_qty;
      TextView inspectGoodQty = ViewBindings.findChildViewById(rootView, id);
      if (inspectGoodQty == null) {
        break missingId;
      }

      id = R.id.item_cd;
      TextView itemCd = ViewBindings.findChildViewById(rootView, id);
      if (itemCd == null) {
        break missingId;
      }

      id = R.id.item_nm;
      TextView itemNm = ViewBindings.findChildViewById(rootView, id);
      if (itemNm == null) {
        break missingId;
      }

      id = R.id.layout_body;
      RelativeLayout layoutBody = ViewBindings.findChildViewById(rootView, id);
      if (layoutBody == null) {
        break missingId;
      }

      id = R.id.layout_const1;
      ConstraintLayout layoutConst1 = ViewBindings.findChildViewById(rootView, id);
      if (layoutConst1 == null) {
        break missingId;
      }

      id = R.id.layout_const10;
      ConstraintLayout layoutConst10 = ViewBindings.findChildViewById(rootView, id);
      if (layoutConst10 == null) {
        break missingId;
      }

      id = R.id.layout_const11;
      ConstraintLayout layoutConst11 = ViewBindings.findChildViewById(rootView, id);
      if (layoutConst11 == null) {
        break missingId;
      }

      id = R.id.layout_const12;
      ConstraintLayout layoutConst12 = ViewBindings.findChildViewById(rootView, id);
      if (layoutConst12 == null) {
        break missingId;
      }

      id = R.id.layout_const13;
      ConstraintLayout layoutConst13 = ViewBindings.findChildViewById(rootView, id);
      if (layoutConst13 == null) {
        break missingId;
      }

      id = R.id.layout_const14;
      ConstraintLayout layoutConst14 = ViewBindings.findChildViewById(rootView, id);
      if (layoutConst14 == null) {
        break missingId;
      }

      id = R.id.layout_const15;
      ConstraintLayout layoutConst15 = ViewBindings.findChildViewById(rootView, id);
      if (layoutConst15 == null) {
        break missingId;
      }

      id = R.id.layout_const16;
      ConstraintLayout layoutConst16 = ViewBindings.findChildViewById(rootView, id);
      if (layoutConst16 == null) {
        break missingId;
      }

      id = R.id.layout_const17;
      ConstraintLayout layoutConst17 = ViewBindings.findChildViewById(rootView, id);
      if (layoutConst17 == null) {
        break missingId;
      }

      id = R.id.layout_const18;
      ConstraintLayout layoutConst18 = ViewBindings.findChildViewById(rootView, id);
      if (layoutConst18 == null) {
        break missingId;
      }

      id = R.id.layout_const19;
      ConstraintLayout layoutConst19 = ViewBindings.findChildViewById(rootView, id);
      if (layoutConst19 == null) {
        break missingId;
      }

      id = R.id.layout_const3;
      ConstraintLayout layoutConst3 = ViewBindings.findChildViewById(rootView, id);
      if (layoutConst3 == null) {
        break missingId;
      }

      id = R.id.layout_const4;
      ConstraintLayout layoutConst4 = ViewBindings.findChildViewById(rootView, id);
      if (layoutConst4 == null) {
        break missingId;
      }

      id = R.id.layout_const5;
      ConstraintLayout layoutConst5 = ViewBindings.findChildViewById(rootView, id);
      if (layoutConst5 == null) {
        break missingId;
      }

      id = R.id.layout_const6;
      ConstraintLayout layoutConst6 = ViewBindings.findChildViewById(rootView, id);
      if (layoutConst6 == null) {
        break missingId;
      }

      id = R.id.layout_const7;
      ConstraintLayout layoutConst7 = ViewBindings.findChildViewById(rootView, id);
      if (layoutConst7 == null) {
        break missingId;
      }

      id = R.id.layout_const8;
      ConstraintLayout layoutConst8 = ViewBindings.findChildViewById(rootView, id);
      if (layoutConst8 == null) {
        break missingId;
      }

      id = R.id.layout_const9;
      ConstraintLayout layoutConst9 = ViewBindings.findChildViewById(rootView, id);
      if (layoutConst9 == null) {
        break missingId;
      }

      id = R.id.materialToolbar;
      MaterialToolbar materialToolbar = ViewBindings.findChildViewById(rootView, id);
      if (materialToolbar == null) {
        break missingId;
      }

      id = R.id.mvmt_rcpt_qty;
      TextView mvmtRcptQty = ViewBindings.findChildViewById(rootView, id);
      if (mvmtRcptQty == null) {
        break missingId;
      }

      id = R.id.qty;
      TextView qty = ViewBindings.findChildViewById(rootView, id);
      if (qty == null) {
        break missingId;
      }

      id = R.id.top_location;
      TextView topLocation = ViewBindings.findChildViewById(rootView, id);
      if (topLocation == null) {
        break missingId;
      }

      return new ActivityM11DtlBinding((CoordinatorLayout) rootView, INSPECTORNM, INSPRESULTNO,
          MSTS, MVMTNO, SLCDFORDEFECT, SLCDFORGOOD, STS, appBarLayout, blank, bpCd, bpNm, btnSave,
          inspReqNo, inspectBadQty, inspectGoodQty, itemCd, itemNm, layoutBody, layoutConst1,
          layoutConst10, layoutConst11, layoutConst12, layoutConst13, layoutConst14, layoutConst15,
          layoutConst16, layoutConst17, layoutConst18, layoutConst19, layoutConst3, layoutConst4,
          layoutConst5, layoutConst6, layoutConst7, layoutConst8, layoutConst9, materialToolbar,
          mvmtRcptQty, qty, topLocation);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
