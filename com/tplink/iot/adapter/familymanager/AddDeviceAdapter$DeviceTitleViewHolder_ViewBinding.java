package com.tplink.iot.adapter.familymanager;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;

public class AddDeviceAdapter$DeviceTitleViewHolder_ViewBinding
  implements Unbinder
{
  private AddDeviceAdapter.DeviceTitleViewHolder b;
  
  @UiThread
  public AddDeviceAdapter$DeviceTitleViewHolder_ViewBinding(AddDeviceAdapter.DeviceTitleViewHolder paramDeviceTitleViewHolder, View paramView)
  {
    this.b = paramDeviceTitleViewHolder;
    paramDeviceTitleViewHolder.mDeviceTitleTv = ((TextView)c.d(paramView, 2131364688, "field 'mDeviceTitleTv'", TextView.class));
  }
  
  @CallSuper
  public void a()
  {
    AddDeviceAdapter.DeviceTitleViewHolder localDeviceTitleViewHolder = this.b;
    if (localDeviceTitleViewHolder != null)
    {
      this.b = null;
      localDeviceTitleViewHolder.mDeviceTitleTv = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\familymanager\AddDeviceAdapter$DeviceTitleViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */