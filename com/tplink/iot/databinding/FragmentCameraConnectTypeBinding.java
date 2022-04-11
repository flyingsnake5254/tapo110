package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraConnectTypeViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public abstract class FragmentCameraConnectTypeBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final RelativeLayout d;
  @NonNull
  public final LinearLayout f;
  @NonNull
  public final LinearLayout p0;
  @Bindable
  protected CameraConnectTypeViewModel p1;
  @Bindable
  protected CameraOnBoardingViewModel p2;
  @Bindable
  protected g p3;
  @NonNull
  public final TPRefreshableButton q;
  @NonNull
  public final TextView x;
  @NonNull
  public final Toolbar y;
  @NonNull
  public final LinearLayout z;
  
  protected FragmentCameraConnectTypeBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout1, TPRefreshableButton paramTPRefreshableButton, TextView paramTextView2, Toolbar paramToolbar, LinearLayout paramLinearLayout2, LinearLayout paramLinearLayout3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramRelativeLayout;
    this.f = paramLinearLayout1;
    this.q = paramTPRefreshableButton;
    this.x = paramTextView2;
    this.y = paramToolbar;
    this.z = paramLinearLayout2;
    this.p0 = paramLinearLayout3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraConnectTypeBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */