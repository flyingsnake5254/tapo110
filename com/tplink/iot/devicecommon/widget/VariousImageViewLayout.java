package com.tplink.iot.devicecommon.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.iot.databinding.LayoutVariousImageViewBinding;
import com.tplink.iot.devicecommon.feature.AnimationDrawableImageViewFeature;
import com.tplink.iot.devicecommon.feature.AnimationDrawableImageViewFeature.a;
import com.tplink.iot.devicecommon.feature.LottieAnimationViewFeature;
import com.tplink.iot.devicecommon.feature.LottieAnimationViewFeature.a;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class VariousImageViewLayout
  extends FrameLayout
{
  private final LayoutVariousImageViewBinding c;
  
  public VariousImageViewLayout(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public VariousImageViewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public VariousImageViewLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = DataBindingUtil.inflate(LayoutInflater.from(paramContext), 2131559243, this, true);
    j.d(paramContext, "DataBindingUtil.inflate(…s_image_view, this, true)");
    this.c = ((LayoutVariousImageViewBinding)paramContext);
  }
  
  private final void c()
  {
    Object localObject = this.c.c;
    j.d(localObject, "mBinding.imageView");
    ((View)localObject).setVisibility(0);
    localObject = this.c.d;
    j.d(localObject, "mBinding.lottieAnimationView");
    ((View)localObject).setVisibility(8);
  }
  
  private final void d()
  {
    Object localObject = this.c.c;
    j.d(localObject, "mBinding.imageView");
    ((View)localObject).setVisibility(8);
    localObject = this.c.d;
    j.d(localObject, "mBinding.lottieAnimationView");
    ((View)localObject).setVisibility(0);
  }
  
  public final void a(LifecycleOwner paramLifecycleOwner, @DrawableRes int paramInt)
  {
    j.e(paramLifecycleOwner, "lifecycleOwner");
    AnimationDrawableImageViewFeature.a locala = AnimationDrawableImageViewFeature.c;
    ImageView localImageView = this.c.c;
    j.d(localImageView, "mBinding.imageView");
    locala.a(paramLifecycleOwner, localImageView).b(paramInt);
    c();
  }
  
  public final void b(LifecycleOwner paramLifecycleOwner, l<? super LottieAnimationView, p> paraml)
  {
    j.e(paramLifecycleOwner, "lifecycleOwner");
    j.e(paraml, "setup");
    LottieAnimationViewFeature.a locala = LottieAnimationViewFeature.c;
    LottieAnimationView localLottieAnimationView = this.c.d;
    j.d(localLottieAnimationView, "mBinding.lottieAnimationView");
    locala.b(paramLifecycleOwner, localLottieAnimationView, paraml);
    d();
  }
  
  public final void setStaticImageDrawable(Drawable paramDrawable)
  {
    this.c.c.setImageDrawable(paramDrawable);
    c();
  }
  
  public final void setStaticImageResource(@DrawableRes int paramInt)
  {
    this.c.c.setImageResource(paramInt);
    c();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\widget\VariousImageViewLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */