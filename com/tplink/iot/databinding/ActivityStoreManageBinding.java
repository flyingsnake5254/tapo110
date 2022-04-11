package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.StoreManageViewModel;
import com.tplink.iot.widget.camerasetting.SimpleProcessBarNewIpc;

public abstract class ActivityStoreManageBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final CameraLoadingView d;
  @NonNull
  public final CheckBox f;
  @Bindable
  protected StoreManageViewModel p0;
  @Bindable
  protected View.OnClickListener p1;
  @NonNull
  public final SimpleProcessBarNewIpc q;
  @NonNull
  public final TextView x;
  @NonNull
  public final Toolbar y;
  @NonNull
  public final TextView z;
  
  protected ActivityStoreManageBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, CameraLoadingView paramCameraLoadingView, CheckBox paramCheckBox, SimpleProcessBarNewIpc paramSimpleProcessBarNewIpc, TextView paramTextView2, Toolbar paramToolbar, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramCameraLoadingView;
    this.f = paramCheckBox;
    this.q = paramSimpleProcessBarNewIpc;
    this.x = paramTextView2;
    this.y = paramToolbar;
    this.z = paramTextView3;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable StoreManageViewModel paramStoreManageViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityStoreManageBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */