package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripSettingsViewModel;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.iot.widget.viewgroup.ItemInfoLayout;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

public abstract class LayoutLightStripSettingsFeatureExtBinding
  extends ViewDataBinding
{
  @NonNull
  public final ItemSettingLayout c;
  @NonNull
  public final TextView d;
  @NonNull
  public final RelativeLayout f;
  @NonNull
  public final ItemInfoLayout q;
  @NonNull
  public final TPSwitchCompat x;
  @Bindable
  protected View.OnClickListener y;
  @Bindable
  protected LightStripSettingsViewModel z;
  
  protected LayoutLightStripSettingsFeatureExtBinding(Object paramObject, View paramView, int paramInt, ItemSettingLayout paramItemSettingLayout, TextView paramTextView, RelativeLayout paramRelativeLayout, ItemInfoLayout paramItemInfoLayout, TPSwitchCompat paramTPSwitchCompat)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramItemSettingLayout;
    this.d = paramTextView;
    this.f = paramRelativeLayout;
    this.q = paramItemInfoLayout;
    this.x = paramTPSwitchCompat;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutLightStripSettingsFeatureExtBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */