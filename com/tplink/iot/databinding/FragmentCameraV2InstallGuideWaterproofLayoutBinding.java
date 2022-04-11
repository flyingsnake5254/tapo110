package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstallGuideViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

public abstract class FragmentCameraV2InstallGuideWaterproofLayoutBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final LinearLayout f;
  @Bindable
  protected CameraInstallGuideViewModel p0;
  @Bindable
  protected CameraOnBoardingViewModel p1;
  @Bindable
  protected g p2;
  @NonNull
  public final LinearLayout q;
  @NonNull
  public final LinearLayout x;
  @NonNull
  public final LinearLayout y;
  @NonNull
  public final LinearLayout z;
  
  protected FragmentCameraV2InstallGuideWaterproofLayoutBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, TextView paramTextView2, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, LinearLayout paramLinearLayout3, LinearLayout paramLinearLayout4, LinearLayout paramLinearLayout5)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramTextView2;
    this.f = paramLinearLayout1;
    this.q = paramLinearLayout2;
    this.x = paramLinearLayout3;
    this.y = paramLinearLayout4;
    this.z = paramLinearLayout5;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2InstallGuideWaterproofLayoutBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */