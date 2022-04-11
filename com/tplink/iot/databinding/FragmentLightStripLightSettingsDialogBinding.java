package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

public abstract class FragmentLightStripLightSettingsDialogBinding
  extends ViewDataBinding
{
  @NonNull
  public final TabLayout c;
  @NonNull
  public final ViewPager2 d;
  @NonNull
  public final FrameLayout f;
  @NonNull
  public final ImageView q;
  @NonNull
  public final ImageView x;
  @NonNull
  public final LinearLayout y;
  
  protected FragmentLightStripLightSettingsDialogBinding(Object paramObject, View paramView, int paramInt, TabLayout paramTabLayout, ViewPager2 paramViewPager2, FrameLayout paramFrameLayout, ImageView paramImageView1, ImageView paramImageView2, LinearLayout paramLinearLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTabLayout;
    this.d = paramViewPager2;
    this.f = paramFrameLayout;
    this.q = paramImageView1;
    this.x = paramImageView2;
    this.y = paramLinearLayout;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentLightStripLightSettingsDialogBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */