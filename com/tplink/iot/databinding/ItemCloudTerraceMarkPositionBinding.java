package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

public abstract class ItemCloudTerraceMarkPositionBinding
  extends ViewDataBinding
{
  @NonNull
  public final View c;
  @NonNull
  public final View d;
  @NonNull
  public final TextView f;
  
  protected ItemCloudTerraceMarkPositionBinding(Object paramObject, View paramView1, int paramInt, View paramView2, View paramView3, TextView paramTextView)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramView2;
    this.d = paramView3;
    this.f = paramTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemCloudTerraceMarkPositionBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */