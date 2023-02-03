// Generated by view binder compiler. Do not edit!
package com.example.gmax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public final class ActivitySearchBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final LinearLayout appView2;

  @NonNull
  public final ImageView imgBarcode;

  @NonNull
  public final LinearLayout layoutBody;

  @NonNull
  public final LinearLayout layoutMenuTitle;

  @NonNull
  public final EditText txtScan;

  @NonNull
  public final TextView viewTitle;

  private ActivitySearchBinding(@NonNull RelativeLayout rootView, @NonNull LinearLayout appView2,
      @NonNull ImageView imgBarcode, @NonNull LinearLayout layoutBody,
      @NonNull LinearLayout layoutMenuTitle, @NonNull EditText txtScan,
      @NonNull TextView viewTitle) {
    this.rootView = rootView;
    this.appView2 = appView2;
    this.imgBarcode = imgBarcode;
    this.layoutBody = layoutBody;
    this.layoutMenuTitle = layoutMenuTitle;
    this.txtScan = txtScan;
    this.viewTitle = viewTitle;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_search, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySearchBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.app_view2;
      LinearLayout appView2 = ViewBindings.findChildViewById(rootView, id);
      if (appView2 == null) {
        break missingId;
      }

      id = R.id.img_barcode;
      ImageView imgBarcode = ViewBindings.findChildViewById(rootView, id);
      if (imgBarcode == null) {
        break missingId;
      }

      id = R.id.layout_body;
      LinearLayout layoutBody = ViewBindings.findChildViewById(rootView, id);
      if (layoutBody == null) {
        break missingId;
      }

      id = R.id.layout_menu_title;
      LinearLayout layoutMenuTitle = ViewBindings.findChildViewById(rootView, id);
      if (layoutMenuTitle == null) {
        break missingId;
      }

      id = R.id.txt_Scan;
      EditText txtScan = ViewBindings.findChildViewById(rootView, id);
      if (txtScan == null) {
        break missingId;
      }

      id = R.id.view_title;
      TextView viewTitle = ViewBindings.findChildViewById(rootView, id);
      if (viewTitle == null) {
        break missingId;
      }

      return new ActivitySearchBinding((RelativeLayout) rootView, appView2, imgBarcode, layoutBody,
          layoutMenuTitle, txtScan, viewTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
