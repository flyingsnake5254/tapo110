package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.ItemSettingLayout;

public abstract class ActivityTrvSetFrostProtectionBinding
  extends ViewDataBinding
{
  @NonNull
  public final ItemSettingLayout c;
  @NonNull
  public final TextView d;
  @NonNull
  public final TextView f;
  
  protected ActivityTrvSetFrostProtectionBinding(Object paramObject, View paramView, int paramInt, ItemSettingLayout paramItemSettingLayout, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramItemSettingLayout;
    this.d = paramTextView1;
    this.f = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityTrvSetFrostProtectionBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */