package com.tplink.iot.adapter.quicksetup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.List;

public class QsFragmentStatePagerAdapter
  extends FragmentStatePagerAdapter
{
  private List<Fragment> a;
  
  public int getCount()
  {
    List localList = this.a;
    int i;
    if (localList != null) {
      i = localList.size();
    } else {
      i = 0;
    }
    return i;
  }
  
  public Fragment getItem(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = (Fragment)((List)localObject).get(paramInt);
    } else {
      localObject = null;
    }
    return (Fragment)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\quicksetup\QsFragmentStatePagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */