package com.tplink.iot.adapter.familymanager;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;

public class RoomDetailAdapter$DeviceTitleViewHolder_ViewBinding
  implements Unbinder
{
  private RoomDetailAdapter.DeviceTitleViewHolder b;
  
  @UiThread
  public RoomDetailAdapter$DeviceTitleViewHolder_ViewBinding(RoomDetailAdapter.DeviceTitleViewHolder paramDeviceTitleViewHolder, View paramView)
  {
    this.b = paramDeviceTitleViewHolder;
    paramDeviceTitleViewHolder.mDeviceTitle = ((TextView)c.d(paramView, 2131364688, "field 'mDeviceTitle'", TextView.class));
  }
  
  @CallSuper
  public void a()
  {
    RoomDetailAdapter.DeviceTitleViewHolder localDeviceTitleViewHolder = this.b;
    if (localDeviceTitleViewHolder != null)
    {
      this.b = null;
      localDeviceTitleViewHolder.mDeviceTitle = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\familymanager\RoomDetailAdapter$DeviceTitleViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */