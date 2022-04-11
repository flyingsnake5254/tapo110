package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraConnectRouterViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public abstract class FragmentCameraConnectRouterBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final RelativeLayout f;
  @NonNull
  public final TextView p0;
  @Bindable
  protected CameraConnectRouterViewModel p1;
  @Bindable
  protected CameraOnBoardingViewModel p2;
  @Bindable
  protected g p3;
  @NonNull
  public final TPRefreshableButton q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final Toolbar z;
  
  protected FragmentCameraConnectRouterBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, TextView paramTextView1, RelativeLayout paramRelativeLayout, TPRefreshableButton paramTPRefreshableButton, TextView paramTextView2, TextView paramTextView3, Toolbar paramToolbar, TextView paramTextView4)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramTextView1;
    this.f = paramRelativeLayout;
    this.q = paramTPRefreshableButton;
    this.x = paramTextView2;
    this.y = paramTextView3;
    this.z = paramToolbar;
    this.p0 = paramTextView4;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraConnectRouterBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */