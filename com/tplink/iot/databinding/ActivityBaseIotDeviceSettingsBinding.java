package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devicecommon.viewmodel.IoTSettingsBaseViewModel;
import com.tplink.iot.widget.ItemSettingLayout;

public abstract class ActivityBaseIotDeviceSettingsBinding
  extends ViewDataBinding
{
  @NonNull
  public final View H3;
  @NonNull
  public final ImageView I3;
  @NonNull
  public final ImageView J3;
  @NonNull
  public final ImageView K3;
  @Bindable
  protected View.OnClickListener L3;
  @Bindable
  protected IoTSettingsBaseViewModel M3;
  @NonNull
  public final Button c;
  @NonNull
  public final View d;
  @NonNull
  public final FrameLayout f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final ItemSettingLayout p1;
  @NonNull
  public final ItemSettingLayout p2;
  @NonNull
  public final LinearLayout p3;
  @NonNull
  public final FrameLayout q;
  @NonNull
  public final ConstraintLayout x;
  @NonNull
  public final RelativeLayout y;
  @NonNull
  public final ItemSettingLayout z;
  
  protected ActivityBaseIotDeviceSettingsBinding(Object paramObject, View paramView1, int paramInt, Button paramButton, View paramView2, FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2, ConstraintLayout paramConstraintLayout, RelativeLayout paramRelativeLayout, ItemSettingLayout paramItemSettingLayout1, TextView paramTextView, ItemSettingLayout paramItemSettingLayout2, ItemSettingLayout paramItemSettingLayout3, LinearLayout paramLinearLayout, View paramView3, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramButton;
    this.d = paramView2;
    this.f = paramFrameLayout1;
    this.q = paramFrameLayout2;
    this.x = paramConstraintLayout;
    this.y = paramRelativeLayout;
    this.z = paramItemSettingLayout1;
    this.p0 = paramTextView;
    this.p1 = paramItemSettingLayout2;
    this.p2 = paramItemSettingLayout3;
    this.p3 = paramLinearLayout;
    this.H3 = paramView3;
    this.I3 = paramImageView1;
    this.J3 = paramImageView2;
    this.K3 = paramImageView3;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable IoTSettingsBaseViewModel paramIoTSettingsBaseViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityBaseIotDeviceSettingsBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */