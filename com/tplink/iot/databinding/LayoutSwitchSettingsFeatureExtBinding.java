package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.switches.viewmodel.SwitchSettingsViewModel;
import com.tplink.iot.widget.ItemSettingLayout;

public abstract class LayoutSwitchSettingsFeatureExtBinding
  extends ViewDataBinding
{
  @NonNull
  public final ItemSettingLayout c;
  @NonNull
  public final ItemSettingLayout d;
  @NonNull
  public final ItemSettingLayout f;
  @Bindable
  protected View.OnClickListener q;
  @Bindable
  protected SwitchSettingsViewModel x;
  
  protected LayoutSwitchSettingsFeatureExtBinding(Object paramObject, View paramView, int paramInt, ItemSettingLayout paramItemSettingLayout1, ItemSettingLayout paramItemSettingLayout2, ItemSettingLayout paramItemSettingLayout3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramItemSettingLayout1;
    this.d = paramItemSettingLayout2;
    this.f = paramItemSettingLayout3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutSwitchSettingsFeatureExtBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */