package com.tplink.iot.view.notification;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.c;

public class TriggeredDeviceTypeActivity_ViewBinding
  implements Unbinder
{
  private TriggeredDeviceTypeActivity b;
  
  @UiThread
  public TriggeredDeviceTypeActivity_ViewBinding(TriggeredDeviceTypeActivity paramTriggeredDeviceTypeActivity, View paramView)
  {
    this.b = paramTriggeredDeviceTypeActivity;
    paramTriggeredDeviceTypeActivity.mToolbarTitle = ((TextView)c.d(paramView, 2131364290, "field 'mToolbarTitle'", TextView.class));
    paramTriggeredDeviceTypeActivity.mMotionDetectionDeviceRV = ((RecyclerView)c.d(paramView, 2131363805, "field 'mMotionDetectionDeviceRV'", RecyclerView.class));
    paramTriggeredDeviceTypeActivity.mNoMotionDeviceTv = ((TextView)c.d(paramView, 2131364550, "field 'mNoMotionDeviceTv'", TextView.class));
  }
  
  @CallSuper
  public void a()
  {
    TriggeredDeviceTypeActivity localTriggeredDeviceTypeActivity = this.b;
    if (localTriggeredDeviceTypeActivity != null)
    {
      this.b = null;
      localTriggeredDeviceTypeActivity.mToolbarTitle = null;
      localTriggeredDeviceTypeActivity.mMotionDetectionDeviceRV = null;
      localTriggeredDeviceTypeActivity.mNoMotionDeviceTv = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\notification\TriggeredDeviceTypeActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */