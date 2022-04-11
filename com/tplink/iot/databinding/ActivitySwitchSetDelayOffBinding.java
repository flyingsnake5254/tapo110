package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.devices.switches.viewmodel.SwitchSetDelayOffViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

public abstract class ActivitySwitchSetDelayOffBinding
  extends ViewDataBinding
{
  @NonNull
  public final LinearLayout c;
  @NonNull
  public final RecyclerView d;
  @NonNull
  public final TPSwitchCompat f;
  @Bindable
  protected SwitchSetDelayOffViewModel q;
  
  protected ActivitySwitchSetDelayOffBinding(Object paramObject, View paramView, int paramInt, LinearLayout paramLinearLayout, RecyclerView paramRecyclerView, TPSwitchCompat paramTPSwitchCompat)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramLinearLayout;
    this.d = paramRecyclerView;
    this.f = paramTPSwitchCompat;
  }
  
  public abstract void h(@Nullable SwitchSetDelayOffViewModel paramSwitchSetDelayOffViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySwitchSetDelayOffBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */