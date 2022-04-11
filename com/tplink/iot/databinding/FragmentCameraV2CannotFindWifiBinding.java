package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;

public abstract class FragmentCameraV2CannotFindWifiBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final LinearLayout d;
  @NonNull
  public final Toolbar f;
  @NonNull
  public final TextView q;
  
  protected FragmentCameraV2CannotFindWifiBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, LinearLayout paramLinearLayout, Toolbar paramToolbar, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramLinearLayout;
    this.f = paramToolbar;
    this.q = paramTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2CannotFindWifiBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */