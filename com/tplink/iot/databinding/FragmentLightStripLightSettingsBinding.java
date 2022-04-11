package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

public abstract class FragmentLightStripLightSettingsBinding
  extends ViewDataBinding
{
  @NonNull
  public final TabLayout c;
  @NonNull
  public final ViewPager2 d;
  
  protected FragmentLightStripLightSettingsBinding(Object paramObject, View paramView, int paramInt, TabLayout paramTabLayout, ViewPager2 paramViewPager2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTabLayout;
    this.d = paramViewPager2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentLightStripLightSettingsBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */