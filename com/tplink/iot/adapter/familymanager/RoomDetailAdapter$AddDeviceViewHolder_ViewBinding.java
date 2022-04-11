package com.tplink.iot.adapter.familymanager;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;

public class RoomDetailAdapter$AddDeviceViewHolder_ViewBinding
  implements Unbinder
{
  private RoomDetailAdapter.AddDeviceViewHolder b;
  
  @UiThread
  public RoomDetailAdapter$AddDeviceViewHolder_ViewBinding(RoomDetailAdapter.AddDeviceViewHolder paramAddDeviceViewHolder, View paramView)
  {
    this.b = paramAddDeviceViewHolder;
    paramAddDeviceViewHolder.mAddDeviceTv = ((TextView)c.d(paramView, 2131364334, "field 'mAddDeviceTv'", TextView.class));
  }
  
  @CallSuper
  public void a()
  {
    RoomDetailAdapter.AddDeviceViewHolder localAddDeviceViewHolder = this.b;
    if (localAddDeviceViewHolder != null)
    {
      this.b = null;
      localAddDeviceViewHolder.mAddDeviceTv = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\familymanager\RoomDetailAdapter$AddDeviceViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */