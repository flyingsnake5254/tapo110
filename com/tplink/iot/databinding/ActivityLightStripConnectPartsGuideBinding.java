package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityLightStripConnectPartsGuideBinding
  extends ViewDataBinding
{
  @NonNull
  public final Button c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @Bindable
  protected View.OnClickListener z;
  
  protected ActivityLightStripConnectPartsGuideBinding(Object paramObject, View paramView, int paramInt, Button paramButton, ImageView paramImageView1, ImageView paramImageView2, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton;
    this.d = paramImageView1;
    this.f = paramImageView2;
    this.q = paramTextView1;
    this.x = paramTextView2;
    this.y = paramTextView3;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityLightStripConnectPartsGuideBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */