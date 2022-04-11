package com.tplink.iot.adapter.familymanager;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;

public class FamilyListAdapter$HomeListViewHolder_ViewBinding
  implements Unbinder
{
  private FamilyListAdapter.HomeListViewHolder b;
  
  @UiThread
  public FamilyListAdapter$HomeListViewHolder_ViewBinding(FamilyListAdapter.HomeListViewHolder paramHomeListViewHolder, View paramView)
  {
    this.b = paramHomeListViewHolder;
    paramHomeListViewHolder.mHomeNameTv = ((TextView)c.d(paramView, 2131364486, "field 'mHomeNameTv'", TextView.class));
    paramHomeListViewHolder.mRoomNumbersTv = ((TextView)c.d(paramView, 2131364611, "field 'mRoomNumbersTv'", TextView.class));
    paramHomeListViewHolder.mDeviceNumbersTv = ((TextView)c.d(paramView, 2131364411, "field 'mDeviceNumbersTv'", TextView.class));
  }
  
  @CallSuper
  public void a()
  {
    FamilyListAdapter.HomeListViewHolder localHomeListViewHolder = this.b;
    if (localHomeListViewHolder != null)
    {
      this.b = null;
      localHomeListViewHolder.mHomeNameTv = null;
      localHomeListViewHolder.mRoomNumbersTv = null;
      localHomeListViewHolder.mDeviceNumbersTv = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\familymanager\FamilyListAdapter$HomeListViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */