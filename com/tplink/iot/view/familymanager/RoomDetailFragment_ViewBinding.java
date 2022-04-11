package com.tplink.iot.view.familymanager;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;

public class RoomDetailFragment_ViewBinding
  implements Unbinder
{
  private RoomDetailFragment b;
  private View c;
  
  @UiThread
  public RoomDetailFragment_ViewBinding(final RoomDetailFragment paramRoomDetailFragment, View paramView)
  {
    this.b = paramRoomDetailFragment;
    paramRoomDetailFragment.mToolbar = ((Toolbar)c.d(paramView, 2131364275, "field 'mToolbar'", Toolbar.class));
    paramRoomDetailFragment.mToolbarTitle = ((TextView)c.d(paramView, 2131364290, "field 'mToolbarTitle'", TextView.class));
    paramRoomDetailFragment.mRoomDeviceListRecyclerView = ((RecyclerView)c.d(paramView, 2131363806, "field 'mRoomDeviceListRecyclerView'", RecyclerView.class));
    paramView = c.c(paramView, 2131362048, "field 'mDeleteRoomButton' and method 'deleteRoom'");
    paramRoomDetailFragment.mDeleteRoomButton = ((Button)c.b(paramView, 2131362048, "field 'mDeleteRoomButton'", Button.class));
    this.c = paramView;
    paramView.setOnClickListener(new a(paramRoomDetailFragment));
  }
  
  @CallSuper
  public void a()
  {
    RoomDetailFragment localRoomDetailFragment = this.b;
    if (localRoomDetailFragment != null)
    {
      this.b = null;
      localRoomDetailFragment.mToolbar = null;
      localRoomDetailFragment.mToolbarTitle = null;
      localRoomDetailFragment.mRoomDeviceListRecyclerView = null;
      localRoomDetailFragment.mDeleteRoomButton = null;
      this.c.setOnClickListener(null);
      this.c = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
  
  class a
    extends b
  {
    a(RoomDetailFragment paramRoomDetailFragment) {}
    
    public void a(View paramView)
    {
      paramRoomDetailFragment.deleteRoom();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\familymanager\RoomDetailFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */