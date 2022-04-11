package com.tplink.iot.adapter.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.tplink.iot.view.home.alldevice.RoomDevicesFragment;
import java.util.ArrayList;
import java.util.List;

public class RoomPagerAdapter
  extends FragmentStatePagerAdapter
{
  private List<RoomDevicesFragment> a = new ArrayList();
  private List<String> b = new ArrayList();
  
  public RoomPagerAdapter(FragmentManager paramFragmentManager, List<RoomDevicesFragment> paramList, List<String> paramList1)
  {
    super(paramFragmentManager);
    b(paramList, paramList1);
  }
  
  private void b(List<RoomDevicesFragment> paramList, List<String> paramList1)
  {
    this.a.clear();
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.a.addAll(paramList);
    }
    this.b.clear();
    if ((paramList1 != null) && (!paramList1.isEmpty())) {
      this.b.addAll(paramList1);
    }
  }
  
  @NonNull
  public RoomDevicesFragment a(int paramInt)
  {
    if (paramInt < getCount()) {
      return (RoomDevicesFragment)this.a.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public int getItemPosition(@NonNull Object paramObject)
  {
    return -2;
  }
  
  @Nullable
  public CharSequence getPageTitle(int paramInt)
  {
    return (CharSequence)this.b.get(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\home\RoomPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */