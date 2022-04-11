package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.viewgroup.ItemInfoLayout;

public abstract class ItemFeaturedActionChooseBinding
  extends ViewDataBinding
{
  @NonNull
  public final ItemInfoLayout c;
  
  protected ItemFeaturedActionChooseBinding(Object paramObject, View paramView, int paramInt, ItemInfoLayout paramItemInfoLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramItemInfoLayout;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemFeaturedActionChooseBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */