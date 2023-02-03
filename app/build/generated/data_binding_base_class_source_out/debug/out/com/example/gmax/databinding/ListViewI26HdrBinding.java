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

public final class ListViewI26HdrBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView blnk1;

  @NonNull
  public final TextView blnk2;

  @NonNull
  public final TextView blnk3;

  @NonNull
  public final TextView dlvyDt;

  @NonNull
  public final TextView issueLocation;

  @NonNull
  public final TextView issueSlCd;

  @NonNull
  public final TextView itemCd;

  @NonNull
  public final TextView itemNm;

  @NonNull
  public final TextView mvReqQty;

  @NonNull
  public final TextView mvReqSeq;

  private ListViewI26HdrBinding(@NonNull LinearLayout rootView, @NonNull TextView blnk1,
      @NonNull TextView blnk2, @NonNull TextView blnk3, @NonNull TextView dlvyDt,
      @NonNull TextView issueLocation, @NonNull TextView issueSlCd, @NonNull TextView itemCd,
      @NonNull TextView itemNm, @NonNull TextView mvReqQty, @NonNull TextView mvReqSeq) {
    this.rootView = rootView;
    this.blnk1 = blnk1;
    this.blnk2 = blnk2;
    this.blnk3 = blnk3;
    this.dlvyDt = dlvyDt;
    this.issueLocation = issueLocation;
    this.issueSlCd = issueSlCd;
    this.itemCd = itemCd;
    this.itemNm = itemNm;
    this.mvReqQty = mvReqQty;
    this.mvReqSeq = mvReqSeq;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ListViewI26HdrBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ListViewI26HdrBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.list_view_i26_hdr, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ListViewI26HdrBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.blnk1;
      TextView blnk1 = ViewBindings.findChildViewById(rootView, id);
      if (blnk1 == null) {
        break missingId;
      }

      id = R.id.blnk2;
      TextView blnk2 = ViewBindings.findChildViewById(rootView, id);
      if (blnk2 == null) {
        break missingId;
      }

      id = R.id.blnk3;
      TextView blnk3 = ViewBindings.findChildViewById(rootView, id);
      if (blnk3 == null) {
        break missingId;
      }

      id = R.id.dlvy_dt;
      TextView dlvyDt = ViewBindings.findChildViewById(rootView, id);
      if (dlvyDt == null) {
        break missingId;
      }

      id = R.id.issue_location;
      TextView issueLocation = ViewBindings.findChildViewById(rootView, id);
      if (issueLocation == null) {
        break missingId;
      }

      id = R.id.issue_sl_cd;
      TextView issueSlCd = ViewBindings.findChildViewById(rootView, id);
      if (issueSlCd == null) {
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

      id = R.id.mv_req_qty;
      TextView mvReqQty = ViewBindings.findChildViewById(rootView, id);
      if (mvReqQty == null) {
        break missingId;
      }

      id = R.id.mv_req_seq;
      TextView mvReqSeq = ViewBindings.findChildViewById(rootView, id);
      if (mvReqSeq == null) {
        break missingId;
      }

      return new ListViewI26HdrBinding((LinearLayout) rootView, blnk1, blnk2, blnk3, dlvyDt,
          issueLocation, issueSlCd, itemCd, itemNm, mvReqQty, mvReqSeq);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
