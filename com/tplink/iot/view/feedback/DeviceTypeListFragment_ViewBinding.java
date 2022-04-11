package com.tplink.iot.view.feedback;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.c;

public class DeviceTypeListFragment_ViewBinding
  implements Unbinder
{
  private DeviceTypeListFragment b;
  
  @UiThread
  public DeviceTypeListFragment_ViewBinding(DeviceTypeListFragment paramDeviceTypeListFragment, View paramView)
  {
    this.b = paramDeviceTypeListFragment;
    paramDeviceTypeListFragment.mToolbar = ((Toolbar)c.d(paramView, 2131364275, "field 'mToolbar'", Toolbar.class));
    paramDeviceTypeListFragment.mToolbarTitle = ((TextView)c.d(paramView, 2131364290, "field 'mToolbarTitle'", TextView.class));
    paramDeviceTypeListFragment.mDeviceTypeListRecyclerView = ((RecyclerView)c.d(paramView, 2131363803, "field 'mDeviceTypeListRecyclerView'", RecyclerView.class));
  }
  
  @CallSuper
  public void a()
  {
    DeviceTypeListFragment localDeviceTypeListFragment = this.b;
    if (localDeviceTypeListFragment != null)
    {
      this.b = null;
      localDeviceTypeListFragment.mToolbar = null;
      localDeviceTypeListFragment.mToolbarTitle = null;
      localDeviceTypeListFragment.mDeviceTypeListRecyclerView = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\feedback\DeviceTypeListFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */