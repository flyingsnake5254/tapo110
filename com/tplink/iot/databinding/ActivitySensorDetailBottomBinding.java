package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.iotsensor.SensorDetailViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.yinglan.scrolllayout.content.ContentScrollView;

public abstract class ActivitySensorDetailBottomBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView H3;
  @Bindable
  protected View.OnClickListener I3;
  @Bindable
  protected SensorDetailViewModel J3;
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final RelativeLayout p0;
  @NonNull
  public final ImageView p1;
  @NonNull
  public final RelativeLayout p2;
  @NonNull
  public final ContentScrollView p3;
  @NonNull
  public final View q;
  @NonNull
  public final TPSwitchCompat x;
  @NonNull
  public final RelativeLayout y;
  @NonNull
  public final RelativeLayout z;
  
  protected ActivitySensorDetailBottomBinding(Object paramObject, View paramView1, int paramInt, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, View paramView2, TPSwitchCompat paramTPSwitchCompat, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, RelativeLayout paramRelativeLayout3, ImageView paramImageView4, RelativeLayout paramRelativeLayout4, ContentScrollView paramContentScrollView, TextView paramTextView)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
    this.f = paramImageView3;
    this.q = paramView2;
    this.x = paramTPSwitchCompat;
    this.y = paramRelativeLayout1;
    this.z = paramRelativeLayout2;
    this.p0 = paramRelativeLayout3;
    this.p1 = paramImageView4;
    this.p2 = paramRelativeLayout4;
    this.p3 = paramContentScrollView;
    this.H3 = paramTextView;
  }
  
  public abstract void h(@Nullable SensorDetailViewModel paramSensorDetailViewModel);
  
  public abstract void i(@Nullable View.OnClickListener paramOnClickListener);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySensorDetailBottomBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */