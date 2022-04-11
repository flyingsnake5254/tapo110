package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.libtpcontrols.TPHookView;
import com.tplink.libtpcontrols.TPRippleBackground;

public abstract class FragmentCameraWiredConnectingBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView H3;
  @NonNull
  public final ImageView I3;
  @NonNull
  public final TextView J3;
  @NonNull
  public final RelativeLayout K3;
  @Bindable
  protected g L3;
  @NonNull
  public final ImageView c;
  @NonNull
  public final TPHookView d;
  @NonNull
  public final TPHookView f;
  @NonNull
  public final ImageView p0;
  @NonNull
  public final TPRippleBackground p1;
  @NonNull
  public final TPRippleBackground p2;
  @NonNull
  public final ImageView p3;
  @NonNull
  public final ImageView q;
  @NonNull
  public final ImageView x;
  @NonNull
  public final ImageView y;
  @NonNull
  public final ImageView z;
  
  protected FragmentCameraWiredConnectingBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, TPHookView paramTPHookView1, TPHookView paramTPHookView2, ImageView paramImageView2, ImageView paramImageView3, ImageView paramImageView4, ImageView paramImageView5, ImageView paramImageView6, TPRippleBackground paramTPRippleBackground1, TPRippleBackground paramTPRippleBackground2, ImageView paramImageView7, ImageView paramImageView8, ImageView paramImageView9, TextView paramTextView, RelativeLayout paramRelativeLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramTPHookView1;
    this.f = paramTPHookView2;
    this.q = paramImageView2;
    this.x = paramImageView3;
    this.y = paramImageView4;
    this.z = paramImageView5;
    this.p0 = paramImageView6;
    this.p1 = paramTPRippleBackground1;
    this.p2 = paramTPRippleBackground2;
    this.p3 = paramImageView7;
    this.H3 = paramImageView8;
    this.I3 = paramImageView9;
    this.J3 = paramTextView;
    this.K3 = paramRelativeLayout;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraWiredConnectingBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */