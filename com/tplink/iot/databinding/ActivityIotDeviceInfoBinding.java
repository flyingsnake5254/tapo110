package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.ItemSettingLayout;

public abstract class ActivityIotDeviceInfoBinding
  extends ViewDataBinding
{
  @NonNull
  public final ItemSettingLayout c;
  @NonNull
  public final ItemSettingLayout d;
  @NonNull
  public final ItemSettingLayout f;
  @NonNull
  public final ItemSettingLayout q;
  @NonNull
  public final ItemSettingLayout x;
  @NonNull
  public final ItemSettingLayout y;
  @NonNull
  public final ItemSettingLayout z;
  
  protected ActivityIotDeviceInfoBinding(Object paramObject, View paramView, int paramInt, ItemSettingLayout paramItemSettingLayout1, ItemSettingLayout paramItemSettingLayout2, ItemSettingLayout paramItemSettingLayout3, ItemSettingLayout paramItemSettingLayout4, ItemSettingLayout paramItemSettingLayout5, ItemSettingLayout paramItemSettingLayout6, ItemSettingLayout paramItemSettingLayout7)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramItemSettingLayout1;
    this.d = paramItemSettingLayout2;
    this.f = paramItemSettingLayout3;
    this.q = paramItemSettingLayout4;
    this.x = paramItemSettingLayout5;
    this.y = paramItemSettingLayout6;
    this.z = paramItemSettingLayout7;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityIotDeviceInfoBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */