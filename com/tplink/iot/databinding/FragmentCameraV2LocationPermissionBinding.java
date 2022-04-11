package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;

public abstract class FragmentCameraV2LocationPermissionBinding
  extends ViewDataBinding
{
  @NonNull
  public final Button c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final LinearLayout f;
  @Bindable
  protected g q;
  
  protected FragmentCameraV2LocationPermissionBinding(Object paramObject, View paramView, int paramInt, Button paramButton, ImageView paramImageView, LinearLayout paramLinearLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton;
    this.d = paramImageView;
    this.f = paramLinearLayout;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2LocationPermissionBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */