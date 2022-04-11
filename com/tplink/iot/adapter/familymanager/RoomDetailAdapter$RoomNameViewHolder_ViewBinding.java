package com.tplink.iot.adapter.familymanager;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;

public class RoomDetailAdapter$RoomNameViewHolder_ViewBinding
  implements Unbinder
{
  private RoomDetailAdapter.RoomNameViewHolder b;
  
  @UiThread
  public RoomDetailAdapter$RoomNameViewHolder_ViewBinding(RoomDetailAdapter.RoomNameViewHolder paramRoomNameViewHolder, View paramView)
  {
    this.b = paramRoomNameViewHolder;
    paramRoomNameViewHolder.mRoomTitleTv = ((TextView)c.d(paramView, 2131364483, "field 'mRoomTitleTv'", TextView.class));
    paramRoomNameViewHolder.mRoomNameTv = ((TextView)c.d(paramView, 2131364482, "field 'mRoomNameTv'", TextView.class));
  }
  
  @CallSuper
  public void a()
  {
    RoomDetailAdapter.RoomNameViewHolder localRoomNameViewHolder = this.b;
    if (localRoomNameViewHolder != null)
    {
      this.b = null;
      localRoomNameViewHolder.mRoomTitleTv = null;
      localRoomNameViewHolder.mRoomNameTv = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\familymanager\RoomDetailAdapter$RoomNameViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */