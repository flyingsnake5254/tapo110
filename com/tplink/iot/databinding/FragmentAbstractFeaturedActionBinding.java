package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class FragmentAbstractFeaturedActionBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final RecyclerView d;
  @NonNull
  public final TextView f;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  
  protected FragmentAbstractFeaturedActionBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, RecyclerView paramRecyclerView, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramRecyclerView;
    this.f = paramTextView1;
    this.q = paramTextView2;
    this.x = paramTextView3;
    this.y = paramTextView4;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentAbstractFeaturedActionBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */