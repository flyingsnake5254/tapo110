package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.viewgroup.ItemInfoLayout;

public abstract class FragmentButtonFeaturedActionsGuideBinding
  extends ViewDataBinding
{
  @NonNull
  public final ItemInfoLayout c;
  @NonNull
  public final ItemInfoLayout d;
  @NonNull
  public final ItemInfoLayout f;
  @NonNull
  public final ItemInfoLayout q;
  @NonNull
  public final ItemInfoLayout x;
  @Bindable
  protected View.OnClickListener y;
  
  protected FragmentButtonFeaturedActionsGuideBinding(Object paramObject, View paramView, int paramInt, ItemInfoLayout paramItemInfoLayout1, ItemInfoLayout paramItemInfoLayout2, ItemInfoLayout paramItemInfoLayout3, ItemInfoLayout paramItemInfoLayout4, ItemInfoLayout paramItemInfoLayout5)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramItemInfoLayout1;
    this.d = paramItemInfoLayout2;
    this.f = paramItemInfoLayout3;
    this.q = paramItemInfoLayout4;
    this.x = paramItemInfoLayout5;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentButtonFeaturedActionsGuideBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */