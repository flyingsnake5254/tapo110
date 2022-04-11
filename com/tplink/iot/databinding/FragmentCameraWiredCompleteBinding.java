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
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraWiredCompleteViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public abstract class FragmentCameraWiredCompleteBinding
  extends ViewDataBinding
{
  @NonNull
  public final TPRefreshableButton c;
  @NonNull
  public final Button d;
  @NonNull
  public final ImageView f;
  @Bindable
  protected CameraWiredCompleteViewModel p0;
  @Bindable
  protected CameraOnBoardingViewModel p1;
  @Bindable
  protected g p2;
  @NonNull
  public final TextView q;
  @NonNull
  public final RelativeLayout x;
  @NonNull
  public final TextView y;
  @NonNull
  public final Toolbar z;
  
  protected FragmentCameraWiredCompleteBinding(Object paramObject, View paramView, int paramInt, TPRefreshableButton paramTPRefreshableButton, Button paramButton, ImageView paramImageView, TextView paramTextView1, RelativeLayout paramRelativeLayout, TextView paramTextView2, Toolbar paramToolbar)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTPRefreshableButton;
    this.d = paramButton;
    this.f = paramImageView;
    this.q = paramTextView1;
    this.x = paramRelativeLayout;
    this.y = paramTextView2;
    this.z = paramToolbar;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraWiredCompleteBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */