package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public abstract class ActivitySoftApCommonGuideBinding
  extends ViewDataBinding
{
  @NonNull
  public final TPRefreshableButton c;
  @NonNull
  public final FrameLayout d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final TextView p1;
  @Bindable
  protected View.OnClickListener p2;
  @NonNull
  public final ImageView q;
  @NonNull
  public final LottieAnimationView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected ActivitySoftApCommonGuideBinding(Object paramObject, View paramView, int paramInt, TPRefreshableButton paramTPRefreshableButton, FrameLayout paramFrameLayout, ImageView paramImageView1, ImageView paramImageView2, LottieAnimationView paramLottieAnimationView, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTPRefreshableButton;
    this.d = paramFrameLayout;
    this.f = paramImageView1;
    this.q = paramImageView2;
    this.x = paramLottieAnimationView;
    this.y = paramTextView1;
    this.z = paramTextView2;
    this.p0 = paramTextView3;
    this.p1 = paramTextView4;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySoftApCommonGuideBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */