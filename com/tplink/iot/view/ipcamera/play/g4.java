package com.tplink.iot.view.ipcamera.play;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import kotlin.jvm.internal.j;

final class g4
  extends FragmentPagerAdapter
{
  private final ArrayList<Fragment> a;
  private final ArrayList<String> b;
  
  public g4(ArrayList<Fragment> paramArrayList, ArrayList<String> paramArrayList1, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
    this.a = paramArrayList;
    this.b = paramArrayList1;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    Object localObject = this.a.get(paramInt);
    j.d(localObject, "fragments[position]");
    return (Fragment)localObject;
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return (CharSequence)this.b.get(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\g4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */