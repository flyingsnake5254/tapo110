package com.github.mikephil.charting.jobs;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.ObjectPool.Poolable;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

@SuppressLint({"NewApi"})
public class AnimatedZoomJob
  extends AnimatedViewPortJob
  implements Animator.AnimatorListener
{
  private static ObjectPool<AnimatedZoomJob> pool = ObjectPool.create(8, new AnimatedZoomJob(null, null, null, null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0L));
  protected Matrix mOnAnimationUpdateMatrixBuffer = new Matrix();
  protected float xAxisRange;
  protected YAxis yAxis;
  protected float zoomCenterX;
  protected float zoomCenterY;
  protected float zoomOriginX;
  protected float zoomOriginY;
  
  @SuppressLint({"NewApi"})
  public AnimatedZoomJob(ViewPortHandler paramViewPortHandler, View paramView, Transformer paramTransformer, YAxis paramYAxis, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, long paramLong)
  {
    super(paramViewPortHandler, paramFloat2, paramFloat3, paramTransformer, paramView, paramFloat4, paramFloat5, paramLong);
    this.zoomCenterX = paramFloat6;
    this.zoomCenterY = paramFloat7;
    this.zoomOriginX = paramFloat8;
    this.zoomOriginY = paramFloat9;
    this.animator.addListener(this);
    this.yAxis = paramYAxis;
    this.xAxisRange = paramFloat1;
  }
  
  public static AnimatedZoomJob getInstance(ViewPortHandler paramViewPortHandler, View paramView, Transformer paramTransformer, YAxis paramYAxis, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, long paramLong)
  {
    AnimatedZoomJob localAnimatedZoomJob = (AnimatedZoomJob)pool.get();
    localAnimatedZoomJob.mViewPortHandler = paramViewPortHandler;
    localAnimatedZoomJob.xValue = paramFloat2;
    localAnimatedZoomJob.yValue = paramFloat3;
    localAnimatedZoomJob.mTrans = paramTransformer;
    localAnimatedZoomJob.view = paramView;
    localAnimatedZoomJob.xOrigin = paramFloat4;
    localAnimatedZoomJob.yOrigin = paramFloat5;
    localAnimatedZoomJob.yAxis = paramYAxis;
    localAnimatedZoomJob.xAxisRange = paramFloat1;
    localAnimatedZoomJob.resetAnimator();
    localAnimatedZoomJob.animator.setDuration(paramLong);
    return localAnimatedZoomJob;
  }
  
  protected ObjectPool.Poolable instantiate()
  {
    return new AnimatedZoomJob(null, null, null, null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0L);
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ((BarLineChartBase)this.view).calculateOffsets();
    this.view.postInvalidate();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = this.xOrigin;
    float f2 = this.xValue;
    float f3 = this.phase;
    float f4 = this.yOrigin;
    float f5 = this.yValue;
    Matrix localMatrix = this.mOnAnimationUpdateMatrixBuffer;
    this.mViewPortHandler.setZoom(f1 + (f2 - f1) * f3, f4 + (f5 - f4) * f3, localMatrix);
    this.mViewPortHandler.refresh(localMatrix, this.view, false);
    f2 = this.yAxis.mAxisRange / this.mViewPortHandler.getScaleY();
    f5 = this.xAxisRange / this.mViewPortHandler.getScaleX();
    paramValueAnimator = this.pts;
    f1 = this.zoomOriginX;
    f3 = this.zoomCenterX;
    f4 = f5 / 2.0F;
    f5 = this.phase;
    paramValueAnimator[0] = (f1 + (f3 - f4 - f1) * f5);
    f1 = this.zoomOriginY;
    paramValueAnimator[1] = (f1 + (this.zoomCenterY + f2 / 2.0F - f1) * f5);
    this.mTrans.pointValuesToPixel(paramValueAnimator);
    this.mViewPortHandler.translate(this.pts, localMatrix);
    this.mViewPortHandler.refresh(localMatrix, this.view, true);
  }
  
  public void recycleSelf() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\jobs\AnimatedZoomJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */