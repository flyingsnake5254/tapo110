package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripSettingsViewModel;
import com.tplink.iot.widget.viewgroup.ItemInfoLayout;

public abstract class LayoutLightStripSettingsOtherExtBinding
  extends ViewDataBinding
{
  @NonNull
  public final ItemInfoLayout c;
  @NonNull
  public final ItemInfoLayout d;
  @Bindable
  protected View.OnClickListener f;
  @Bindable
  protected LightStripSettingsViewModel q;
  
  protected LayoutLightStripSettingsOtherExtBinding(Object paramObject, View paramView, int paramInt, ItemInfoLayout paramItemInfoLayout1, ItemInfoLayout paramItemInfoLayout2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramItemInfoLayout1;
    this.d = paramItemInfoLayout2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutLightStripSettingsOtherExtBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */