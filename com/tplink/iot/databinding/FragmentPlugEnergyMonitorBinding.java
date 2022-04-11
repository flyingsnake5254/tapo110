package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

public abstract class FragmentPlugEnergyMonitorBinding
  extends ViewDataBinding
{
  @NonNull
  public final FrameLayout c;
  @NonNull
  public final TextView d;
  @NonNull
  public final TextView f;
  @NonNull
  public final TextView q;
  
  protected FragmentPlugEnergyMonitorBinding(Object paramObject, View paramView, int paramInt, FrameLayout paramFrameLayout, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramFrameLayout;
    this.d = paramTextView1;
    this.f = paramTextView2;
    this.q = paramTextView3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentPlugEnergyMonitorBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */