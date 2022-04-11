package com.tplink.iot.adapter.notification;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.SwitchCompat;
import butterknife.Unbinder;
import butterknife.internal.c;

public class MotionDetectionAdapter$MotionDeviceViewHolder_ViewBinding
  implements Unbinder
{
  private MotionDetectionAdapter.MotionDeviceViewHolder b;
  
  @UiThread
  public MotionDetectionAdapter$MotionDeviceViewHolder_ViewBinding(MotionDetectionAdapter.MotionDeviceViewHolder paramMotionDeviceViewHolder, View paramView)
  {
    this.b = paramMotionDeviceViewHolder;
    paramMotionDeviceViewHolder.mMotionDeviceNameTv = ((TextView)c.d(paramView, 2131364533, "field 'mMotionDeviceNameTv'", TextView.class));
    paramMotionDeviceViewHolder.mDeviceLocationTv = ((TextView)c.d(paramView, 2131364408, "field 'mDeviceLocationTv'", TextView.class));
    paramMotionDeviceViewHolder.mMotionSwitch = ((SwitchCompat)c.d(paramView, 2131363483, "field 'mMotionSwitch'", SwitchCompat.class));
  }
  
  @CallSuper
  public void a()
  {
    MotionDetectionAdapter.MotionDeviceViewHolder localMotionDeviceViewHolder = this.b;
    if (localMotionDeviceViewHolder != null)
    {
      this.b = null;
      localMotionDeviceViewHolder.mMotionDeviceNameTv = null;
      localMotionDeviceViewHolder.mDeviceLocationTv = null;
      localMotionDeviceViewHolder.mMotionSwitch = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\notification\MotionDetectionAdapter$MotionDeviceViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */