package com.tplink.iot.devicecommon.feature;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.jvm.internal.j;

public final class AnimationDrawableImageViewFeature
  implements LifecycleObserver
{
  public static final a c = new a(null);
  private final LifecycleOwner d;
  private final ImageView f;
  
  private AnimationDrawableImageViewFeature(LifecycleOwner paramLifecycleOwner, ImageView paramImageView)
  {
    this.d = paramLifecycleOwner;
    this.f = paramImageView;
    paramLifecycleOwner.getLifecycle().addObserver(this);
  }
  
  public static final AnimationDrawableImageViewFeature a(LifecycleOwner paramLifecycleOwner, ImageView paramImageView)
  {
    return c.a(paramLifecycleOwner, paramImageView);
  }
  
  private final void c()
  {
    Drawable localDrawable = this.f.getDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof AnimationDrawable))) {
      ((AnimationDrawable)localDrawable).start();
    }
  }
  
  private final void d()
  {
    Lifecycle localLifecycle = this.d.getLifecycle();
    j.d(localLifecycle, "owner.lifecycle");
    if (localLifecycle.getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
      c();
    }
  }
  
  private final void e()
  {
    Drawable localDrawable = this.f.getDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof AnimationDrawable))) {
      ((AnimationDrawable)localDrawable).stop();
    }
  }
  
  public final void b(@DrawableRes int paramInt)
  {
    this.f.setImageResource(paramInt);
    d();
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void onCreate() {}
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public final void onPause()
  {
    e();
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onResume()
  {
    c();
  }
  
  public static final class a
  {
    public final AnimationDrawableImageViewFeature a(LifecycleOwner paramLifecycleOwner, ImageView paramImageView)
    {
      j.e(paramLifecycleOwner, "owner");
      j.e(paramImageView, "imageView");
      return new AnimationDrawableImageViewFeature(paramLifecycleOwner, paramImageView, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\feature\AnimationDrawableImageViewFeature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */