package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;

public abstract class ActivityFeaturedActionHostBinding
  extends ViewDataBinding
{
  @NonNull
  public final FragmentContainerView c;
  
  protected ActivityFeaturedActionHostBinding(Object paramObject, View paramView, int paramInt, FragmentContainerView paramFragmentContainerView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramFragmentContainerView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityFeaturedActionHostBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */