package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerraceControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.LensMaskViewModel;
import com.tplink.iot.viewmodel.ipcamera.setting.AdvancedSettingViewModel;
import com.tplink.iot.viewmodel.ipcamera.setting.DiagnoseSettingViewModel;
import com.tplink.iot.viewmodel.ipcamera.setting.LdcSettingViewModel;

public abstract class ActivityAdvancedSettingNewIpcBinding
  extends ViewDataBinding
{
  @NonNull
  public final RelativeLayout H3;
  @NonNull
  public final TextView I3;
  @NonNull
  public final FrameLayout J3;
  @NonNull
  public final TextView K3;
  @NonNull
  public final FrameLayout L3;
  @NonNull
  public final RelativeLayout M3;
  @NonNull
  public final TextView N3;
  @NonNull
  public final TextView O3;
  @NonNull
  public final RelativeLayout P3;
  @NonNull
  public final TextView Q3;
  @NonNull
  public final TextView R3;
  @NonNull
  public final TextView S3;
  @NonNull
  public final Toolbar T3;
  @NonNull
  public final TextView U3;
  @NonNull
  public final RelativeLayout V3;
  @NonNull
  public final TextView W3;
  @Bindable
  protected AdvancedSettingViewModel X3;
  @Bindable
  protected CloudTerraceControlViewModel Y3;
  @Bindable
  protected LensMaskViewModel Z3;
  @Bindable
  protected LdcSettingViewModel a4;
  @Bindable
  protected DiagnoseSettingViewModel b4;
  @NonNull
  public final TextView c;
  @Bindable
  protected View.OnClickListener c4;
  @NonNull
  public final RelativeLayout d;
  @NonNull
  public final TextView f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final RelativeLayout p1;
  @NonNull
  public final TextView p2;
  @NonNull
  public final TextView p3;
  @NonNull
  public final CameraLoadingView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final RelativeLayout y;
  @NonNull
  public final TextView z;
  
  protected ActivityAdvancedSettingNewIpcBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, RelativeLayout paramRelativeLayout1, TextView paramTextView2, CameraLoadingView paramCameraLoadingView, TextView paramTextView3, RelativeLayout paramRelativeLayout2, TextView paramTextView4, TextView paramTextView5, RelativeLayout paramRelativeLayout3, TextView paramTextView6, TextView paramTextView7, RelativeLayout paramRelativeLayout4, TextView paramTextView8, FrameLayout paramFrameLayout1, TextView paramTextView9, FrameLayout paramFrameLayout2, RelativeLayout paramRelativeLayout5, TextView paramTextView10, TextView paramTextView11, RelativeLayout paramRelativeLayout6, TextView paramTextView12, TextView paramTextView13, TextView paramTextView14, Toolbar paramToolbar, TextView paramTextView15, RelativeLayout paramRelativeLayout7, TextView paramTextView16)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramRelativeLayout1;
    this.f = paramTextView2;
    this.q = paramCameraLoadingView;
    this.x = paramTextView3;
    this.y = paramRelativeLayout2;
    this.z = paramTextView4;
    this.p0 = paramTextView5;
    this.p1 = paramRelativeLayout3;
    this.p2 = paramTextView6;
    this.p3 = paramTextView7;
    this.H3 = paramRelativeLayout4;
    this.I3 = paramTextView8;
    this.J3 = paramFrameLayout1;
    this.K3 = paramTextView9;
    this.L3 = paramFrameLayout2;
    this.M3 = paramRelativeLayout5;
    this.N3 = paramTextView10;
    this.O3 = paramTextView11;
    this.P3 = paramRelativeLayout6;
    this.Q3 = paramTextView12;
    this.R3 = paramTextView13;
    this.S3 = paramTextView14;
    this.T3 = paramToolbar;
    this.U3 = paramTextView15;
    this.V3 = paramRelativeLayout7;
    this.W3 = paramTextView16;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable CloudTerraceControlViewModel paramCloudTerraceControlViewModel);
  
  public abstract void l(@Nullable DiagnoseSettingViewModel paramDiagnoseSettingViewModel);
  
  public abstract void m(@Nullable LdcSettingViewModel paramLdcSettingViewModel);
  
  public abstract void n(@Nullable LensMaskViewModel paramLensMaskViewModel);
  
  public abstract void o(@Nullable AdvancedSettingViewModel paramAdvancedSettingViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityAdvancedSettingNewIpcBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */