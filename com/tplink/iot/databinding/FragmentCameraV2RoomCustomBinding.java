package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraRoomCustomViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.FlowTagLayout;

public abstract class FragmentCameraV2RoomCustomBinding
  extends ViewDataBinding
{
  @NonNull
  public final RelativeLayout c;
  @NonNull
  public final DrawableEditText d;
  @NonNull
  public final FlowTagLayout f;
  @Bindable
  protected CameraOnBoardingViewModel p0;
  @Bindable
  protected g p1;
  @NonNull
  public final Button q;
  @NonNull
  public final Toolbar x;
  @NonNull
  public final TextView y;
  @Bindable
  protected CameraRoomCustomViewModel z;
  
  protected FragmentCameraV2RoomCustomBinding(Object paramObject, View paramView, int paramInt, RelativeLayout paramRelativeLayout, DrawableEditText paramDrawableEditText, FlowTagLayout paramFlowTagLayout, Button paramButton, Toolbar paramToolbar, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramRelativeLayout;
    this.d = paramDrawableEditText;
    this.f = paramFlowTagLayout;
    this.q = paramButton;
    this.x = paramToolbar;
    this.y = paramTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2RoomCustomBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */