package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

public abstract class ActivitySubGOnBoardingBinding
  extends ViewDataBinding
{
  @NonNull
  public final FrameLayout c;
  @Bindable
  protected SubGViewModel d;
  
  protected ActivitySubGOnBoardingBinding(Object paramObject, View paramView, int paramInt, FrameLayout paramFrameLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramFrameLayout;
  }
  
  public abstract void h(@Nullable SubGViewModel paramSubGViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySubGOnBoardingBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */