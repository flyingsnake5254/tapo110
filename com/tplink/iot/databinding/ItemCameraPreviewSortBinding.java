package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.adapter.databinding.f;

public abstract class ItemCameraPreviewSortBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final TextView f;
  @Bindable
  protected String p0;
  @Bindable
  protected RecyclerView.ViewHolder p1;
  @Bindable
  protected f p2;
  @NonNull
  public final ImageView q;
  @Bindable
  protected Integer x;
  @Bindable
  protected String y;
  @Bindable
  protected String z;
  
  protected ItemCameraPreviewSortBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramTextView1;
    this.f = paramTextView2;
    this.q = paramImageView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemCameraPreviewSortBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */