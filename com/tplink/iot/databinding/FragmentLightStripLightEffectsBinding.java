package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class FragmentLightStripLightEffectsBinding
  extends ViewDataBinding
{
  @NonNull
  public final RecyclerView c;
  @NonNull
  public final RecyclerView d;
  @NonNull
  public final RecyclerView f;
  @NonNull
  public final RecyclerView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  
  protected FragmentLightStripLightEffectsBinding(Object paramObject, View paramView, int paramInt, RecyclerView paramRecyclerView1, RecyclerView paramRecyclerView2, RecyclerView paramRecyclerView3, RecyclerView paramRecyclerView4, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramRecyclerView1;
    this.d = paramRecyclerView2;
    this.f = paramRecyclerView3;
    this.q = paramRecyclerView4;
    this.x = paramTextView1;
    this.y = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentLightStripLightEffectsBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */