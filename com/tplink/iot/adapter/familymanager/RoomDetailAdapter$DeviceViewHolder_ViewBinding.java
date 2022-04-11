package com.tplink.iot.adapter.familymanager;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;

public class RoomDetailAdapter$DeviceViewHolder_ViewBinding
  implements Unbinder
{
  private RoomDetailAdapter.DeviceViewHolder b;
  
  @UiThread
  public RoomDetailAdapter$DeviceViewHolder_ViewBinding(RoomDetailAdapter.DeviceViewHolder paramDeviceViewHolder, View paramView)
  {
    this.b = paramDeviceViewHolder;
    paramDeviceViewHolder.mDeviceImageIv = ((ImageView)c.d(paramView, 2131363028, "field 'mDeviceImageIv'", ImageView.class));
    paramDeviceViewHolder.mDeviceCategoryTv = ((TextView)c.d(paramView, 2131364407, "field 'mDeviceCategoryTv'", TextView.class));
    paramDeviceViewHolder.mDeviceDeleteIv = ((ImageView)c.d(paramView, 2131363030, "field 'mDeviceDeleteIv'", ImageView.class));
  }
  
  @CallSuper
  public void a()
  {
    RoomDetailAdapter.DeviceViewHolder localDeviceViewHolder = this.b;
    if (localDeviceViewHolder != null)
    {
      this.b = null;
      localDeviceViewHolder.mDeviceImageIv = null;
      localDeviceViewHolder.mDeviceCategoryTv = null;
      localDeviceViewHolder.mDeviceDeleteIv = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\familymanager\RoomDetailAdapter$DeviceViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */