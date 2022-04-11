package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.ItemSettingLayout;

public abstract class ActivityBaseIotDeviceInfoBinding
  extends ViewDataBinding
{
  @NonNull
  public final View c;
  @NonNull
  public final ItemSettingLayout d;
  @NonNull
  public final ItemSettingLayout f;
  @NonNull
  public final ItemSettingLayout p0;
  @NonNull
  public final ItemSettingLayout p1;
  @NonNull
  public final ItemSettingLayout q;
  @NonNull
  public final ItemSettingLayout x;
  @NonNull
  public final ItemSettingLayout y;
  @NonNull
  public final ImageView z;
  
  protected ActivityBaseIotDeviceInfoBinding(Object paramObject, View paramView1, int paramInt, View paramView2, ItemSettingLayout paramItemSettingLayout1, ItemSettingLayout paramItemSettingLayout2, ItemSettingLayout paramItemSettingLayout3, ItemSettingLayout paramItemSettingLayout4, ItemSettingLayout paramItemSettingLayout5, ImageView paramImageView, ItemSettingLayout paramItemSettingLayout6, ItemSettingLayout paramItemSettingLayout7)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramView2;
    this.d = paramItemSettingLayout1;
    this.f = paramItemSettingLayout2;
    this.q = paramItemSettingLayout3;
    this.x = paramItemSettingLayout4;
    this.y = paramItemSettingLayout5;
    this.z = paramImageView;
    this.p0 = paramItemSettingLayout6;
    this.p1 = paramItemSettingLayout7;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityBaseIotDeviceInfoBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */