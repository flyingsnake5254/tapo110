package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityLightStripEffectsBinding
  extends ViewDataBinding
{
  @NonNull
  public final FrameLayout c;
  
  protected ActivityLightStripEffectsBinding(Object paramObject, View paramView, int paramInt, FrameLayout paramFrameLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramFrameLayout;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityLightStripEffectsBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */