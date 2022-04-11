package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.TimezoneViewModel;

public abstract class ActivityTimeZoneNewIpcBinding
  extends ViewDataBinding
{
  @NonNull
  public final CameraLoadingView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final TextView f;
  @Bindable
  protected View.OnClickListener p0;
  @NonNull
  public final Button q;
  @NonNull
  public final RecyclerView x;
  @NonNull
  public final Toolbar y;
  @Bindable
  protected TimezoneViewModel z;
  
  protected ActivityTimeZoneNewIpcBinding(Object paramObject, View paramView, int paramInt, CameraLoadingView paramCameraLoadingView, TextView paramTextView1, TextView paramTextView2, Button paramButton, RecyclerView paramRecyclerView, Toolbar paramToolbar)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramCameraLoadingView;
    this.d = paramTextView1;
    this.f = paramTextView2;
    this.q = paramButton;
    this.x = paramRecyclerView;
    this.y = paramToolbar;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable TimezoneViewModel paramTimezoneViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityTimeZoneNewIpcBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */