package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.login.RegionListNewAdapter.c;
import com.tplink.iot.viewmodel.login.a;

public abstract class ItemRegionListContentBinding
  extends ViewDataBinding
{
  @Bindable
  protected a c;
  @Bindable
  protected RegionListNewAdapter.c d;
  
  protected ItemRegionListContentBinding(Object paramObject, View paramView, int paramInt)
  {
    super(paramObject, paramView, paramInt);
  }
  
  public abstract void h(@Nullable RegionListNewAdapter.c paramc);
  
  public abstract void i(@Nullable a parama);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemRegionListContentBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */