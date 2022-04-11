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
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.DeviceNameEditorViewModel;
import com.tplink.iot.widget.DrawableEditText;

public abstract class ActivityDeviceNameEditorBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final TextView f;
  @Bindable
  protected DeviceNameEditorViewModel p0;
  @Bindable
  protected View.OnClickListener p1;
  @NonNull
  public final CameraLoadingView q;
  @NonNull
  public final DrawableEditText x;
  @NonNull
  public final Button y;
  @NonNull
  public final Toolbar z;
  
  protected ActivityDeviceNameEditorBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, CameraLoadingView paramCameraLoadingView, DrawableEditText paramDrawableEditText, Button paramButton, Toolbar paramToolbar)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramTextView2;
    this.f = paramTextView3;
    this.q = paramCameraLoadingView;
    this.x = paramDrawableEditText;
    this.y = paramButton;
    this.z = paramToolbar;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable DeviceNameEditorViewModel paramDeviceNameEditorViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityDeviceNameEditorBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */