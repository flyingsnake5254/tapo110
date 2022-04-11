package com.tplink.iot.view.ipcamera.play.functionintroduce;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.List;

public class CameraIntroduceVideoPlayPager2Adapter
  extends FragmentStateAdapter
{
  private List<CameraIntroduceVideoPlayItemFragment> a;
  
  public CameraIntroduceVideoPlayPager2Adapter(@NonNull FragmentManager paramFragmentManager, @NonNull Lifecycle paramLifecycle, List<CameraIntroduceVideoPlayItemFragment> paramList)
  {
    super(paramFragmentManager, paramLifecycle);
    this.a = paramList;
  }
  
  @NonNull
  public Fragment createFragment(int paramInt)
  {
    return (Fragment)this.a.get(paramInt);
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\functionintroduce\CameraIntroduceVideoPlayPager2Adapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */