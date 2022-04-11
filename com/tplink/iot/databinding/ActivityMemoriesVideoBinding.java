package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;

public abstract class ActivityMemoriesVideoBinding
  extends ViewDataBinding
{
  @NonNull
  public final CameraLoadingView c;
  @NonNull
  public final RelativeLayout d;
  @NonNull
  public final Toolbar f;
  @NonNull
  public final DialogMemoryBottomOperationBinding p0;
  @Bindable
  protected g p1;
  @Bindable
  protected MemoriesViewModel p2;
  @NonNull
  public final AppBarLayout q;
  @NonNull
  public final TextView x;
  @NonNull
  public final FrameLayout y;
  @NonNull
  public final TextView z;
  
  protected ActivityMemoriesVideoBinding(Object paramObject, View paramView, int paramInt, CameraLoadingView paramCameraLoadingView, RelativeLayout paramRelativeLayout, Toolbar paramToolbar, AppBarLayout paramAppBarLayout, TextView paramTextView1, FrameLayout paramFrameLayout, TextView paramTextView2, DialogMemoryBottomOperationBinding paramDialogMemoryBottomOperationBinding)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramCameraLoadingView;
    this.d = paramRelativeLayout;
    this.f = paramToolbar;
    this.q = paramAppBarLayout;
    this.x = paramTextView1;
    this.y = paramFrameLayout;
    this.z = paramTextView2;
    this.p0 = paramDialogMemoryBottomOperationBinding;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityMemoriesVideoBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */