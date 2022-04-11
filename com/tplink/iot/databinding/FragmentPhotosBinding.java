package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;

public abstract class FragmentPhotosBinding
  extends ViewDataBinding
{
  @NonNull
  public final View c;
  @NonNull
  public final RelativeLayout d;
  @NonNull
  public final CollapsingToolbarLayout f;
  @Bindable
  protected g p0;
  @Bindable
  protected MemoriesViewModel p1;
  @NonNull
  public final RecyclerView q;
  @NonNull
  public final CameraLoadingView x;
  @NonNull
  public final ImageView y;
  @NonNull
  public final DialogMemoryBottomOperationBinding z;
  
  protected FragmentPhotosBinding(Object paramObject, View paramView1, int paramInt, View paramView2, RelativeLayout paramRelativeLayout, CollapsingToolbarLayout paramCollapsingToolbarLayout, RecyclerView paramRecyclerView, CameraLoadingView paramCameraLoadingView, ImageView paramImageView, DialogMemoryBottomOperationBinding paramDialogMemoryBottomOperationBinding)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramView2;
    this.d = paramRelativeLayout;
    this.f = paramCollapsingToolbarLayout;
    this.q = paramRecyclerView;
    this.x = paramCameraLoadingView;
    this.y = paramImageView;
    this.z = paramDialogMemoryBottomOperationBinding;
  }
  
  public abstract void h(@Nullable MemoriesViewModel paramMemoriesViewModel);
  
  public abstract void i(@Nullable g paramg);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentPhotosBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */