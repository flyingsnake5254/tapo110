package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.annotation.NonNull;

public final class CircularRevealCompat
{
  @NonNull
  public static Animator createCircularReveal(@NonNull CircularRevealWidget paramCircularRevealWidget, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofObject(paramCircularRevealWidget, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo[] { new CircularRevealWidget.RevealInfo(paramFloat1, paramFloat2, paramFloat3) });
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = paramCircularRevealWidget.getRevealInfo();
      if (localObject != null)
      {
        float f = ((CircularRevealWidget.RevealInfo)localObject).radius;
        paramCircularRevealWidget = ViewAnimationUtils.createCircularReveal((View)paramCircularRevealWidget, (int)paramFloat1, (int)paramFloat2, f, paramFloat3);
        localObject = new AnimatorSet();
        ((AnimatorSet)localObject).playTogether(new Animator[] { localObjectAnimator, paramCircularRevealWidget });
        return (Animator)localObject;
      }
      throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }
    return localObjectAnimator;
  }
  
  @NonNull
  public static Animator createCircularReveal(CircularRevealWidget paramCircularRevealWidget, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofObject(paramCircularRevealWidget, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo[] { new CircularRevealWidget.RevealInfo(paramFloat1, paramFloat2, paramFloat3), new CircularRevealWidget.RevealInfo(paramFloat1, paramFloat2, paramFloat4) });
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramCircularRevealWidget = ViewAnimationUtils.createCircularReveal((View)paramCircularRevealWidget, (int)paramFloat1, (int)paramFloat2, paramFloat3, paramFloat4);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, paramCircularRevealWidget });
      return localAnimatorSet;
    }
    return localObjectAnimator;
  }
  
  @NonNull
  public static Animator.AnimatorListener createCircularRevealListener(@NonNull CircularRevealWidget paramCircularRevealWidget)
  {
    new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        this.val$view.destroyCircularRevealCache();
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        this.val$view.buildCircularRevealCache();
      }
    };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\circularreveal\CircularRevealCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */