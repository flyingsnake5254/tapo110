package com.tplink.iot.devicecommon.feature;

import android.view.View;
import androidx.annotation.RawRes;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import b.d.w.c.a;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class LottieAnimationViewFeature
  implements LifecycleObserver
{
  public static final a c = new a(null);
  private final LottieAnimationView d;
  
  private LottieAnimationViewFeature(LifecycleOwner paramLifecycleOwner, LottieAnimationView paramLottieAnimationView)
  {
    this.d = paramLottieAnimationView;
    paramLifecycleOwner.getLifecycle().addObserver(this);
  }
  
  public static final LottieAnimationViewFeature b(LifecycleOwner paramLifecycleOwner, LottieAnimationView paramLottieAnimationView, @RawRes int paramInt)
  {
    return c.a(paramLifecycleOwner, paramLottieAnimationView, paramInt);
  }
  
  private final void c()
  {
    try
    {
      LottieAnimationView localLottieAnimationView = this.d;
      localLottieAnimationView.setProgress(0.0F);
      localLottieAnimationView.o();
      localLottieAnimationView.setVisibility(0);
    }
    catch (Exception localException)
    {
      a.e("Lottie", "Load local json lottie anim error.");
    }
  }
  
  private final void d()
  {
    LottieAnimationView localLottieAnimationView = this.d;
    int i;
    if (localLottieAnimationView.getVisibility() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (!localLottieAnimationView.m())) {
      localLottieAnimationView.q();
    }
  }
  
  private final LottieAnimationViewFeature e(l<? super LottieAnimationView, p> paraml)
  {
    paraml.invoke(this.d);
    return this;
  }
  
  private final void f(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.d.g();
    } else {
      this.d.n();
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void onCreate()
  {
    c();
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroy()
  {
    f(true);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public final void onPause()
  {
    f(false);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onResume()
  {
    d();
  }
  
  public static final class a
  {
    public final LottieAnimationViewFeature a(LifecycleOwner paramLifecycleOwner, LottieAnimationView paramLottieAnimationView, @RawRes int paramInt)
    {
      j.e(paramLifecycleOwner, "owner");
      j.e(paramLottieAnimationView, "lottieAnimationView");
      return LottieAnimationViewFeature.a(new LottieAnimationViewFeature(paramLifecycleOwner, paramLottieAnimationView, null), new a(paramInt));
    }
    
    public final LottieAnimationViewFeature b(LifecycleOwner paramLifecycleOwner, LottieAnimationView paramLottieAnimationView, l<? super LottieAnimationView, p> paraml)
    {
      j.e(paramLifecycleOwner, "owner");
      j.e(paramLottieAnimationView, "lottieAnimationView");
      j.e(paraml, "setup");
      return LottieAnimationViewFeature.a(new LottieAnimationViewFeature(paramLifecycleOwner, paramLottieAnimationView, null), paraml);
    }
    
    static final class a
      extends Lambda
      implements l<LottieAnimationView, p>
    {
      a(int paramInt)
      {
        super();
      }
      
      public final void a(LottieAnimationView paramLottieAnimationView)
      {
        j.e(paramLottieAnimationView, "it");
        paramLottieAnimationView.setAnimation(this.c);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\feature\LottieAnimationViewFeature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */