package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.iotsensor.SensorSettingViewModel;
import com.tplink.iot.widget.ItemSettingLayout;

public abstract class ActivitySensorSettingsBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView H3;
  @NonNull
  public final ImageView I3;
  @NonNull
  public final ImageView J3;
  @NonNull
  public final ImageView K3;
  @Bindable
  protected View.OnClickListener L3;
  @Bindable
  protected SensorSettingViewModel M3;
  @NonNull
  public final Button c;
  @NonNull
  public final ConstraintLayout d;
  @NonNull
  public final RelativeLayout f;
  @NonNull
  public final RelativeLayout p0;
  @NonNull
  public final ItemSettingLayout p1;
  @NonNull
  public final ItemSettingLayout p2;
  @NonNull
  public final LinearLayout p3;
  @NonNull
  public final ItemSettingLayout q;
  @NonNull
  public final TextView x;
  @NonNull
  public final ItemSettingLayout y;
  @NonNull
  public final ItemSettingLayout z;
  
  protected ActivitySensorSettingsBinding(Object paramObject, View paramView, int paramInt, Button paramButton, ConstraintLayout paramConstraintLayout, RelativeLayout paramRelativeLayout1, ItemSettingLayout paramItemSettingLayout1, TextView paramTextView, ItemSettingLayout paramItemSettingLayout2, ItemSettingLayout paramItemSettingLayout3, RelativeLayout paramRelativeLayout2, ItemSettingLayout paramItemSettingLayout4, ItemSettingLayout paramItemSettingLayout5, LinearLayout paramLinearLayout, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, ImageView paramImageView4)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton;
    this.d = paramConstraintLayout;
    this.f = paramRelativeLayout1;
    this.q = paramItemSettingLayout1;
    this.x = paramTextView;
    this.y = paramItemSettingLayout2;
    this.z = paramItemSettingLayout3;
    this.p0 = paramRelativeLayout2;
    this.p1 = paramItemSettingLayout4;
    this.p2 = paramItemSettingLayout5;
    this.p3 = paramLinearLayout;
    this.H3 = paramImageView1;
    this.I3 = paramImageView2;
    this.J3 = paramImageView3;
    this.K3 = paramImageView4;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable SensorSettingViewModel paramSensorSettingViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySensorSettingsBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */