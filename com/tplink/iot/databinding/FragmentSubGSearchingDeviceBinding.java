package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.libtpcontrols.TPRippleBackground;

public abstract class FragmentSubGSearchingDeviceBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView H3;
  @NonNull
  public final RelativeLayout I3;
  @Bindable
  protected SubGViewModel J3;
  @Bindable
  protected g K3;
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final TPRippleBackground p0;
  @NonNull
  public final TPRippleBackground p1;
  @NonNull
  public final ImageView p2;
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
  
  protected FragmentSubGSearchingDeviceBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, ImageView paramImageView4, ImageView paramImageView5, ImageView paramImageView6, ImageView paramImageView7, TPRippleBackground paramTPRippleBackground1, TPRippleBackground paramTPRippleBackground2, ImageView paramImageView8, ImageView paramImageView9, TextView paramTextView, RelativeLayout paramRelativeLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
    this.f = paramImageView3;
    this.q = paramImageView4;
    this.x = paramImageView5;
    this.y = paramImageView6;
    this.z = paramImageView7;
    this.p0 = paramTPRippleBackground1;
    this.p1 = paramTPRippleBackground2;
    this.p2 = paramImageView8;
    this.p3 = paramImageView9;
    this.H3 = paramTextView;
    this.I3 = paramRelativeLayout;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSubGSearchingDeviceBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */