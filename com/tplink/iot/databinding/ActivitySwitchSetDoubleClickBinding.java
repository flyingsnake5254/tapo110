package com.tplink.iot.databinding;

import android.view.View;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.switches.viewmodel.SwitchSetDoubleClickViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

public abstract class ActivitySwitchSetDoubleClickBinding
  extends ViewDataBinding
{
  @NonNull
  public final SeekBar c;
  @NonNull
  public final TPSwitchCompat d;
  @Bindable
  protected SwitchSetDoubleClickViewModel f;
  
  protected ActivitySwitchSetDoubleClickBinding(Object paramObject, View paramView, int paramInt, SeekBar paramSeekBar, TPSwitchCompat paramTPSwitchCompat)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramSeekBar;
    this.d = paramTPSwitchCompat;
  }
  
  public abstract void h(@Nullable SwitchSetDoubleClickViewModel paramSwitchSetDoubleClickViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySwitchSetDoubleClickBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */