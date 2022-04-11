package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

public abstract class FragmentSubGHubListBinding
  extends ViewDataBinding
{
  @NonNull
  public final FrameLayout c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final LinearLayout f;
  @Bindable
  protected g p0;
  @NonNull
  public final RecyclerView q;
  @NonNull
  public final RecyclerView x;
  @NonNull
  public final TextView y;
  @Bindable
  protected SubGViewModel z;
  
  protected FragmentSubGHubListBinding(Object paramObject, View paramView, int paramInt, FrameLayout paramFrameLayout, ImageView paramImageView, LinearLayout paramLinearLayout, RecyclerView paramRecyclerView1, RecyclerView paramRecyclerView2, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramFrameLayout;
    this.d = paramImageView;
    this.f = paramLinearLayout;
    this.q = paramRecyclerView1;
    this.x = paramRecyclerView2;
    this.y = paramTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSubGHubListBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */