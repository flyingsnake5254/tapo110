package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.iot.widget.viewgroup.ItemInfoLayout;

public abstract class LayoutTrvSettingsFeatureExtBinding
  extends ViewDataBinding
{
  @NonNull
  public final ItemSettingLayout c;
  @NonNull
  public final ItemSettingLayout d;
  @NonNull
  public final ItemInfoLayout f;
  @NonNull
  public final ItemSettingLayout p0;
  @NonNull
  public final ItemSettingLayout p1;
  @Bindable
  protected View.OnClickListener p2;
  @Bindable
  protected TRVSettingsViewModel p3;
  @NonNull
  public final ItemInfoLayout q;
  @NonNull
  public final ItemSettingLayout x;
  @NonNull
  public final ItemSettingLayout y;
  @NonNull
  public final ItemSettingLayout z;
  
  protected LayoutTrvSettingsFeatureExtBinding(Object paramObject, View paramView, int paramInt, ItemSettingLayout paramItemSettingLayout1, ItemSettingLayout paramItemSettingLayout2, ItemInfoLayout paramItemInfoLayout1, ItemInfoLayout paramItemInfoLayout2, ItemSettingLayout paramItemSettingLayout3, ItemSettingLayout paramItemSettingLayout4, ItemSettingLayout paramItemSettingLayout5, ItemSettingLayout paramItemSettingLayout6, ItemSettingLayout paramItemSettingLayout7)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramItemSettingLayout1;
    this.d = paramItemSettingLayout2;
    this.f = paramItemInfoLayout1;
    this.q = paramItemInfoLayout2;
    this.x = paramItemSettingLayout3;
    this.y = paramItemSettingLayout4;
    this.z = paramItemSettingLayout5;
    this.p0 = paramItemSettingLayout6;
    this.p1 = paramItemSettingLayout7;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutTrvSettingsFeatureExtBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */