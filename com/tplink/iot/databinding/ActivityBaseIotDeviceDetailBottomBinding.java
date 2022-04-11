package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.yinglan.scrolllayout.content.ContentScrollView;

public abstract class ActivityBaseIotDeviceDetailBottomBinding
  extends ViewDataBinding
{
  @Bindable
  protected View.OnClickListener H3;
  @Bindable
  protected IoTDetailBaseViewModel I3;
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final TPSwitchCompat f;
  @NonNull
  public final RelativeLayout p0;
  @NonNull
  public final ContentScrollView p1;
  @NonNull
  public final TextView p2;
  @NonNull
  public final View p3;
  @NonNull
  public final FrameLayout q;
  @NonNull
  public final RelativeLayout x;
  @NonNull
  public final RelativeLayout y;
  @NonNull
  public final ImageView z;
  
  protected ActivityBaseIotDeviceDetailBottomBinding(Object paramObject, View paramView1, int paramInt, ImageView paramImageView1, ImageView paramImageView2, TPSwitchCompat paramTPSwitchCompat, FrameLayout paramFrameLayout, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, ImageView paramImageView3, RelativeLayout paramRelativeLayout3, ContentScrollView paramContentScrollView, TextView paramTextView, View paramView2)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
    this.f = paramTPSwitchCompat;
    this.q = paramFrameLayout;
    this.x = paramRelativeLayout1;
    this.y = paramRelativeLayout2;
    this.z = paramImageView3;
    this.p0 = paramRelativeLayout3;
    this.p1 = paramContentScrollView;
    this.p2 = paramTextView;
    this.p3 = paramView2;
  }
  
  public abstract void h(@Nullable IoTDetailBaseViewModel paramIoTDetailBaseViewModel);
  
  public abstract void i(@Nullable View.OnClickListener paramOnClickListener);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityBaseIotDeviceDetailBottomBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */