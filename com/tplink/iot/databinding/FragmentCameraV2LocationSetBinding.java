package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraLocationSetViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

public abstract class FragmentCameraV2LocationSetBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final RelativeLayout d;
  @NonNull
  public final TextView f;
  @NonNull
  public final Toolbar p0;
  @Bindable
  protected CameraLocationSetViewModel p1;
  @Bindable
  protected CameraOnBoardingViewModel p2;
  @Bindable
  protected g p3;
  @NonNull
  public final RecyclerView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final Button z;
  
  protected FragmentCameraV2LocationSetBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, RelativeLayout paramRelativeLayout, TextView paramTextView1, RecyclerView paramRecyclerView, TextView paramTextView2, TextView paramTextView3, Button paramButton, Toolbar paramToolbar)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramRelativeLayout;
    this.f = paramTextView1;
    this.q = paramRecyclerView;
    this.x = paramTextView2;
    this.y = paramTextView3;
    this.z = paramButton;
    this.p0 = paramToolbar;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2LocationSetBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */