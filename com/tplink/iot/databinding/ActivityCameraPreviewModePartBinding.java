package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;

public abstract class ActivityCameraPreviewModePartBinding
  extends ViewDataBinding
{
  @NonNull
  public final LinearLayout c;
  @NonNull
  public final LinearLayout d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final TextView p1;
  @Bindable
  protected MutableLiveData<Boolean> p2;
  @NonNull
  public final ImageView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected ActivityCameraPreviewModePartBinding(Object paramObject, View paramView, int paramInt, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, ImageView paramImageView1, ImageView paramImageView2, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramLinearLayout1;
    this.d = paramLinearLayout2;
    this.f = paramImageView1;
    this.q = paramImageView2;
    this.x = paramTextView1;
    this.y = paramTextView2;
    this.z = paramTextView3;
    this.p0 = paramTextView4;
    this.p1 = paramTextView5;
  }
  
  public abstract void h(@Nullable MutableLiveData<Boolean> paramMutableLiveData);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityCameraPreviewModePartBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */