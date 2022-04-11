package com.github.mikephil.charting.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.annotation.RequiresApi;

public class ChartAnimator
{
  private ValueAnimator.AnimatorUpdateListener mListener;
  protected float mPhaseX = 1.0F;
  protected float mPhaseY = 1.0F;
  
  public ChartAnimator() {}
  
  @RequiresApi(11)
  public ChartAnimator(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.mListener = paramAnimatorUpdateListener;
  }
  
  @RequiresApi(11)
  private ObjectAnimator xAnimator(int paramInt, Easing.EasingFunction paramEasingFunction)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "phaseX", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setInterpolator(paramEasingFunction);
    localObjectAnimator.setDuration(paramInt);
    return localObjectAnimator;
  }
  
  @RequiresApi(11)
  private ObjectAnimator yAnimator(int paramInt, Easing.EasingFunction paramEasingFunction)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "phaseY", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setInterpolator(paramEasingFunction);
    localObjectAnimator.setDuration(paramInt);
    return localObjectAnimator;
  }
  
  @RequiresApi(11)
  public void animateX(int paramInt)
  {
    animateX(paramInt, Easing.Linear);
  }
  
  @RequiresApi(11)
  public void animateX(int paramInt, Easing.EasingFunction paramEasingFunction)
  {
    paramEasingFunction = xAnimator(paramInt, paramEasingFunction);
    paramEasingFunction.addUpdateListener(this.mListener);
    paramEasingFunction.start();
  }
  
  @RequiresApi(11)
  public void animateXY(int paramInt1, int paramInt2)
  {
    Easing.EasingFunction localEasingFunction = Easing.Linear;
    animateXY(paramInt1, paramInt2, localEasingFunction, localEasingFunction);
  }
  
  @RequiresApi(11)
  public void animateXY(int paramInt1, int paramInt2, Easing.EasingFunction paramEasingFunction)
  {
    ObjectAnimator localObjectAnimator = xAnimator(paramInt1, paramEasingFunction);
    paramEasingFunction = yAnimator(paramInt2, paramEasingFunction);
    if (paramInt1 > paramInt2) {
      localObjectAnimator.addUpdateListener(this.mListener);
    } else {
      paramEasingFunction.addUpdateListener(this.mListener);
    }
    localObjectAnimator.start();
    paramEasingFunction.start();
  }
  
  @RequiresApi(11)
  public void animateXY(int paramInt1, int paramInt2, Easing.EasingFunction paramEasingFunction1, Easing.EasingFunction paramEasingFunction2)
  {
    paramEasingFunction1 = xAnimator(paramInt1, paramEasingFunction1);
    paramEasingFunction2 = yAnimator(paramInt2, paramEasingFunction2);
    if (paramInt1 > paramInt2) {
      paramEasingFunction1.addUpdateListener(this.mListener);
    } else {
      paramEasingFunction2.addUpdateListener(this.mListener);
    }
    paramEasingFunction1.start();
    paramEasingFunction2.start();
  }
  
  @RequiresApi(11)
  public void animateY(int paramInt)
  {
    animateY(paramInt, Easing.Linear);
  }
  
  @RequiresApi(11)
  public void animateY(int paramInt, Easing.EasingFunction paramEasingFunction)
  {
    paramEasingFunction = yAnimator(paramInt, paramEasingFunction);
    paramEasingFunction.addUpdateListener(this.mListener);
    paramEasingFunction.start();
  }
  
  public float getPhaseX()
  {
    return this.mPhaseX;
  }
  
  public float getPhaseY()
  {
    return this.mPhaseY;
  }
  
  public void setPhaseX(float paramFloat)
  {
    float f;
    if (paramFloat > 1.0F)
    {
      f = 1.0F;
    }
    else
    {
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    this.mPhaseX = f;
  }
  
  public void setPhaseY(float paramFloat)
  {
    float f;
    if (paramFloat > 1.0F)
    {
      f = 1.0F;
    }
    else
    {
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
    }
    this.mPhaseY = f;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\animation\ChartAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */