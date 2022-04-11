package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraRoomSelectViewModel;

public abstract class FragmentCameraV2RoomSelectBinding
  extends ViewDataBinding
{
  @NonNull
  public final RelativeLayout c;
  @NonNull
  public final RecyclerView d;
  @NonNull
  public final TextView f;
  @Bindable
  protected g p0;
  @NonNull
  public final Button q;
  @NonNull
  public final Toolbar x;
  @Bindable
  protected CameraRoomSelectViewModel y;
  @Bindable
  protected CameraOnBoardingViewModel z;
  
  protected FragmentCameraV2RoomSelectBinding(Object paramObject, View paramView, int paramInt, RelativeLayout paramRelativeLayout, RecyclerView paramRecyclerView, TextView paramTextView, Button paramButton, Toolbar paramToolbar)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramRelativeLayout;
    this.d = paramRecyclerView;
    this.f = paramTextView;
    this.q = paramButton;
    this.x = paramToolbar;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2RoomSelectBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */