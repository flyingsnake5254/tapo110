package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraWifiListViewModel;

public abstract class FragmentCameraV2WifiListBinding
  extends ViewDataBinding
{
  @Bindable
  protected CameraOnBoardingViewModel H3;
  @Bindable
  protected g I3;
  @NonNull
  public final Button c;
  @NonNull
  public final Button d;
  @NonNull
  public final LinearLayout f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final TextView p1;
  @NonNull
  public final TextView p2;
  @Bindable
  protected CameraWifiListViewModel p3;
  @NonNull
  public final RecyclerView q;
  @NonNull
  public final Toolbar x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected FragmentCameraV2WifiListBinding(Object paramObject, View paramView, int paramInt, Button paramButton1, Button paramButton2, LinearLayout paramLinearLayout, RecyclerView paramRecyclerView, Toolbar paramToolbar, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton1;
    this.d = paramButton2;
    this.f = paramLinearLayout;
    this.q = paramRecyclerView;
    this.x = paramToolbar;
    this.y = paramTextView1;
    this.z = paramTextView2;
    this.p0 = paramTextView3;
    this.p1 = paramTextView4;
    this.p2 = paramTextView5;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2WifiListBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */