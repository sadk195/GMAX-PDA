// Generated by view binder compiler. Do not edit!
package com.example.gmax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gmax.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final MaterialButton btnEnd;

  @NonNull
  public final MaterialButton btnLogin;

  @NonNull
  public final ImageView imgLogo;

  @NonNull
  public final ImageView imgUser;

  @NonNull
  public final TextView lblDeviceName;

  @NonNull
  public final TextInputLayout txtId;

  @NonNull
  public final TextInputLayout txtPwd;

  private ActivityMainBinding(@NonNull LinearLayout rootView, @NonNull MaterialButton btnEnd,
      @NonNull MaterialButton btnLogin, @NonNull ImageView imgLogo, @NonNull ImageView imgUser,
      @NonNull TextView lblDeviceName, @NonNull TextInputLayout txtId,
      @NonNull TextInputLayout txtPwd) {
    this.rootView = rootView;
    this.btnEnd = btnEnd;
    this.btnLogin = btnLogin;
    this.imgLogo = imgLogo;
    this.imgUser = imgUser;
    this.lblDeviceName = lblDeviceName;
    this.txtId = txtId;
    this.txtPwd = txtPwd;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_End;
      MaterialButton btnEnd = ViewBindings.findChildViewById(rootView, id);
      if (btnEnd == null) {
        break missingId;
      }

      id = R.id.btn_Login;
      MaterialButton btnLogin = ViewBindings.findChildViewById(rootView, id);
      if (btnLogin == null) {
        break missingId;
      }

      id = R.id.img_logo;
      ImageView imgLogo = ViewBindings.findChildViewById(rootView, id);
      if (imgLogo == null) {
        break missingId;
      }

      id = R.id.img_user;
      ImageView imgUser = ViewBindings.findChildViewById(rootView, id);
      if (imgUser == null) {
        break missingId;
      }

      id = R.id.lbl_device_name;
      TextView lblDeviceName = ViewBindings.findChildViewById(rootView, id);
      if (lblDeviceName == null) {
        break missingId;
      }

      id = R.id.txt_id;
      TextInputLayout txtId = ViewBindings.findChildViewById(rootView, id);
      if (txtId == null) {
        break missingId;
      }

      id = R.id.txt_pwd;
      TextInputLayout txtPwd = ViewBindings.findChildViewById(rootView, id);
      if (txtPwd == null) {
        break missingId;
      }

      return new ActivityMainBinding((LinearLayout) rootView, btnEnd, btnLogin, imgLogo, imgUser,
          lblDeviceName, txtId, txtPwd);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
