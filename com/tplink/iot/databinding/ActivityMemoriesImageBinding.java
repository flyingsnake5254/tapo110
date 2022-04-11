package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;
import uk.co.senab.photoview.PhotoView;

public abstract class ActivityMemoriesImageBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final CameraLoadingView d;
  @NonNull
  public final PhotoView f;
  @NonNull
  public final DialogMemoryBottomOperationBinding p0;
  @Bindable
  protected g p1;
  @Bindable
  protected MemoriesViewModel p2;
  @NonNull
  public final PhotoView q;
  @NonNull
  public final Toolbar x;
  @NonNull
  public final AppBarLayout y;
  @NonNull
  public final TextView z;
  
  protected ActivityMemoriesImageBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, CameraLoadingView paramCameraLoadingView, PhotoView paramPhotoView1, PhotoView paramPhotoView2, Toolbar paramToolbar, AppBarLayout paramAppBarLayout, TextView paramTextView, DialogMemoryBottomOperationBinding paramDialogMemoryBottomOperationBinding)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramCameraLoadingView;
    this.f = paramPhotoView1;
    this.q = paramPhotoView2;
    this.x = paramToolbar;
    this.y = paramAppBarLayout;
    this.z = paramTextView;
    this.p0 = paramDialogMemoryBottomOperationBinding;
  }
  
  public abstract void h(@Nullable MemoriesViewModel paramMemoriesViewModel);
  
  public abstract void i(@Nullable g paramg);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityMemoriesImageBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */