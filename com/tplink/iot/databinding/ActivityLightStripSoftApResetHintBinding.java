package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;

public abstract class ActivityLightStripSoftApResetHintBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final LottieAnimationView f;
  @NonNull
  public final TextView q;
  
  protected ActivityLightStripSoftApResetHintBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, ImageView paramImageView2, LottieAnimationView paramLottieAnimationView, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
    this.f = paramLottieAnimationView;
    this.q = paramTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityLightStripSoftApResetHintBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */