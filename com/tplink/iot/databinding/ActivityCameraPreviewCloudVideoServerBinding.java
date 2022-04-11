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

public abstract class ActivityCameraPreviewCloudVideoServerBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final LinearLayout d;
  @NonNull
  public final TextView f;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @Bindable
  protected MutableLiveData<Boolean> y;
  @Bindable
  protected MutableLiveData<Boolean> z;
  
  protected ActivityCameraPreviewCloudVideoServerBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, LinearLayout paramLinearLayout, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramLinearLayout;
    this.f = paramTextView1;
    this.q = paramTextView2;
    this.x = paramTextView3;
  }
  
  public abstract void h(@Nullable MutableLiveData<Boolean> paramMutableLiveData);
  
  public abstract void i(@Nullable MutableLiveData<Boolean> paramMutableLiveData);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityCameraPreviewCloudVideoServerBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */