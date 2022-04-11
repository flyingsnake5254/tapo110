package com.tplink.iot.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.devices.lightstrip.widget.AutoLightFeaturePointView;

public abstract class LayoutLightingEffectPresetBinding
  extends ViewDataBinding
{
  @NonNull
  public final AutoLightFeaturePointView c;
  @NonNull
  public final RelativeLayout d;
  @NonNull
  public final RecyclerView f;
  
  protected LayoutLightingEffectPresetBinding(Object paramObject, View paramView, int paramInt, AutoLightFeaturePointView paramAutoLightFeaturePointView, RelativeLayout paramRelativeLayout, RecyclerView paramRecyclerView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramAutoLightFeaturePointView;
    this.d = paramRelativeLayout;
    this.f = paramRecyclerView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutLightingEffectPresetBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */