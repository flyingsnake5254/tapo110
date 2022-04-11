package com.airbnb.lottie.v;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class a
  extends ValueAnimator
{
  private final Set<ValueAnimator.AnimatorUpdateListener> c = new CopyOnWriteArraySet();
  private final Set<Animator.AnimatorListener> d = new CopyOnWriteArraySet();
  
  void a()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((Animator.AnimatorListener)localIterator.next()).onAnimationCancel(this);
    }
  }
  
  public void addListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.d.add(paramAnimatorListener);
  }
  
  public void addUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.c.add(paramAnimatorUpdateListener);
  }
  
  void b(boolean paramBoolean)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)localIterator.next();
      if (Build.VERSION.SDK_INT >= 26) {
        localAnimatorListener.onAnimationEnd(this, paramBoolean);
      } else {
        localAnimatorListener.onAnimationEnd(this);
      }
    }
  }
  
  void c()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((Animator.AnimatorListener)localIterator.next()).onAnimationRepeat(this);
    }
  }
  
  void d(boolean paramBoolean)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)localIterator.next();
      if (Build.VERSION.SDK_INT >= 26) {
        localAnimatorListener.onAnimationStart(this, paramBoolean);
      } else {
        localAnimatorListener.onAnimationStart(this);
      }
    }
  }
  
  void e()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((ValueAnimator.AnimatorUpdateListener)localIterator.next()).onAnimationUpdate(this);
    }
  }
  
  public long getStartDelay()
  {
    throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
  }
  
  public void removeAllListeners()
  {
    this.d.clear();
  }
  
  public void removeAllUpdateListeners()
  {
    this.c.clear();
  }
  
  public void removeListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.d.remove(paramAnimatorListener);
  }
  
  public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.c.remove(paramAnimatorUpdateListener);
  }
  
  public ValueAnimator setDuration(long paramLong)
  {
    throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
  }
  
  public void setInterpolator(TimeInterpolator paramTimeInterpolator)
  {
    throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
  }
  
  public void setStartDelay(long paramLong)
  {
    throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\v\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */