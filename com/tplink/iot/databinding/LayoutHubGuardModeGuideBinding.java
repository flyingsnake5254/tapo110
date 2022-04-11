package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

public abstract class LayoutHubGuardModeGuideBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final RelativeLayout q;
  @NonNull
  public final ConstraintLayout x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected LayoutHubGuardModeGuideBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, TextView paramTextView1, ImageView paramImageView2, RelativeLayout paramRelativeLayout, ConstraintLayout paramConstraintLayout, TextView paramTextView2, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramTextView1;
    this.f = paramImageView2;
    this.q = paramRelativeLayout;
    this.x = paramConstraintLayout;
    this.y = paramTextView2;
    this.z = paramTextView3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutHubGuardModeGuideBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */