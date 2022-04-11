package com.tplink.iot.i;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.List;

public abstract interface a
{
  public abstract boolean d();
  
  public static class a
  {
    public static boolean a(Fragment paramFragment)
    {
      return c(paramFragment.getChildFragmentManager());
    }
    
    public static boolean b(FragmentActivity paramFragmentActivity)
    {
      return c(paramFragmentActivity.getSupportFragmentManager());
    }
    
    private static boolean c(FragmentManager paramFragmentManager)
    {
      List localList = paramFragmentManager.getFragments();
      if (localList == null) {
        return false;
      }
      for (int i = localList.size() - 1; i >= 0; i--) {
        if (d((Fragment)localList.get(i))) {
          return true;
        }
      }
      if (paramFragmentManager.getBackStackEntryCount() > 0)
      {
        paramFragmentManager.popBackStack();
        return true;
      }
      return false;
    }
    
    private static boolean d(Fragment paramFragment)
    {
      boolean bool;
      if ((paramFragment != null) && (paramFragment.isVisible()) && (paramFragment.getUserVisibleHint()) && ((paramFragment instanceof a)) && (((a)paramFragment).d())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */