package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.login.a;

public abstract class ItemRegionListTitleBinding
  extends ViewDataBinding
{
  @Bindable
  protected a c;
  
  protected ItemRegionListTitleBinding(Object paramObject, View paramView, int paramInt)
  {
    super(paramObject, paramView, paramInt);
  }
  
  public abstract void h(@Nullable a parama);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemRegionListTitleBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */