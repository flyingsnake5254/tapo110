package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;

public abstract class LayoutVariousImageViewBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final LottieAnimationView d;
  
  protected LayoutVariousImageViewBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, LottieAnimationView paramLottieAnimationView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramLottieAnimationView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutVariousImageViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */