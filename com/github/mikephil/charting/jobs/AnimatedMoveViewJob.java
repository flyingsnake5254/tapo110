package com.github.mikephil.charting.jobs;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.ObjectPool.Poolable;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

@SuppressLint({"NewApi"})
public class AnimatedMoveViewJob
  extends AnimatedViewPortJob
{
  private static ObjectPool<AnimatedMoveViewJob> pool;
  
  static
  {
    ObjectPool localObjectPool = ObjectPool.create(4, new AnimatedMoveViewJob(null, 0.0F, 0.0F, null, null, 0.0F, 0.0F, 0L));
    pool = localObjectPool;
    localObjectPool.setReplenishPercentage(0.5F);
  }
  
  public AnimatedMoveViewJob(ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Transformer paramTransformer, View paramView, float paramFloat3, float paramFloat4, long paramLong)
  {
    super(paramViewPortHandler, paramFloat1, paramFloat2, paramTransformer, paramView, paramFloat3, paramFloat4, paramLong);
  }
  
  public static AnimatedMoveViewJob getInstance(ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Transformer paramTransformer, View paramView, float paramFloat3, float paramFloat4, long paramLong)
  {
    AnimatedMoveViewJob localAnimatedMoveViewJob = (AnimatedMoveViewJob)pool.get();
    localAnimatedMoveViewJob.mViewPortHandler = paramViewPortHandler;
    localAnimatedMoveViewJob.xValue = paramFloat1;
    localAnimatedMoveViewJob.yValue = paramFloat2;
    localAnimatedMoveViewJob.mTrans = paramTransformer;
    localAnimatedMoveViewJob.view = paramView;
    localAnimatedMoveViewJob.xOrigin = paramFloat3;
    localAnimatedMoveViewJob.yOrigin = paramFloat4;
    localAnimatedMoveViewJob.animator.setDuration(paramLong);
    return localAnimatedMoveViewJob;
  }
  
  public static void recycleInstance(AnimatedMoveViewJob paramAnimatedMoveViewJob)
  {
    pool.recycle(paramAnimatedMoveViewJob);
  }
  
  protected ObjectPool.Poolable instantiate()
  {
    return new AnimatedMoveViewJob(null, 0.0F, 0.0F, null, null, 0.0F, 0.0F, 0L);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = this.pts;
    float f1 = this.xOrigin;
    float f2 = this.xValue;
    float f3 = this.phase;
    paramValueAnimator[0] = (f1 + (f2 - f1) * f3);
    f1 = this.yOrigin;
    paramValueAnimator[1] = (f1 + (this.yValue - f1) * f3);
    this.mTrans.pointValuesToPixel(paramValueAnimator);
    this.mViewPortHandler.centerViewPort(this.pts, this.view);
  }
  
  public void recycleSelf()
  {
    recycleInstance(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\jobs\AnimatedMoveViewJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */