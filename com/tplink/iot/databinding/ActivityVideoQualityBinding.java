package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.video.VideoQualityViewModel;

public abstract class ActivityVideoQualityBinding
  extends ViewDataBinding
{
  @NonNull
  public final CameraLoadingView c;
  @NonNull
  public final RecyclerView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final ImageView q;
  @NonNull
  public final TextView x;
  @Bindable
  protected VideoQualityViewModel y;
  @Bindable
  protected View.OnClickListener z;
  
  protected ActivityVideoQualityBinding(Object paramObject, View paramView, int paramInt, CameraLoadingView paramCameraLoadingView, RecyclerView paramRecyclerView, ImageView paramImageView1, ImageView paramImageView2, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramCameraLoadingView;
    this.d = paramRecyclerView;
    this.f = paramImageView1;
    this.q = paramImageView2;
    this.x = paramTextView;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable VideoQualityViewModel paramVideoQualityViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityVideoQualityBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */