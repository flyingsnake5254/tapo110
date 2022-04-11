package com.tplink.iot.adapter.familymanager;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;

public class RoomDetailAdapter$GroupViewHolder_ViewBinding
  implements Unbinder
{
  private RoomDetailAdapter.GroupViewHolder b;
  
  @UiThread
  public RoomDetailAdapter$GroupViewHolder_ViewBinding(RoomDetailAdapter.GroupViewHolder paramGroupViewHolder, View paramView)
  {
    this.b = paramGroupViewHolder;
    paramGroupViewHolder.mDeviceImageIv = ((ImageView)c.d(paramView, 2131363028, "field 'mDeviceImageIv'", ImageView.class));
    paramGroupViewHolder.mDeviceCategoryTv = ((TextView)c.d(paramView, 2131364407, "field 'mDeviceCategoryTv'", TextView.class));
    paramGroupViewHolder.mDeviceDeleteIv = ((ImageView)c.d(paramView, 2131363030, "field 'mDeviceDeleteIv'", ImageView.class));
  }
  
  @CallSuper
  public void a()
  {
    RoomDetailAdapter.GroupViewHolder localGroupViewHolder = this.b;
    if (localGroupViewHolder != null)
    {
      this.b = null;
      localGroupViewHolder.mDeviceImageIv = null;
      localGroupViewHolder.mDeviceCategoryTv = null;
      localGroupViewHolder.mDeviceDeleteIv = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\familymanager\RoomDetailAdapter$GroupViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */