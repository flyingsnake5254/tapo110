package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSSIDListViewModel;

public abstract class FragmentCameraV2SsidListBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final LinearLayout d;
  @NonNull
  public final RecyclerView f;
  @NonNull
  public final Toolbar q;
  @Bindable
  protected CameraSSIDListViewModel x;
  @Bindable
  protected CameraOnBoardingViewModel y;
  @Bindable
  protected g z;
  
  protected FragmentCameraV2SsidListBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView, LinearLayout paramLinearLayout, RecyclerView paramRecyclerView, Toolbar paramToolbar)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView;
    this.d = paramLinearLayout;
    this.f = paramRecyclerView;
    this.q = paramToolbar;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2SsidListBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */