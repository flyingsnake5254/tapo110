package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ActivityDiscoveredDevicesBinding
  extends ViewDataBinding
{
  @NonNull
  public final RecyclerView c;
  
  protected ActivityDiscoveredDevicesBinding(Object paramObject, View paramView, int paramInt, RecyclerView paramRecyclerView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramRecyclerView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityDiscoveredDevicesBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */