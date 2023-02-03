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

public final class ListViewM31HdrBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView confirmDlvQty;

  @NonNull
  public final TextView dlvNo;

  @NonNull
  public final TextView dlvQty;

  @NonNull
  public final TextView inspectFlg;

  @NonNull
  public final TextView itemCd;

  @NonNull
  public final TextView itemNm;

  @NonNull
  public final TextView purType;

  @NonNull
  public final TextView serNo;

  @NonNull
  public final TextView spec;

  private ListViewM31HdrBinding(@NonNull LinearLayout rootView, @NonNull TextView confirmDlvQty,
      @NonNull TextView dlvNo, @NonNull TextView dlvQty, @NonNull TextView inspectFlg,
      @NonNull TextView itemCd, @NonNull TextView itemNm, @NonNull TextView purType,
      @NonNull TextView serNo, @NonNull TextView spec) {
    this.rootView = rootView;
    this.confirmDlvQty = confirmDlvQty;
    this.dlvNo = dlvNo;
    this.dlvQty = dlvQty;
    this.inspectFlg = inspectFlg;
    this.itemCd = itemCd;
    this.itemNm = itemNm;
    this.purType = purType;
    this.serNo = serNo;
    this.spec = spec;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ListViewM31HdrBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ListViewM31HdrBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.list_view_m31_hdr, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ListViewM31HdrBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.confirm_dlv_qty;
      TextView confirmDlvQty = ViewBindings.findChildViewById(rootView, id);
      if (confirmDlvQty == null) {
        break missingId;
      }

      id = R.id.dlv_no;
      TextView dlvNo = ViewBindings.findChildViewById(rootView, id);
      if (dlvNo == null) {
        break missingId;
      }

      id = R.id.dlv_qty;
      TextView dlvQty = ViewBindings.findChildViewById(rootView, id);
      if (dlvQty == null) {
        break missingId;
      }

      id = R.id.inspect_flg;
      TextView inspectFlg = ViewBindings.findChildViewById(rootView, id);
      if (inspectFlg == null) {
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

      id = R.id.pur_type;
      TextView purType = ViewBindings.findChildViewById(rootView, id);
      if (purType == null) {
        break missingId;
      }

      id = R.id.ser_no;
      TextView serNo = ViewBindings.findChildViewById(rootView, id);
      if (serNo == null) {
        break missingId;
      }

      id = R.id.spec;
      TextView spec = ViewBindings.findChildViewById(rootView, id);
      if (spec == null) {
        break missingId;
      }

      return new ListViewM31HdrBinding((LinearLayout) rootView, confirmDlvQty, dlvNo, dlvQty,
          inspectFlg, itemCd, itemNm, purType, serNo, spec);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
