package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import net.lucode.hackware.magicindicator.MagicIndicator;

public abstract class FragmentOperationShellBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final Guideline d;
  @NonNull
  public final Guideline f;
  @NonNull
  public final MagicIndicator q;
  @NonNull
  public final ImageView x;
  @NonNull
  public final ViewPager y;
  @Bindable
  protected MutableLiveData<Boolean> z;
  
  protected FragmentOperationShellBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, Guideline paramGuideline1, Guideline paramGuideline2, MagicIndicator paramMagicIndicator, ImageView paramImageView2, ViewPager paramViewPager)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramGuideline1;
    this.f = paramGuideline2;
    this.q = paramMagicIndicator;
    this.x = paramImageView2;
    this.y = paramViewPager;
  }
  
  public abstract void h(@Nullable MutableLiveData<Boolean> paramMutableLiveData);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentOperationShellBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */