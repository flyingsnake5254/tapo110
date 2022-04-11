package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraTroubleShootingViewModel;

public abstract class FragmentCameraV2TroubleShootingBinding
  extends ViewDataBinding
{
  @NonNull
  public final Button c;
  @NonNull
  public final FrameLayout d;
  @NonNull
  public final FrameLayout f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final Toolbar p1;
  @Bindable
  protected CameraTroubleShootingViewModel p2;
  @Bindable
  protected g p3;
  @NonNull
  public final RelativeLayout q;
  @NonNull
  public final LinearLayout x;
  @NonNull
  public final LinearLayout y;
  @NonNull
  public final TextView z;
  
  protected FragmentCameraV2TroubleShootingBinding(Object paramObject, View paramView, int paramInt, Button paramButton, FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, TextView paramTextView1, TextView paramTextView2, Toolbar paramToolbar)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton;
    this.d = paramFrameLayout1;
    this.f = paramFrameLayout2;
    this.q = paramRelativeLayout;
    this.x = paramLinearLayout1;
    this.y = paramLinearLayout2;
    this.z = paramTextView1;
    this.p0 = paramTextView2;
    this.p1 = paramToolbar;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2TroubleShootingBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */