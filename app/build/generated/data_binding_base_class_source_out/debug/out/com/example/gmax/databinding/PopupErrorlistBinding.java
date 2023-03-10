// Generated by view binder compiler. Do not edit!
package com.example.gmax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gmax.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PopupErrorlistBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnShutdown;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final TextView txtContents;

  @NonNull
  public final TextView txtName;

  private PopupErrorlistBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnShutdown,
      @NonNull ConstraintLayout constraintLayout, @NonNull TextView txtContents,
      @NonNull TextView txtName) {
    this.rootView = rootView;
    this.btnShutdown = btnShutdown;
    this.constraintLayout = constraintLayout;
    this.txtContents = txtContents;
    this.txtName = txtName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static PopupErrorlistBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PopupErrorlistBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.popup_errorlist, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PopupErrorlistBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_shutdown;
      Button btnShutdown = ViewBindings.findChildViewById(rootView, id);
      if (btnShutdown == null) {
        break missingId;
      }

      id = R.id.constraintLayout;
      ConstraintLayout constraintLayout = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout == null) {
        break missingId;
      }

      id = R.id.txt_contents;
      TextView txtContents = ViewBindings.findChildViewById(rootView, id);
      if (txtContents == null) {
        break missingId;
      }

      id = R.id.txt_name;
      TextView txtName = ViewBindings.findChildViewById(rootView, id);
      if (txtName == null) {
        break missingId;
      }

      return new PopupErrorlistBinding((ConstraintLayout) rootView, btnShutdown, constraintLayout,
          txtContents, txtName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
