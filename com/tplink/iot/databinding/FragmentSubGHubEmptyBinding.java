package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

public abstract class FragmentSubGHubEmptyBinding
  extends ViewDataBinding
{
  @NonNull
  public final FrameLayout c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final RecyclerView f;
  @Bindable
  protected SubGViewModel q;
  @Bindable
  protected g x;
  
  protected FragmentSubGHubEmptyBinding(Object paramObject, View paramView, int paramInt, FrameLayout paramFrameLayout, ImageView paramImageView, RecyclerView paramRecyclerView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramFrameLayout;
    this.d = paramImageView;
    this.f = paramRecyclerView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSubGHubEmptyBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */