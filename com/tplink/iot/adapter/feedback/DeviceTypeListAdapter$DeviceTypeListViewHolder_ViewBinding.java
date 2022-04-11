package com.tplink.iot.adapter.feedback;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;

public class DeviceTypeListAdapter$DeviceTypeListViewHolder_ViewBinding
  implements Unbinder
{
  private DeviceTypeListAdapter.DeviceTypeListViewHolder b;
  
  @UiThread
  public DeviceTypeListAdapter$DeviceTypeListViewHolder_ViewBinding(DeviceTypeListAdapter.DeviceTypeListViewHolder paramDeviceTypeListViewHolder, View paramView)
  {
    this.b = paramDeviceTypeListViewHolder;
    paramDeviceTypeListViewHolder.mDeviceTypeIv = ((ImageView)c.d(paramView, 2131363034, "field 'mDeviceTypeIv'", ImageView.class));
    paramDeviceTypeListViewHolder.mDeviceTypeNameTv = ((TextView)c.d(paramView, 2131364416, "field 'mDeviceTypeNameTv'", TextView.class));
  }
  
  @CallSuper
  public void a()
  {
    DeviceTypeListAdapter.DeviceTypeListViewHolder localDeviceTypeListViewHolder = this.b;
    if (localDeviceTypeListViewHolder != null)
    {
      this.b = null;
      localDeviceTypeListViewHolder.mDeviceTypeIv = null;
      localDeviceTypeListViewHolder.mDeviceTypeNameTv = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\feedback\DeviceTypeListAdapter$DeviceTypeListViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */