package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.ItemSettingLayout;

public abstract class LayoutTrvOneSelectSettingsBinding
  extends ViewDataBinding
{
  @NonNull
  public final ItemSettingLayout c;
  @NonNull
  public final TextView d;
  
  protected LayoutTrvOneSelectSettingsBinding(Object paramObject, View paramView, int paramInt, ItemSettingLayout paramItemSettingLayout, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramItemSettingLayout;
    this.d = paramTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutTrvOneSelectSettingsBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */