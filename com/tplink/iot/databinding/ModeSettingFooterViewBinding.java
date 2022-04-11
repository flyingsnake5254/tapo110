package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

public abstract class ModeSettingFooterViewBinding
  extends ViewDataBinding
{
  @NonNull
  public final View c;
  @NonNull
  public final LinearLayout d;
  
  protected ModeSettingFooterViewBinding(Object paramObject, View paramView1, int paramInt, View paramView2, LinearLayout paramLinearLayout)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramView2;
    this.d = paramLinearLayout;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ModeSettingFooterViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */