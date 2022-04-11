package com.tplink.iot.view.familymanager;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public class AddDeviceFragment_ViewBinding
  implements Unbinder
{
  private AddDeviceFragment b;
  private View c;
  
  @UiThread
  public AddDeviceFragment_ViewBinding(final AddDeviceFragment paramAddDeviceFragment, View paramView)
  {
    this.b = paramAddDeviceFragment;
    paramAddDeviceFragment.mToolbar = ((Toolbar)c.d(paramView, 2131364275, "field 'mToolbar'", Toolbar.class));
    paramAddDeviceFragment.mToolbarTitle = ((TextView)c.d(paramView, 2131364290, "field 'mToolbarTitle'", TextView.class));
    paramAddDeviceFragment.mAddDeviceRecyclerView = ((RecyclerView)c.d(paramView, 2131363800, "field 'mAddDeviceRecyclerView'", RecyclerView.class));
    View localView = c.c(paramView, 2131362032, "field 'mAddDeviceBtn' and method 'addDevices'");
    paramAddDeviceFragment.mAddDeviceBtn = ((TPRefreshableButton)c.b(localView, 2131362032, "field 'mAddDeviceBtn'", TPRefreshableButton.class));
    this.c = localView;
    localView.setOnClickListener(new a(paramAddDeviceFragment));
    paramAddDeviceFragment.mNoDeviceAddedTv = ((TextView)c.d(paramView, 2131364548, "field 'mNoDeviceAddedTv'", TextView.class));
  }
  
  @CallSuper
  public void a()
  {
    AddDeviceFragment localAddDeviceFragment = this.b;
    if (localAddDeviceFragment != null)
    {
      this.b = null;
      localAddDeviceFragment.mToolbar = null;
      localAddDeviceFragment.mToolbarTitle = null;
      localAddDeviceFragment.mAddDeviceRecyclerView = null;
      localAddDeviceFragment.mAddDeviceBtn = null;
      localAddDeviceFragment.mNoDeviceAddedTv = null;
      this.c.setOnClickListener(null);
      this.c = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
  
  class a
    extends b
  {
    a(AddDeviceFragment paramAddDeviceFragment) {}
    
    public void a(View paramView)
    {
      paramAddDeviceFragment.addDevices();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\familymanager\AddDeviceFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */