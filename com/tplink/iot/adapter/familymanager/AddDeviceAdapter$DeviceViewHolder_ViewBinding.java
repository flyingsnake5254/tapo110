package com.tplink.iot.adapter.familymanager;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;

public class AddDeviceAdapter$DeviceViewHolder_ViewBinding
  implements Unbinder
{
  private AddDeviceAdapter.DeviceViewHolder b;
  
  @UiThread
  public AddDeviceAdapter$DeviceViewHolder_ViewBinding(AddDeviceAdapter.DeviceViewHolder paramDeviceViewHolder, View paramView)
  {
    this.b = paramDeviceViewHolder;
    paramDeviceViewHolder.mDeviceItem = c.c(paramView, 2131362905, "field 'mDeviceItem'");
    paramDeviceViewHolder.mDeviceImageIv = ((ImageView)c.d(paramView, 2131363028, "field 'mDeviceImageIv'", ImageView.class));
    paramDeviceViewHolder.mDeviceCategoryTv = ((TextView)c.d(paramView, 2131364407, "field 'mDeviceCategoryTv'", TextView.class));
    paramDeviceViewHolder.mDeviceOfRoomTv = ((TextView)c.d(paramView, 2131364412, "field 'mDeviceOfRoomTv'", TextView.class));
    paramDeviceViewHolder.mDeviceSelectIv = ((ImageView)c.d(paramView, 2131363030, "field 'mDeviceSelectIv'", ImageView.class));
  }
  
  @CallSuper
  public void a()
  {
    AddDeviceAdapter.DeviceViewHolder localDeviceViewHolder = this.b;
    if (localDeviceViewHolder != null)
    {
      this.b = null;
      localDeviceViewHolder.mDeviceItem = null;
      localDeviceViewHolder.mDeviceImageIv = null;
      localDeviceViewHolder.mDeviceCategoryTv = null;
      localDeviceViewHolder.mDeviceOfRoomTv = null;
      localDeviceViewHolder.mDeviceSelectIv = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\familymanager\AddDeviceAdapter$DeviceViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */