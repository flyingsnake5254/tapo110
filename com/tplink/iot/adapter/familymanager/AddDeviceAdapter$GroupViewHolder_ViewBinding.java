package com.tplink.iot.adapter.familymanager;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;

public class AddDeviceAdapter$GroupViewHolder_ViewBinding
  implements Unbinder
{
  private AddDeviceAdapter.GroupViewHolder b;
  
  @UiThread
  public AddDeviceAdapter$GroupViewHolder_ViewBinding(AddDeviceAdapter.GroupViewHolder paramGroupViewHolder, View paramView)
  {
    this.b = paramGroupViewHolder;
    paramGroupViewHolder.mDeviceItem = c.c(paramView, 2131362905, "field 'mDeviceItem'");
    paramGroupViewHolder.mDeviceImageIv = ((ImageView)c.d(paramView, 2131363028, "field 'mDeviceImageIv'", ImageView.class));
    paramGroupViewHolder.mDeviceCategoryTv = ((TextView)c.d(paramView, 2131364407, "field 'mDeviceCategoryTv'", TextView.class));
    paramGroupViewHolder.mDeviceOfRoomTv = ((TextView)c.d(paramView, 2131364412, "field 'mDeviceOfRoomTv'", TextView.class));
    paramGroupViewHolder.mDeviceSelectIv = ((ImageView)c.d(paramView, 2131363030, "field 'mDeviceSelectIv'", ImageView.class));
  }
  
  @CallSuper
  public void a()
  {
    AddDeviceAdapter.GroupViewHolder localGroupViewHolder = this.b;
    if (localGroupViewHolder != null)
    {
      this.b = null;
      localGroupViewHolder.mDeviceItem = null;
      localGroupViewHolder.mDeviceImageIv = null;
      localGroupViewHolder.mDeviceCategoryTv = null;
      localGroupViewHolder.mDeviceOfRoomTv = null;
      localGroupViewHolder.mDeviceSelectIv = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\familymanager\AddDeviceAdapter$GroupViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */