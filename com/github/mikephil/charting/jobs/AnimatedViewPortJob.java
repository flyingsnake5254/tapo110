package com.github.mikephil.charting.jobs;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.view.View;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

@SuppressLint({"NewApi"})
public abstract class AnimatedViewPortJob
  extends ViewPortJob
  implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener
{
  protected ObjectAnimator animator;
  protected float phase;
  protected float xOrigin;
  protected float yOrigin;
  
  public AnimatedViewPortJob(ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Transformer paramTransformer, View paramView, float paramFloat3, float paramFloat4, long paramLong)
  {
    super(paramViewPortHandler, paramFloat1, paramFloat2, paramTransformer, paramView);
    this.xOrigin = paramFloat3;
    this.yOrigin = paramFloat4;
    paramViewPortHandler = ObjectAnimator.ofFloat(this, "phase", new float[] { 0.0F, 1.0F });
    this.animator = paramViewPortHandler;
    paramViewPortHandler.setDuration(paramLong);
    this.animator.addUpdateListener(this);
    this.animator.addListener(this);
  }
  
  public float getPhase()
  {
    return this.phase;
  }
  
  public float getXOrigin()
  {
    return this.xOrigin;
  }
  
  public float getYOrigin()
  {
    return this.yOrigin;
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    try
    {
      recycleSelf();
      return;
    }
    catch (IllegalArgumentException paramAnimator)
    {
      for (;;) {}
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    try
    {
      recycleSelf();
      return;
    }
    catch (IllegalArgumentException paramAnimator)
    {
      for (;;) {}
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator) {}
  
  public abstract void recycleSelf();
  
  protected void resetAnimator()
  {
    this.animator.removeAllListeners();
    this.animator.removeAllUpdateListeners();
    this.animator.reverse();
    this.animator.addUpdateListener(this);
    this.animator.addListener(this);
  }
  
  @SuppressLint({"NewApi"})
  public void run()
  {
    this.animator.start();
  }
  
  public void setPhase(float paramFloat)
  {
    this.phase = paramFloat;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\jobs\AnimatedViewPortJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */